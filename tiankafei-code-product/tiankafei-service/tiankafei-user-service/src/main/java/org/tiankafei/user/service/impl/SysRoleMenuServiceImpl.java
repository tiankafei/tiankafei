package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.SysRoleMenuEntity;
import org.tiankafei.user.mapper.SysRoleMenuMapper;
import org.tiankafei.user.param.SysRoleMenuPageQueryParam;
import org.tiankafei.user.param.SysRoleMenuQueryParam;
import org.tiankafei.user.service.SysRoleMenuService;
import org.tiankafei.user.vo.SysRoleMenuQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public boolean checkSysRoleMenuExists(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception {
        LambdaQueryWrapper<SysRoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysRoleMenu(SysRoleMenuQueryVo sysRoleMenuQueryVo) throws Exception {
        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
        BeanUtils.copyProperties(sysRoleMenuQueryVo, sysRoleMenuEntity);
        super.save(sysRoleMenuEntity);
        return sysRoleMenuEntity.getId();
    }

    @Override
    public boolean addSysRoleMenuList(List<SysRoleMenuQueryVo> sysRoleMenuQueryVoList) throws Exception {
        if (sysRoleMenuQueryVoList != null && !sysRoleMenuQueryVoList.isEmpty()) {
            List<SysRoleMenuEntity> sysRoleMenuList = new ArrayList<>();
            for (SysRoleMenuQueryVo sysRoleMenuQueryVo : sysRoleMenuQueryVoList) {
                SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
                BeanUtils.copyProperties(sysRoleMenuQueryVo, sysRoleMenuEntity);
                sysRoleMenuList.add(sysRoleMenuEntity);
            }
            super.saveBatch(sysRoleMenuList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysRoleMenu(SysRoleMenuQueryVo sysRoleMenuQueryVo) throws Exception {
        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
        BeanUtils.copyProperties(sysRoleMenuQueryVo, sysRoleMenuEntity);
        return super.updateById(sysRoleMenuEntity);
    }

    @Override
    public boolean deleteSysRoleMenu(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception {
        LambdaQueryWrapper<SysRoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysRoleMenuQueryVo getSysRoleMenuById(Serializable id) throws Exception {
		//SysRoleMenuQueryVo sysRoleMenuQueryVo = sysRoleMenuMapper.getSysRoleMenuById(id);

        SysRoleMenuEntity sysRoleMenuEntity = super.getById(id);
        SysRoleMenuQueryVo sysRoleMenuQueryVo = new SysRoleMenuQueryVo();
        BeanUtils.copyProperties(sysRoleMenuEntity, sysRoleMenuQueryVo);
        return sysRoleMenuQueryVo;
    }

    @Override
    public Paging<SysRoleMenuQueryVo> getSysRoleMenuPageList(SysRoleMenuPageQueryParam sysRoleMenuPageQueryParam) throws Exception {
        //IPage<SysRoleMenuQueryVo> iPage = sysRoleMenuMapper.getSysRoleMenuPageList(page, sysRoleMenuPageQueryParam);

		Page page = setPageParam(sysRoleMenuPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysRoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysRoleMenuQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysRoleMenuQueryVo> getSysRoleMenuList(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception {
        List<SysRoleMenuQueryVo> sysRoleMenuQueryVoList = sysRoleMenuMapper.getSysRoleMenuList(sysRoleMenuQueryParam);
        return sysRoleMenuQueryVoList;
    }

    @Override
    public int countSysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam) throws Exception {
        LambdaQueryWrapper<SysRoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}