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
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.mapper.UserInfoMapper;
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.service.UserInfoService;
import org.tiankafei.user.vo.UserInfoVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

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
     * 校验 用户基本信息表 是否已经存在
     *
     * @param userInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkUserInfoServiceExists(UserInfoCheckParam userInfoCheckParam) throws Exception {
        LambdaQueryWrapper<UserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userInfoCheckParam != null) {
            Long id = userInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(UserInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addUserInfoService(UserInfoVo userInfoVo) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoVo, userInfoEntity);
        super.save(userInfoEntity);
        return userInfoEntity.getId();
    }

    /**
     * 保存 用户基本信息表 集合
     *
     * @param userInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddUserInfoService(List<UserInfoVo> userInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(userInfoVoList)) {
            List<UserInfoEntity> userInfoEntityList = Lists.newArrayList();
            for (UserInfoVo userInfoVo : userInfoVoList) {
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                BeanUtils.copyProperties(userInfoVo, userInfoEntity);
                userInfoEntityList.add(userInfoEntity);
            }
            super.saveBatch(userInfoEntityList);

            return userInfoEntityList.stream().map(userInfoEntity -> userInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 用户基本信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUserInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 用户基本信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteUserInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param userInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteUserInfoService(UserInfoDeleteParam userInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<UserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUserInfoService(UserInfoVo userInfoVo) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoVo, userInfoEntity);
        return super.updateById(userInfoEntity);
    }

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfoVo getUserInfoServiceById(Serializable id) throws Exception {
        UserInfoEntity userInfoEntity = super.getById(id);
        if (userInfoEntity == null) {
            return null;
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(userInfoEntity, userInfoVo);
        return userInfoVo;
    }

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfoVo> getUserInfoServiceList(UserInfoListParam userInfoListParam) throws Exception {
        return userInfoMapper.getUserInfoServiceList(userInfoListParam);
    }

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<UserInfoVo> getUserInfoServicePageList(UserInfoPageParam userInfoPageParam) throws Exception {
        Page page = setPageParam(userInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<UserInfoVo> iPage = userInfoMapper.getUserInfoServicePageList(page, userInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(userInfoVo -> userInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<UserInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            UserInfoListParam userInfoListParam = new UserInfoListParam();
            userInfoListParam.setIdList(idList);
            List<UserInfoVo> userInfoVoList = this.getUserInfoServiceList(userInfoListParam);
            paging.setRecords(userInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countUserInfoService(UserInfoCountParam userInfoCountParam) throws Exception {
        LambdaQueryWrapper<UserInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (userInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
