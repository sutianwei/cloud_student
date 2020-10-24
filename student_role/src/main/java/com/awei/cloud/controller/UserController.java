package com.awei.cloud.controller;

import com.awei.cloud.utils.RedisUtil;
import com.awei.cloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {




    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/get")
    private void test() {
        redisUtil.set("ss", "sdsd");

    }
}
