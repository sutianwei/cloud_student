package com.awei.cloud.service.impl;

import com.awei.cloud.Enum.UserRole;
import com.awei.cloud.dao.UserDao;
import com.awei.cloud.entity.User;
import com.awei.cloud.request.DeleteOneRequest;
import com.awei.cloud.request.DeleteUserBizRequest;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.service.UserService;
import com.awei.cloud.utils.BaseResponse;
import com.awei.cloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(InsertUserBizRequest bizRequest) {
        User user = new User();
        user.setUserId(UUIDUtils.getUUID());
        user.setUserName(bizRequest.getUserName());
        user.setPassWord(bizRequest.getPassWord());
        if ("T".equals(bizRequest.getRole())) {
            user.setRole(UserRole.TEACHER.getRole());
        } else if ("S".equals(bizRequest.getRole())) {
            user.setRole(UserRole.STUDNET.getRole());
        } else {
            user.setRole(UserRole.MANAGER.getRole()
            );
        }
        userDao.insertUser(user);

    }

    @Override
    public List<User> listUser() {
        List<User> list = userDao.ListUser();
        return list;
    }

    @Override

    public void deleteUser(DeleteUserBizRequest bizRequest) {

        userDao.deleteUser(bizRequest.getIds());

    }

    @Override
    public void delete(DeleteOneRequest request) {
        String uid = request.getUid();

        userDao.deleteSingle(uid);
    }
}
