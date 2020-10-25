package com.awei.cloud.controller;


import com.awei.cloud.request.DeleteTopicRequest;
import com.awei.cloud.request.InsertTopicRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.UpdateTopicRequest;
import com.awei.cloud.service.TopicService;
import com.awei.cloud.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("topic")
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


    /**
     * 调用题库系统查询题目
     *
     * @param request
     * @return BaseResponse
     */
    @PostMapping("/list_topic")
    public BaseResponse list(@RequestBody ListRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(topicService.listTopic(request));
        response.setSuccess(true);
        return response;
    }

    /**
     * 添加题目
     * @param request
     */
    @PostMapping("/insert_topic")
    public void insert(@RequestBody InsertTopicRequest request) {
        topicService.insertTopic(request);
    }

    /**
     * 删除题目
     * @param request
     */
    @PostMapping("delete_topic")
    public void delete(@RequestBody DeleteTopicRequest request) {
        topicService.deleteTopic(request);

    }

    /**
     * 更新题目
     * @param request
     */
    @PostMapping("/update_topic")
    public void update(@RequestBody UpdateTopicRequest request) {
        topicService.update(request);
    }

}
