package com.awei.cloud.controller;

import com.awei.cloud.entity.Article;
import com.awei.cloud.utils.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class TitleControllerTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisUtils redisTemplate;

    @Test
    public  void redis(){
        redisTemplate.setValue("s","s");
    }




    @Test
    public void 单条添加() {


        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("这是第一条数据");
            article.setUrl("www.test.com");
            article.setAuthor("awei");
            article.setTags(Arrays.asList("java", "mongo", "spring"));
            article.setVisitorCount(0L);
            article.setAddTime(new Date());
            mongoTemplate.insert(article);
        }
    }
}