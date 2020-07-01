package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.service.CheckUserInfoExists;
import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.user.service.UserService;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.UserException;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Override
    public void checkAddUserInfoExists(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        checkAddUserInfoExists(sysUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkAddUserInfoExists(sysUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkAddUserInfoExists(sysUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));
    }

    @Override
    public void checkAddUserInfoExists(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        checkAddUserInfoExists(sysUserInfoQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkAddUserInfoExists(sysUserInfoQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkAddUserInfoExists(sysUserInfoQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));
    }

    @Override
    public boolean checkUsernameExists(String username) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserInfoEntity::getUsername, username);
        return checkSysUserInfoExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkEmailExists(String email) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserInfoEntity::getEmail, email);
        return checkSysUserInfoExists(lambdaQueryWrapper);
    }

    @Override
    public boolean checkTelephoneExists(String telephone) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserInfoEntity::getTelephone, telephone);
        return checkSysUserInfoExists(lambdaQueryWrapper);
    }

    private boolean checkSysUserInfoExists(LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper) throws Exception {
        int count = sysUserInfoService.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public void checkAddUserInfoExists(String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception {
        if(StringUtils.isNotBlank(str)){
            boolean existsFlag = checkUserInfoExists.checkUserInfoExists(str);
            if(existsFlag){
                throw new UserException(message + "已经存在，请重新输入！");
            }
        }
    }

    @Override
    public void checkUpdateUserInfoExists(SysUserLoginEntity oldUserEntity, SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        checkUpdateUserInfoExists(oldUserEntity.getUsername(), sysUserLoginQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getEmail(), sysUserLoginQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkUpdateUserInfoExists(oldUserEntity.getTelephone(), sysUserLoginQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));
    }

    @Override
    public void checkUpdateUserInfoExists(SysUserInfoEntity oldUserInfoEntity, SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        checkUpdateUserInfoExists(oldUserInfoEntity.getUsername(), sysUserInfoQueryVo.getUsername(), "用户名", str -> checkUsernameExists(str));
        checkUpdateUserInfoExists(oldUserInfoEntity.getEmail(), sysUserInfoQueryVo.getEmail(), "邮箱", str -> checkEmailExists(str));
        checkUpdateUserInfoExists(oldUserInfoEntity.getTelephone(), sysUserInfoQueryVo.getTelephone(), "手机号码", str -> checkTelephoneExists(str));
    }

    @Override
    public void checkUpdateUserInfoExists(String oldStr, String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception {
        boolean emailChangeFlag = Boolean.FALSE;
        if(StringUtils.isNotEmpty(oldStr)){
            emailChangeFlag = !oldStr.equals(str);
        }else if(StringUtils.isNotEmpty(str)){
            emailChangeFlag = !str.equals(oldStr);
        }
        if(emailChangeFlag){
            boolean existsFlag = checkUserInfoExists.checkUserInfoExists(str);
            if(existsFlag){
                throw new UserException(message + "已经存在，请重新输入！");
            }
        }
    }

}
