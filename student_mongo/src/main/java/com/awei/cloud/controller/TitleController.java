package com.awei.cloud.controller;

import com.awei.cloud.entity.Title;
import com.awei.cloud.request.DeleteRequest;
import com.awei.cloud.request.InsertTitleRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.UpdateRequest;
import com.awei.cloud.response.ListTopicResponse;
import com.awei.cloud.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {

    @Autowired
    private TitleService service;

    /**
     * 添加题目
     *
     * @param request
     */
    @PostMapping("/insert")
    public void insert(@RequestBody InsertTitleRequest request) {
        service.insert(request);
    }

    /**
     * 删除
     *
     * @param request
     */

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRequest request) {
        service.delete(request.getId());
    }

    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    @PostMapping("/list")
    public ListTopicResponse list(@RequestBody ListRequest request) {

        Title entity = service.listTitle(request.getId());
        ListTopicResponse response = new ListTopicResponse();
        response.setItem(entity.getItem());
        response.setId(entity.getId());
        response.setTopic(entity.getTopic());
        return response;
    }

    /**
     * 更新题目
     *
     * @param request
     */
    @PostMapping("/update")
    public void update(@RequestBody UpdateRequest request) {
        service.update(request);

    }


}
