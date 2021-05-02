package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统数据字典表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DictInfoService extends BaseService<DictInfoEntity> {

    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param dictInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDictInfoServiceExists(DictInfoCheckParam dictInfoCheckParam) throws Exception;

    /**
     * 校验 系统数据字典表的数据表是否已经存在
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    boolean checkDictInfoServiceDataTableExists(String dataTable, String id) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    Long addDictInfoService(DictInfoVo dictInfoVo) throws Exception;

    /**
     * 批量保存 系统数据字典表
     *
     * @param dictInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddDictInfoService(List<DictInfoVo> dictInfoVoList) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDictInfoService(String id) throws Exception;

    /**
     * 批量删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDictInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典表
     *
     * @param dictInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDictInfoService(DictInfoDeleteParam dictInfoDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDictInfoService(DictInfoVo dictInfoVo) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    boolean updateDictInfoServiceStatus(String id, Boolean status) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DictInfoVo getDictInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    List<DictInfoVo> getDictInfoServiceList(DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param dictInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<DictInfoVo> getDictInfoServicePageList(DictInfoPageParam dictInfoPageParam) throws Exception;

    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param dictInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDictInfoService(DictInfoCountParam dictInfoCountParam) throws Exception;

}
