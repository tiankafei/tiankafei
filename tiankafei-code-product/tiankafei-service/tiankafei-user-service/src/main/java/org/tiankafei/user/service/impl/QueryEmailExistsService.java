package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.service.QueryUserExistsService;
import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.web.common.exception.UserException;

@Service
public class QueryEmailExistsService implements QueryUserExistsService {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Override
    public Boolean checkSysUserExists(String keywords) throws UserException {
        if(StringUtils.isBlank(keywords)){
            return Boolean.FALSE;
        }
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserInfoEntity::getEmail, keywords);
        int count = sysUserInfoService.count(lambdaQueryWrapper);
        boolean exists = count > 0;
        if(exists){
            throw new UserException("邮箱已经存在，请重新输入！");
        }
        return Boolean.FALSE;
    }

    @Override
    public Integer getUserFlag() {
        return LoginEnums.EMAIL.getCode();
    }
}
