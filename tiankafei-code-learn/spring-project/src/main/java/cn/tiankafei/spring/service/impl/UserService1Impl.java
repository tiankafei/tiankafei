package cn.tiankafei.spring.service.impl;

import cn.tiankafei.spring.dao.UserDao;
import cn.tiankafei.spring.dao.impl.UserDaoImpl;
import cn.tiankafei.spring.service.UserService;

public class UserService1Impl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}