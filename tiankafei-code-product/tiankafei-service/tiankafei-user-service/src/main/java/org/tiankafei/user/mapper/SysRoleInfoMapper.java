package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysRoleInfoEntity;
import org.tiankafei.user.param.SysRoleInfoQueryParam;
import org.tiankafei.user.param.SysRoleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRoleInfoQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 角色信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Repository
public interface SysRoleInfoMapper extends BaseMapper<SysRoleInfoEntity> {

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     */
     SysRoleInfoQueryVo getSysRoleInfoById(Serializable id);

    /**
     * 获取 角色信息表 分页对象
     *
     * @param page
     * @param sysRoleInfoPageQueryParam
     * @return
     */
     IPage<SysRoleInfoQueryVo> getSysRoleInfoPageList(@Param("page") Page page, @Param("param") SysRoleInfoPageQueryParam sysRoleInfoPageQueryParam);
    
    /**
     * 获取 角色信息表 对象列表
     *
     * @param sysRoleInfoQueryParam
     * @return
     */
     List<SysRoleInfoQueryVo> getSysRoleInfoList(@Param("param") SysRoleInfoQueryParam sysRoleInfoQueryParam);

}