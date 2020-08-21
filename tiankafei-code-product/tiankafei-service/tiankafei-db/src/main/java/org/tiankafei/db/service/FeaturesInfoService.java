package org.tiankafei.db.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.db.entity.FeaturesInfoEntity;
import org.tiankafei.db.param.FeaturesInfoCheckParam;
import org.tiankafei.db.param.FeaturesInfoCountParam;
import org.tiankafei.db.param.FeaturesInfoDeleteParam;
import org.tiankafei.db.param.FeaturesInfoListParam;
import org.tiankafei.db.param.FeaturesInfoPageParam;
import org.tiankafei.db.vo.FeaturesInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能注册表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface FeaturesInfoService extends BaseService<FeaturesInfoEntity> {

    /**
     * 校验 功能注册表 是否已经存在
     *
     * @param featuresInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkFeaturesInfoServiceExists(FeaturesInfoCheckParam featuresInfoCheckParam) throws Exception;

    /**
     * 保存 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    Integer addFeaturesInfoService(FeaturesInfoVo featuresInfoVo) throws Exception;

    /**
     * 批量保存 功能注册表
     *
     * @param featuresInfoVoList
     * @return
     * @throws Exception
     */
    List<Integer> batchAddFeaturesInfoService(List<FeaturesInfoVo> featuresInfoVoList) throws Exception;

    /**
     * 删除 功能注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteFeaturesInfoService(String id) throws Exception;

    /**
     * 批量删除 功能注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteFeaturesInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 功能注册表
     *
     * @param featuresInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteFeaturesInfoService(FeaturesInfoDeleteParam featuresInfoDeleteParam) throws Exception;

    /**
     * 修改 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    boolean updateFeaturesInfoService(FeaturesInfoVo featuresInfoVo) throws Exception;

    /**
     * 根据ID获取 功能注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    FeaturesInfoVo getFeaturesInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 功能注册表 对象列表
     *
     * @param featuresInfoListParam
     * @return
     * @throws Exception
     */
    List<FeaturesInfoVo> getFeaturesInfoServiceList(FeaturesInfoListParam featuresInfoListParam) throws Exception;

    /**
     * 获取 功能注册表 分页对象列表
     *
     * @param featuresInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<FeaturesInfoVo> getFeaturesInfoServicePageList(FeaturesInfoPageParam featuresInfoPageParam) throws Exception;

    /**
     * 计算 功能注册表 总记录数
     *
     * @param featuresInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countFeaturesInfoService(FeaturesInfoCountParam featuresInfoCountParam) throws Exception;

}
