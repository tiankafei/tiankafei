package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统数据字典的数据表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DictTableService extends BaseService<DictTableEntity> {

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    boolean checkSysDictTableExists(DictTableListParam dictTableListParam) throws Exception;

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    Object addSysDictTable(DictTableVo dictTableVo) throws Exception;

    /**
     * 保存 系统数据字典的数据表 集合
     *
     * @param dataTable
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    boolean addSysDictTableList(String dataTable, List<DictTableVo> dictTableVoList) throws Exception;

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    boolean updateSysDictTable(DictTableVo dictTableVo) throws Exception;

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
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDictTable(DictTableListParam dictTableListParam) throws Exception;

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    DictTableVo getSysDictTableById(String dataTable, Serializable id) throws Exception;

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    Paging<DictTableVo> getSysDictTablePageList(DictTablePageParam dictTablePageParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    List<DictTableVo> getSysDictTableList(DictTableListParam dictTableListParam) throws Exception;

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    int countSysDictTable(DictTableListParam dictTableListParam) throws Exception;

}