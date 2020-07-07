package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysLinksEntity;
import org.tiankafei.user.param.SysLinksQueryParam;
import org.tiankafei.user.param.SysLinksPageQueryParam;
import org.tiankafei.user.vo.SysLinksQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统的友情链接 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysLinksMapper extends BaseMapper<SysLinksEntity> {

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     */
     SysLinksQueryVo getSysLinksById(Serializable id);

    /**
     * 获取 系统的友情链接 分页对象
     *
     * @param page
     * @param sysLinksPageQueryParam
     * @return
     */
     IPage<SysLinksQueryVo> getSysLinksPageList(@Param("page") Page page, @Param("param") SysLinksPageQueryParam sysLinksPageQueryParam);
    
    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param sysLinksQueryParam
     * @return
     */
     List<SysLinksQueryVo> getSysLinksList(@Param("param") SysLinksQueryParam sysLinksQueryParam);

}