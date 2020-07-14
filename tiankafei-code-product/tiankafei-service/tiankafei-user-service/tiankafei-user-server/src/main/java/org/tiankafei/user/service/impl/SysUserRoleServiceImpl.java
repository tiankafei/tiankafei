package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.SysUserRoleEntity;
import org.tiankafei.user.mapper.SysUserRoleMapper;
import org.tiankafei.user.param.SysUserRolePageQueryParam;
import org.tiankafei.user.param.SysUserRoleQueryParam;
import org.tiankafei.user.service.SysUserRoleService;
import org.tiankafei.user.vo.SysUserRoleQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public boolean checkSysUserRoleExists(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysUserRole(SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception {
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        BeanUtils.copyProperties(sysUserRoleQueryVo, sysUserRoleEntity);
        super.save(sysUserRoleEntity);
        return sysUserRoleEntity.getId();
    }

    @Override
    public boolean addSysUserRoleList(List<SysUserRoleQueryVo> sysUserRoleQueryVoList) throws Exception {
        if (sysUserRoleQueryVoList != null && !sysUserRoleQueryVoList.isEmpty()) {
            List<SysUserRoleEntity> sysUserRoleList = new ArrayList<>();
            for (SysUserRoleQueryVo sysUserRoleQueryVo : sysUserRoleQueryVoList) {
                SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
                BeanUtils.copyProperties(sysUserRoleQueryVo, sysUserRoleEntity);
                sysUserRoleList.add(sysUserRoleEntity);
            }
            super.saveBatch(sysUserRoleList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysUserRole(SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception {
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        BeanUtils.copyProperties(sysUserRoleQueryVo, sysUserRoleEntity);
        return super.updateById(sysUserRoleEntity);
    }

    @Override
    public boolean deleteSysUserRole(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        return super.removeByIds(idList);
    }

    @Override
    public boolean deleteSysUserRoleFromUserId(String userIds) throws Exception {
        return deleteSysUserRole(new SysUserRoleQueryParam().setUserIds(userIds));
    }

    @Override
    public boolean deleteSysUserRoleFromRoleId(String roleIds) throws Exception {
        return deleteSysUserRole(new SysUserRoleQueryParam().setRoleIds(roleIds));
    }

    @Override
    public boolean deleteSysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        String userIds = sysUserRoleQueryParam.getUserIds();
        if(StringUtils.isNotBlank(userIds)){
            List<String> userIdList = Arrays.asList(userIds.split(","));
            lambdaQueryWrapper.in(SysUserRoleEntity::getUserId, userIdList);
        }

        String roleIds = sysUserRoleQueryParam.getRoleIds();
        if(StringUtils.isNotBlank(roleIds)){
            List<String> roleIdList = Arrays.asList(roleIds.split(","));
            lambdaQueryWrapper.in(SysUserRoleEntity::getRoleId, roleIdList);
        }

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysUserRoleQueryVo getSysUserRoleById(Serializable id) throws Exception {
		//SysUserRoleQueryVo sysUserRoleQueryVo = sysUserRoleMapper.getSysUserRoleById(id);

        SysUserRoleEntity sysUserRoleEntity = super.getById(id);
        SysUserRoleQueryVo sysUserRoleQueryVo = new SysUserRoleQueryVo();
        BeanUtils.copyProperties(sysUserRoleEntity, sysUserRoleQueryVo);
        return sysUserRoleQueryVo;
    }

    @Override
    public Paging<SysUserRoleQueryVo> getSysUserRolePageList(SysUserRolePageQueryParam sysUserRolePageQueryParam) throws Exception {
        //IPage<SysUserRoleQueryVo> iPage = sysUserRoleMapper.getSysUserRolePageList(page, sysUserRolePageQueryParam);

		Page page = setPageParam(sysUserRolePageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysUserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysUserRoleQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysUserRoleQueryVo> getSysUserRoleList(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        List<SysUserRoleQueryVo> sysUserRoleQueryVoList = sysUserRoleMapper.getSysUserRoleList(sysUserRoleQueryParam);
        return sysUserRoleQueryVoList;
    }

    @Override
    public int countSysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        LambdaQueryWrapper<SysUserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}