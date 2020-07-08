package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.SysRoleMenuEntity;
import org.tiankafei.user.param.SysRoleMenuPageQueryParam;
import org.tiankafei.user.param.SysRoleMenuQueryParam;
import org.tiankafei.user.vo.SysRoleMenuQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统角色对应的功能配置表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     */
    SysRoleMenuQueryVo getSysRoleMenuById(Serializable id);

    /**
     * 获取 系统角色对应的功能配置表 分页对象
     *
     * @param page
     * @param sysRoleMenuPageQueryParam
     * @return
     */
    IPage<SysRoleMenuQueryVo> getSysRoleMenuPageList(@Param("page") Page page, @Param("param") SysRoleMenuPageQueryParam sysRoleMenuPageQueryParam);

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param sysRoleMenuQueryParam
     * @return
     */
    List<SysRoleMenuQueryVo> getSysRoleMenuList(@Param("param") SysRoleMenuQueryParam sysRoleMenuQueryParam);

}