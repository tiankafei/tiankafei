package org.tiankafei.user.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.UserException;

public interface QueryUserAndCheckExistsService {

    /**
     * 新增时验证系统用户是否存在
     *
     * @param keywords
     * @return
     */
    Boolean checkAddSysUserExists(String keywords) throws UserException ;

    /**
     * 登录时验证用户是否存在
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    Boolean checkLoginSysUserExists(String keywords) throws LoginException;

    /**
     * 编辑时验证系统用户是否存在
     *
     * @param keywords
     * @param oldKeywords
     * @return
     * @throws UserException
     */
    default Boolean checkUpdateSysUserExists(String keywords, String oldKeywords) throws UserException {
        boolean emailChangeFlag = Boolean.FALSE;
        if(StringUtils.isNotEmpty(oldKeywords)){
            emailChangeFlag = !oldKeywords.equals(keywords);
        }else if(StringUtils.isNotEmpty(keywords)){
            emailChangeFlag = !keywords.equals(oldKeywords);
        }
        if(emailChangeFlag){
            return checkAddSysUserExists(keywords);
        }
        return Boolean.FALSE;
    }

    /**
     * 获取用户登录对象
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    SysUserLoginQueryVo getSysUserLoginQueryVo(String keywords, String password) throws LoginException;

    /**
     * 转换对象
     * @param sysUserLoginEntity
     * @return
     */
    default SysUserLoginQueryVo getSysUserLoginQueryVo(SysUserLoginEntity sysUserLoginEntity){
        SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
        BeanUtils.copyProperties(sysUserLoginEntity, sysUserLoginQueryVo);
        return sysUserLoginQueryVo;
    }

    /**
     * 获取用户标识，
     * @return
     */
    Integer getUserFlag();

}
