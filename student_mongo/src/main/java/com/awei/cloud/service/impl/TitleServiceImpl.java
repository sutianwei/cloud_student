package com.awei.cloud.service.impl;

import com.awei.cloud.dao.TitleDao;
import com.awei.cloud.entity.Title;
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
        Title entity = new Title();
        entity.setItem(request.getItem());
        entity.setTopic(request.getTopic());
        dao.insertTitle(entity);
    }

    @Override
    public void delete(String tid) {
        dao.deleteTitle(tid);
    }

    @Override
    public Title listTitle(String id) {
        Title entity = dao.listTitle(id);
        return entity;
    }

    @Override
    public void update(UpdateRequest request) {
        Title entity = new Title();
        entity.setId(request.getId());
        entity.setTopic(request.getTopic());
        entity.setItem(request.getItem());
        dao.update(entity);
    }
}
