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
import org.tiankafei.features.entity.AttributesInfoEntity;
import org.tiankafei.features.mapper.AttributesInfoMapper;
import org.tiankafei.features.param.AttributesInfoCheckParam;
import org.tiankafei.features.param.AttributesInfoCountParam;
import org.tiankafei.features.param.AttributesInfoDeleteParam;
import org.tiankafei.features.param.AttributesInfoListParam;
import org.tiankafei.features.param.AttributesInfoPageParam;
import org.tiankafei.features.service.AttributesInfoService;
import org.tiankafei.features.vo.AttributesInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能的属性注册表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class AttributesInfoServiceImpl extends BaseServiceImpl<AttributesInfoMapper, AttributesInfoEntity> implements AttributesInfoService {

    @Autowired
    private AttributesInfoMapper attributesInfoMapper;


    /**
     * 校验 功能的属性注册表 是否已经存在
     *
     * @param attributesInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkAttributesInfoServiceExists(AttributesInfoCheckParam attributesInfoCheckParam) throws Exception {
        LambdaQueryWrapper<AttributesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (attributesInfoCheckParam != null) {
            Long id = attributesInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(AttributesInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addAttributesInfoService(AttributesInfoVo attributesInfoVo) throws Exception {
        AttributesInfoEntity attributesInfoEntity = new AttributesInfoEntity();
        BeanUtils.copyProperties(attributesInfoVo, attributesInfoEntity);
        super.save(attributesInfoEntity);
        return attributesInfoEntity.getId();
    }

    /**
     * 保存 功能的属性注册表 集合
     *
     * @param attributesInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddAttributesInfoService(List<AttributesInfoVo> attributesInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(attributesInfoVoList)) {
            List<AttributesInfoEntity> attributesInfoEntityList = Lists.newArrayList();
            for (AttributesInfoVo attributesInfoVo : attributesInfoVoList) {
                AttributesInfoEntity attributesInfoEntity = new AttributesInfoEntity();
                BeanUtils.copyProperties(attributesInfoVo, attributesInfoEntity);
                attributesInfoEntityList.add(attributesInfoEntity);
            }
            super.saveBatch(attributesInfoEntityList);

            return attributesInfoEntityList.stream().map(attributesInfoEntity -> attributesInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 功能的属性注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteAttributesInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 功能的属性注册表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteAttributesInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 功能的属性注册表
     *
     * @param attributesInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteAttributesInfoService(AttributesInfoDeleteParam attributesInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<AttributesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (attributesInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateAttributesInfoService(AttributesInfoVo attributesInfoVo) throws Exception {
        AttributesInfoEntity attributesInfoEntity = new AttributesInfoEntity();
        BeanUtils.copyProperties(attributesInfoVo, attributesInfoEntity);
        return super.updateById(attributesInfoEntity);
    }

    /**
     * 根据ID获取 功能的属性注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public AttributesInfoVo getAttributesInfoServiceById(Serializable id) throws Exception {
        AttributesInfoEntity attributesInfoEntity = super.getById(id);
        if (attributesInfoEntity == null) {
            return null;
        }
        AttributesInfoVo attributesInfoVo = new AttributesInfoVo();
        BeanUtils.copyProperties(attributesInfoEntity, attributesInfoVo);
        return attributesInfoVo;
    }

    /**
     * 获取 功能的属性注册表 对象列表
     *
     * @param attributesInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<AttributesInfoVo> getAttributesInfoServiceList(AttributesInfoListParam attributesInfoListParam) throws Exception {
        return attributesInfoMapper.getAttributesInfoServiceList(attributesInfoListParam);
    }

    /**
     * 获取 功能的属性注册表 分页对象列表
     *
     * @param attributesInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<AttributesInfoVo> getAttributesInfoServicePageList(AttributesInfoPageParam attributesInfoPageParam) throws Exception {
        Page page = setPageParam(attributesInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<AttributesInfoVo> iPage = attributesInfoMapper.getAttributesInfoServicePageList(page, attributesInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(attributesInfoVo -> attributesInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<AttributesInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            AttributesInfoListParam attributesInfoListParam = new AttributesInfoListParam();
            attributesInfoListParam.setIdList(idList);
            List<AttributesInfoVo> attributesInfoVoList = this.getAttributesInfoServiceList(attributesInfoListParam);
            paging.setRecords(attributesInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 功能的属性注册表 总记录数
     *
     * @param attributesInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countAttributesInfoService(AttributesInfoCountParam attributesInfoCountParam) throws Exception {
        LambdaQueryWrapper<AttributesInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (attributesInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
