package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.mapper.SysUserLoginMapper;
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
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfoMapper, SysUserInfoEntity> implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Autowired
    private SysUserLoginMapper userLoginMapper;

    @Autowired
    private CheckExistsClient checkExistsClient;

    @Override
    public boolean checkSysUserInfoExists(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysUserInfo(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        // 新增时校验用户信息是否存在
        checkExistsClient.checkAddSysUserExists(LoginEnums.USER_NAME.getCode(), sysUserInfoQueryVo.getUsername());
        checkExistsClient.checkAddSysUserExists(LoginEnums.EMAIL.getCode(), sysUserInfoQueryVo.getEmail());
        checkExistsClient.checkAddSysUserExists(LoginEnums.PHONE.getCode(), sysUserInfoQueryVo.getTelephone());

        // 保存用户登录表数据
        SysUserLoginEntity userLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, userLoginEntity);
        userLoginMapper.insert(userLoginEntity);

        // 保存用户信息表数据
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
        sysUserInfoEntity.setId(userLoginEntity.getId());
        super.save(sysUserInfoEntity);

        return sysUserInfoEntity.getId();
    }
        
    @Override
    public boolean addSysUserInfoList(List<SysUserInfoQueryVo> sysUserInfoQueryVoList) throws Exception {
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
        SysUserInfoEntity oldUserInfoEntity = super.getById(sysUserInfoQueryVo.getId());
        // 修改时，校验用户信息是否存在
        checkExistsClient.checkUpdateSysUserExists(LoginEnums.USER_NAME.getCode(), sysUserInfoQueryVo.getUsername(), oldUserInfoEntity.getUsername());
        checkExistsClient.checkUpdateSysUserExists(LoginEnums.EMAIL.getCode(), sysUserInfoQueryVo.getEmail(), oldUserInfoEntity.getEmail());
        checkExistsClient.checkUpdateSysUserExists(LoginEnums.PHONE.getCode(), sysUserInfoQueryVo.getTelephone(), oldUserInfoEntity.getTelephone());

        // 更新用户登录表数据
        SysUserLoginEntity userLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, userLoginEntity);
        userLoginMapper.updateById(userLoginEntity);

        // 更新用户信息表数据
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
        super.updateById(sysUserInfoEntity);

        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysUserInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        List<String> idList = Arrays.asList(idArray);

        if(CollectionUtils.isNotEmpty(idList)){
            // 删除用户登录表数据
            userLoginMapper.deleteBatchIds(idList);
            // 删除用户信息表数据
            super.removeByIds(idList);
        }
        return Boolean.TRUE;
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
    public SysUserInfoQueryVo getSysUserAndRoleAndFeatureById(Serializable id) throws Exception {
        SysUserInfoEntity sysUserInfoEntity = super.getById(id);
        SysUserInfoQueryVo sysUserInfoQueryVo = new SysUserInfoQueryVo();
        BeanUtils.copyProperties(sysUserInfoEntity, sysUserInfoQueryVo);

        // 获取角色，功能清单的数据

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
        List<SysUserInfoQueryVo> sysUserInfoQueryVoList = userInfoMapper.getSysUserInfoList(sysUserInfoQueryParam);
        return sysUserInfoQueryVoList;
    }
    
    @Override
    public int countSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}