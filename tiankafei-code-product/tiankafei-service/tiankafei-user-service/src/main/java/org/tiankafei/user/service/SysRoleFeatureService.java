package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysRoleFeatureEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysRoleFeatureQueryParam;
import org.tiankafei.user.param.SysRoleFeaturePageQueryParam;
import org.tiankafei.user.vo.SysRoleFeatureQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统角色对应的功能配置表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysRoleFeatureService extends BaseService<SysRoleFeatureEntity> {
    
    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param sysRoleFeatureQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysRoleFeatureExists(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param sysRoleFeatureQueryVo
     * @return
     * @throws Exception
     */
    Object saveSysRoleFeature(SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception;
    
    /**
     * 保存 系统角色对应的功能配置表 集合
     *
     * @param sysRoleFeatureQueryVoList
     * @return
     * @throws Exception
     */
    boolean saveSysRoleFeatureList(List<SysRoleFeatureQueryVo> sysRoleFeatureQueryVoList) throws Exception;

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param sysRoleFeatureQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysRoleFeature(SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception;

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleFeature(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param sysRoleFeatureQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRoleFeature(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception;

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysRoleFeatureQueryVo getSysRoleFeatureById(Serializable id) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param sysRoleFeaturePageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysRoleFeatureQueryVo> getSysRoleFeaturePageList(SysRoleFeaturePageQueryParam sysRoleFeaturePageQueryParam) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param sysRoleFeatureQueryParam
     * @return
     * @throws Exception
     */
     List<SysRoleFeatureQueryVo> getSysRoleFeatureList(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception;
    
    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param sysRoleFeatureQueryParam
     * @return
     * @throws Exception
     */
    int countSysRoleFeature(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception;

}