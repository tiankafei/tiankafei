package org.tiankafei.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.blog.entity.SysBlogLabelEntity;
import org.tiankafei.blog.mapper.SysBlogLabelMapper;
import org.tiankafei.blog.service.SysBlogLabelService;
import org.tiankafei.blog.param.SysBlogLabelQueryParam;
import org.tiankafei.blog.param.SysBlogLabelPageQueryParam;
import org.tiankafei.blog.vo.SysBlogLabelQueryVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;

/**
 * <pre>
 * 系统的博客标签 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysBlogLabelServiceImpl extends BaseServiceImpl<SysBlogLabelMapper, SysBlogLabelEntity> implements SysBlogLabelService {

    @Autowired
    private SysBlogLabelMapper sysBlogLabelMapper;

    @Override
    public boolean checkSysBlogLabelExists(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogLabelEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysBlogLabel(SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception {
        SysBlogLabelEntity sysBlogLabelEntity = new SysBlogLabelEntity();
        BeanUtils.copyProperties(sysBlogLabelQueryVo, sysBlogLabelEntity);
        super.save(sysBlogLabelEntity);
        return sysBlogLabelEntity.getId();
    }

    @Override
    public boolean addSysBlogLabelList(List<SysBlogLabelQueryVo> sysBlogLabelQueryVoList) throws Exception {
        if (sysBlogLabelQueryVoList != null && !sysBlogLabelQueryVoList.isEmpty()) {
            List<SysBlogLabelEntity> sysBlogLabelList = new ArrayList<>();
            for (SysBlogLabelQueryVo sysBlogLabelQueryVo : sysBlogLabelQueryVoList) {
                SysBlogLabelEntity sysBlogLabelEntity = new SysBlogLabelEntity();
                BeanUtils.copyProperties(sysBlogLabelQueryVo, sysBlogLabelEntity);
                sysBlogLabelList.add(sysBlogLabelEntity);
            }
            super.saveBatch(sysBlogLabelList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysBlogLabel(SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception {
        SysBlogLabelEntity sysBlogLabelEntity = new SysBlogLabelEntity();
        BeanUtils.copyProperties(sysBlogLabelQueryVo, sysBlogLabelEntity);
        return super.updateById(sysBlogLabelEntity);
    }

    @Override
    public boolean deleteSysBlogLabel(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysBlogLabel(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogLabelEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysBlogLabelQueryVo getSysBlogLabelById(Serializable id) throws Exception {
		//SysBlogLabelQueryVo sysBlogLabelQueryVo = sysBlogLabelMapper.getSysBlogLabelById(id);

        SysBlogLabelEntity sysBlogLabelEntity = super.getById(id);
        SysBlogLabelQueryVo sysBlogLabelQueryVo = new SysBlogLabelQueryVo();
        BeanUtils.copyProperties(sysBlogLabelEntity, sysBlogLabelQueryVo);
        return sysBlogLabelQueryVo;
    }

    @Override
    public Paging<SysBlogLabelQueryVo> getSysBlogLabelPageList(SysBlogLabelPageQueryParam sysBlogLabelPageQueryParam) throws Exception {
        //IPage<SysBlogLabelQueryVo> iPage = sysBlogLabelMapper.getSysBlogLabelPageList(page, sysBlogLabelPageQueryParam);

		Page page = setPageParam(sysBlogLabelPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysBlogLabelEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysBlogLabelQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysBlogLabelQueryVo> getSysBlogLabelList(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        List<SysBlogLabelQueryVo> sysBlogLabelQueryVoList = sysBlogLabelMapper.getSysBlogLabelList(sysBlogLabelQueryParam);
        return sysBlogLabelQueryVoList;
    }

    @Override
    public int countSysBlogLabel(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogLabelEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}