package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysMenuInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysMenuInfoQueryParam;
import org.tiankafei.user.param.SysMenuInfoPageQueryParam;
import org.tiankafei.user.vo.SysMenuInfoQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统功能菜单信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysMenuInfoService extends BaseService<SysMenuInfoEntity> {
    
    /**
     * 校验 系统功能菜单信息表 是否已经存在
     *
     * @param sysMenuInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysMenuInfoExists(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception;

    /**
     * 保存 系统功能菜单信息表
     *
     * @param sysMenuInfoQueryVo
     * @return
     * @throws Exception
     */
    Object addSysMenuInfo(SysMenuInfoQueryVo sysMenuInfoQueryVo) throws Exception;
    
    /**
     * 保存 系统功能菜单信息表 集合
     *
     * @param sysMenuInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysMenuInfoList(List<SysMenuInfoQueryVo> sysMenuInfoQueryVoList) throws Exception;

    /**
     * 修改 系统功能菜单信息表
     *
     * @param sysMenuInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysMenuInfo(SysMenuInfoQueryVo sysMenuInfoQueryVo) throws Exception;

    /**
     * 删除 系统功能菜单信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysMenuInfo(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统功能菜单信息表
     *
     * @param sysMenuInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysMenuInfo(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysMenuInfoQueryVo getSysMenuInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统功能菜单信息表 分页对象列表
     *
     * @param sysMenuInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysMenuInfoQueryVo> getSysMenuInfoPageList(SysMenuInfoPageQueryParam sysMenuInfoPageQueryParam) throws Exception;

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param sysMenuInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysMenuInfoQueryVo> getSysMenuInfoList(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception;
    
    /**
     * 计算 系统功能菜单信息表 总记录数
     *
     * @param sysMenuInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysMenuInfo(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception;

}