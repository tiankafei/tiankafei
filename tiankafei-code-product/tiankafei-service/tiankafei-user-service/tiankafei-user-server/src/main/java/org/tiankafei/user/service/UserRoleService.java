package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.vo.UserRoleVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 用户拥有的角色关系表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserRoleService extends BaseService<UserRoleEntity> {

    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    boolean checkSysUserRoleExists(UserRoleListParam userRoleListParam) throws Exception;

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    Object addSysUserRole(UserRoleVo userRoleVo) throws Exception;

    /**
     * 保存 用户拥有的角色关系表 集合
     *
     * @param userRoleVoList
     * @return
     * @throws Exception
     */
    boolean addSysUserRoleList(List<UserRoleVo> userRoleVoList) throws Exception;

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    boolean updateSysUserRole(UserRoleVo userRoleVo) throws Exception;

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRole(String ids) throws Exception;

    /**
     * 根据用户id删除 用户拥有的角色关系表
     *
     * @param userIds
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRoleFromUserId(String userIds) throws Exception;

    /**
     * 根据角色id删除 用户拥有的角色关系表
     *
     * @param roleIds
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRoleFromRoleId(String roleIds) throws Exception;

    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRole(UserRoleListParam userRoleListParam) throws Exception;

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserRoleVo getSysUserRoleById(Serializable id) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param userRolePageParam
     * @return
     * @throws Exception
     */
    Paging<UserRoleVo> getSysUserRolePageList(UserRolePageParam userRolePageParam) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    List<UserRoleVo> getSysUserRoleList(UserRoleListParam userRoleListParam) throws Exception;

    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    int countSysUserRole(UserRoleListParam userRoleListParam) throws Exception;

}