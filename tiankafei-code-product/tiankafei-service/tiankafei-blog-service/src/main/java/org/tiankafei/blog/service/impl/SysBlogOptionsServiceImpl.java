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
import org.tiankafei.blog.entity.SysBlogOptionsEntity;
import org.tiankafei.blog.mapper.SysBlogOptionsMapper;
import org.tiankafei.blog.param.SysBlogOptionsPageQueryParam;
import org.tiankafei.blog.param.SysBlogOptionsQueryParam;
import org.tiankafei.blog.service.SysBlogOptionsService;
import org.tiankafei.blog.vo.SysBlogOptionsQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 系统的博客选项设置 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysBlogOptionsServiceImpl extends BaseServiceImpl<SysBlogOptionsMapper, SysBlogOptionsEntity> implements SysBlogOptionsService {

    @Autowired
    private SysBlogOptionsMapper sysBlogOptionsMapper;

    @Override
    public boolean checkSysBlogOptionsExists(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogOptionsEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysBlogOptions(SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception {
        SysBlogOptionsEntity sysBlogOptionsEntity = new SysBlogOptionsEntity();
        BeanUtils.copyProperties(sysBlogOptionsQueryVo, sysBlogOptionsEntity);
        super.save(sysBlogOptionsEntity);
        return sysBlogOptionsEntity.getId();
    }

    @Override
    public boolean addSysBlogOptionsList(List<SysBlogOptionsQueryVo> sysBlogOptionsQueryVoList) throws Exception {
        if (sysBlogOptionsQueryVoList != null && !sysBlogOptionsQueryVoList.isEmpty()) {
            List<SysBlogOptionsEntity> sysBlogOptionsList = new ArrayList<>();
            for (SysBlogOptionsQueryVo sysBlogOptionsQueryVo : sysBlogOptionsQueryVoList) {
                SysBlogOptionsEntity sysBlogOptionsEntity = new SysBlogOptionsEntity();
                BeanUtils.copyProperties(sysBlogOptionsQueryVo, sysBlogOptionsEntity);
                sysBlogOptionsList.add(sysBlogOptionsEntity);
            }
            super.saveBatch(sysBlogOptionsList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysBlogOptions(SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception {
        SysBlogOptionsEntity sysBlogOptionsEntity = new SysBlogOptionsEntity();
        BeanUtils.copyProperties(sysBlogOptionsQueryVo, sysBlogOptionsEntity);
        return super.updateById(sysBlogOptionsEntity);
    }

    @Override
    public boolean deleteSysBlogOptions(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysBlogOptions(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogOptionsEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysBlogOptionsQueryVo getSysBlogOptionsById(Serializable id) throws Exception {
        //SysBlogOptionsQueryVo sysBlogOptionsQueryVo = sysBlogOptionsMapper.getSysBlogOptionsById(id);

        SysBlogOptionsEntity sysBlogOptionsEntity = super.getById(id);
        SysBlogOptionsQueryVo sysBlogOptionsQueryVo = new SysBlogOptionsQueryVo();
        BeanUtils.copyProperties(sysBlogOptionsEntity, sysBlogOptionsQueryVo);
        return sysBlogOptionsQueryVo;
    }

    @Override
    public Paging<SysBlogOptionsQueryVo> getSysBlogOptionsPageList(SysBlogOptionsPageQueryParam sysBlogOptionsPageQueryParam) throws Exception {
        //IPage<SysBlogOptionsQueryVo> iPage = sysBlogOptionsMapper.getSysBlogOptionsPageList(page, sysBlogOptionsPageQueryParam);

        Page page = setPageParam(sysBlogOptionsPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysBlogOptionsEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysBlogOptionsQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysBlogOptionsQueryVo> getSysBlogOptionsList(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        List<SysBlogOptionsQueryVo> sysBlogOptionsQueryVoList = sysBlogOptionsMapper.getSysBlogOptionsList(sysBlogOptionsQueryParam);
        return sysBlogOptionsQueryVoList;
    }

    @Override
    public int countSysBlogOptions(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        LambdaQueryWrapper<SysBlogOptionsEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}