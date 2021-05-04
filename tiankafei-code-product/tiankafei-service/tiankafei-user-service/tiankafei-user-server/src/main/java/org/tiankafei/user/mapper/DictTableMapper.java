package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;

/**
 * <p>
 * 系统数据字典的数据表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DictTableMapper extends BaseMapper<DictTableEntity> {

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDictTableServiceExists(@Param("param") DictTableCheckParam dictTableCheckParam) throws Exception;

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    Object addDictTableService(@Param("param") DictTableVo dictTableVo) throws Exception;

    /**
     * 批量保存 系统数据字典的数据表
     *
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddDictTableService(@Param("param") List<DictTableVo> dictTableVoList) throws Exception;

    /**
     * 删除 系统数据字典的数据表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDictTableService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统数据字典的数据表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDictTableService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param dictTableDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDictTableService(@Param("param") DictTableDeleteParam dictTableDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    boolean updateDictTableService(@Param("param") DictTableVo dictTableVo) throws Exception;

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DictTableVo getDictTableServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 根据父ID获取 子系统数据字典项集合
     *
     * @param id
     * @return
     * @throws Exception
     */
    List<DictTableVo> getDictTableChildrenService(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    List<DictTableVo> getDictTableServiceList(@Param("param") DictTableListParam dictTableListParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param page
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    IPage<DictTableVo> getDictTableServicePageList(@Param("page") Page page, @Param("param") DictTablePageParam dictTablePageParam) throws Exception;

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableCountParam
     * @return
     * @throws Exception
     */
    Integer countDictTableService(@Param("param") DictTableCountParam dictTableCountParam) throws Exception;

}
