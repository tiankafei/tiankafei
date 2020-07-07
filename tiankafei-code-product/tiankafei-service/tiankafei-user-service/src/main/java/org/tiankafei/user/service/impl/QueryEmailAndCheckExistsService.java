package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.service.QueryUserAndCheckExistsService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.UserException;

@Service
public class QueryEmailAndCheckExistsService implements QueryUserAndCheckExistsService {

    @Autowired
    private SysUserLoginService userLoginService;

    /**
     * 验证新增时邮箱是否存在
     * @param keywords
     * @return
     * @throws UserException
     */
    @Override
    public Boolean checkAddSysUserExists(String keywords) throws UserException {
        if(StringUtils.isBlank(keywords)){
            return Boolean.FALSE;
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);

        boolean exists = userLoginService.count(lambdaQueryWrapper) > 0;
        if(exists){
            throw new UserException("邮箱已经存在，请重新输入！");
        }
        return Boolean.FALSE;
    }

    /**
     * 验证登录时邮箱帐号是否存在
     * @param keywords
     * @return
     * @throws LoginException
     */
    @Override
    public Boolean checkLoginSysUserExists(String keywords) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);

        return userLoginService.count(lambdaQueryWrapper) > 0;
    }

    /**
     * 获取登录对象
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    @Override
    public SysUserLoginQueryVo getSysUserLoginQueryVo(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);
        lambdaQueryWrapper.eq(SysUserLoginEntity::getPassword, password);

        SysUserLoginEntity sysUserLoginEntity = userLoginService.getOne(lambdaQueryWrapper);
        return getSysUserLoginQueryVo(sysUserLoginEntity);
    }

    @Override
    public Integer getUserFlag() {
        return LoginEnums.EMAIL.getCode();
    }
}
