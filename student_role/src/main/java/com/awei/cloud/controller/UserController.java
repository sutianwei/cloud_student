package com.awei.cloud.controller;

import com.awei.cloud.entity.User;
import com.awei.cloud.request.*;
import com.awei.cloud.service.TopicService;
import com.awei.cloud.service.UserService;
import com.awei.cloud.utils.BaseResponse;
import com.awei.cloud.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TopicService topicService;


    @PostMapping("/list_topic")
    public BaseResponse list(@RequestBody ListRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(topicService.listTopic(request));
        return response;
    }


    /**
     * 添加客户
     *
     * @param bizRequest
     */
    @PostMapping("insert_user")
    public void insertUser(@RequestBody InsertUserBizRequest bizRequest) {

        userService.insertUser(bizRequest);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @PostMapping("/list")
    public List<User> listUser() {
        List<User> users = userService.listUser();

        return users;
    }

    /**
     * 删除用户
     *
     * @param bizRequest
     */
    @PostMapping("/delete")
    public void deleteUser(@RequestBody DeleteUserBizRequest bizRequest) {
        userService.deleteUser(bizRequest);
    }


    /**
     * 查询用户
     *
     * @param request
     * @return
     */
    @PostMapping("query")
    public User query(@RequestBody QueryUserRequest request) {
        User user = userService.queryUser(request);
        return user;

    }

    /**
     * 更新用户
     *
     * @param request
     */
    @PostMapping("/update")
    public void update(@RequestBody UpdateUserRequest request) {
        userService.update(request);
    }

}
