package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysUserRoleEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysUserRoleQueryParam;
import org.tiankafei.user.param.SysUserRolePageQueryParam;
import org.tiankafei.user.vo.SysUserRoleQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 用户拥有的角色关系表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
    
    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param sysUserRoleQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysUserRoleExists(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception;

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param sysUserRoleQueryVo
     * @return
     * @throws Exception
     */
    Object addSysUserRole(SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception;
    
    /**
     * 保存 用户拥有的角色关系表 集合
     *
     * @param sysUserRoleQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysUserRoleList(List<SysUserRoleQueryVo> sysUserRoleQueryVoList) throws Exception;

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param sysUserRoleQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysUserRole(SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception;

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRole(String ids) throws Exception;
	
    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param sysUserRoleQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception;

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysUserRoleQueryVo getSysUserRoleById(Serializable id) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param sysUserRolePageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysUserRoleQueryVo> getSysUserRolePageList(SysUserRolePageQueryParam sysUserRolePageQueryParam) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param sysUserRoleQueryParam
     * @return
     * @throws Exception
     */
     List<SysUserRoleQueryVo> getSysUserRoleList(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception;
    
    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param sysUserRoleQueryParam
     * @return
     * @throws Exception
     */
    int countSysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception;

}