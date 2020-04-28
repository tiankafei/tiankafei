package cn.tiankafei.spring;

import cn.tiankafei.spring.dao.impl.UserDaoMysqlImpl;
import cn.tiankafei.spring.dao.impl.UserDaoOracleImpl;
import cn.tiankafei.spring.service.UserService;
import cn.tiankafei.spring.service.impl.UserService1Impl;
import cn.tiankafei.spring.service.impl.UserService2Impl;
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
