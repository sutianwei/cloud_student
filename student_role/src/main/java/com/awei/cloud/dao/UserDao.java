package com.awei.cloud.dao;

import com.awei.cloud.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

     void insertUser( User user) ;

     List<User> ListUser();
}
