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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.mapper.UserRoleMapper;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.service.UserRoleService;
import org.tiankafei.user.vo.UserRoleVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 用户拥有的角色关系表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean checkSysUserRoleExists(UserRoleListParam userRoleListParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysUserRole(UserRoleVo userRoleVo) throws Exception {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userRoleVo, userRoleEntity);
        super.save(userRoleEntity);
        return userRoleEntity.getId();
    }

    @Override
    public boolean addSysUserRoleList(List<UserRoleVo> userRoleVoList) throws Exception {
        if (userRoleVoList != null && !userRoleVoList.isEmpty()) {
            List<UserRoleEntity> sysUserRoleList = new ArrayList<>();
            for (UserRoleVo userRoleVo : userRoleVoList) {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                BeanUtils.copyProperties(userRoleVo, userRoleEntity);
                sysUserRoleList.add(userRoleEntity);
            }
            super.saveBatch(sysUserRoleList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserRole(UserRoleVo userRoleVo) throws Exception {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userRoleVo, userRoleEntity);
        return super.updateById(userRoleEntity);
    }

    @Override
    public boolean deleteSysUserRole(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        return super.removeByIds(idList);
    }

    @Override
    public boolean deleteSysUserRoleFromUserId(String userIds) throws Exception {
        return deleteSysUserRole(new UserRoleListParam().setUserIds(userIds));
    }

    @Override
    public boolean deleteSysUserRoleFromRoleId(String roleIds) throws Exception {
        return deleteSysUserRole(new UserRoleListParam().setRoleIds(roleIds));
    }

    @Override
    public boolean deleteSysUserRole(UserRoleListParam userRoleListParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        String userIds = userRoleListParam.getUserIds();
        if (StringUtils.isNotBlank(userIds)) {
            List<String> userIdList = Arrays.asList(userIds.split(","));
            lambdaQueryWrapper.in(UserRoleEntity::getUserId, userIdList);
        }

        String roleIds = userRoleListParam.getRoleIds();
        if (StringUtils.isNotBlank(roleIds)) {
            List<String> roleIdList = Arrays.asList(roleIds.split(","));
            lambdaQueryWrapper.in(UserRoleEntity::getRoleId, roleIdList);
        }

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public UserRoleVo getSysUserRoleById(Serializable id) throws Exception {
        //SysUserRoleQueryVo sysUserRoleQueryVo = sysUserRoleMapper.getSysUserRoleById(id);

        UserRoleEntity userRoleEntity = super.getById(id);
        UserRoleVo userRoleVo = new UserRoleVo();
        BeanUtils.copyProperties(userRoleEntity, userRoleVo);
        return userRoleVo;
    }

    @Override
    public Paging<UserRoleVo> getSysUserRolePageList(UserRolePageParam userRolePageParam) throws Exception {
        //IPage<SysUserRoleQueryVo> iPage = sysUserRoleMapper.getSysUserRolePageList(page, sysUserRolePageQueryParam);

        Page page = setPageParam(userRolePageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<UserRoleVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<UserRoleVo> getSysUserRoleList(UserRoleListParam userRoleListParam) throws Exception {
        List<UserRoleVo> userRoleVoList = userRoleMapper.getSysUserRoleList(userRoleListParam);
        return userRoleVoList;
    }

    @Override
    public int countSysUserRole(UserRoleListParam userRoleListParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}