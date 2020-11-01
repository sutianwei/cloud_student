package com.awei.cloud.dao;


import com.awei.cloud.entity.Title;
import com.awei.cloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class TitleDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加题目
     */
    public void insertTitle(Title entity) {
        entity.setId(UUIDUtils.getUUID());
        mongoTemplate.save(entity);
    }
    /**
     * 查询题目
     */
    public Title listTitle(String id) {
        return mongoTemplate.findById(id, Title.class);
    }

    /**
     * 删除题目
     */
    public void deleteTitle(String tid) {
        Query query = new Query(Criteria.where("id").is(tid));
        mongoTemplate.remove(query, Title.class);
    }
    /**
     * 更新题目
     */
    public void update(Title entity) {
        Query query = new Query(Criteria.where("id").is(entity.getId()));
        Update update = new Update().set("topic", entity.getTopic()).set("item", entity.getItem());
        mongoTemplate.updateFirst(query, update, Title.class);
    }


}
