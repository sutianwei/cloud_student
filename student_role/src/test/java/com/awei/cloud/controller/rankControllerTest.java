package com.awei.cloud.controller;

import com.awei.cloud.StudentRoleApplication;
import com.awei.cloud.entity.User;
import com.awei.cloud.utils.RedisUtil;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
    public void redis() throws InterruptedException {

        User user = new User();
        user.setId(12);
        user.setPassWord("pass1");
        user.setRole("ths");
        user.setUserId("su");
        user.setUserName("su");

        User user1 = new User();
        user1.setId(122);
        user1.setPassWord("pass2");
        user1.setRole("ths2");
        user1.setUserId("su2");
        user1.setUserName("su2");

        User user2 = new User();
        user2.setId(122);
        user2.setPassWord("pass3");
        user2.setRole("user2");
        user2.setUserId("user2");
        user2.setUserName("user2");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        Map<String, Object> map = list.stream().collect(Collectors.toMap(this::convert, Function.identity(), (o1, o2) -> o2));


        redisTemplate.hset("hset", "su", map);
        redisTemplate.hset("hset", "li", map);
        redisTemplate.hset("hset", "wa", map);
        redisTemplate.hdel("hset","su","li");


        redisTemplate.hmset("hmset", map);
        redisTemplate.set("lock",1);
        redisTemplate.expire("lock",10);
        Thread.sleep(2000);
        System.out.println("lock 失效时间"+ redisTemplate.getExpire("lock"));

        redisTemplate.incr("lock",5);
        redisTemplate.decr("lock",2);
        System.out.println("hget +++++++++"+redisTemplate.hmget("hset"));
        System.out.println(redisTemplate.hget("su", "su"));


        redisTemplate.hincr("hincl","hicle",2);
        redisTemplate.hdecr("hincl","hicle",2);

        redisTemplate.sSet("sset",map,map);
        System.out.println("sget---"+redisTemplate.sGet("sset"));

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(3);
        al.add(3);
        redisTemplate.lSet("list列表",al);
        redisTemplate.lRemove("list列表",1,3);
        System.out.println("list 列表"+redisTemplate.lGetIndex("list列表",0));
    }

    private String convert(User user) {
        String key = String.format("%s_%s_%s", user.getId(), user.getPassWord(), "KEY");

        return key;
    }

}