package org.tiankafei.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

public interface QueryUserService {

    /**
     * 登录时验证用户是否存在
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    Boolean checkUserExists(String keywords) throws LoginException;

    /**
     * 获取用户登录对象
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    SysUserLoginQueryVo login(String keywords, String password) throws LoginException;

    /**
     * 转换对象
     * @param sysUserLoginEntity
     * @return
     */
    default SysUserLoginQueryVo switchObject(SysUserLoginEntity sysUserLoginEntity){
        if(sysUserLoginEntity != null){
            SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
            BeanUtils.copyProperties(sysUserLoginEntity, sysUserLoginQueryVo);
            return sysUserLoginQueryVo;
        }
        return null;
    }

    /**
     * 获取查询条件
     *
     * @param keywords
     * @return
     */
    default LambdaQueryWrapper<SysUserLoginEntity> getLambdaQueryWrapper(String keywords) throws LoginException {
        return getLambdaQueryWrapper(keywords, null);
    }

    /**
     * 获取查询条件
     *
     * @param keywords
     * @param password
     * @return
     */
    LambdaQueryWrapper<SysUserLoginEntity> getLambdaQueryWrapper(String keywords, String password) throws LoginException;

    /**
     * 获取用户标识，
     * @return
     */
    Integer getUserFlag();

}
