package com.awei.cloud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collation = "student_title")
public class Title implements Serializable {

    private static final long serialVersionUID = 729918189840157911L;
    @Id
    private String id;

    /**
     * 题目
     */
    private String topic;
    /**
     * 答案
     */
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
