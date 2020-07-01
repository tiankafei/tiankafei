package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysRuleInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysRuleInfoQueryParam;
import org.tiankafei.user.param.SysRuleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRuleInfoQueryVo;
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
public interface SysRuleInfoService extends BaseService<SysRuleInfoEntity> {
    
    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param sysRuleInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysRuleInfoExists(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception;

    /**
     * 保存 角色信息表
     *
     * @param sysRuleInfoQueryVo
     * @return
     * @throws Exception
     */
    Object saveSysRuleInfo(SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception;
    
    /**
     * 保存 角色信息表 集合
     *
     * @param sysRuleInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean saveSysRuleInfoList(List<SysRuleInfoQueryVo> sysRuleInfoQueryVoList) throws Exception;

    /**
     * 修改 角色信息表
     *
     * @param sysRuleInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysRuleInfo(SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception;

    /**
     * 删除 角色信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysRuleInfo(String ids) throws Exception;
	
    /**
     * 根据条件删除 角色信息表
     *
     * @param sysRuleInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysRuleInfo(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysRuleInfoQueryVo getSysRuleInfoById(Serializable id) throws Exception;

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param sysRuleInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysRuleInfoQueryVo> getSysRuleInfoPageList(SysRuleInfoPageQueryParam sysRuleInfoPageQueryParam) throws Exception;

    /**
     * 获取 角色信息表 对象列表
     *
     * @param sysRuleInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysRuleInfoQueryVo> getSysRuleInfoList(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception;
    
    /**
     * 计算 角色信息表 总记录数
     *
     * @param sysRuleInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysRuleInfo(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception;

}