package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.vo.UserRoleVo;

/**
 * <pre>
 * 用户拥有的角色关系表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     */
    UserRoleVo getSysUserRoleById(Serializable id);

    /**
     * 获取 用户拥有的角色关系表 分页对象
     *
     * @param page
     * @param userRolePageParam
     * @return
     */
    IPage<UserRoleVo> getSysUserRolePageList(@Param("page") Page page, @Param("param") UserRolePageParam userRolePageParam);

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     */
    List<UserRoleVo> getSysUserRoleList(@Param("param") UserRoleListParam userRoleListParam);

}