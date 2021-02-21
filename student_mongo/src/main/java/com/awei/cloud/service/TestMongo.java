package com.awei.cloud.service;

import com.awei.cloud.entity.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;


@SpringBootTest
public class TestMongo {

    @Autowired
//    @Resource
    private MongoTemplate mongoTemplate;

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
            mongoTemplate.save(article);
        }
    }
}
