package com.awei.cloud.controller;

import com.awei.cloud.entity.TitleEntity;
import com.awei.cloud.request.DeleteRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.service.TitleService;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {

    @Autowired
    private TitleService service;

    @PostMapping("/insert")
    public void insert(@RequestBody TitleEntity entity) {
        service.insert(entity);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRequest request) {
        service.delete(request.getId());
    }

    @PostMapping("/list")
    public TitleEntity list(@RequestBody ListRequest request) {
        TitleEntity entity = service.listTitle(request.getId());
        return entity;
    }
}
