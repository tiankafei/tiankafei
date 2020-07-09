package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.blog.entity.SysBlogDiaryEntity;
import org.tiankafei.blog.param.SysBlogDiaryQueryParam;
import org.tiankafei.blog.param.SysBlogDiaryPageQueryParam;
import org.tiankafei.blog.vo.SysBlogDiaryQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统的博客日记 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysBlogDiaryMapper extends BaseMapper<SysBlogDiaryEntity> {

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     */
    SysBlogDiaryQueryVo getSysBlogDiaryById(Serializable id);

    /**
     * 获取 系统的博客日记 分页对象
     *
     * @param page
     * @param sysBlogDiaryPageQueryParam
     * @return
     */
    IPage<SysBlogDiaryQueryVo> getSysBlogDiaryPageList(@Param("page") Page page, @Param("param") SysBlogDiaryPageQueryParam sysBlogDiaryPageQueryParam);

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param sysBlogDiaryQueryParam
     * @return
     */
    List<SysBlogDiaryQueryVo> getSysBlogDiaryList(@Param("param") SysBlogDiaryQueryParam sysBlogDiaryQueryParam);

}