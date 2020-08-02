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
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.mapper.UserInfoMapper;
import org.tiankafei.user.model.UserInfoDto;
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.service.UserInfoService;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


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

        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoDto
     * @return
     * @throws Exception
     */
    @Override
    public Long addUserInfoService(UserInfoDto userInfoDto) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDto, userInfoEntity);
        super.save(userInfoEntity);
        return userInfoEntity.getId();
    }

    /**
     * 保存 用户基本信息表 集合
     *
     * @param userInfoDtoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddUserInfoService(List<UserInfoDto> userInfoDtoList) throws Exception {
        if (CollectionUtils.isNotEmpty(userInfoDtoList)) {
            List<UserInfoEntity> userInfoEntityList = Lists.newArrayList();
            for (UserInfoDto userInfoDto : userInfoDtoList) {
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                BeanUtils.copyProperties(userInfoDto, userInfoEntity);
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
     * 删除 用户基本信息表
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
     * @param userInfoDto
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUserInfoService(UserInfoDto userInfoDto) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDto, userInfoEntity);
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
