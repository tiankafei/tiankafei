package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.mapper.SysUserLoginMapper;
import org.tiankafei.user.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class GetLoginEmailService implements GetLoginService {

    @Autowired
    private SysUserLoginMapper userLoginMapper;

    @Override
    public Boolean checkSysUserExists(String keywords) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);

        return userLoginMapper.selectCount(lambdaQueryWrapper) > 0;
    }

    @Override
    public SysUserLoginEntity getLoginEntity(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);
        lambdaQueryWrapper.eq(SysUserLoginEntity::getPassword, password);
        SysUserLoginEntity userLoginEntity = userLoginMapper.selectOne(lambdaQueryWrapper);
        return userLoginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.EMAIL;
    }

}
