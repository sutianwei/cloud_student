package com.awei.cloud.service.impl;

import com.awei.cloud.dao.UserRankDao;
import com.awei.cloud.entity.UserRankEntity;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.ReplyRequest;
import com.awei.cloud.response.ListTopicResponse;
import com.awei.cloud.service.ReplyService;
import com.awei.cloud.service.TopicService;
import com.awei.cloud.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReplyTopicServiceImpl implements ReplyService {
    private final static String RANK = "RANK";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TopicService service;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRankDao rankDao;

    public static final String SCORE_RANK = "score_rank";
    @Override
    public void replyTopic(ReplyRequest replyRequest) {

        ListRequest request = new ListRequest();
        request.setId(replyRequest.getId());
        ListTopicResponse response = service.listTopic(request);
        UserRankEntity rank = rankDao.getRank(replyRequest.getUserId());

        Integer sp = rank.getUserRank();
        if (response.getItem().equals(replyRequest.getItem())) {
            UserRankEntity rankEntity = new UserRankEntity();
            rankEntity.setUserId(replyRequest.getUserId());
            rankEntity.setUserName(replyRequest.getUserName());
            sp++;
            rankEntity.setUserRank(sp);
//            rankDao.insertRank(rankEntity);
            rankDao.updateRank(replyRequest.getUserId(), sp
            );
            redisUtil.set(RANK+replyRequest.getUserName() , sp, 60 * 60 * 24);
        }

        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
//        DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>(replyRequest.getUserName() + replyRequest.getItem(), 1D );
//
//        tuples.add(tuple);
////        Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
//        Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
        redisTemplate.opsForZSet().incrementScore(SCORE_RANK, replyRequest.getUserName(), 1);
    }
}
