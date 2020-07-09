package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.blog.entity.SysBlogLabelEntity;
import org.tiankafei.blog.param.SysBlogLabelQueryParam;
import org.tiankafei.blog.param.SysBlogLabelPageQueryParam;
import org.tiankafei.blog.vo.SysBlogLabelQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统的博客标签 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysBlogLabelMapper extends BaseMapper<SysBlogLabelEntity> {

    /**
     * 根据ID获取 系统的博客标签 对象
     *
     * @param id
     * @return
     */
    SysBlogLabelQueryVo getSysBlogLabelById(Serializable id);

    /**
     * 获取 系统的博客标签 分页对象
     *
     * @param page
     * @param sysBlogLabelPageQueryParam
     * @return
     */
    IPage<SysBlogLabelQueryVo> getSysBlogLabelPageList(@Param("page") Page page, @Param("param") SysBlogLabelPageQueryParam sysBlogLabelPageQueryParam);

    /**
     * 获取 系统的博客标签 对象列表
     *
     * @param sysBlogLabelQueryParam
     * @return
     */
    List<SysBlogLabelQueryVo> getSysBlogLabelList(@Param("param") SysBlogLabelQueryParam sysBlogLabelQueryParam);

}