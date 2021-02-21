package com.awei.cloud.controller;

import com.awei.cloud.StudentRoleApplication;
import com.awei.cloud.entity.User;
import com.awei.cloud.utils.RedisUtil;
import com.awei.cloud.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.statements.SpringRepeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest(classes = StudentRoleApplication.class)
@RunWith(SpringRunner.class)
public class rankControllerTest {


    @Autowired
    private RedisUtil redisTemplate;

    @Test
    public void redis() {
        redisTemplate.set("s", "s");

        User user = new User();
        user.setId(12);
        user.setPassWord("pass");
        user.setRole("ths");
        user.setUserId("su");
        user.setUserName("su");

        User user1 = new User();
        user1.setId(122);
        user1.setPassWord("pass2");
        user1.setRole("ths2");
        user1.setUserId("su2");
        user1.setUserName("su2");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        Map<String, User> map = list.stream().collect(Collectors.toMap(User::getPassWord, Function.identity(), (o1, o2) -> o2));


        redisTemplate.hset("su", "su", map);
        System.out.println(redisTemplate.hget("su", "su"));
    }


}