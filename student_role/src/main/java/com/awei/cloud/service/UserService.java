package com.awei.cloud.service;

import com.awei.cloud.entity.User;
import com.awei.cloud.request.DeleteOneRequest;
import com.awei.cloud.request.DeleteUserBizRequest;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.utils.BaseResponse;

import java.util.List;

public interface UserService {

    void insertUser(InsertUserBizRequest bizRequest);

    List<User>  listUser();

    public void deleteUser(DeleteUserBizRequest bizRequest);
    void delete(DeleteOneRequest request);
}