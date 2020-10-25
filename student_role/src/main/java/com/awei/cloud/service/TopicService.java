package com.awei.cloud.service;


import com.awei.cloud.request.DeleteTopicRequest;
import com.awei.cloud.request.InsertTopicRequest;
import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.UpdateTopicRequest;
import com.awei.cloud.utils.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("student-mongo")
public interface TopicService {

    @RequestMapping("/list")
    BaseResponse  listTopic(ListRequest request);

    @RequestMapping("insert")
    void insertTopic(InsertTopicRequest request);

    @RequestMapping("/delete")
    void deleteTopic(DeleteTopicRequest request);

    @RequestMapping("/update")
    void update(UpdateTopicRequest request);
}
