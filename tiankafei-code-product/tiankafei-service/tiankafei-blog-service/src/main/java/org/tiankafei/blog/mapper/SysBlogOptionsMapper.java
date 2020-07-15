package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.blog.entity.SysBlogOptionsEntity;
import org.tiankafei.blog.param.SysBlogOptionsPageQueryParam;
import org.tiankafei.blog.param.SysBlogOptionsQueryParam;
import org.tiankafei.blog.vo.SysBlogOptionsQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客选项设置 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysBlogOptionsMapper extends BaseMapper<SysBlogOptionsEntity> {

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     */
    SysBlogOptionsQueryVo getSysBlogOptionsById(Serializable id);

    /**
     * 获取 系统的博客选项设置 分页对象
     *
     * @param page
     * @param sysBlogOptionsPageQueryParam
     * @return
     */
    IPage<SysBlogOptionsQueryVo> getSysBlogOptionsPageList(@Param("page") Page page, @Param("param") SysBlogOptionsPageQueryParam sysBlogOptionsPageQueryParam);

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param sysBlogOptionsQueryParam
     * @return
     */
    List<SysBlogOptionsQueryVo> getSysBlogOptionsList(@Param("param") SysBlogOptionsQueryParam sysBlogOptionsQueryParam);

}