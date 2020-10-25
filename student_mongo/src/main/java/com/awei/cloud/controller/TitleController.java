package com.awei.cloud.controller;

import com.awei.cloud.entity.TitleEntity;
import com.awei.cloud.request.DeleteRequest;
import com.awei.cloud.request.InsertTitleRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.UpdateRequest;
import com.awei.cloud.service.TitleService;
import com.awei.cloud.utils.BaseResponse;
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
    public BaseResponse  list(@RequestBody ListRequest request) {

        TitleEntity entity = service.listTitle(request.getId());
        BaseResponse  response = new BaseResponse();
        response.setData(entity);
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
