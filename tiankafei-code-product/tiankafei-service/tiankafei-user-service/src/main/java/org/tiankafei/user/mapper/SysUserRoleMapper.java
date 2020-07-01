package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysUserRoleEntity;
import org.tiankafei.user.param.SysUserRoleQueryParam;
import org.tiankafei.user.param.SysUserRolePageQueryParam;
import org.tiankafei.user.vo.SysUserRoleQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户拥有的角色关系表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     */
     SysUserRoleQueryVo getSysUserRoleById(Serializable id);

    /**
     * 获取 用户拥有的角色关系表 分页对象
     *
     * @param page
     * @param sysUserRolePageQueryParam
     * @return
     */
     IPage<SysUserRoleQueryVo> getSysUserRolePageList(@Param("page") Page page, @Param("param") SysUserRolePageQueryParam sysUserRolePageQueryParam);
    
    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param sysUserRoleQueryParam
     * @return
     */
     List<SysUserRoleQueryVo> getSysUserRoleList(@Param("param") SysUserRoleQueryParam sysUserRoleQueryParam);

}