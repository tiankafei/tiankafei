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
import org.tiankafei.blog.entity.DiaryInfoEntity;
import org.tiankafei.blog.mapper.DiaryInfoMapper;
import org.tiankafei.blog.param.DiaryInfoCheckParam;
import org.tiankafei.blog.param.DiaryInfoCountParam;
import org.tiankafei.blog.param.DiaryInfoDeleteParam;
import org.tiankafei.blog.param.DiaryInfoListParam;
import org.tiankafei.blog.param.DiaryInfoPageParam;
import org.tiankafei.blog.service.DiaryInfoService;
import org.tiankafei.blog.vo.DiaryInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客日记 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DiaryInfoServiceImpl extends BaseServiceImpl<DiaryInfoMapper, DiaryInfoEntity> implements DiaryInfoService {

    @Autowired
    private DiaryInfoMapper diaryInfoMapper;


    /**
     * 校验 系统的博客日记 是否已经存在
     *
     * @param diaryInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkDiaryInfoServiceExists(DiaryInfoCheckParam diaryInfoCheckParam) throws Exception {
        LambdaQueryWrapper<DiaryInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (diaryInfoCheckParam != null) {
            Long id = diaryInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(DiaryInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addDiaryInfoService(DiaryInfoVo diaryInfoVo) throws Exception {
        DiaryInfoEntity diaryInfoEntity = new DiaryInfoEntity();
        BeanUtils.copyProperties(diaryInfoVo, diaryInfoEntity);
        super.save(diaryInfoEntity);
        return diaryInfoEntity.getId();
    }

    /**
     * 保存 系统的博客日记 集合
     *
     * @param diaryInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddDiaryInfoService(List<DiaryInfoVo> diaryInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(diaryInfoVoList)) {
            List<DiaryInfoEntity> diaryInfoEntityList = Lists.newArrayList();
            for (DiaryInfoVo diaryInfoVo : diaryInfoVoList) {
                DiaryInfoEntity diaryInfoEntity = new DiaryInfoEntity();
                BeanUtils.copyProperties(diaryInfoVo, diaryInfoEntity);
                diaryInfoEntityList.add(diaryInfoEntity);
            }
            super.saveBatch(diaryInfoEntityList);

            return diaryInfoEntityList.stream().map(diaryInfoEntity -> diaryInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统的博客日记
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteDiaryInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统的博客日记
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDiaryInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统的博客日记
     *
     * @param diaryInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteDiaryInfoService(DiaryInfoDeleteParam diaryInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<DiaryInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (diaryInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateDiaryInfoService(DiaryInfoVo diaryInfoVo) throws Exception {
        DiaryInfoEntity diaryInfoEntity = new DiaryInfoEntity();
        BeanUtils.copyProperties(diaryInfoVo, diaryInfoEntity);
        return super.updateById(diaryInfoEntity);
    }

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DiaryInfoVo getDiaryInfoServiceById(Serializable id) throws Exception {
        DiaryInfoEntity diaryInfoEntity = super.getById(id);
        if (diaryInfoEntity == null) {
            return null;
        }
        DiaryInfoVo diaryInfoVo = new DiaryInfoVo();
        BeanUtils.copyProperties(diaryInfoEntity, diaryInfoVo);
        return diaryInfoVo;
    }

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param diaryInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<DiaryInfoVo> getDiaryInfoServiceList(DiaryInfoListParam diaryInfoListParam) throws Exception {
        return diaryInfoMapper.getDiaryInfoServiceList(diaryInfoListParam);
    }

    /**
     * 获取 系统的博客日记 分页对象列表
     *
     * @param diaryInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<DiaryInfoVo> getDiaryInfoServicePageList(DiaryInfoPageParam diaryInfoPageParam) throws Exception {
        Page page = setPageParam(diaryInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<DiaryInfoVo> iPage = diaryInfoMapper.getDiaryInfoServicePageList(page, diaryInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(diaryInfoVo -> diaryInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<DiaryInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            DiaryInfoListParam diaryInfoListParam = new DiaryInfoListParam();
            diaryInfoListParam.setIdList(idList);
            List<DiaryInfoVo> diaryInfoVoList = this.getDiaryInfoServiceList(diaryInfoListParam);
            paging.setRecords(diaryInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统的博客日记 总记录数
     *
     * @param diaryInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countDiaryInfoService(DiaryInfoCountParam diaryInfoCountParam) throws Exception {
        LambdaQueryWrapper<DiaryInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (diaryInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
