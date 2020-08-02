package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.vo.RoleInfoVo;

/**
 * <pre>
 * 角色信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RoleInfoMapper extends BaseMapper<RoleInfoEntity> {

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     */
    RoleInfoVo getSysRoleInfoById(Serializable id);

    /**
     * 获取 角色信息表 分页对象
     *
     * @param page
     * @param roleInfoPageParam
     * @return
     */
    IPage<RoleInfoVo> getSysRoleInfoPageList(@Param("page") Page page, @Param("param") RoleInfoPageParam roleInfoPageParam);

    /**
     * 获取 角色信息表 对象列表
     *
     * @param roleInfoListParam
     * @return
     */
    List<RoleInfoVo> getSysRoleInfoList(@Param("param") RoleInfoListParam roleInfoListParam);

}