package org.tiankafei.user.login.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.user.vo.SysUserLoginQueryVo;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public interface LoginMapper {

    /**
     * 获取用户、角色、功能的所有数据
     * @param userId
     * @return
     */
    SysUserInfoQueryVo getSysUserAndRoleAndFeatureById(@Param("param") Long userId);

    /**
     * 根据用户名登录获取用户对象
     * @param loginParamVo
     * @return
     */
    SysUserLoginQueryVo queryUserLoginFromUsername(@Param("param") LoginParamVo loginParamVo);

    /**
     * 根据邮箱登录获取用户对象
     * @param loginParamVo
     * @return
     */
    SysUserLoginQueryVo queryUserLoginFromEmail(@Param("param") LoginParamVo loginParamVo);

    /**
     * 根据手机号码登录获取用户对象
     * @param loginParamVo
     * @return
     */
    SysUserLoginQueryVo queryUserLoginFromTelephone(@Param("param") LoginParamVo loginParamVo);

    /**
     * 登录获取用户对象
     * @param loginParamVo
     * @return
     */
    SysUserLoginQueryVo queryUserLogin(@Param("param") LoginParamVo loginParamVo);

}
