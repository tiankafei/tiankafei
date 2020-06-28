package org.tiankafei.springdemo.dao.impl;

import org.tiankafei.springdemo.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle");
    }
}