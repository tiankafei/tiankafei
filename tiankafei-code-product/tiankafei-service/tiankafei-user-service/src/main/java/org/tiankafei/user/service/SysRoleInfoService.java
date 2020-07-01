package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysRoleInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysRoleInfoQueryParam;
import org.tiankafei.user.param.SysRoleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRoleInfoQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 角色信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysRoleInfoService extends BaseService<SysRoleInfoEntity> {
    
    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param sysRoleInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysRoleInfoExists(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception;

    /**
     * 保存 角色信息表
     *
     * @param sysRoleInfoQueryVo
     * @return
     * @throws Exception
     */
    Object addSysRoleInfo(SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception;
    
    /**
     * 保存 角色信息表 集合
     *
     * @param sysRoleInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysRoleInfoList(List<SysRoleInfoQueryVo> sysRoleInfoQueryVoList) throws Exception;

    /**
     * 修改 角色信息表
     *
     * @param sysRoleInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysRoleInfo(SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception;

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
     * @param sysRoleInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleInfo(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysRoleInfoQueryVo getSysRoleInfoById(Serializable id) throws Exception;

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param sysRoleInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysRoleInfoQueryVo> getSysRoleInfoPageList(SysRoleInfoPageQueryParam sysRoleInfoPageQueryParam) throws Exception;

    /**
     * 获取 角色信息表 对象列表
     *
     * @param sysRoleInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysRoleInfoQueryVo> getSysRoleInfoList(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception;
    
    /**
     * 计算 角色信息表 总记录数
     *
     * @param sysRoleInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysRoleInfo(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception;

}