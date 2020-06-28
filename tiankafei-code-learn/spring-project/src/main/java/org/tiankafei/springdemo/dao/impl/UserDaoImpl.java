package org.tiankafei.springdemo.dao.impl;

import org.tiankafei.springdemo.dao.UserDao;

public class UserDaoImpl  implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取用户数据");
    }
}