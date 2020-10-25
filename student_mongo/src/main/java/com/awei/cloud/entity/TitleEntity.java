package com.awei.cloud.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class TitleEntity {

    @Id
    private String id;

    private String topic;

    private String item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
