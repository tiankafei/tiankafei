package cn.tiankafei.spring.dao.impl;

import cn.tiankafei.spring.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle");
    }
}