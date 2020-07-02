package org.tiankafei.user.login.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.LoginService;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, LoginQueryVo> implements LoginService {

    @Override
    public void login(LoginQueryVo loginQueryVo) throws LoginException {
        // 0.验证传入数据的合法性
        // 1.从当前缓存中查询用户信息，
        // 2.如果存在，说明已经登录，取出缓存的数据，直接返回，
        // 3.如果不存在，说明没有登录过，去数据库读取数据进行验证
        // 4.如果验证不通过，抛出异常，让用户重新输入：用户名或密码不正确，验证码不正确
        // 5.如果验证通过，取出其他数据放到缓存中并返回
    }

    @Override
    public void logout(String userId) throws LoginException {
        // 1.从缓存中删除当前用户信息
        // 1.1同步方式从缓存中删除用户信息
        // 1.2异步(MQ)方式从缓存中删除用户信息
        // 2.返回注销成功
    }

}
