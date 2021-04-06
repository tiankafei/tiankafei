package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.param.RoleMenuCheckParam;
import org.tiankafei.user.param.RoleMenuCountParam;
import org.tiankafei.user.param.RoleMenuDeleteParam;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.vo.RoleMenuVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统角色对应的功能配置表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RoleMenuService extends BaseService<RoleMenuEntity> {

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param roleMenuCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRoleMenuServiceExists(RoleMenuCheckParam roleMenuCheckParam) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    Long addRoleMenuService(RoleMenuVo roleMenuVo) throws Exception;

    /**
     * 批量保存 系统角色对应的功能配置表
     *
     * @param roleMenuVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRoleMenuService(List<RoleMenuVo> roleMenuVoList) throws Exception;

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRoleMenuService(String id) throws Exception;

    /**
     * 批量删除 系统角色对应的功能配置表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRoleMenuService(String ids) throws Exception;

    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param roleMenuDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRoleMenuService(RoleMenuDeleteParam roleMenuDeleteParam) throws Exception;

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    boolean updateRoleMenuService(RoleMenuVo roleMenuVo) throws Exception;

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleMenuVo getRoleMenuServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    List<RoleMenuVo> getRoleMenuServiceList(RoleMenuListParam roleMenuListParam) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param roleMenuPageParam
     * @return
     * @throws Exception
     */
    Paging<RoleMenuVo> getRoleMenuServicePageList(RoleMenuPageParam roleMenuPageParam) throws Exception;

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param roleMenuCountParam
     * @return
     * @throws Exception
     */
    Integer countRoleMenuService(RoleMenuCountParam roleMenuCountParam) throws Exception;

}
