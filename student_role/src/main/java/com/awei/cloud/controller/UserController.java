package com.awei.cloud.controller;

import com.awei.cloud.entity.User;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.service.UserService;
import com.awei.cloud.utils.BaseResponse;
import com.awei.cloud.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/get")
    private void test() {
        redisUtil.set("ss", "sdsd");

    }

    @PostMapping("insert_user")
    public void insertUser(@RequestBody InsertUserBizRequest bizRequest) {

        userService.insertUser(bizRequest);
    }

    @PostMapping("/list")
    public List<User> listUser(){

        List<User> users = userService.listUser();


        return users;
    }
}
