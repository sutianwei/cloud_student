package com.awei.cloud.service.impl;

import com.awei.cloud.Enum.UserRole;
import com.awei.cloud.dao.UserDao;
import com.awei.cloud.entity.User;
import com.awei.cloud.request.DeleteUserBizRequest;
import com.awei.cloud.request.InsertUserBizRequest;
import com.awei.cloud.request.QueryUserRequest;
import com.awei.cloud.request.UpdateUserRequest;
import com.awei.cloud.service.UserService;
import com.awei.cloud.utils.RedisUtil;
import com.awei.cloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.xml.bind.annotation.W3CDomHandler;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_CACHE = "USER_CACHE_";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    private TransactionTemplate  template;

    @Override
    public void insertUser(InsertUserBizRequest bizRequest) {
        User user = new User();
        user.setUserId(UUIDUtils.getUUID());
        user.setUserName(bizRequest.getUserName());
        user.setPassWord(bizRequest.getPassWord());
        //判断用户角色
        if ("T".equals(bizRequest.getRole())) {
            user.setRole(UserRole.TEACHER.getRole());
        } else if ("S".equals(bizRequest.getRole())) {
            user.setRole(UserRole.STUDNET.getRole());
        } else  if ("M" .equals(bizRequest.getRole())){
            user.setRole(UserRole.MANAGER.getRole()
            );
        }else {
            return;
        }
        userDao.insertUser(user);
        //教师信息放在redis缓存
        if ("T".equals(user.getRole())) {
            redisUtil.set(USER_CACHE + user.getRole() + user.getUserId(), user, 200000);
        }
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
    public User queryUser(QueryUserRequest request) {

        //先查询缓存
        Object o = redisUtil.get(USER_CACHE + "T" + request.getUid());
        if (o != null) {

            return (User) o;
        } else {

            User user = userDao.queryUser(request.getUid());
            return user;
        }
    }

    @Override
    public void update(UpdateUserRequest request) {
        redisUtil.del(USER_CACHE + "T" +request.getUserId()+ request.getUserId());

        User user = new User();
        user.setRole(request.getRole());
        user.setPassWord(request.getPassWord());
        user.setUserId(request.getUserId());
        user.setUserName(request.getUserName());
        userDao.update(request.getUserId(),user);

        redisUtil.set(USER_CACHE+request.getRole()+request.getUserId(),user);
    }
}
