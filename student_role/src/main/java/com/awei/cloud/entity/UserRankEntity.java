package com.awei.cloud.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Table(name = "user_rank")
//@Entity
public class UserRankEntity implements Serializable {

    private static final long serialVersionUID = -8812245386537485619L;

    @Id
    @Column(length = 32)
    private int id;

    @Column(length = 32, name = "user_id")
    private String userId;

    @Column(name = "user_name")

    private String userName;

    @Column(name = "user_rank")
    private Integer userRank;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }
}
