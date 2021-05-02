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
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.mapper.RoleInfoMapper;
import org.tiankafei.user.param.RoleInfoCheckParam;
import org.tiankafei.user.param.RoleInfoCountParam;
import org.tiankafei.user.param.RoleInfoDeleteParam;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.service.RoleInfoService;
import org.tiankafei.user.vo.RoleInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfoMapper, RoleInfoEntity> implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;


    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param roleInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRoleInfoServiceExists(RoleInfoCheckParam roleInfoCheckParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleInfoCheckParam != null) {
            Long id = roleInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RoleInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRoleInfoService(RoleInfoVo roleInfoVo) throws Exception {
        RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
        BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
        super.save(roleInfoEntity);
        return roleInfoEntity.getId();
    }

    /**
     * 保存 角色信息表 集合
     *
     * @param roleInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRoleInfoService(List<RoleInfoVo> roleInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(roleInfoVoList)) {
            List<RoleInfoEntity> roleInfoEntityList = Lists.newArrayList();
            for (RoleInfoVo roleInfoVo : roleInfoVoList) {
                RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
                BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
                roleInfoEntityList.add(roleInfoEntity);
            }
            super.saveBatch(roleInfoEntityList);

            return roleInfoEntityList.stream().map(roleInfoEntity -> roleInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 角色信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRoleInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 角色信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRoleInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 角色信息表
     *
     * @param roleInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRoleInfoService(RoleInfoDeleteParam roleInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRoleInfoService(RoleInfoVo roleInfoVo) throws Exception {
        RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
        BeanUtils.copyProperties(roleInfoVo, roleInfoEntity);
        return super.updateById(roleInfoEntity);
    }

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RoleInfoVo getRoleInfoServiceById(Serializable id) throws Exception {
        RoleInfoEntity roleInfoEntity = super.getById(id);
        if (roleInfoEntity == null) {
            return null;
        }
        RoleInfoVo roleInfoVo = new RoleInfoVo();
        BeanUtils.copyProperties(roleInfoEntity, roleInfoVo);
        return roleInfoVo;
    }

    /**
     * 获取 角色信息表 对象列表
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RoleInfoVo> getRoleInfoServiceList(RoleInfoListParam roleInfoListParam) throws Exception {
        return roleInfoMapper.getRoleInfoServiceList(roleInfoListParam);
    }

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param roleInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RoleInfoVo> getRoleInfoServicePageList(RoleInfoPageParam roleInfoPageParam) throws Exception {
        Page page = setPageParam(roleInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RoleInfoVo> iPage = roleInfoMapper.getRoleInfoServicePageList(page, roleInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(roleInfoVo -> roleInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RoleInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RoleInfoListParam roleInfoListParam = new RoleInfoListParam();
            roleInfoListParam.setIdList(idList);
            List<RoleInfoVo> roleInfoVoList = this.getRoleInfoServiceList(roleInfoListParam);
            paging.setRecords(roleInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 角色信息表 总记录数
     *
     * @param roleInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRoleInfoService(RoleInfoCountParam roleInfoCountParam) throws Exception {
        LambdaQueryWrapper<RoleInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (roleInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
