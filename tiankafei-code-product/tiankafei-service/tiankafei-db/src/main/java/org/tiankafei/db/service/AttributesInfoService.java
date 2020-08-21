package org.tiankafei.db.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.db.entity.AttributesInfoEntity;
import org.tiankafei.db.param.AttributesInfoCheckParam;
import org.tiankafei.db.param.AttributesInfoCountParam;
import org.tiankafei.db.param.AttributesInfoDeleteParam;
import org.tiankafei.db.param.AttributesInfoListParam;
import org.tiankafei.db.param.AttributesInfoPageParam;
import org.tiankafei.db.vo.AttributesInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能的属性注册表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface AttributesInfoService extends BaseService<AttributesInfoEntity> {

    /**
     * 校验 功能的属性注册表 是否已经存在
     *
     * @param attributesInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkAttributesInfoServiceExists(AttributesInfoCheckParam attributesInfoCheckParam) throws Exception;

    /**
     * 保存 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    Long addAttributesInfoService(AttributesInfoVo attributesInfoVo) throws Exception;

    /**
     * 批量保存 功能的属性注册表
     *
     * @param attributesInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddAttributesInfoService(List<AttributesInfoVo> attributesInfoVoList) throws Exception;

    /**
     * 删除 功能的属性注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteAttributesInfoService(String id) throws Exception;

    /**
     * 批量删除 功能的属性注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteAttributesInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 功能的属性注册表
     *
     * @param attributesInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteAttributesInfoService(AttributesInfoDeleteParam attributesInfoDeleteParam) throws Exception;

    /**
     * 修改 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    boolean updateAttributesInfoService(AttributesInfoVo attributesInfoVo) throws Exception;

    /**
     * 根据ID获取 功能的属性注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    AttributesInfoVo getAttributesInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 功能的属性注册表 对象列表
     *
     * @param attributesInfoListParam
     * @return
     * @throws Exception
     */
    List<AttributesInfoVo> getAttributesInfoServiceList(AttributesInfoListParam attributesInfoListParam) throws Exception;

    /**
     * 获取 功能的属性注册表 分页对象列表
     *
     * @param attributesInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<AttributesInfoVo> getAttributesInfoServicePageList(AttributesInfoPageParam attributesInfoPageParam) throws Exception;

    /**
     * 计算 功能的属性注册表 总记录数
     *
     * @param attributesInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countAttributesInfoService(AttributesInfoCountParam attributesInfoCountParam) throws Exception;

}
