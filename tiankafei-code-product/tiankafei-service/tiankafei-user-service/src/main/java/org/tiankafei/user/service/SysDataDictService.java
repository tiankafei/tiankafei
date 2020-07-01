package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysDataDictEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysDataDictQueryParam;
import org.tiankafei.user.param.SysDataDictPageQueryParam;
import org.tiankafei.user.vo.SysDataDictQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统数据字典表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysDataDictService extends BaseService<SysDataDictEntity> {
    
    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param sysDataDictQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysDataDictExists(SysDataDictQueryParam sysDataDictQueryParam) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param sysDataDictQueryVo
     * @return
     * @throws Exception
     */
    Object saveSysDataDict(SysDataDictQueryVo sysDataDictQueryVo) throws Exception;
    
    /**
     * 保存 系统数据字典表 集合
     *
     * @param sysDataDictQueryVoList
     * @return
     * @throws Exception
     */
    boolean saveSysDataDictList(List<SysDataDictQueryVo> sysDataDictQueryVoList) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param sysDataDictQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysDataDict(SysDataDictQueryVo sysDataDictQueryVo) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysDataDict(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统数据字典表
     *
     * @param sysDataDictQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDataDict(SysDataDictQueryParam sysDataDictQueryParam) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysDataDictQueryVo getSysDataDictById(Serializable id) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param sysDataDictPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysDataDictQueryVo> getSysDataDictPageList(SysDataDictPageQueryParam sysDataDictPageQueryParam) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param sysDataDictQueryParam
     * @return
     * @throws Exception
     */
     List<SysDataDictQueryVo> getSysDataDictList(SysDataDictQueryParam sysDataDictQueryParam) throws Exception;
    
    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param sysDataDictQueryParam
     * @return
     * @throws Exception
     */
    int countSysDataDict(SysDataDictQueryParam sysDataDictQueryParam) throws Exception;

}