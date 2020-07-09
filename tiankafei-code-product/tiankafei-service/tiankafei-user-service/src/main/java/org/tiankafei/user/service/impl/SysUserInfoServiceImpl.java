package org.tiankafei.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.SysUserInfoMapper;
import org.tiankafei.user.mapper.SysUserLoginMapper;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.user.service.SysUserRoleService;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private SysUserRoleService userRoleService;

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
        checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), sysUserInfoQueryVo.getUsername());
        checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), sysUserInfoQueryVo.getEmail());
        checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), sysUserInfoQueryVo.getTelephone());

        // 保存用户登录表数据
        SysUserLoginEntity sysUserLoginEntity = new SysUserLoginEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo.getUserLoginQueryVo(), sysUserLoginEntity);
        // 新增时密码加密
        sysUserLoginEntity.setPassword(SecureUtil.md5(sysUserLoginEntity.getPassword()));
        // id值赋为空，使用自动生成的ID
        sysUserLoginEntity.setId(null);
        userLoginMapper.insert(sysUserLoginEntity);

        // 保存用户信息表数据
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoQueryVo, sysUserInfoEntity);
        sysUserInfoEntity.setId(sysUserLoginEntity.getId());
        super.save(sysUserInfoEntity);

        return sysUserInfoEntity.getId();
    }

    @Override
    public boolean addSysUserInfoList(List<SysUserInfoQueryVo> sysUserInfoQueryVoList) throws Exception {
        if (sysUserInfoQueryVoList != null && !sysUserInfoQueryVoList.isEmpty()) {
            List<SysUserInfoEntity> sysUserInfoList = new ArrayList<>();
            for (SysUserInfoQueryVo sysUserInfoQueryVo : sysUserInfoQueryVoList) {
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
        checkExistsClient.checkUpdateSysUserExists(UserEnums.USER_NAME.getCode(), sysUserInfoQueryVo.getUsername(), oldUserInfoEntity.getUsername());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.EMAIL.getCode(), sysUserInfoQueryVo.getEmail(), oldUserInfoEntity.getEmail());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.PHONE.getCode(), sysUserInfoQueryVo.getTelephone(), oldUserInfoEntity.getTelephone());

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

        if (CollectionUtils.isNotEmpty(idList)) {
            // 删除用户登录表数据
            userLoginMapper.deleteBatchIds(idList);
            // 删除用户信息表数据
            super.removeByIds(idList);
            // 删除用户和角色的对应关系
            userRoleService.deleteSysUserRoleFromUserId(ids);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

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
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
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
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}