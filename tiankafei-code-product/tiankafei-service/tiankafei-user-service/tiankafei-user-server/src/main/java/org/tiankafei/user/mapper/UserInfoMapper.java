package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.model.UserInfoDto;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;

/**
 * <pre>
 * 用户基本信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     */
    UserInfoDto getSysUserInfoById(Serializable id);

    /**
     * 获取 用户基本信息表 分页对象
     *
     * @param page
     * @param userInfoPageParam
     * @return
     */
    IPage<UserInfoDto> getSysUserInfoPageList(@Param("page") Page page, @Param("param") UserInfoPageParam userInfoPageParam);

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     */
    List<UserInfoDto> getSysUserInfoList(@Param("param") UserInfoListParam userInfoListParam);

}