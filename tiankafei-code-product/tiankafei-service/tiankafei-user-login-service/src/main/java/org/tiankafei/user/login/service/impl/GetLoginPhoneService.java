package org.tiankafei.user.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class GetLoginPhoneService implements GetLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Boolean checkSysUserExists(String keywords) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("手机号码不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getTelephone, keywords);

        return loginMapper.selectCount(lambdaQueryWrapper) > 0;
    }

    @Override
    public SysUserLoginEntity getLoginEntity(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("手机号码不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getTelephone, keywords);
        lambdaQueryWrapper.eq(SysUserLoginEntity::getPassword, password);
        SysUserLoginEntity userLoginEntity = loginMapper.selectOne(lambdaQueryWrapper);
        return userLoginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.PHONE;
    }

}
