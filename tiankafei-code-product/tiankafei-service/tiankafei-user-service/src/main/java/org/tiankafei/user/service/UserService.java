package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.user.vo.SysUserLoginQueryVo;

/**
 * @author tiankafei
 */
public interface UserService {

    /**
     * 新增时校验用户信息是否存在
     * @param sysUserLoginQueryVo
     * @throws Exception
     */
    void checkAddUserInfoExists(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception;

    /**
     * 新增时校验用户信息是否存在
     * @param sysUserInfoQueryVo
     * @throws Exception
     */
    void checkAddUserInfoExists(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception;

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     * @throws Exception
     */
    boolean checkUsernameExists(String username) throws Exception;

    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     * @throws Exception
     */
    boolean checkEmailExists(String email) throws Exception;

    /**
     * 验证手机号码是否存在
     * @param telephone
     * @return
     * @throws Exception
     */
    boolean checkTelephoneExists(String telephone) throws Exception;

    /**
     * 新增时校验用户信息是否存在
     * @param str
     * @param message
     * @param checkUserInfoExists
     * @throws Exception
     */
    public void checkAddUserInfoExists(String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception ;

    /**
     * 修改时，校验用户信息是否存在
     * @param oldUserEntity
     * @param sysUserLoginQueryVo
     * @throws Exception
     */
    void checkUpdateUserInfoExists(SysUserLoginEntity oldUserEntity, SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception;

    /**
     * 修改时，校验用户信息是否存在
     * @param oldUserInfoEntity
     * @param sysUserInfoQueryVo
     * @throws Exception
     */
    void checkUpdateUserInfoExists(SysUserInfoEntity oldUserInfoEntity, SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception;

    /**
     * 修改时，校验用户信息是否存在
     * @param oldStr
     * @param str
     * @param message
     * @param checkUserInfoExists
     * @throws Exception
     */
    public void checkUpdateUserInfoExists(String oldStr, String str, String message, CheckUserInfoExists checkUserInfoExists) throws Exception ;

}
