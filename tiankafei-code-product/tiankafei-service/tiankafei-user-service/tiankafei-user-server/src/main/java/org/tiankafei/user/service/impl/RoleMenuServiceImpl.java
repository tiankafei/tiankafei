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
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.mapper.RoleMenuMapper;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.service.RoleMenuService;
import org.tiankafei.user.vo.RoleMenuVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统角色对应的功能配置表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenuMapper, RoleMenuEntity> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public boolean checkSysRoleMenuExists(RoleMenuListParam roleMenuListParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysRoleMenu(RoleMenuVo roleMenuVo) throws Exception {
        RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
        BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
        super.save(roleMenuEntity);
        return roleMenuEntity.getId();
    }

    @Override
    public boolean addSysRoleMenuList(List<RoleMenuVo> roleMenuVoList) throws Exception {
        if (roleMenuVoList != null && !roleMenuVoList.isEmpty()) {
            List<RoleMenuEntity> sysRoleMenuList = new ArrayList<>();
            for (RoleMenuVo roleMenuVo : roleMenuVoList) {
                RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
                BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
                sysRoleMenuList.add(roleMenuEntity);
            }
            super.saveBatch(sysRoleMenuList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRoleMenu(RoleMenuVo roleMenuVo) throws Exception {
        RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
        BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
        return super.updateById(roleMenuEntity);
    }

    @Override
    public boolean deleteSysRoleMenu(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysRoleMenu(RoleMenuListParam roleMenuListParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public RoleMenuVo getSysRoleMenuById(Serializable id) throws Exception {
        //SysRoleMenuQueryVo sysRoleMenuQueryVo = sysRoleMenuMapper.getSysRoleMenuById(id);

        RoleMenuEntity roleMenuEntity = super.getById(id);
        RoleMenuVo roleMenuVo = new RoleMenuVo();
        BeanUtils.copyProperties(roleMenuEntity, roleMenuVo);
        return roleMenuVo;
    }

    @Override
    public Paging<RoleMenuVo> getSysRoleMenuPageList(RoleMenuPageParam roleMenuPageParam) throws Exception {
        //IPage<SysRoleMenuQueryVo> iPage = sysRoleMenuMapper.getSysRoleMenuPageList(page, sysRoleMenuPageQueryParam);

        Page page = setPageParam(roleMenuPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<RoleMenuVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<RoleMenuVo> getSysRoleMenuList(RoleMenuListParam roleMenuListParam) throws Exception {
        List<RoleMenuVo> roleMenuVoList = roleMenuMapper.getSysRoleMenuList(roleMenuListParam);
        return roleMenuVoList;
    }

    @Override
    public int countSysRoleMenu(RoleMenuListParam roleMenuListParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}