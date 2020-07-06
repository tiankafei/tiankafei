package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.user.bean.VerificationClient;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.mapper.SysUserInfoMapper;
import org.tiankafei.user.mapper.SysUserLoginMapper;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
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
 * 用户登录信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserLoginServiceImpl extends BaseServiceImpl<SysUserLoginMapper, SysUserLoginEntity> implements SysUserLoginService {

    @Autowired
    private SysUserLoginMapper userLoginMapper;

    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Autowired
    private VerificationClient verificationClient;

    @Override
    public boolean checkSysUserLoginExists(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }
    
    @Override
    public Object addSysUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        // 新增时校验用户信息是否存在
        verificationClient.checkSysUserExists(LoginEnums.USER_NAME.getCode(), sysUserLoginQueryVo.getUsername());
        verificationClient.checkSysUserExists(LoginEnums.EMAIL.getCode(), sysUserLoginQueryVo.getEmail());
        verificationClient.checkSysUserExists(LoginEnums.PHONE.getCode(), sysUserLoginQueryVo.getTelephone());


        // 保存用户登录表数据
        SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
        super.save(sysUserLoginEntity);
        Long id = sysUserLoginEntity.getId();

        // 保存用户信息表数据
        SysUserInfoEntity userInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserLoginQueryVo, userInfoEntity);
        userInfoMapper.insert(userInfoEntity);
        return id;
    }

    @Override
    public boolean addSysUserLoginList(List<SysUserLoginQueryVo> sysUserLoginQueryVoList) throws Exception {
        if(sysUserLoginQueryVoList != null && !sysUserLoginQueryVoList.isEmpty()){
            List<SysUserLoginEntity> sysUserLoginList = new ArrayList<>();
            for ( SysUserLoginQueryVo sysUserLoginQueryVo : sysUserLoginQueryVoList) {
                SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
                BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
                sysUserLoginList.add(sysUserLoginEntity);
            }
            super.saveBatch(sysUserLoginList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        SysUserLoginEntity oldUserEntity = super.getById(sysUserLoginQueryVo.getId());
        // 修改时，校验用户信息是否存在
        verificationClient.checkSysUserExists(LoginEnums.USER_NAME.getCode(), sysUserLoginQueryVo.getUsername(), oldUserEntity.getUsername());
        verificationClient.checkSysUserExists(LoginEnums.EMAIL.getCode(), sysUserLoginQueryVo.getEmail(), oldUserEntity.getEmail());
        verificationClient.checkSysUserExists(LoginEnums.PHONE.getCode(), sysUserLoginQueryVo.getTelephone(), oldUserEntity.getTelephone());

        // 更新用户信息表数据
        SysUserInfoEntity userInfoEntity = userInfoMapper.selectById(sysUserLoginQueryVo.getId());
        BeanUtils.copyProperties(sysUserLoginQueryVo, userInfoEntity);
        userInfoMapper.updateById(userInfoEntity);

        // 更新用户登录表数据
        SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserLoginQueryVo, sysUserLoginEntity);
        super.updateById(sysUserLoginEntity);

        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysUserLogin(String ids) throws Exception {
        String[] idArray = ids.split(",");
        List<String> idList = Arrays.asList(idArray);
        if(CollectionUtils.isNotEmpty(idList)){
            // 删除用户信息表
            userInfoMapper.deleteBatchIds(idList);
            // 删除登录用户表
            super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }
	
    @Override
    public boolean deleteSysUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysUserLoginQueryVo getSysUserLoginById(Serializable id) throws Exception {
         SysUserLoginEntity sysUserLoginEntity = super.getById(id);
         SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
         BeanUtils.copyProperties(sysUserLoginEntity, sysUserLoginQueryVo);
        return sysUserLoginQueryVo;
    }

    @Override
    public Paging<SysUserLoginQueryVo> getSysUserLoginPageList(SysUserLoginPageQueryParam sysUserLoginPageQueryParam) throws Exception {
        Page page = setPageParam(sysUserLoginPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysUserLoginQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysUserLoginQueryVo> getSysUserLoginList(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        List<SysUserLoginQueryVo> sysUserLoginQueryVoList = userLoginMapper.getSysUserLoginList(sysUserLoginQueryParam);
        return sysUserLoginQueryVoList;
    }
    
    @Override
    public int countSysUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        LambdaQueryWrapper <SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}