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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.login.feign.EncryptionFeign;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.UserLoginMapper;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.service.UserLoginService;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 用户登录信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserLoginServiceImpl extends BaseServiceImpl<UserLoginMapper, UserLoginEntity> implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private CheckExistsClient checkExistsClient;

    @Autowired
    private EncryptionFeign encryptionFeign;

    @Override
    public Object addSysUserLogin(UserLoginVo userLoginVo) throws Exception {
        // 新增时校验用户信息是否存在
        checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), userLoginVo.getUsername());
        checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), userLoginVo.getEmail());
        checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), userLoginVo.getTelephone());

        // 保存用户登录表数据
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(userLoginVo, userLoginEntity);
        // 新增时密码加密
        userLoginEntity.setPassword(encryptionFeign.encryption(userLoginEntity.getPassword()).getData());
        // id值赋为空，使用自动生成的ID
        userLoginEntity.setId(null);
        super.save(userLoginEntity);

        return userLoginEntity.getId();
    }

    @Override
    public boolean addSysUserLoginList(List<UserLoginVo> userLoginVoList) throws Exception {
        if (userLoginVoList != null && !userLoginVoList.isEmpty()) {
            List<UserLoginEntity> sysUserLoginList = new ArrayList<>();
            for (UserLoginVo userLoginVo : userLoginVoList) {
                UserLoginEntity userLoginEntity = new UserLoginEntity();
                BeanUtils.copyProperties(userLoginVo, userLoginEntity);
                sysUserLoginList.add(userLoginEntity);
            }
            super.saveBatch(sysUserLoginList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserLogin(UserLoginVo userLoginVo) throws Exception {
        UserLoginEntity oldUserEntity = super.getById(userLoginVo.getId());
        // 修改时，校验用户信息是否存在
        checkExistsClient.checkUpdateSysUserExists(UserEnums.USER_NAME.getCode(), userLoginVo.getUsername(), oldUserEntity.getUsername());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.EMAIL.getCode(), userLoginVo.getEmail(), oldUserEntity.getEmail());
        checkExistsClient.checkUpdateSysUserExists(UserEnums.PHONE.getCode(), userLoginVo.getTelephone(), oldUserEntity.getTelephone());

        // 更新用户登录表数据
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(userLoginVo, userLoginEntity);
        // TODO 有待测试 编辑时密码加密
        userLoginEntity.setPassword(encryptionFeign.encryption(userLoginEntity.getPassword()).getData());
        super.updateById(userLoginEntity);

        return Boolean.TRUE;
    }

    @Override
    public boolean deleteSysUserLogin(String ids) throws Exception {
        // 删除登录用户表
        List<String> idList = Arrays.asList(ids.split(","));
        return super.removeByIds(idList);
    }

    @Override
    public UserLoginVo getSysUserLoginById(Serializable id) throws Exception {
        //SysUserLoginQueryVo sysUserLoginQueryVo = sysUserLoginMapper.getSysUserLoginById(id);

        UserLoginEntity userLoginEntity = super.getById(id);
        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userLoginEntity, userLoginVo);
        return userLoginVo;
    }

    @Override
    public Paging<UserLoginVo> getSysUserLoginPageList(UserLoginPageParam userLoginPageParam) throws Exception {
        //IPage<SysUserLoginQueryVo> iPage = sysUserLoginMapper.getSysUserLoginPageList(page, sysUserLoginPageQueryParam);

        Page page = setPageParam(userLoginPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<UserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<UserLoginVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<UserLoginVo> getSysUserLoginList(UserLoginListParam userLoginListParam) throws Exception {
        List<UserLoginVo> userLoginVoList = userLoginMapper.getSysUserLoginList(userLoginListParam);
        return userLoginVoList;
    }

    @Override
    public int countSysUserLogin(UserLoginListParam userLoginListParam) throws Exception {
        LambdaQueryWrapper<UserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}