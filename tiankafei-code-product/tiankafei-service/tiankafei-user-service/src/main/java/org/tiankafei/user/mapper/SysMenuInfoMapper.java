package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysMenuInfoEntity;
import org.tiankafei.user.param.SysMenuInfoQueryParam;
import org.tiankafei.user.param.SysMenuInfoPageQueryParam;
import org.tiankafei.user.vo.SysMenuInfoQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统功能菜单信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysMenuInfoMapper extends BaseMapper<SysMenuInfoEntity> {

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     */
     SysMenuInfoQueryVo getSysMenuInfoById(Serializable id);

    /**
     * 获取 系统功能菜单信息表 分页对象
     *
     * @param page
     * @param sysMenuInfoPageQueryParam
     * @return
     */
     IPage<SysMenuInfoQueryVo> getSysMenuInfoPageList(@Param("page") Page page, @Param("param") SysMenuInfoPageQueryParam sysMenuInfoPageQueryParam);
    
    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param sysMenuInfoQueryParam
     * @return
     */
     List<SysMenuInfoQueryVo> getSysMenuInfoList(@Param("param") SysMenuInfoQueryParam sysMenuInfoQueryParam);

}