package org.tiankafei.springdemo.service.impl;

import org.tiankafei.springdemo.dao.UserDao;
import org.tiankafei.springdemo.dao.impl.UserDaoImpl;
import org.tiankafei.springdemo.service.UserService;

public class UserService1Impl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}