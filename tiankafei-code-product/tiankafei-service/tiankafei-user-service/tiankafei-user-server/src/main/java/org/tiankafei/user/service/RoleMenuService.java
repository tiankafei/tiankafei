package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.vo.RoleMenuVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统角色对应的功能配置表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RoleMenuService extends BaseService<RoleMenuEntity> {

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    boolean checkSysRoleMenuExists(RoleMenuListParam roleMenuListParam) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    Object addSysRoleMenu(RoleMenuVo roleMenuVo) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表 集合
     *
     * @param roleMenuVoList
     * @return
     * @throws Exception
     */
    boolean addSysRoleMenuList(List<RoleMenuVo> roleMenuVoList) throws Exception;

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    boolean updateSysRoleMenu(RoleMenuVo roleMenuVo) throws Exception;

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
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleMenu(RoleMenuListParam roleMenuListParam) throws Exception;

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleMenuVo getSysRoleMenuById(Serializable id) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param roleMenuPageParam
     * @return
     * @throws Exception
     */
    Paging<RoleMenuVo> getSysRoleMenuPageList(RoleMenuPageParam roleMenuPageParam) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    List<RoleMenuVo> getSysRoleMenuList(RoleMenuListParam roleMenuListParam) throws Exception;

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    int countSysRoleMenu(RoleMenuListParam roleMenuListParam) throws Exception;

}