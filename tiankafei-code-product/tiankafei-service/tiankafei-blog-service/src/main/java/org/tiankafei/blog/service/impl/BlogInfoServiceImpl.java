package org.tiankafei.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.blog.entity.BlogInfoEntity;
import org.tiankafei.blog.mapper.BlogInfoMapper;
import org.tiankafei.blog.param.BlogInfoCheckParam;
import org.tiankafei.blog.param.BlogInfoCountParam;
import org.tiankafei.blog.param.BlogInfoDeleteParam;
import org.tiankafei.blog.param.BlogInfoListParam;
import org.tiankafei.blog.param.BlogInfoPageParam;
import org.tiankafei.blog.service.BlogInfoService;
import org.tiankafei.blog.vo.BlogInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class BlogInfoServiceImpl extends BaseServiceImpl<BlogInfoMapper, BlogInfoEntity> implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;


    /**
     * 校验 系统的博客数据 是否已经存在
     *
     * @param blogInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkBlogInfoServiceExists(BlogInfoCheckParam blogInfoCheckParam) throws Exception {
        LambdaQueryWrapper<BlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (blogInfoCheckParam != null) {
            Long id = blogInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(BlogInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addBlogInfoService(BlogInfoVo blogInfoVo) throws Exception {
        BlogInfoEntity blogInfoEntity = new BlogInfoEntity();
        BeanUtils.copyProperties(blogInfoVo, blogInfoEntity);
        super.save(blogInfoEntity);
        return blogInfoEntity.getId();
    }

    /**
     * 保存 系统的博客数据 集合
     *
     * @param blogInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddBlogInfoService(List<BlogInfoVo> blogInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(blogInfoVoList)) {
            List<BlogInfoEntity> blogInfoEntityList = Lists.newArrayList();
            for (BlogInfoVo blogInfoVo : blogInfoVoList) {
                BlogInfoEntity blogInfoEntity = new BlogInfoEntity();
                BeanUtils.copyProperties(blogInfoVo, blogInfoEntity);
                blogInfoEntityList.add(blogInfoEntity);
            }
            super.saveBatch(blogInfoEntityList);

            return blogInfoEntityList.stream().map(blogInfoEntity -> blogInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统的博客数据
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteBlogInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 系统的博客数据
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteBlogInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统的博客数据
     *
     * @param blogInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteBlogInfoService(BlogInfoDeleteParam blogInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<BlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (blogInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统的博客数据
     *
     * @param blogInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateBlogInfoService(BlogInfoVo blogInfoVo) throws Exception {
        BlogInfoEntity blogInfoEntity = new BlogInfoEntity();
        BeanUtils.copyProperties(blogInfoVo, blogInfoEntity);
        return super.updateById(blogInfoEntity);
    }

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public BlogInfoVo getBlogInfoServiceById(Serializable id) throws Exception {
        BlogInfoEntity blogInfoEntity = super.getById(id);
        BlogInfoVo blogInfoVo = new BlogInfoVo();
        BeanUtils.copyProperties(blogInfoEntity, blogInfoVo);
        return blogInfoVo;
    }

    /**
     * 获取 系统的博客数据 对象列表
     *
     * @param blogInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<BlogInfoVo> getBlogInfoServiceList(BlogInfoListParam blogInfoListParam) throws Exception {
        return blogInfoMapper.getBlogInfoServiceList(blogInfoListParam);
    }

    /**
     * 获取 系统的博客数据 分页对象列表
     *
     * @param blogInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<BlogInfoVo> getBlogInfoServicePageList(BlogInfoPageParam blogInfoPageParam) throws Exception {
        Page page = setPageParam(blogInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<BlogInfoVo> iPage = blogInfoMapper.getBlogInfoServicePageList(page, blogInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(blogInfoVo -> blogInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<BlogInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            BlogInfoListParam blogInfoListParam = new BlogInfoListParam();
            blogInfoListParam.setIdList(idList);
            List<BlogInfoVo> blogInfoVoList = this.getBlogInfoServiceList(blogInfoListParam);
            paging.setRecords(blogInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统的博客数据 总记录数
     *
     * @param blogInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countBlogInfoService(BlogInfoCountParam blogInfoCountParam) throws Exception {
        LambdaQueryWrapper<BlogInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (blogInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
