package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.mapper.SysUserInfoMapper;
import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
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
 * 用户基本信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfoMapper, SysUserInfoEntity> implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public boolean checkSysUserInfoExists(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object saveSysUserInfo(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
        super.save(sysUserInfoEntity);
        return sysUserInfoEntity.getId();
    }
        
    @Override
    public boolean saveSysUserInfoList(List<SysUserInfoQueryVo> sysUserInfoQueryVoList) throws Exception {
        if(sysUserInfoQueryVoList != null && !sysUserInfoQueryVoList.isEmpty()){
            List<SysUserInfoEntity> sysUserInfoList = new ArrayList<>();
            for ( SysUserInfoQueryVo sysUserInfoQueryVo : sysUserInfoQueryVoList) {
                SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
                BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
                sysUserInfoList.add(sysUserInfoEntity);
            }
            super.saveBatch(sysUserInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserInfo(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
        return super.updateById(sysUserInfoEntity);
    }

    @Override
    public boolean deleteSysUserInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysUserInfoQueryVo getSysUserInfoById(Serializable id) throws Exception {
         SysUserInfoEntity sysUserInfoEntity = super.getById(id);
         SysUserInfoQueryVo sysUserInfoQueryVo = new SysUserInfoQueryVo();
         BeanUtils.copyProperties(sysUserInfoEntity, sysUserInfoQueryVo);
        return sysUserInfoQueryVo;
    }

    @Override
    public Paging<SysUserInfoQueryVo> getSysUserInfoPageList(SysUserInfoPageQueryParam sysUserInfoPageQueryParam) throws Exception {
        Page page = setPageParam(sysUserInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysUserInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysUserInfoQueryVo> getSysUserInfoList(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        List<SysUserInfoQueryVo> sysUserInfoQueryVoList = sysUserInfoMapper.getSysUserInfoList(sysUserInfoQueryParam);
        return sysUserInfoQueryVoList;
    }
    
    @Override
    public int countSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}