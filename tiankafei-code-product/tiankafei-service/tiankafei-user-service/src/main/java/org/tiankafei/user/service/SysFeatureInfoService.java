package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysFeatureInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysFeatureInfoQueryParam;
import org.tiankafei.user.param.SysFeatureInfoPageQueryParam;
import org.tiankafei.user.vo.SysFeatureInfoQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统功能菜单 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysFeatureInfoService extends BaseService<SysFeatureInfoEntity> {
    
    /**
     * 校验 系统功能菜单 是否已经存在
     *
     * @param sysFeatureInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysFeatureInfoExists(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception;

    /**
     * 保存 系统功能菜单
     *
     * @param sysFeatureInfoQueryVo
     * @return
     * @throws Exception
     */
    Object saveSysFeatureInfo(SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception;
    
    /**
     * 保存 系统功能菜单 集合
     *
     * @param sysFeatureInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean saveSysFeatureInfoList(List<SysFeatureInfoQueryVo> sysFeatureInfoQueryVoList) throws Exception;

    /**
     * 修改 系统功能菜单
     *
     * @param sysFeatureInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysFeatureInfo(SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception;

    /**
     * 删除 系统功能菜单
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysFeatureInfo(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统功能菜单
     *
     * @param sysFeatureInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysFeatureInfo(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 系统功能菜单 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysFeatureInfoQueryVo getSysFeatureInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统功能菜单 分页对象列表
     *
     * @param sysFeatureInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysFeatureInfoQueryVo> getSysFeatureInfoPageList(SysFeatureInfoPageQueryParam sysFeatureInfoPageQueryParam) throws Exception;

    /**
     * 获取 系统功能菜单 对象列表
     *
     * @param sysFeatureInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysFeatureInfoQueryVo> getSysFeatureInfoList(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception;
    
    /**
     * 计算 系统功能菜单 总记录数
     *
     * @param sysFeatureInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysFeatureInfo(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception;

}