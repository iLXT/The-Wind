package com.stuwxq.service.impl;

import com.stuwxq.dao.UserDao;
import com.stuwxq.pojo.User;
import com.stuwxq.service.UserService;
import com.stuwxq.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
