package org.tiankafei.user.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统数据字典的数据表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DictTableService extends BaseService<DictTableEntity> {

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDictTableServiceExists(DictTableCheckParam dictTableCheckParam) throws Exception;

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    Long addDictTableService(DictTableVo dictTableVo) throws Exception;

    /**
     * 批量保存 系统数据字典的数据表
     *
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddDictTableService(List<DictTableVo> dictTableVoList) throws Exception;

    /**
     * 删除 系统数据字典的数据表
     *
     * @param dictId
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDictTableService(Long dictId, Long id) throws Exception;

    /**
     * 批量删除 系统数据字典的数据表
     *
     * @param dictId
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDictTableService(Long dictId, String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param dictTableDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDictTableService(DictTableDeleteParam dictTableDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    boolean updateDictTableService(DictTableVo dictTableVo) throws Exception;

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dictId
     * @param id
     * @return
     * @throws Exception
     */
    DictTableVo getDictTableServiceById(Long dictId, Serializable id) throws Exception;

    /**
     * 根据父ID获取 子系统数据字典项集合
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    List<DictTableVo> getDictTableChildrenService(DictTablePageParam dictTablePageParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    List<DictTableVo> getDictTableServiceList(DictTableListParam dictTableListParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象同步树列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    List<DictTableVo> getDictTableTreeServiceList(DictTableListParam dictTableListParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    Paging<DictTableVo> getDictTableServicePageList(DictTablePageParam dictTablePageParam) throws Exception;

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableCountParam
     * @return
     * @throws Exception
     */
    Integer countDictTableService(DictTableCountParam dictTableCountParam) throws Exception;

}
