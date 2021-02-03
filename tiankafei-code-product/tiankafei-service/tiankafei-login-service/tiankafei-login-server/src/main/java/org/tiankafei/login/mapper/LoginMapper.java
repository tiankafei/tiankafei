package org.tiankafei.login.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.user.vo.UserLoginVo;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public interface LoginMapper {

    /**
     * 获取用户、角色、功能的所有数据
     *
     * @param userId
     * @return
     */
    UserInfoVo getSysUserAndRoleAndFeatureById(@Param("param") Long userId);

    /**
     * 根据用户名登录获取用户对象
     *
     * @param keywords
     * @return
     */
    UserLoginVo queryUserLoginFromUsername(@Param("param") String keywords);

    /**
     * 根据邮箱登录获取用户对象
     *
     * @param keywords
     * @return
     */
    UserLoginVo queryUserLoginFromEmail(@Param("param") String keywords);

    /**
     * 根据手机号码登录获取用户对象
     *
     * @param keywords
     * @return
     */
    UserLoginVo queryUserLoginFromTelephone(@Param("param") String keywords);

    /**
     * 登录获取用户对象
     *
     * @param keywords
     * @return
     */
    UserLoginVo queryUserLoginFromMore(@Param("param") String keywords);

}
