package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.vo.RoleMenuVo;

/**
 * <pre>
 * 系统角色对应的功能配置表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     */
    RoleMenuVo getSysRoleMenuById(Serializable id);

    /**
     * 获取 系统角色对应的功能配置表 分页对象
     *
     * @param page
     * @param roleMenuPageParam
     * @return
     */
    IPage<RoleMenuVo> getSysRoleMenuPageList(@Param("page") Page page, @Param("param") RoleMenuPageParam roleMenuPageParam);

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     */
    List<RoleMenuVo> getSysRoleMenuList(@Param("param") RoleMenuListParam roleMenuListParam);

}