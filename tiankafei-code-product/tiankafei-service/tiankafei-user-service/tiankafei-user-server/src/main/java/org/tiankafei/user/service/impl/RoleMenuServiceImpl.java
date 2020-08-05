package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.mapper.RoleMenuMapper;
import org.tiankafei.user.param.RoleMenuCheckParam;
import org.tiankafei.user.param.RoleMenuCountParam;
import org.tiankafei.user.param.RoleMenuDeleteParam;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.service.RoleMenuService;
import org.tiankafei.user.vo.RoleMenuVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统角色对应的功能配置表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenuMapper, RoleMenuEntity> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param roleMenuCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRoleMenuServiceExists(RoleMenuCheckParam roleMenuCheckParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleMenuCheckParam != null) {
            Long id = roleMenuCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RoleMenuEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRoleMenuService(RoleMenuVo roleMenuVo) throws Exception {
        RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
        BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
        super.save(roleMenuEntity);
        return roleMenuEntity.getId();
    }

    /**
     * 保存 系统角色对应的功能配置表 集合
     *
     * @param roleMenuVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRoleMenuService(List<RoleMenuVo> roleMenuVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(roleMenuVoList)) {
            List<RoleMenuEntity> roleMenuEntityList = Lists.newArrayList();
            for (RoleMenuVo roleMenuVo : roleMenuVoList) {
                RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
                BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
                roleMenuEntityList.add(roleMenuEntity);
            }
            super.saveBatch(roleMenuEntityList);

            return roleMenuEntityList.stream().map(roleMenuEntity -> roleMenuEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRoleMenuService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRoleMenuService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param roleMenuDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRoleMenuService(RoleMenuDeleteParam roleMenuDeleteParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleMenuDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRoleMenuService(RoleMenuVo roleMenuVo) throws Exception {
        RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
        BeanUtils.copyProperties(roleMenuVo, roleMenuEntity);
        return super.updateById(roleMenuEntity);
    }

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RoleMenuVo getRoleMenuServiceById(Serializable id) throws Exception {
        RoleMenuEntity roleMenuEntity = super.getById(id);
        if (roleMenuEntity == null) {
            return null;
        }
        RoleMenuVo roleMenuVo = new RoleMenuVo();
        BeanUtils.copyProperties(roleMenuEntity, roleMenuVo);
        return roleMenuVo;
    }

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RoleMenuVo> getRoleMenuServiceList(RoleMenuListParam roleMenuListParam) throws Exception {
        return roleMenuMapper.getRoleMenuServiceList(roleMenuListParam);
    }

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param roleMenuPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RoleMenuVo> getRoleMenuServicePageList(RoleMenuPageParam roleMenuPageParam) throws Exception {
        Page page = setPageParam(roleMenuPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RoleMenuVo> iPage = roleMenuMapper.getRoleMenuServicePageList(page, roleMenuPageParam);
        List<Long> idList = iPage.getRecords().stream().map(roleMenuVo -> roleMenuVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RoleMenuVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RoleMenuListParam roleMenuListParam = new RoleMenuListParam();
            roleMenuListParam.setIdList(idList);
            List<RoleMenuVo> roleMenuVoList = this.getRoleMenuServiceList(roleMenuListParam);
            paging.setRecords(roleMenuVoList);
        }
        return paging;
    }

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param roleMenuCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRoleMenuService(RoleMenuCountParam roleMenuCountParam) throws Exception {
        LambdaQueryWrapper<RoleMenuEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleMenuCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
