package com.awei.cloud.service;

import com.awei.cloud.entity.User;
import com.awei.cloud.request.DeleteUserBizRequest;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.request.QueryUserRequest;
import com.awei.cloud.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    void insertUser(InsertUserBizRequest bizRequest);

    List<User> listUser();

    public void deleteUser(DeleteUserBizRequest bizRequest);

    User  queryUser(QueryUserRequest request);

    void update(UpdateUserRequest request);
}
