package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.model.SysUserInfoDto;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.param.SysUserInfoQueryParam;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 用户基本信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysUserInfoMapper extends BaseMapper<SysUserInfoEntity> {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     */
    SysUserInfoDto getSysUserInfoById(Serializable id);

    /**
     * 获取 用户基本信息表 分页对象
     *
     * @param page
     * @param sysUserInfoPageQueryParam
     * @return
     */
    IPage<SysUserInfoDto> getSysUserInfoPageList(@Param("page") Page page, @Param("param") SysUserInfoPageQueryParam sysUserInfoPageQueryParam);

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param sysUserInfoQueryParam
     * @return
     */
    List<SysUserInfoDto> getSysUserInfoList(@Param("param") SysUserInfoQueryParam sysUserInfoQueryParam);

}