package org.tiankafei.features.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.features.entity.AttributesInfoEntity;
import org.tiankafei.features.param.AttributesInfoCheckParam;
import org.tiankafei.features.param.AttributesInfoCountParam;
import org.tiankafei.features.param.AttributesInfoDeleteParam;
import org.tiankafei.features.param.AttributesInfoListParam;
import org.tiankafei.features.param.AttributesInfoPageParam;
import org.tiankafei.features.vo.AttributesInfoVo;

/**
 * <p>
 * 功能的属性注册表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface AttributesInfoMapper extends BaseMapper<AttributesInfoEntity> {

    /**
     * 校验 功能的属性注册表 是否已经存在
     *
     * @param attributesInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkAttributesInfoServiceExists(@Param("param") AttributesInfoCheckParam attributesInfoCheckParam) throws Exception;

    /**
     * 保存 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    Object addAttributesInfoService(@Param("param") AttributesInfoVo attributesInfoVo) throws Exception;

    /**
     * 批量保存 功能的属性注册表
     *
     * @param attributesInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddAttributesInfoService(@Param("param") List<AttributesInfoVo> attributesInfoVoList) throws Exception;

    /**
     * 删除 功能的属性注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteAttributesInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 功能的属性注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteAttributesInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 功能的属性注册表
     *
     * @param attributesInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteAttributesInfoService(@Param("param") AttributesInfoDeleteParam attributesInfoDeleteParam) throws Exception;

    /**
     * 修改 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    boolean updateAttributesInfoService(@Param("param") AttributesInfoVo attributesInfoVo) throws Exception;

    /**
     * 根据ID获取 功能的属性注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    AttributesInfoVo getAttributesInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 功能的属性注册表 对象列表
     *
     * @param attributesInfoListParam
     * @return
     * @throws Exception
     */
    List<AttributesInfoVo> getAttributesInfoServiceList(@Param("param") AttributesInfoListParam attributesInfoListParam) throws Exception;

    /**
     * 获取 功能的属性注册表 分页对象列表
     *
     * @param page
     * @param attributesInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<AttributesInfoVo> getAttributesInfoServicePageList(@Param("page") Page page, @Param("param") AttributesInfoPageParam attributesInfoPageParam) throws Exception;

    /**
     * 计算 功能的属性注册表 总记录数
     *
     * @param attributesInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countAttributesInfoService(@Param("param") AttributesInfoCountParam attributesInfoCountParam) throws Exception;

}
