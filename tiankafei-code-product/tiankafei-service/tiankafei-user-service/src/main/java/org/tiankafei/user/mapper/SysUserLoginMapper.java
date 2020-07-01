package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户登录信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Repository
public interface SysUserLoginMapper extends BaseMapper<SysUserLoginEntity> {

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     */
     SysUserLoginQueryVo getTkfUserLoginById(Serializable id);

    /**
     * 获取 用户登录信息表 分页对象
     *
     * @param page
     * @param sysUserLoginPageQueryParam
     * @return
     */
     IPage<SysUserLoginQueryVo> getTkfUserLoginPageList(@Param("page") Page page, @Param("param") SysUserLoginPageQueryParam sysUserLoginPageQueryParam);
    
    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param sysUserLoginQueryParam
     * @return
     */
     List<SysUserLoginQueryVo> getTkfUserLoginList(@Param("param") SysUserLoginQueryParam sysUserLoginQueryParam);

}