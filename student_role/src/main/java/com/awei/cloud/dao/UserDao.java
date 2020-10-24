package com.awei.cloud.dao;

import com.awei.cloud.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserDao {

    void insertUser(User user);

    List<User> ListUser();

    void deleteUser(@Param("userIds") Collection<String> userIds);

    User queryUser(@Param("userId") String userId);

}
