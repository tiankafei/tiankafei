package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
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
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.mapper.UserRoleMapper;
import org.tiankafei.user.param.UserRoleCheckParam;
import org.tiankafei.user.param.UserRoleCountParam;
import org.tiankafei.user.param.UserRoleDeleteParam;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.service.UserRoleService;
import org.tiankafei.user.vo.UserRoleVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 用户拥有的角色关系表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param userRoleCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkUserRoleServiceExists(UserRoleCheckParam userRoleCheckParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userRoleCheckParam != null) {
            Long id = userRoleCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(UserRoleEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addUserRoleService(UserRoleVo userRoleVo) throws Exception {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userRoleVo, userRoleEntity);
        super.save(userRoleEntity);
        return userRoleEntity.getId();
    }

    /**
     * 保存 用户拥有的角色关系表 集合
     *
     * @param userRoleVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddUserRoleService(List<UserRoleVo> userRoleVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(userRoleVoList)) {
            List<UserRoleEntity> userRoleEntityList = Lists.newArrayList();
            for (UserRoleVo userRoleVo : userRoleVoList) {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                BeanUtils.copyProperties(userRoleVo, userRoleEntity);
                userRoleEntityList.add(userRoleEntity);
            }
            super.saveBatch(userRoleEntityList);

            return userRoleEntityList.stream().map(userRoleEntity -> userRoleEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUserRoleService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 用户拥有的角色关系表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteUserRoleService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param userRoleDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteUserRoleService(UserRoleDeleteParam userRoleDeleteParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userRoleDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUserRoleService(UserRoleVo userRoleVo) throws Exception {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userRoleVo, userRoleEntity);
        return super.updateById(userRoleEntity);
    }

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserRoleVo getUserRoleServiceById(Serializable id) throws Exception {
        UserRoleEntity userRoleEntity = super.getById(id);
        if (userRoleEntity == null) {
            return null;
        }
        UserRoleVo userRoleVo = new UserRoleVo();
        BeanUtils.copyProperties(userRoleEntity, userRoleVo);
        return userRoleVo;
    }

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<UserRoleVo> getUserRoleServiceList(UserRoleListParam userRoleListParam) throws Exception {
        return userRoleMapper.getUserRoleServiceList(userRoleListParam);
    }

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param userRolePageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<UserRoleVo> getUserRoleServicePageList(UserRolePageParam userRolePageParam) throws Exception {
        Page page = setPageParam(userRolePageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<UserRoleVo> iPage = userRoleMapper.getUserRoleServicePageList(page, userRolePageParam);
        List<Long> idList = iPage.getRecords().stream().map(userRoleVo -> userRoleVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<UserRoleVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            UserRoleListParam userRoleListParam = new UserRoleListParam();
            userRoleListParam.setIdList(idList);
            List<UserRoleVo> userRoleVoList = this.getUserRoleServiceList(userRoleListParam);
            paging.setRecords(userRoleVoList);
        }
        return paging;
    }

    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param userRoleCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countUserRoleService(UserRoleCountParam userRoleCountParam) throws Exception {
        LambdaQueryWrapper<UserRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userRoleCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
