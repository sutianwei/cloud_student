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
import org.springframework.stereotype.Service;

@Service
public class ReplyTopicServiceImpl implements ReplyService {

    @Autowired
    private TopicService service;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRankDao rankDao;


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
            rankDao.insertRank(rankEntity);
            redisUtil.set("阿伟做对了" + response.getTopic(), replyRequest.getId(), 60 * 60 * 24);
            System.out.println("6666");
        }

    }
}
