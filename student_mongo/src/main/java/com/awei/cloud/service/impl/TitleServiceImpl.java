package com.awei.cloud.service.impl;

import com.awei.cloud.dao.TitleDao;
import com.awei.cloud.entity.TitleEntity;
import com.awei.cloud.request.InsertTitleRequest;
import com.awei.cloud.request.UpdateRequest;
import com.awei.cloud.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao dao;

    @Override
    public void insert(InsertTitleRequest request) {
        TitleEntity entity = new TitleEntity();
        entity.setItem(request.getItem());
        entity.setTopic(request.getTopic());
        dao.insertTitle(entity);
    }

    @Override
    public void delete(String tid) {
        dao.deleteTitle(tid);
    }

    @Override
    public TitleEntity listTitle(String id) {
        TitleEntity entity = dao.listTitle(id);
        return entity;
    }

    @Override
    public void update(UpdateRequest request) {
        TitleEntity  entity =new TitleEntity();
        entity.setId(request.getId());
        entity.setTopic(request.getTopic());
        entity.setItem(request.getItem());
        dao.update(entity);
    }
}
