package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.user.entity.SysRoleInfoEntity;
import org.tiankafei.user.mapper.SysRoleInfoMapper;
import org.tiankafei.user.service.SysRoleInfoService;
import org.tiankafei.user.param.SysRoleInfoQueryParam;
import org.tiankafei.user.param.SysRoleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRoleInfoQueryVo;
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
public class SysRoleInfoServiceImpl extends BaseServiceImpl<SysRoleInfoMapper, SysRoleInfoEntity> implements SysRoleInfoService {

    @Autowired
    private SysRoleInfoMapper sysRoleInfoMapper;

    @Override
    public boolean checkSysRoleInfoExists(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysRoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysRoleInfo(SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception {
        SysRoleInfoEntity sysRoleInfoEntity = new SysRoleInfoEntity();
        BeanUtils.copyProperties(sysRoleInfoQueryVo, sysRoleInfoEntity);
        super.save(sysRoleInfoEntity);
        return sysRoleInfoEntity.getId();
    }
        
    @Override
    public boolean addSysRoleInfoList(List<SysRoleInfoQueryVo> sysRoleInfoQueryVoList) throws Exception {
        if(sysRoleInfoQueryVoList != null && !sysRoleInfoQueryVoList.isEmpty()){
            List<SysRoleInfoEntity> sysRoleInfoList = new ArrayList<>();
            for ( SysRoleInfoQueryVo sysRoleInfoQueryVo : sysRoleInfoQueryVoList) {
                SysRoleInfoEntity sysRoleInfoEntity = new SysRoleInfoEntity();
                BeanUtils.copyProperties(sysRoleInfoQueryVo, sysRoleInfoEntity);
                sysRoleInfoList.add(sysRoleInfoEntity);
            }
            super.saveBatch(sysRoleInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRoleInfo(SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception {
        SysRoleInfoEntity sysRoleInfoEntity = new SysRoleInfoEntity();
        BeanUtils.copyProperties(sysRoleInfoQueryVo, sysRoleInfoEntity);
        return super.updateById(sysRoleInfoEntity);
    }

    @Override
    public boolean deleteSysRoleInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }
	
    @Override
    public boolean deleteSysRoleInfo(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysRoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysRoleInfoQueryVo getSysRoleInfoById(Serializable id) throws Exception {
         SysRoleInfoEntity sysRoleInfoEntity = super.getById(id);
         SysRoleInfoQueryVo sysRoleInfoQueryVo = new SysRoleInfoQueryVo();
         BeanUtils.copyProperties(sysRoleInfoEntity, sysRoleInfoQueryVo);
        return sysRoleInfoQueryVo;
    }

    @Override
    public Paging<SysRoleInfoQueryVo> getSysRoleInfoPageList(SysRoleInfoPageQueryParam sysRoleInfoPageQueryParam) throws Exception {
        Page page = setPageParam(sysRoleInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysRoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysRoleInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysRoleInfoQueryVo> getSysRoleInfoList(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        List<SysRoleInfoQueryVo> sysRoleInfoQueryVoList = sysRoleInfoMapper.getSysRoleInfoList(sysRoleInfoQueryParam);
        return sysRoleInfoQueryVoList;
    }
    
    @Override
    public int countSysRoleInfo(SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysRoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}