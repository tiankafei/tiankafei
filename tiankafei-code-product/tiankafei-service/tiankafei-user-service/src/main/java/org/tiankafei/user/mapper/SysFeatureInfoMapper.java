package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysFeatureInfoEntity;
import org.tiankafei.user.param.SysFeatureInfoQueryParam;
import org.tiankafei.user.param.SysFeatureInfoPageQueryParam;
import org.tiankafei.user.vo.SysFeatureInfoQueryVo;
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
 * @since 2020-07-01
 */
@Repository
public interface SysFeatureInfoMapper extends BaseMapper<SysFeatureInfoEntity> {

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     */
     SysFeatureInfoQueryVo getSysFeatureInfoById(Serializable id);

    /**
     * 获取 系统功能菜单信息表 分页对象
     *
     * @param page
     * @param sysFeatureInfoPageQueryParam
     * @return
     */
     IPage<SysFeatureInfoQueryVo> getSysFeatureInfoPageList(@Param("page") Page page, @Param("param") SysFeatureInfoPageQueryParam sysFeatureInfoPageQueryParam);
    
    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param sysFeatureInfoQueryParam
     * @return
     */
     List<SysFeatureInfoQueryVo> getSysFeatureInfoList(@Param("param") SysFeatureInfoQueryParam sysFeatureInfoQueryParam);

}