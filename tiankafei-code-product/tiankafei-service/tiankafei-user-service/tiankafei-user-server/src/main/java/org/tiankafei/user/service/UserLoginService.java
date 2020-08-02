package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 用户登录信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserLoginService extends BaseService<UserLoginEntity> {

    /**
     * 保存 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    Object addSysUserLogin(UserLoginVo userLoginVo) throws Exception;

    /**
     * 保存 用户登录信息表 集合
     *
     * @param userLoginVoList
     * @return
     * @throws Exception
     */
    boolean addSysUserLoginList(List<UserLoginVo> userLoginVoList) throws Exception;

    /**
     * 修改 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    boolean updateSysUserLogin(UserLoginVo userLoginVo) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserLogin(String ids) throws Exception;

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserLoginVo getSysUserLoginById(Serializable id) throws Exception;

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param userLoginPageParam
     * @return
     * @throws Exception
     */
    Paging<UserLoginVo> getSysUserLoginPageList(UserLoginPageParam userLoginPageParam) throws Exception;

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param userLoginListParam
     * @return
     * @throws Exception
     */
    List<UserLoginVo> getSysUserLoginList(UserLoginListParam userLoginListParam) throws Exception;

    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param userLoginListParam
     * @return
     * @throws Exception
     */
    int countSysUserLogin(UserLoginListParam userLoginListParam) throws Exception;

}