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
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.UserLoginMapper;
import org.tiankafei.user.param.UserLoginCheckParam;
import org.tiankafei.user.param.UserLoginCountParam;
import org.tiankafei.user.param.UserLoginDeleteParam;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.service.UserLoginService;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户登录信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class UserLoginServiceImpl extends BaseServiceImpl<UserLoginMapper, UserLoginEntity> implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private CheckExistsClient checkExistsClient;

    /**
     * 校验 用户名 是否已经存在
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Boolean checkUsernameExists(String username) throws Exception {
        return checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), username);
    }

    /**
     * 校验  邮箱 是否已经存在
     *
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public Boolean checkEmailExists(String email) throws Exception {
        return checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), email);
    }

    /**
     * 校验 手机号码 是否已经存在
     *
     * @param telephone
     * @return
     * @throws Exception
     */
    @Override
    public Boolean checkTelephoneExists(String telephone) throws Exception {
        return checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), telephone);
    }

    /**
     * 校验 用户登录信息表 是否已经存在
     *
     * @param userLoginCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkUserLoginServiceExists(UserLoginCheckParam userLoginCheckParam) throws Exception {
        LambdaQueryWrapper<UserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userLoginCheckParam != null) {
            Long id = userLoginCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(UserLoginEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addUserLoginService(UserLoginVo userLoginVo) throws Exception {
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(userLoginVo, userLoginEntity);
        super.save(userLoginEntity);
        return userLoginEntity.getId();
    }

    /**
     * 保存 用户登录信息表 集合
     *
     * @param userLoginVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddUserLoginService(List<UserLoginVo> userLoginVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(userLoginVoList)) {
            List<UserLoginEntity> userLoginEntityList = Lists.newArrayList();
            for (UserLoginVo userLoginVo : userLoginVoList) {
                UserLoginEntity userLoginEntity = new UserLoginEntity();
                BeanUtils.copyProperties(userLoginVo, userLoginEntity);
                userLoginEntityList.add(userLoginEntity);
            }
            super.saveBatch(userLoginEntityList);

            return userLoginEntityList.stream().map(userLoginEntity -> userLoginEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 用户登录信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUserLoginService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteUserLoginService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 用户登录信息表
     *
     * @param userLoginDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteUserLoginService(UserLoginDeleteParam userLoginDeleteParam) throws Exception {
        LambdaQueryWrapper<UserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userLoginDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUserLoginService(UserLoginVo userLoginVo) throws Exception {
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(userLoginVo, userLoginEntity);
        return super.updateById(userLoginEntity);
    }

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserLoginVo getUserLoginServiceById(Serializable id) throws Exception {
        UserLoginEntity userLoginEntity = super.getById(id);
        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userLoginEntity, userLoginVo);
        return userLoginVo;
    }

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param userLoginListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<UserLoginVo> getUserLoginServiceList(UserLoginListParam userLoginListParam) throws Exception {
        return userLoginMapper.getUserLoginServiceList(userLoginListParam);
    }

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param userLoginPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<UserLoginVo> getUserLoginServicePageList(UserLoginPageParam userLoginPageParam) throws Exception {
        Page page = setPageParam(userLoginPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<UserLoginVo> iPage = userLoginMapper.getUserLoginServicePageList(page, userLoginPageParam);
        List<Long> idList = iPage.getRecords().stream().map(userLoginVo -> userLoginVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<UserLoginVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            UserLoginListParam userLoginListParam = new UserLoginListParam();
            userLoginListParam.setIdList(idList);
            List<UserLoginVo> userLoginVoList = this.getUserLoginServiceList(userLoginListParam);
            paging.setRecords(userLoginVoList);
        }
        return paging;
    }

    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param userLoginCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countUserLoginService(UserLoginCountParam userLoginCountParam) throws Exception {
        LambdaQueryWrapper<UserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userLoginCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
