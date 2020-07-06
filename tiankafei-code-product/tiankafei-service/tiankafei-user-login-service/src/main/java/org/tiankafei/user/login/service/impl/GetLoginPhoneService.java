package org.tiankafei.user.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class GetLoginPhoneService implements GetLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginEntity getLoginEntity(LoginQueryVo loginQueryVo) throws LoginException {
        String keywords = loginQueryVo.getTelephone();
        String password = loginQueryVo.getPassword();
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("手机号码不能为空");
        }
        LambdaQueryWrapper<LoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(LoginEntity::getTelephone, keywords);
        lambdaQueryWrapper.eq(LoginEntity::getPassword, password);
        LoginEntity loginEntity = loginMapper.selectOne(lambdaQueryWrapper);
        return loginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.PHONE;
    }

}
