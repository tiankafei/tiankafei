package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.vo.DictInfoVo;

/**
 * <p>
 * 系统数据字典表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DictInfoMapper extends BaseMapper<DictInfoEntity> {

    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param dictInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDictInfoServiceExists(@Param("param") DictInfoCheckParam dictInfoCheckParam) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    Object addDictInfoService(@Param("param") DictInfoVo dictInfoVo) throws Exception;

    /**
     * 批量保存 系统数据字典表
     *
     * @param dictInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddDictInfoService(@Param("param") List<DictInfoVo> dictInfoVoList) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDictInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDictInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典表
     *
     * @param dictInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDictInfoService(@Param("param") DictInfoDeleteParam dictInfoDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDictInfoService(@Param("param") DictInfoVo dictInfoVo) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DictInfoVo getDictInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    List<DictInfoVo> getDictInfoServiceList(@Param("param") DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param page
     * @param dictInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<DictInfoVo> getDictInfoServicePageList(@Param("page") Page page, @Param("param") DictInfoPageParam dictInfoPageParam) throws Exception;

    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param dictInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDictInfoService(@Param("param") DictInfoCountParam dictInfoCountParam) throws Exception;

}
