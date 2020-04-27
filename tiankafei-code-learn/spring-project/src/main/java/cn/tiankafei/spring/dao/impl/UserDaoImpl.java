package cn.tiankafei.spring.dao.impl;

import cn.tiankafei.spring.dao.UserDao;

public class UserDaoImpl  implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取用户数据");
    }
}