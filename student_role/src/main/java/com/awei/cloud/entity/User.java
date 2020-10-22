package com.awei.cloud.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student_user")
public class User implements Serializable {

    private static final long serialVersionUID = 7313908511206187571L;
    @Id
    @Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", columnDefinition = "varchar(100) COMMENT '用户名'")
    private String userName;
    @Column(name = "user_pass", columnDefinition = "varchar(100) COMMENT '用户密码'")
    private String passWord;
    @Column(name = "role", columnDefinition = "varchar(100) COMMENT '角色'")
    private String role;
    @Column(name = "gmt_create", columnDefinition = "varchar(100) COMMENT '创建时间'")
    private Date gmtCreate;
    @Column(name = "gmt_modified", columnDefinition = "varchar(100) COMMENT '创建时间'")
    private Date gmtModified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
