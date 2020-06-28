package org.tiankafei.springdemo.service.impl;

import org.tiankafei.springdemo.dao.UserDao;
import org.tiankafei.springdemo.service.UserService;

public class UserService2Impl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}