package org.tiankafei.user.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.login.enums.LoginEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service("email")
public class GetLoginEmailService implements GetLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginEntity getLoginEntity(LoginQueryVo loginQueryVo) throws LoginException {
        String keywords = loginQueryVo.getEmail();
        String password = loginQueryVo.getPassword();
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<LoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(LoginEntity::getEmail, keywords);
        lambdaQueryWrapper.eq(LoginEntity::getPassword, password);
        LoginEntity loginEntity = loginMapper.selectOne(lambdaQueryWrapper);
        return loginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.EMAIL;
    }

}
