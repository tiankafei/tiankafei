package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.SysUserInfoMapper;
import org.tiankafei.user.model.SysUserInfoDto;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.service.SysUserRoleService;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
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
    private SysUserRoleService userRoleService;

    @Autowired
    private SysUserLoginService userLoginService;

    @Autowired
    private CheckExistsClient checkExistsClient;

    @Override
    public Object addSysUserInfo(SysUserInfoDto sysUserInfoDto) throws Exception {
        // 新增时校验用户信息是否存在
        checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), sysUserInfoDto.getUsername());
        checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), sysUserInfoDto.getEmail());
        checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), sysUserInfoDto.getTelephone());

        // 保存用户登录表数据
        SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
        BeanUtils.copyProperties(sysUserInfoDto, sysUserLoginQueryVo);
        Long id = (Long) userLoginService.addSysUserLogin(sysUserLoginQueryVo);

        // 保存用户信息表数据
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoDto, sysUserInfoEntity);
        sysUserInfoEntity.setId(id);
        super.save(sysUserInfoEntity);

        return id;
    }

    @Override
    public boolean addSysUserInfoList(List<SysUserInfoDto> sysUserInfoList) throws Exception {
        if (CollectionUtils.isNotEmpty(sysUserInfoList)) {
            // 用户信息实体对象集合
            List<SysUserInfoEntity> sysUserInfoEntityList = new ArrayList<>();
            for (SysUserInfoDto sysUserInfoDto : sysUserInfoList) {
                // 对象转换
                SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
                BeanUtils.copyProperties(sysUserInfoDto, sysUserInfoEntity);
                sysUserInfoEntityList.add(sysUserInfoEntity);
            }
            super.saveBatch(sysUserInfoEntityList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserInfo(SysUserInfoDto sysUserInfoDto) throws Exception {
        SysUserInfoEntity oldUserInfoEntity = super.getById(sysUserInfoDto.getId());
        // 修改时，校验用户信息是否存在
        checkExistsClient.checkUpdateSysUserExists(UserEnums.USER_NAME.getCode(), sysUserInfoDto.getUsername(), oldUserInfoEntity.getUsername());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.EMAIL.getCode(), sysUserInfoDto.getEmail(), oldUserInfoEntity.getEmail());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.PHONE.getCode(), sysUserInfoDto.getTelephone(), oldUserInfoEntity.getTelephone());

        // 更新用户登录表数据
        SysUserLoginQueryVo sysUserLoginQueryVo = new SysUserLoginQueryVo();
        BeanUtils.copyProperties(sysUserInfoDto, sysUserLoginQueryVo);
        userLoginService.updateSysUserLogin(sysUserLoginQueryVo);

        // 更新用户信息表数据
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        BeanUtils.copyProperties(sysUserInfoDto, sysUserInfoEntity);
        super.updateById(sysUserInfoEntity);

        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysUserInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        List<String> idList = Arrays.asList(idArray);

        if (CollectionUtils.isNotEmpty(idList)) {
            // 删除用户登录表数据
            userLoginService.deleteSysUserLogin(ids);
            // 删除用户信息表数据
            super.removeByIds(idList);
            // 删除用户和角色的对应关系
            userRoleService.deleteSysUserRoleFromUserId(ids);
        }
        return Boolean.TRUE;
    }

    @Override
    public SysUserInfoDto getSysUserInfoById(Serializable id) throws Exception {
        //SysUserInfoQueryVo sysUserInfoQueryVo = sysUserInfoMapper.getSysUserInfoById(id);
        SysUserInfoEntity sysUserInfoEntity = super.getById(id);

        SysUserInfoDto sysUserInfoDto = new SysUserInfoDto();
        BeanUtils.copyProperties(sysUserInfoEntity, sysUserInfoDto);
        return sysUserInfoDto;
    }

    @Override
    public Paging<SysUserInfoDto> getSysUserInfoPageList(SysUserInfoPageQueryParam sysUserInfoPageQueryParam) throws Exception {
        //IPage<SysUserInfoQueryVo> iPage = sysUserInfoMapper.getSysUserInfoPageList(page, sysUserInfoPageQueryParam);

        Page page = setPageParam(sysUserInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysUserInfoDto> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysUserInfoDto> getSysUserInfoList(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        List<SysUserInfoDto> sysUserInfoQueryVoList = userInfoMapper.getSysUserInfoList(sysUserInfoQueryParam);
        return sysUserInfoQueryVoList;
    }

    @Override
    public int countSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}