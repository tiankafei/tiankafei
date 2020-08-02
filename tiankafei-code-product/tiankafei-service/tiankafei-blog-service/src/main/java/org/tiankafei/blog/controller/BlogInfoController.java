package org.tiankafei.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.blog.param.BlogInfoCheckParam;
import org.tiankafei.blog.param.BlogInfoCountParam;
import org.tiankafei.blog.param.BlogInfoDeleteParam;
import org.tiankafei.blog.param.BlogInfoListParam;
import org.tiankafei.blog.param.BlogInfoPageParam;
import org.tiankafei.blog.service.BlogInfoService;
import org.tiankafei.blog.vo.BlogInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客数据 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/blog/blog-info-entity")
@Api(value = "系统的博客数据 API", tags = {"系统的博客数据"})
public class BlogInfoController extends BaseController {

    @Autowired
    private BlogInfoService blogInfoService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客数据 对象是否存在")
    public ApiResult<Boolean> checkBlogInfoControllerExists(@Valid @RequestBody BlogInfoCheckParam blogInfoCheckParam) throws Exception {
        Boolean flag = blogInfoService.checkBlogInfoServiceExists(blogInfoCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统的博客数据")
    public ApiResult<Object> addBlogInfoController(@Valid @RequestBody BlogInfoVo blogInfoVo) throws Exception {
        Object id = blogInfoService.addBlogInfoService(blogInfoVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统的博客数据")
    public ApiResult<List<Object>> batchAddBlogInfoController(@Valid @RequestBody List<BlogInfoVo> blogInfoVoList) throws Exception {
        List<Object> idList = blogInfoService.batchAddBlogInfoService(blogInfoVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统的博客数据")
    public ApiResult<Boolean> deleteBlogInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = blogInfoService.deleteBlogInfoService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统的博客数据")
    public ApiResult<Boolean> batchDeleteBlogInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = blogInfoService.batchDeleteBlogInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统的博客数据")
    public ApiResult<Boolean> conditionDeleteBlogInfoController(@Valid @RequestBody BlogInfoDeleteParam blogInfoDeleteParam) throws Exception {
        boolean flag = blogInfoService.conditionDeleteBlogInfoService(blogInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统的博客数据")
    public ApiResult<Boolean> updateBlogInfoController(@Valid @RequestBody BlogInfoVo blogInfoVo) throws Exception {
        boolean flag = blogInfoService.updateBlogInfoService(blogInfoVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统的博客数据 对象")
    public ApiResult<BlogInfoVo> getBlogInfoController(@PathVariable(value = "id") String id) throws Exception {
        BlogInfoVo blogInfoVo = blogInfoService.getBlogInfoServiceById(id);
        return ApiResult.ok(blogInfoVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统的博客数据 对象全部列表")
    public ApiResult<List<BlogInfoVo>> getBlogInfoControllerAllList() throws Exception {
        List<BlogInfoVo> blogInfoVoList = blogInfoService.getBlogInfoServiceList(null);
        return ApiResult.ok(blogInfoVoList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客数据 对象列表")
    public ApiResult<List<BlogInfoVo>> getBlogInfoControllerList(@Valid @RequestBody BlogInfoListParam blogInfoListParam) throws Exception {
        List<BlogInfoVo> blogInfoVoList = blogInfoService.getBlogInfoServiceList(blogInfoListParam);
        return ApiResult.ok(blogInfoVoList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客数据 分页对象列表")
    public ApiResult<Paging<BlogInfoVo>> getBlogInfoControllerPageList(@Valid @RequestBody BlogInfoPageParam blogInfoPageParam) throws Exception {
        Paging<BlogInfoVo> blogInfoVoList = blogInfoService.getBlogInfoServicePageList(blogInfoPageParam);
        return ApiResult.ok(blogInfoVoList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统的博客数据 对象的记录数")
    public ApiResult<Integer> countBlogInfoController(@Valid @RequestBody BlogInfoCountParam blogInfoCountParam) throws Exception {
        Integer count = blogInfoService.countBlogInfoService(blogInfoCountParam);
        return ApiResult.ok(count);
    }


}

