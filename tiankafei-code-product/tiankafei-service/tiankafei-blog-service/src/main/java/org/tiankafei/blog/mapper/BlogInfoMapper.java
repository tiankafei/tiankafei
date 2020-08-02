package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.blog.entity.BlogInfoEntity;
import org.tiankafei.blog.param.BlogInfoCheckParam;
import org.tiankafei.blog.param.BlogInfoCountParam;
import org.tiankafei.blog.param.BlogInfoDeleteParam;
import org.tiankafei.blog.param.BlogInfoListParam;
import org.tiankafei.blog.param.BlogInfoPageParam;
import org.tiankafei.blog.vo.BlogInfoVo;

/**
 * <p>
 * 系统的博客数据 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface BlogInfoMapper extends BaseMapper<BlogInfoEntity> {

    /**
     * 校验 系统的博客数据 是否已经存在
     *
     * @param blogInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkBlogInfoServiceExists(@Param("param") BlogInfoCheckParam blogInfoCheckParam) throws Exception;

    /**
     * 保存 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    Object addBlogInfoService(@Param("param") BlogInfoVo blogInfoVo) throws Exception;

    /**
     * 批量保存 系统的博客数据
     *
     * @param blogInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddBlogInfoService(@Param("param") List<BlogInfoVo> blogInfoVoList) throws Exception;

    /**
     * 删除 系统的博客数据
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteBlogInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统的博客数据
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteBlogInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客数据
     *
     * @param blogInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteBlogInfoService(@Param("param") BlogInfoDeleteParam blogInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    boolean updateBlogInfoService(@Param("param") BlogInfoVo blogInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoVo getBlogInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统的博客数据 对象列表
     *
     * @param blogInfoListParam
     * @return
     * @throws Exception
     */
    List<BlogInfoVo> getBlogInfoServiceList(@Param("param") BlogInfoListParam blogInfoListParam) throws Exception;

    /**
     * 获取 系统的博客数据 分页对象列表
     *
     * @param page
     * @param blogInfoPageParam
     * @return
     * @throws Exception
     */
    List<Long> getBlogInfoServicePageList(@Param("page") Page page, @Param("param") BlogInfoPageParam blogInfoPageParam) throws Exception;

    /**
     * 计算 系统的博客数据 总记录数
     *
     * @param blogInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countBlogInfoService(@Param("param") BlogInfoCountParam blogInfoCountParam) throws Exception;

}
