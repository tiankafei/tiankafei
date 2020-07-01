package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysRoleFeatureEntity;
import org.tiankafei.user.param.SysRoleFeatureQueryParam;
import org.tiankafei.user.param.SysRoleFeaturePageQueryParam;
import org.tiankafei.user.vo.SysRoleFeatureQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统角色对应的功能配置表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Repository
public interface SysRoleFeatureMapper extends BaseMapper<SysRoleFeatureEntity> {

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     */
     SysRoleFeatureQueryVo getSysRoleFeatureById(Serializable id);

    /**
     * 获取 系统角色对应的功能配置表 分页对象
     *
     * @param page
     * @param sysRoleFeaturePageQueryParam
     * @return
     */
     IPage<SysRoleFeatureQueryVo> getSysRoleFeaturePageList(@Param("page") Page page, @Param("param") SysRoleFeaturePageQueryParam sysRoleFeaturePageQueryParam);
    
    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param sysRoleFeatureQueryParam
     * @return
     */
     List<SysRoleFeatureQueryVo> getSysRoleFeatureList(@Param("param") SysRoleFeatureQueryParam sysRoleFeatureQueryParam);

}