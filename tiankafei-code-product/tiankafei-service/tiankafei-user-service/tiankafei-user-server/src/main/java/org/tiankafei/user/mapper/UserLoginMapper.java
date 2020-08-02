package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.vo.UserLoginVo;

/**
 * <pre>
 * 用户登录信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserLoginMapper extends BaseMapper<UserLoginEntity> {

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     */
    UserLoginVo getSysUserLoginById(Serializable id);

    /**
     * 获取 用户登录信息表 分页对象
     *
     * @param page
     * @param userLoginPageParam
     * @return
     */
    IPage<UserLoginVo> getSysUserLoginPageList(@Param("page") Page page, @Param("param") UserLoginPageParam userLoginPageParam);

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param userLoginListParam
     * @return
     */
    List<UserLoginVo> getSysUserLoginList(@Param("param") UserLoginListParam userLoginListParam);

}