package org.tiankafei.blog.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.blog.entity.BlogInfoEntity;
import org.tiankafei.blog.param.BlogInfoCheckParam;
import org.tiankafei.blog.param.BlogInfoCountParam;
import org.tiankafei.blog.param.BlogInfoDeleteParam;
import org.tiankafei.blog.param.BlogInfoListParam;
import org.tiankafei.blog.param.BlogInfoPageParam;
import org.tiankafei.blog.vo.BlogInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客数据 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface BlogInfoService extends BaseService<BlogInfoEntity> {

    /**
     * 校验 系统的博客数据 是否已经存在
     *
     * @param blogInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkBlogInfoServiceExists(BlogInfoCheckParam blogInfoCheckParam) throws Exception;

    /**
     * 保存 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    Long addBlogInfoService(BlogInfoVo blogInfoVo) throws Exception;

    /**
     * 批量保存 系统的博客数据
     *
     * @param blogInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddBlogInfoService(List<BlogInfoVo> blogInfoVoList) throws Exception;

    /**
     * 删除 系统的博客数据
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteBlogInfoService(String id) throws Exception;

    /**
     * 删除 系统的博客数据
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteBlogInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客数据
     *
     * @param blogInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteBlogInfoService(BlogInfoDeleteParam blogInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    boolean updateBlogInfoService(BlogInfoVo blogInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoVo getBlogInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客数据 对象列表
     *
     * @param blogInfoListParam
     * @return
     * @throws Exception
     */
    List<BlogInfoVo> getBlogInfoServiceList(BlogInfoListParam blogInfoListParam) throws Exception;

    /**
     * 获取 系统的博客数据 分页对象列表
     *
     * @param blogInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<BlogInfoVo> getBlogInfoServicePageList(BlogInfoPageParam blogInfoPageParam) throws Exception;

    /**
     * 计算 系统的博客数据 总记录数
     *
     * @param blogInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countBlogInfoService(BlogInfoCountParam blogInfoCountParam) throws Exception;

}
