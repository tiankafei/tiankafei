package org.tiankafei.blog.service.impl;

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
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.blog.entity.GlobalSettingEntity;
import org.tiankafei.blog.mapper.GlobalSettingMapper;
import org.tiankafei.blog.param.GlobalSettingCheckParam;
import org.tiankafei.blog.param.GlobalSettingCountParam;
import org.tiankafei.blog.param.GlobalSettingDeleteParam;
import org.tiankafei.blog.param.GlobalSettingListParam;
import org.tiankafei.blog.param.GlobalSettingPageParam;
import org.tiankafei.blog.service.GlobalSettingService;
import org.tiankafei.blog.vo.GlobalSettingVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客选项设置 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GlobalSettingServiceImpl extends BaseServiceImpl<GlobalSettingMapper, GlobalSettingEntity> implements GlobalSettingService {

    @Autowired
    private GlobalSettingMapper globalSettingMapper;


    /**
     * 校验 系统的博客选项设置 是否已经存在
     *
     * @param globalSettingCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkGlobalSettingServiceExists(GlobalSettingCheckParam globalSettingCheckParam) throws Exception {
        LambdaQueryWrapper<GlobalSettingEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (globalSettingCheckParam != null) {
            Long id = globalSettingCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(GlobalSettingEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addGlobalSettingService(GlobalSettingVo globalSettingVo) throws Exception {
        GlobalSettingEntity globalSettingEntity = new GlobalSettingEntity();
        BeanUtils.copyProperties(globalSettingVo, globalSettingEntity);
        super.save(globalSettingEntity);
        return globalSettingEntity.getId();
    }

    /**
     * 保存 系统的博客选项设置 集合
     *
     * @param globalSettingVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddGlobalSettingService(List<GlobalSettingVo> globalSettingVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(globalSettingVoList)) {
            List<GlobalSettingEntity> globalSettingEntityList = Lists.newArrayList();
            for (GlobalSettingVo globalSettingVo : globalSettingVoList) {
                GlobalSettingEntity globalSettingEntity = new GlobalSettingEntity();
                BeanUtils.copyProperties(globalSettingVo, globalSettingEntity);
                globalSettingEntityList.add(globalSettingEntity);
            }
            super.saveBatch(globalSettingEntityList);

            return globalSettingEntityList.stream().map(globalSettingEntity -> globalSettingEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统的博客选项设置
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteGlobalSettingService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统的博客选项设置
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteGlobalSettingService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统的博客选项设置
     *
     * @param globalSettingDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteGlobalSettingService(GlobalSettingDeleteParam globalSettingDeleteParam) throws Exception {
        LambdaQueryWrapper<GlobalSettingEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (globalSettingDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateGlobalSettingService(GlobalSettingVo globalSettingVo) throws Exception {
        GlobalSettingEntity globalSettingEntity = new GlobalSettingEntity();
        BeanUtils.copyProperties(globalSettingVo, globalSettingEntity);
        return super.updateById(globalSettingEntity);
    }

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public GlobalSettingVo getGlobalSettingServiceById(Serializable id) throws Exception {
        GlobalSettingEntity globalSettingEntity = super.getById(id);
        if (globalSettingEntity == null) {
            return null;
        }
        GlobalSettingVo globalSettingVo = new GlobalSettingVo();
        BeanUtils.copyProperties(globalSettingEntity, globalSettingVo);
        return globalSettingVo;
    }

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param globalSettingListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<GlobalSettingVo> getGlobalSettingServiceList(GlobalSettingListParam globalSettingListParam) throws Exception {
        return globalSettingMapper.getGlobalSettingServiceList(globalSettingListParam);
    }

    /**
     * 获取 系统的博客选项设置 分页对象列表
     *
     * @param globalSettingPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<GlobalSettingVo> getGlobalSettingServicePageList(GlobalSettingPageParam globalSettingPageParam) throws Exception {
        Page page = setPageParam(globalSettingPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<GlobalSettingVo> iPage = globalSettingMapper.getGlobalSettingServicePageList(page, globalSettingPageParam);
        List<Long> idList = iPage.getRecords().stream().map(globalSettingVo -> globalSettingVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<GlobalSettingVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            GlobalSettingListParam globalSettingListParam = new GlobalSettingListParam();
            globalSettingListParam.setIdList(idList);
            List<GlobalSettingVo> globalSettingVoList = this.getGlobalSettingServiceList(globalSettingListParam);
            paging.setRecords(globalSettingVoList);
        }
        return paging;
    }

    /**
     * 计算 系统的博客选项设置 总记录数
     *
     * @param globalSettingCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countGlobalSettingService(GlobalSettingCountParam globalSettingCountParam) throws Exception {
        LambdaQueryWrapper<GlobalSettingEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (globalSettingCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
