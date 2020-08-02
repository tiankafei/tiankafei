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
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.mapper.RoleInfoMapper;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.service.RoleInfoService;
import org.tiankafei.user.vo.RoleInfoVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 角色信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfoMapper, RoleInfoEntity> implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public boolean checkSysRoleInfoExists(RoleInfoListParam roleInfoListParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysRoleInfo(RoleInfoVo roleInfoVo) throws Exception {
        RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
        BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
        super.save(roleInfoEntity);
        return roleInfoEntity.getId();
    }

    @Override
    public boolean addSysRoleInfoList(List<RoleInfoVo> roleInfoVoList) throws Exception {
        if (roleInfoVoList != null && !roleInfoVoList.isEmpty()) {
            List<RoleInfoEntity> sysRoleInfoList = new ArrayList<>();
            for (RoleInfoVo roleInfoVo : roleInfoVoList) {
                RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
                BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
                sysRoleInfoList.add(roleInfoEntity);
            }
            super.saveBatch(sysRoleInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRoleInfo(RoleInfoVo roleInfoVo) throws Exception {
        RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
        BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
        return super.updateById(roleInfoEntity);
    }

    @Override
    public boolean deleteSysRoleInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysRoleInfo(RoleInfoListParam roleInfoListParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public RoleInfoVo getSysRoleInfoById(Serializable id) throws Exception {
        //SysRoleInfoQueryVo sysRoleInfoQueryVo = sysRoleInfoMapper.getSysRoleInfoById(id);

        RoleInfoEntity roleInfoEntity = super.getById(id);
        RoleInfoVo roleInfoVo = new RoleInfoVo();
        BeanUtils.copyProperties(roleInfoEntity, roleInfoVo);
        return roleInfoVo;
    }

    @Override
    public Paging<RoleInfoVo> getSysRoleInfoPageList(RoleInfoPageParam roleInfoPageParam) throws Exception {
        //IPage<SysRoleInfoQueryVo> iPage = sysRoleInfoMapper.getSysRoleInfoPageList(page, sysRoleInfoPageQueryParam);

        Page page = setPageParam(roleInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<RoleInfoVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<RoleInfoVo> getSysRoleInfoList(RoleInfoListParam roleInfoListParam) throws Exception {
        List<RoleInfoVo> roleInfoVoList = roleInfoMapper.getSysRoleInfoList(roleInfoListParam);
        return roleInfoVoList;
    }

    @Override
    public int countSysRoleInfo(RoleInfoListParam roleInfoListParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}