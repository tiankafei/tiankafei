package org.tiankafei.springdemo;

import org.tiankafei.springdemo.dao.impl.UserDaoMysqlImpl;
import org.tiankafei.springdemo.dao.impl.UserDaoOracleImpl;
import org.tiankafei.springdemo.service.UserService;
import org.tiankafei.springdemo.service.impl.UserService1Impl;
import org.tiankafei.springdemo.service.impl.UserService2Impl;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class OriginalTest {

    @Test
    public void test01() {
        UserService service = new UserService1Impl();
        service.getUser();
    }

    @Test
    public void test02(){
        UserService2Impl userService = new UserService2Impl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();

        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

}
