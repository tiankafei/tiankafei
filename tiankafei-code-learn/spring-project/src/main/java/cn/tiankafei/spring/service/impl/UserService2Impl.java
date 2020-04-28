package cn.tiankafei.spring.service.impl;

import cn.tiankafei.spring.dao.UserDao;
import cn.tiankafei.spring.service.UserService;

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