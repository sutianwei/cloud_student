package com.awei.cloud.service;


import com.awei.cloud.request.DeleteTopicRequest;
import com.awei.cloud.request.InsertTopicRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.UpdateTopicRequest;
import com.awei.cloud.response.ListTopicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("student-mongo")
public interface TopicService {

    /**
     * 获取题目列表
     * @param request
     * @return
     */
    @RequestMapping("/list")
    ListTopicResponse listTopic(ListRequest request);

    @RequestMapping("insert")
    void insertTopic(InsertTopicRequest request);

    @RequestMapping("/delete")
    void deleteTopic(DeleteTopicRequest request);

    @RequestMapping("/update")
    void update(UpdateTopicRequest request);
}
