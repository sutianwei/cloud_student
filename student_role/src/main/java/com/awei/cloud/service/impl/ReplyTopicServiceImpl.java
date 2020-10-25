package com.awei.cloud.service.impl;

import com.awei.cloud.request.ListRequest;
import com.awei.cloud.request.ReplyRequest;
import com.awei.cloud.response.ListTopicResponse;
import com.awei.cloud.service.ReplyService;
import com.awei.cloud.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReplyTopicServiceImpl implements ReplyService {


    @Autowired
    private TopicService service;


    @Override
    public void replyTopic(ReplyRequest replyRequest) {

        ListRequest  request = new ListRequest();
        request.setId(replyRequest.getId());

        ListTopicResponse response = service.listTopic(request);
        if (response.getItem() .equals(replyRequest.getItem())){
            System.out.println("6666");
        }

    }
}
