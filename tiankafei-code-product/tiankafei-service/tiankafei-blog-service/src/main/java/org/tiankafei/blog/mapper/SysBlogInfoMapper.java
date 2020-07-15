package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.blog.entity.SysBlogInfoEntity;
import org.tiankafei.blog.param.SysBlogInfoPageQueryParam;
import org.tiankafei.blog.param.SysBlogInfoQueryParam;
import org.tiankafei.blog.vo.SysBlogInfoQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客数据 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysBlogInfoMapper extends BaseMapper<SysBlogInfoEntity> {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     */
    SysBlogInfoQueryVo getSysBlogInfoById(Serializable id);

    /**
     * 获取 系统的博客数据 分页对象
     *
     * @param page
     * @param sysBlogInfoPageQueryParam
     * @return
     */
    IPage<SysBlogInfoQueryVo> getSysBlogInfoPageList(@Param("page") Page page, @Param("param") SysBlogInfoPageQueryParam sysBlogInfoPageQueryParam);

    /**
     * 获取 系统的博客数据 对象列表
     *
     * @param sysBlogInfoQueryParam
     * @return
     */
    List<SysBlogInfoQueryVo> getSysBlogInfoList(@Param("param") SysBlogInfoQueryParam sysBlogInfoQueryParam);

}