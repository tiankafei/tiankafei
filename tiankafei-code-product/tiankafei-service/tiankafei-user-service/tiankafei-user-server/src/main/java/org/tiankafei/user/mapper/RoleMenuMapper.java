package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.RoleMenuEntity;
import org.tiankafei.user.param.RoleMenuCheckParam;
import org.tiankafei.user.param.RoleMenuCountParam;
import org.tiankafei.user.param.RoleMenuDeleteParam;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.vo.RoleMenuVo;

/**
 * <p>
 * 系统角色对应的功能配置表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param roleMenuCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRoleMenuServiceExists(@Param("param") RoleMenuCheckParam roleMenuCheckParam) throws Exception;

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    Object addRoleMenuService(@Param("param") RoleMenuVo roleMenuVo) throws Exception;

    /**
     * 批量保存 系统角色对应的功能配置表
     *
     * @param roleMenuVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRoleMenuService(@Param("param") List<RoleMenuVo> roleMenuVoList) throws Exception;

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRoleMenuService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统角色对应的功能配置表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRoleMenuService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param roleMenuDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRoleMenuService(@Param("param") RoleMenuDeleteParam roleMenuDeleteParam) throws Exception;

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    boolean updateRoleMenuService(@Param("param") RoleMenuVo roleMenuVo) throws Exception;

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleMenuVo getRoleMenuServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    List<RoleMenuVo> getRoleMenuServiceList(@Param("param") RoleMenuListParam roleMenuListParam) throws Exception;

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param page
     * @param roleMenuPageParam
     * @return
     * @throws Exception
     */
    IPage<RoleMenuVo> getRoleMenuServicePageList(@Param("page") Page page, @Param("param") RoleMenuPageParam roleMenuPageParam) throws Exception;

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param roleMenuCountParam
     * @return
     * @throws Exception
     */
    Integer countRoleMenuService(@Param("param") RoleMenuCountParam roleMenuCountParam) throws Exception;

}
