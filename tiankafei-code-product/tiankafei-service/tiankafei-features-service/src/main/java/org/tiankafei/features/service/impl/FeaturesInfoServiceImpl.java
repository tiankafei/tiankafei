package org.tiankafei.features.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.features.entity.FeaturesInfoEntity;
import org.tiankafei.features.mapper.FeaturesInfoMapper;
import org.tiankafei.features.param.FeaturesInfoCheckParam;
import org.tiankafei.features.param.FeaturesInfoCountParam;
import org.tiankafei.features.param.FeaturesInfoDeleteParam;
import org.tiankafei.features.param.FeaturesInfoListParam;
import org.tiankafei.features.param.FeaturesInfoPageParam;
import org.tiankafei.features.service.FeaturesInfoService;
import org.tiankafei.features.vo.FeaturesInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能注册表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class FeaturesInfoServiceImpl extends BaseServiceImpl<FeaturesInfoMapper, FeaturesInfoEntity> implements FeaturesInfoService {

    @Autowired
    private FeaturesInfoMapper featuresInfoMapper;


    /**
     * 校验 功能注册表 是否已经存在
     *
     * @param featuresInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkFeaturesInfoServiceExists(FeaturesInfoCheckParam featuresInfoCheckParam) throws Exception {
        LambdaQueryWrapper<FeaturesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (featuresInfoCheckParam != null) {
            Integer id = featuresInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(FeaturesInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Integer addFeaturesInfoService(FeaturesInfoVo featuresInfoVo) throws Exception {
        FeaturesInfoEntity featuresInfoEntity = new FeaturesInfoEntity();
        BeanUtils.copyProperties(featuresInfoVo, featuresInfoEntity);
        super.save(featuresInfoEntity);
        return featuresInfoEntity.getId();
    }

    /**
     * 保存 功能注册表 集合
     *
     * @param featuresInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Integer> batchAddFeaturesInfoService(List<FeaturesInfoVo> featuresInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(featuresInfoVoList)) {
            List<FeaturesInfoEntity> featuresInfoEntityList = Lists.newArrayList();
            for (FeaturesInfoVo featuresInfoVo : featuresInfoVoList) {
                FeaturesInfoEntity featuresInfoEntity = new FeaturesInfoEntity();
                BeanUtils.copyProperties(featuresInfoVo, featuresInfoEntity);
                featuresInfoEntityList.add(featuresInfoEntity);
            }
            super.saveBatch(featuresInfoEntityList);

            return featuresInfoEntityList.stream().map(featuresInfoEntity -> featuresInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 功能注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteFeaturesInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 功能注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteFeaturesInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 功能注册表
     *
     * @param featuresInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteFeaturesInfoService(FeaturesInfoDeleteParam featuresInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<FeaturesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (featuresInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateFeaturesInfoService(FeaturesInfoVo featuresInfoVo) throws Exception {
        FeaturesInfoEntity featuresInfoEntity = new FeaturesInfoEntity();
        BeanUtils.copyProperties(featuresInfoVo, featuresInfoEntity);
        return super.updateById(featuresInfoEntity);
    }

    /**
     * 根据ID获取 功能注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public FeaturesInfoVo getFeaturesInfoServiceById(Serializable id) throws Exception {
        FeaturesInfoEntity featuresInfoEntity = super.getById(id);
        if (featuresInfoEntity == null) {
            return null;
        }
        FeaturesInfoVo featuresInfoVo = new FeaturesInfoVo();
        BeanUtils.copyProperties(featuresInfoEntity, featuresInfoVo);
        return featuresInfoVo;
    }

    /**
     * 获取 功能注册表 对象列表
     *
     * @param featuresInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<FeaturesInfoVo> getFeaturesInfoServiceList(FeaturesInfoListParam featuresInfoListParam) throws Exception {
        return featuresInfoMapper.getFeaturesInfoServiceList(featuresInfoListParam);
    }

    /**
     * 获取 功能注册表 分页对象列表
     *
     * @param featuresInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<FeaturesInfoVo> getFeaturesInfoServicePageList(FeaturesInfoPageParam featuresInfoPageParam) throws Exception {
        Page page = setPageParam(featuresInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<FeaturesInfoVo> iPage = featuresInfoMapper.getFeaturesInfoServicePageList(page, featuresInfoPageParam);
        List<Integer> idList = iPage.getRecords().stream().map(featuresInfoVo -> featuresInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<FeaturesInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            FeaturesInfoListParam featuresInfoListParam = new FeaturesInfoListParam();
            featuresInfoListParam.setIdList(idList);
            List<FeaturesInfoVo> featuresInfoVoList = this.getFeaturesInfoServiceList(featuresInfoListParam);
            paging.setRecords(featuresInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 功能注册表 总记录数
     *
     * @param featuresInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countFeaturesInfoService(FeaturesInfoCountParam featuresInfoCountParam) throws Exception {
        LambdaQueryWrapper<FeaturesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (featuresInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
