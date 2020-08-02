package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.vo.RoleInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 角色信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RoleInfoService extends BaseService<RoleInfoEntity> {

    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    boolean checkSysRoleInfoExists(RoleInfoListParam roleInfoListParam) throws Exception;

    /**
     * 保存 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    Object addSysRoleInfo(RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 保存 角色信息表 集合
     *
     * @param roleInfoVoList
     * @return
     * @throws Exception
     */
    boolean addSysRoleInfoList(List<RoleInfoVo> roleInfoVoList) throws Exception;

    /**
     * 修改 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    boolean updateSysRoleInfo(RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 删除 角色信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleInfo(String ids) throws Exception;

    /**
     * 根据条件删除 角色信息表
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleInfo(RoleInfoListParam roleInfoListParam) throws Exception;

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleInfoVo getSysRoleInfoById(Serializable id) throws Exception;

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param roleInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<RoleInfoVo> getSysRoleInfoPageList(RoleInfoPageParam roleInfoPageParam) throws Exception;

    /**
     * 获取 角色信息表 对象列表
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    List<RoleInfoVo> getSysRoleInfoList(RoleInfoListParam roleInfoListParam) throws Exception;

    /**
     * 计算 角色信息表 总记录数
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    int countSysRoleInfo(RoleInfoListParam roleInfoListParam) throws Exception;

}