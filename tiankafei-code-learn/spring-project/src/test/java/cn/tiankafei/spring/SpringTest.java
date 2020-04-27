package cn.tiankafei.spring;

import cn.tiankafei.spring.dao.impl.UserDaoMysqlImpl;
import cn.tiankafei.spring.dao.impl.UserDaoOracleImpl;
import cn.tiankafei.spring.service.UserService;
import cn.tiankafei.spring.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest {

    @Test
    public void test01() {
        UserService service = new UserServiceImpl();
        service.getUser();
    }

    @Test
    public void test02(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();

        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

}
