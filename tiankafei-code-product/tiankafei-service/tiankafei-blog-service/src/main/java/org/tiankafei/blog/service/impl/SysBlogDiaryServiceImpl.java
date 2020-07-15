package org.tiankafei.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.blog.entity.SysBlogDiaryEntity;
import org.tiankafei.blog.mapper.SysBlogDiaryMapper;
import org.tiankafei.blog.param.SysBlogDiaryPageQueryParam;
import org.tiankafei.blog.param.SysBlogDiaryQueryParam;
import org.tiankafei.blog.service.SysBlogDiaryService;
import org.tiankafei.blog.vo.SysBlogDiaryQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 系统的博客日记 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysBlogDiaryServiceImpl extends BaseServiceImpl<SysBlogDiaryMapper, SysBlogDiaryEntity> implements SysBlogDiaryService {

    @Autowired
    private SysBlogDiaryMapper sysBlogDiaryMapper;

    @Override
    public boolean checkSysBlogDiaryExists(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogDiaryEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysBlogDiary(SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception {
        SysBlogDiaryEntity sysBlogDiaryEntity = new SysBlogDiaryEntity();
        BeanUtils.copyProperties(sysBlogDiaryQueryVo, sysBlogDiaryEntity);
        super.save(sysBlogDiaryEntity);
        return sysBlogDiaryEntity.getId();
    }

    @Override
    public boolean addSysBlogDiaryList(List<SysBlogDiaryQueryVo> sysBlogDiaryQueryVoList) throws Exception {
        if (sysBlogDiaryQueryVoList != null && !sysBlogDiaryQueryVoList.isEmpty()) {
            List<SysBlogDiaryEntity> sysBlogDiaryList = new ArrayList<>();
            for (SysBlogDiaryQueryVo sysBlogDiaryQueryVo : sysBlogDiaryQueryVoList) {
                SysBlogDiaryEntity sysBlogDiaryEntity = new SysBlogDiaryEntity();
                BeanUtils.copyProperties(sysBlogDiaryQueryVo, sysBlogDiaryEntity);
                sysBlogDiaryList.add(sysBlogDiaryEntity);
            }
            super.saveBatch(sysBlogDiaryList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysBlogDiary(SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception {
        SysBlogDiaryEntity sysBlogDiaryEntity = new SysBlogDiaryEntity();
        BeanUtils.copyProperties(sysBlogDiaryQueryVo, sysBlogDiaryEntity);
        return super.updateById(sysBlogDiaryEntity);
    }

    @Override
    public boolean deleteSysBlogDiary(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysBlogDiary(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogDiaryEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysBlogDiaryQueryVo getSysBlogDiaryById(Serializable id) throws Exception {
        //SysBlogDiaryQueryVo sysBlogDiaryQueryVo = sysBlogDiaryMapper.getSysBlogDiaryById(id);

        SysBlogDiaryEntity sysBlogDiaryEntity = super.getById(id);
        SysBlogDiaryQueryVo sysBlogDiaryQueryVo = new SysBlogDiaryQueryVo();
        BeanUtils.copyProperties(sysBlogDiaryEntity, sysBlogDiaryQueryVo);
        return sysBlogDiaryQueryVo;
    }

    @Override
    public Paging<SysBlogDiaryQueryVo> getSysBlogDiaryPageList(SysBlogDiaryPageQueryParam sysBlogDiaryPageQueryParam) throws Exception {
        //IPage<SysBlogDiaryQueryVo> iPage = sysBlogDiaryMapper.getSysBlogDiaryPageList(page, sysBlogDiaryPageQueryParam);

        Page page = setPageParam(sysBlogDiaryPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysBlogDiaryEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysBlogDiaryQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysBlogDiaryQueryVo> getSysBlogDiaryList(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        List<SysBlogDiaryQueryVo> sysBlogDiaryQueryVoList = sysBlogDiaryMapper.getSysBlogDiaryList(sysBlogDiaryQueryParam);
        return sysBlogDiaryQueryVoList;
    }

    @Override
    public int countSysBlogDiary(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogDiaryEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}