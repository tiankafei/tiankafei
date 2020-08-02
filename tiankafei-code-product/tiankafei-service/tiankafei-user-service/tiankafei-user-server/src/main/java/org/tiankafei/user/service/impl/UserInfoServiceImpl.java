package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.UserInfoMapper;
import org.tiankafei.user.model.UserInfoDto;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.service.UserInfoService;
import org.tiankafei.user.service.UserLoginService;
import org.tiankafei.user.service.UserRoleService;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

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
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private CheckExistsClient checkExistsClient;

    @Override
    public Object addSysUserInfo(UserInfoDto userInfoDto) throws Exception {
        // 新增时校验用户信息是否存在
        checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), userInfoDto.getUsername());
        checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), userInfoDto.getEmail());
        checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), userInfoDto.getTelephone());

        // 保存用户登录表数据
        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userInfoDto, userLoginVo);
        Long id = (Long) userLoginService.addSysUserLogin(userLoginVo);

        // 保存用户信息表数据
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDto, userInfoEntity);
        userInfoEntity.setId(id);
        super.save(userInfoEntity);

        return id;
    }

    @Override
    public boolean addSysUserInfoList(List<UserInfoDto> sysUserInfoList) throws Exception {
        if (CollectionUtils.isNotEmpty(sysUserInfoList)) {
            // 用户信息实体对象集合
            List<UserInfoEntity> userInfoEntityList = new ArrayList<>();
            for (UserInfoDto userInfoDto : sysUserInfoList) {
                // 对象转换
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                BeanUtils.copyProperties(userInfoDto, userInfoEntity);
                userInfoEntityList.add(userInfoEntity);
            }
            super.saveBatch(userInfoEntityList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserInfo(UserInfoDto userInfoDto) throws Exception {
        UserInfoEntity oldUserInfoEntity = super.getById(userInfoDto.getId());
        // 修改时，校验用户信息是否存在
        checkExistsClient.checkUpdateSysUserExists(UserEnums.USER_NAME.getCode(), userInfoDto.getUsername(), oldUserInfoEntity.getUsername());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.EMAIL.getCode(), userInfoDto.getEmail(), oldUserInfoEntity.getEmail());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.PHONE.getCode(), userInfoDto.getTelephone(), oldUserInfoEntity.getTelephone());

        // 更新用户登录表数据
        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userInfoDto, userLoginVo);
        userLoginService.updateSysUserLogin(userLoginVo);

        // 更新用户信息表数据
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDto, userInfoEntity);
        super.updateById(userInfoEntity);

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
    public UserInfoDto getSysUserInfoById(Serializable id) throws Exception {
        //SysUserInfoQueryVo sysUserInfoQueryVo = sysUserInfoMapper.getSysUserInfoById(id);
        UserInfoEntity userInfoEntity = super.getById(id);

        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userInfoEntity, userInfoDto);
        return userInfoDto;
    }

    @Override
    public Paging<UserInfoDto> getSysUserInfoPageList(UserInfoPageParam userInfoPageParam) throws Exception {
        //IPage<SysUserInfoQueryVo> iPage = sysUserInfoMapper.getSysUserInfoPageList(page, sysUserInfoPageQueryParam);

        Page page = setPageParam(userInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<UserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<UserInfoDto> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<UserInfoDto> getSysUserInfoList(UserInfoListParam userInfoListParam) throws Exception {
        List<UserInfoDto> sysUserInfoQueryVoList = userInfoMapper.getSysUserInfoList(userInfoListParam);
        return sysUserInfoQueryVoList;
    }

    @Override
    public int countSysUserInfo(UserInfoListParam userInfoListParam) throws Exception {
        LambdaQueryWrapper<UserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}