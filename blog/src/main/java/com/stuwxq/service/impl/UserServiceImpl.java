package com.stuwxq.service.impl;

import com.stuwxq.dao.UserDao;
import com.stuwxq.pojo.User;
import com.stuwxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByName(String username) {
        User user=userDao.queryUserByName(username);
        return user;
    }
}
