package com.awei.cloud.controller;

import com.awei.cloud.entity.User;
import com.awei.cloud.request.DeleteUserBizRequest;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.request.QueryUserRequest;
import com.awei.cloud.request.UpdateUserRequest;
import com.awei.cloud.service.UserService;
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
