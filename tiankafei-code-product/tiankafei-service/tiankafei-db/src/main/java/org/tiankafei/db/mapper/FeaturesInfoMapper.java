package org.tiankafei.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.db.entity.FeaturesInfoEntity;
import org.tiankafei.db.param.FeaturesInfoCheckParam;
import org.tiankafei.db.param.FeaturesInfoCountParam;
import org.tiankafei.db.param.FeaturesInfoDeleteParam;
import org.tiankafei.db.param.FeaturesInfoListParam;
import org.tiankafei.db.param.FeaturesInfoPageParam;
import org.tiankafei.db.vo.FeaturesInfoVo;

/**
 * <p>
 * 功能注册表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface FeaturesInfoMapper extends BaseMapper<FeaturesInfoEntity> {

    /**
     * 校验 功能注册表 是否已经存在
     *
     * @param featuresInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkFeaturesInfoServiceExists(@Param("param") FeaturesInfoCheckParam featuresInfoCheckParam) throws Exception;

    /**
     * 保存 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    Object addFeaturesInfoService(@Param("param") FeaturesInfoVo featuresInfoVo) throws Exception;

    /**
     * 批量保存 功能注册表
     *
     * @param featuresInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddFeaturesInfoService(@Param("param") List<FeaturesInfoVo> featuresInfoVoList) throws Exception;

    /**
     * 删除 功能注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteFeaturesInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 功能注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteFeaturesInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 功能注册表
     *
     * @param featuresInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteFeaturesInfoService(@Param("param") FeaturesInfoDeleteParam featuresInfoDeleteParam) throws Exception;

    /**
     * 修改 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    boolean updateFeaturesInfoService(@Param("param") FeaturesInfoVo featuresInfoVo) throws Exception;

    /**
     * 根据ID获取 功能注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    FeaturesInfoVo getFeaturesInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 功能注册表 对象列表
     *
     * @param featuresInfoListParam
     * @return
     * @throws Exception
     */
    List<FeaturesInfoVo> getFeaturesInfoServiceList(@Param("param") FeaturesInfoListParam featuresInfoListParam) throws Exception;

    /**
     * 获取 功能注册表 分页对象列表
     *
     * @param page
     * @param featuresInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<FeaturesInfoVo> getFeaturesInfoServicePageList(@Param("page") Page page, @Param("param") FeaturesInfoPageParam featuresInfoPageParam) throws Exception;

    /**
     * 计算 功能注册表 总记录数
     *
     * @param featuresInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countFeaturesInfoService(@Param("param") FeaturesInfoCountParam featuresInfoCountParam) throws Exception;

}
