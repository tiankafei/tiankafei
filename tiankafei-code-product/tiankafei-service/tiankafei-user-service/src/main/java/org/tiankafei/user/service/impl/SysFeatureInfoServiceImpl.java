package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysFeatureInfoEntity;
import org.tiankafei.user.mapper.SysFeatureInfoMapper;
import org.tiankafei.user.service.SysFeatureInfoService;
import org.tiankafei.user.param.SysFeatureInfoQueryParam;
import org.tiankafei.user.param.SysFeatureInfoPageQueryParam;
import org.tiankafei.user.vo.SysFeatureInfoQueryVo;
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
 * 系统功能菜单信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysFeatureInfoServiceImpl extends BaseServiceImpl<SysFeatureInfoMapper, SysFeatureInfoEntity> implements SysFeatureInfoService {

    @Autowired
    private SysFeatureInfoMapper sysFeatureInfoMapper;

    @Override
    public boolean checkSysFeatureInfoExists(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysFeatureInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysFeatureInfo(SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception {
        SysFeatureInfoEntity sysFeatureInfoEntity = new SysFeatureInfoEntity();
        BeanUtils.copyProperties(sysFeatureInfoQueryVo, sysFeatureInfoEntity);
        super.save(sysFeatureInfoEntity);
        return sysFeatureInfoEntity.getId();
    }
        
    @Override
    public boolean addSysFeatureInfoList(List<SysFeatureInfoQueryVo> sysFeatureInfoQueryVoList) throws Exception {
        if(sysFeatureInfoQueryVoList != null && !sysFeatureInfoQueryVoList.isEmpty()){
            List<SysFeatureInfoEntity> sysFeatureInfoList = new ArrayList<>();
            for ( SysFeatureInfoQueryVo sysFeatureInfoQueryVo : sysFeatureInfoQueryVoList) {
                SysFeatureInfoEntity sysFeatureInfoEntity = new SysFeatureInfoEntity();
                BeanUtils.copyProperties(sysFeatureInfoQueryVo, sysFeatureInfoEntity);
                sysFeatureInfoList.add(sysFeatureInfoEntity);
            }
            super.saveBatch(sysFeatureInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysFeatureInfo(SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception {
        SysFeatureInfoEntity sysFeatureInfoEntity = new SysFeatureInfoEntity();
        BeanUtils.copyProperties(sysFeatureInfoQueryVo, sysFeatureInfoEntity);
        return super.updateById(sysFeatureInfoEntity);
    }

    @Override
    public boolean deleteSysFeatureInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysFeatureInfo(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysFeatureInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysFeatureInfoQueryVo getSysFeatureInfoById(Serializable id) throws Exception {
         SysFeatureInfoEntity sysFeatureInfoEntity = super.getById(id);
         SysFeatureInfoQueryVo sysFeatureInfoQueryVo = new SysFeatureInfoQueryVo();
         BeanUtils.copyProperties(sysFeatureInfoEntity, sysFeatureInfoQueryVo);
        return sysFeatureInfoQueryVo;
    }

    @Override
    public Paging<SysFeatureInfoQueryVo> getSysFeatureInfoPageList(SysFeatureInfoPageQueryParam sysFeatureInfoPageQueryParam) throws Exception {
        Page page = setPageParam(sysFeatureInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysFeatureInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysFeatureInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysFeatureInfoQueryVo> getSysFeatureInfoList(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        List<SysFeatureInfoQueryVo> sysFeatureInfoQueryVoList = sysFeatureInfoMapper.getSysFeatureInfoList(sysFeatureInfoQueryParam);
        return sysFeatureInfoQueryVoList;
    }
    
    @Override
    public int countSysFeatureInfo(SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysFeatureInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}