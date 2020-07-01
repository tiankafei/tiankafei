package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysDictTableEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysDictTableQueryParam;
import org.tiankafei.user.param.SysDictTablePageQueryParam;
import org.tiankafei.user.vo.SysDictTableQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统数据字典的数据表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysDictTableService extends BaseService<SysDictTableEntity> {
    
    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param sysDictTableQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysDictTableExists(SysDictTableQueryParam sysDictTableQueryParam) throws Exception;

    /**
     * 保存 系统数据字典的数据表
     *
     * @param sysDictTableQueryVo
     * @return
     * @throws Exception
     */
    Object addSysDictTable(SysDictTableQueryVo sysDictTableQueryVo) throws Exception;
    
    /**
     * 保存 系统数据字典的数据表 集合
     *
     * @param dataTable
     * @param sysDictTableQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysDictTableList(String dataTable, List<SysDictTableQueryVo> sysDictTableQueryVoList) throws Exception;

    /**
     * 修改 系统数据字典的数据表
     *
     * @param sysDictTableQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysDictTable(SysDictTableQueryVo sysDictTableQueryVo) throws Exception;

    /**
     * 删除 系统数据字典的数据表
     *
     * @param dataTable
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysDictTable(String dataTable, String ids) throws Exception;
	
    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param sysDictTableQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDictTable(SysDictTableQueryParam sysDictTableQueryParam) throws Exception;

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
     SysDictTableQueryVo getSysDictTableById(String dataTable, Serializable id) throws Exception;

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param sysDictTablePageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysDictTableQueryVo> getSysDictTablePageList(SysDictTablePageQueryParam sysDictTablePageQueryParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param sysDictTableQueryParam
     * @return
     * @throws Exception
     */
     List<SysDictTableQueryVo> getSysDictTableList(SysDictTableQueryParam sysDictTableQueryParam) throws Exception;
    
    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param sysDictTableQueryParam
     * @return
     * @throws Exception
     */
    int countSysDictTable(SysDictTableQueryParam sysDictTableQueryParam) throws Exception;

}