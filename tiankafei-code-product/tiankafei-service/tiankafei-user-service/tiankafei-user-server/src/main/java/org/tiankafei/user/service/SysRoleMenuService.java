package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysRoleMenuEntity;
import org.tiankafei.user.param.SysRoleMenuPageQueryParam;
import org.tiankafei.user.param.SysRoleMenuQueryParam;
import org.tiankafei.user.vo.SysRoleMenuQueryVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统角色对应的功能配置表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenuEntity> {

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param sysRoleMenuQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysRoleMenuExists(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param sysRoleMenuQueryVo
     * @return
     * @throws Exception
     */
    Object addSysRoleMenu(SysRoleMenuQueryVo sysRoleMenuQueryVo) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表 集合
     *
     * @param sysRoleMenuQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysRoleMenuList(List<SysRoleMenuQueryVo> sysRoleMenuQueryVoList) throws Exception;

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param sysRoleMenuQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysRoleMenu(SysRoleMenuQueryVo sysRoleMenuQueryVo) throws Exception;

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleMenu(String ids) throws Exception;

    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param sysRoleMenuQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception;

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysRoleMenuQueryVo getSysRoleMenuById(Serializable id) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param sysRoleMenuPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysRoleMenuQueryVo> getSysRoleMenuPageList(SysRoleMenuPageQueryParam sysRoleMenuPageQueryParam) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param sysRoleMenuQueryParam
     * @return
     * @throws Exception
     */
    List<SysRoleMenuQueryVo> getSysRoleMenuList(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception;

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param sysRoleMenuQueryParam
     * @return
     * @throws Exception
     */
    int countSysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception;

}