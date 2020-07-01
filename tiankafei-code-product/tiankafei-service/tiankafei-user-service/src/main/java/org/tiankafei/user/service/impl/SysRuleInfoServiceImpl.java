package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysRuleInfoEntity;
import org.tiankafei.user.mapper.SysRuleInfoMapper;
import org.tiankafei.user.service.SysRuleInfoService;
import org.tiankafei.user.param.SysRuleInfoQueryParam;
import org.tiankafei.user.param.SysRuleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRuleInfoQueryVo;
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
 * 角色信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRuleInfoServiceImpl extends BaseServiceImpl<SysRuleInfoMapper, SysRuleInfoEntity> implements SysRuleInfoService {

    @Autowired
    private SysRuleInfoMapper sysRuleInfoMapper;

    @Override
    public boolean checkSysRuleInfoExists(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysRuleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object saveSysRuleInfo(SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception {
        SysRuleInfoEntity sysRuleInfoEntity = new SysRuleInfoEntity();
        BeanUtils.copyProperties(sysRuleInfoQueryVo, sysRuleInfoEntity);
        super.save(sysRuleInfoEntity);
        return sysRuleInfoEntity.getId();
    }
        
    @Override
    public boolean saveSysRuleInfoList(List<SysRuleInfoQueryVo> sysRuleInfoQueryVoList) throws Exception {
        if(sysRuleInfoQueryVoList != null && !sysRuleInfoQueryVoList.isEmpty()){
            List<SysRuleInfoEntity> sysRuleInfoList = new ArrayList<>();
            for ( SysRuleInfoQueryVo sysRuleInfoQueryVo : sysRuleInfoQueryVoList) {
                SysRuleInfoEntity sysRuleInfoEntity = new SysRuleInfoEntity();
                BeanUtils.copyProperties(sysRuleInfoQueryVo, sysRuleInfoEntity);
                sysRuleInfoList.add(sysRuleInfoEntity);
            }
            super.saveBatch(sysRuleInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRuleInfo(SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception {
        SysRuleInfoEntity sysRuleInfoEntity = new SysRuleInfoEntity();
        BeanUtils.copyProperties(sysRuleInfoQueryVo, sysRuleInfoEntity);
        return super.updateById(sysRuleInfoEntity);
    }

    @Override
    public boolean deleteSysRuleInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysRuleInfo(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysRuleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysRuleInfoQueryVo getSysRuleInfoById(Serializable id) throws Exception {
         SysRuleInfoEntity sysRuleInfoEntity = super.getById(id);
         SysRuleInfoQueryVo sysRuleInfoQueryVo = new SysRuleInfoQueryVo();
         BeanUtils.copyProperties(sysRuleInfoEntity, sysRuleInfoQueryVo);
        return sysRuleInfoQueryVo;
    }

    @Override
    public Paging<SysRuleInfoQueryVo> getSysRuleInfoPageList(SysRuleInfoPageQueryParam sysRuleInfoPageQueryParam) throws Exception {
        Page page = setPageParam(sysRuleInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysRuleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysRuleInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysRuleInfoQueryVo> getSysRuleInfoList( SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        List<SysRuleInfoQueryVo> sysRuleInfoQueryVoList = sysRuleInfoMapper.getSysRuleInfoList(sysRuleInfoQueryParam);
        return sysRuleInfoQueryVoList;
    }
    
    @Override
    public int countSysRuleInfo(SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysRuleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}