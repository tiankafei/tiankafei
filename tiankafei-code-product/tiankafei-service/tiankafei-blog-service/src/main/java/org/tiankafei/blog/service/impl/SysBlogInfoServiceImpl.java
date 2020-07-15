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
import org.tiankafei.blog.entity.SysBlogInfoEntity;
import org.tiankafei.blog.mapper.SysBlogInfoMapper;
import org.tiankafei.blog.param.SysBlogInfoPageQueryParam;
import org.tiankafei.blog.param.SysBlogInfoQueryParam;
import org.tiankafei.blog.service.SysBlogInfoService;
import org.tiankafei.blog.vo.SysBlogInfoQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 系统的博客数据 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysBlogInfoServiceImpl extends BaseServiceImpl<SysBlogInfoMapper, SysBlogInfoEntity> implements SysBlogInfoService {

    @Autowired
    private SysBlogInfoMapper sysBlogInfoMapper;

    @Override
    public boolean checkSysBlogInfoExists(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysBlogInfo(SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception {
        SysBlogInfoEntity sysBlogInfoEntity = new SysBlogInfoEntity();
        BeanUtils.copyProperties(sysBlogInfoQueryVo, sysBlogInfoEntity);
        super.save(sysBlogInfoEntity);
        return sysBlogInfoEntity.getId();
    }

    @Override
    public boolean addSysBlogInfoList(List<SysBlogInfoQueryVo> sysBlogInfoQueryVoList) throws Exception {
        if (sysBlogInfoQueryVoList != null && !sysBlogInfoQueryVoList.isEmpty()) {
            List<SysBlogInfoEntity> sysBlogInfoList = new ArrayList<>();
            for (SysBlogInfoQueryVo sysBlogInfoQueryVo : sysBlogInfoQueryVoList) {
                SysBlogInfoEntity sysBlogInfoEntity = new SysBlogInfoEntity();
                BeanUtils.copyProperties(sysBlogInfoQueryVo, sysBlogInfoEntity);
                sysBlogInfoList.add(sysBlogInfoEntity);
            }
            super.saveBatch(sysBlogInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysBlogInfo(SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception {
        SysBlogInfoEntity sysBlogInfoEntity = new SysBlogInfoEntity();
        BeanUtils.copyProperties(sysBlogInfoQueryVo, sysBlogInfoEntity);
        return super.updateById(sysBlogInfoEntity);
    }

    @Override
    public boolean deleteSysBlogInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysBlogInfo(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysBlogInfoQueryVo getSysBlogInfoById(Serializable id) throws Exception {
        //SysBlogInfoQueryVo sysBlogInfoQueryVo = sysBlogInfoMapper.getSysBlogInfoById(id);

        SysBlogInfoEntity sysBlogInfoEntity = super.getById(id);
        SysBlogInfoQueryVo sysBlogInfoQueryVo = new SysBlogInfoQueryVo();
        BeanUtils.copyProperties(sysBlogInfoEntity, sysBlogInfoQueryVo);
        return sysBlogInfoQueryVo;
    }

    @Override
    public Paging<SysBlogInfoQueryVo> getSysBlogInfoPageList(SysBlogInfoPageQueryParam sysBlogInfoPageQueryParam) throws Exception {
        //IPage<SysBlogInfoQueryVo> iPage = sysBlogInfoMapper.getSysBlogInfoPageList(page, sysBlogInfoPageQueryParam);

        Page page = setPageParam(sysBlogInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysBlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysBlogInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysBlogInfoQueryVo> getSysBlogInfoList(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        List<SysBlogInfoQueryVo> sysBlogInfoQueryVoList = sysBlogInfoMapper.getSysBlogInfoList(sysBlogInfoQueryParam);
        return sysBlogInfoQueryVoList;
    }

    @Override
    public int countSysBlogInfo(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}