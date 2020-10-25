package com.awei.cloud.controller;


import com.awei.cloud.request.*;
import com.awei.cloud.response.ListTopicResponse;
import com.awei.cloud.service.ReplyService;
import com.awei.cloud.service.TopicService;
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

    @Autowired
    private ReplyService replyService;


    /**
     * 调用题库系统查询题目
     *
     * @param request
     * @return BaseResponse
     */
    @PostMapping("/list_topic")
    public ListTopicResponse list(@RequestBody ListRequest request) {

        ListTopicResponse response = topicService.listTopic(request);
        System.out.println(response.getItem());
        return response;

    }

    /**
     * 添加题目
     *
     * @param request
     */
    @PostMapping("/insert_topic")
    public void insert(@RequestBody InsertTopicRequest request) {
        topicService.insertTopic(request);
    }

    /**
     * 删除题目
     *
     * @param request
     */
    @PostMapping("delete_topic")
    public void delete(@RequestBody DeleteTopicRequest request) {
        topicService.deleteTopic(request);

    }

    /**
     * 更新题目
     *
     * @param request
     */
    @PostMapping("/update_topic")
    public void update(@RequestBody UpdateTopicRequest request) {
        topicService.update(request);
    }

    @PostMapping("/reply")
    public void reply(@RequestBody ReplyRequest replyRequest) {
        replyService.replyTopic(replyRequest);

    }

}
