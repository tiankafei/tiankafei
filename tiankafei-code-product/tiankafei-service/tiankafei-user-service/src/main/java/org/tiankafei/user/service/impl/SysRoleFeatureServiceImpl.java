package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysRoleFeatureEntity;
import org.tiankafei.user.mapper.SysRoleFeatureMapper;
import org.tiankafei.user.service.SysRoleFeatureService;
import org.tiankafei.user.param.SysRoleFeatureQueryParam;
import org.tiankafei.user.param.SysRoleFeaturePageQueryParam;
import org.tiankafei.user.vo.SysRoleFeatureQueryVo;
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
 * 系统角色对应的功能配置表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleFeatureServiceImpl extends BaseServiceImpl<SysRoleFeatureMapper, SysRoleFeatureEntity> implements SysRoleFeatureService {

    @Autowired
    private SysRoleFeatureMapper sysRoleFeatureMapper;

    @Override
    public boolean checkSysRoleFeatureExists(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        LambdaQueryWrapper<SysRoleFeatureEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysRoleFeature(SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception {
        SysRoleFeatureEntity sysRoleFeatureEntity = new SysRoleFeatureEntity();
        BeanUtils.copyProperties(sysRoleFeatureQueryVo, sysRoleFeatureEntity);
        super.save(sysRoleFeatureEntity);
        return sysRoleFeatureEntity.getId();
    }
        
    @Override
    public boolean addSysRoleFeatureList(List<SysRoleFeatureQueryVo> sysRoleFeatureQueryVoList) throws Exception {
        if(sysRoleFeatureQueryVoList != null && !sysRoleFeatureQueryVoList.isEmpty()){
            List<SysRoleFeatureEntity> sysRoleFeatureList = new ArrayList<>();
            for ( SysRoleFeatureQueryVo sysRoleFeatureQueryVo : sysRoleFeatureQueryVoList) {
                SysRoleFeatureEntity sysRoleFeatureEntity = new SysRoleFeatureEntity();
                BeanUtils.copyProperties(sysRoleFeatureQueryVo, sysRoleFeatureEntity);
                sysRoleFeatureList.add(sysRoleFeatureEntity);
            }
            super.saveBatch(sysRoleFeatureList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRoleFeature(SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception {
        SysRoleFeatureEntity sysRoleFeatureEntity = new SysRoleFeatureEntity();
        BeanUtils.copyProperties(sysRoleFeatureQueryVo, sysRoleFeatureEntity);
        return super.updateById(sysRoleFeatureEntity);
    }

    @Override
    public boolean deleteSysRoleFeature(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysRoleFeature(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        LambdaQueryWrapper <SysRoleFeatureEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysRoleFeatureQueryVo getSysRoleFeatureById(Serializable id) throws Exception {
         SysRoleFeatureEntity sysRoleFeatureEntity = super.getById(id);
         SysRoleFeatureQueryVo sysRoleFeatureQueryVo = new SysRoleFeatureQueryVo();
         BeanUtils.copyProperties(sysRoleFeatureEntity, sysRoleFeatureQueryVo);
        return sysRoleFeatureQueryVo;
    }

    @Override
    public Paging<SysRoleFeatureQueryVo> getSysRoleFeaturePageList(SysRoleFeaturePageQueryParam sysRoleFeaturePageQueryParam) throws Exception {
        Page page = setPageParam(sysRoleFeaturePageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysRoleFeatureEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysRoleFeatureQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysRoleFeatureQueryVo> getSysRoleFeatureList(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        List<SysRoleFeatureQueryVo> sysRoleFeatureQueryVoList = sysRoleFeatureMapper.getSysRoleFeatureList(sysRoleFeatureQueryParam);
        return sysRoleFeatureQueryVoList;
    }
    
    @Override
    public int countSysRoleFeature(SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        LambdaQueryWrapper <SysRoleFeatureEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}