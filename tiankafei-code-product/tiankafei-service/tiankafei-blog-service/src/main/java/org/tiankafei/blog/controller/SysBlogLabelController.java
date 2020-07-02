package org.tiankafei.blog.controller;

import org.tiankafei.blog.service.SysBlogLabelService;
import org.tiankafei.blog.param.SysBlogLabelQueryParam;
import org.tiankafei.blog.param.SysBlogLabelPageQueryParam;
import org.tiankafei.blog.vo.SysBlogLabelQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.tiankafei.web.common.vo.Paging;
import org.tiankafei.web.common.param.IdsParam;

import java.util.List;

/**
 * <pre>
 * 系统的博客标签 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-02
 */
@Slf4j
@RestController
@RequestMapping("/sysBlogLabel")
@Api(value = "系统的博客标签 API", tags = "系统的博客标签 功能维护")
public class SysBlogLabelController extends BaseController {

    @Autowired
    private SysBlogLabelService sysBlogLabelService;

    /**
     * 校验 系统的博客标签 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客标签 是否已经存在", notes = "校验 系统的博客标签 是否已经存在")
    public ApiResult<Boolean> checkSysBlogLabelExists(@Valid @RequestBody SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        Boolean flag = sysBlogLabelService.checkSysBlogLabelExists(sysBlogLabelQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的博客标签 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的博客标签 对象", notes = "添加 系统的博客标签")
    public ApiResult<String> addSysBlogLabel(@Valid @RequestBody SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception {
        Object id = sysBlogLabelService.addSysBlogLabel(sysBlogLabelQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的博客标签 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统的博客标签 对象", notes = "修改 系统的博客标签")
    public ApiResult<Boolean> updateSysBlogLabel(@Valid @RequestBody SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception {
        boolean flag = sysBlogLabelService.updateSysBlogLabel(sysBlogLabelQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的博客标签 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统的博客标签 对象", notes = "删除 系统的博客标签")
    public ApiResult<Boolean> deleteSysBlogLabel(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysBlogLabelService.deleteSysBlogLabel(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的博客标签 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的博客标签 对象详情", notes = "获取 系统的博客标签 对象详情")
    public ApiResult<SysBlogLabelQueryVo> getSysBlogLabel(@PathVariable("id") String id) throws Exception {
         SysBlogLabelQueryVo sysBlogLabelQueryVo = sysBlogLabelService.getSysBlogLabelById(id);
        return ApiResult.ok(sysBlogLabelQueryVo);
    }

    /**
     * 获取 系统的博客标签 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客标签 分页列表", notes = "获取 系统的博客标签 分页列表")
    public ApiResult<Paging<SysBlogLabelQueryVo>> getSysBlogLabelPageList(@Valid @RequestBody SysBlogLabelPageQueryParam sysBlogLabelPageQueryParam) throws Exception {
         Paging<SysBlogLabelQueryVo> paging = sysBlogLabelService.getSysBlogLabelPageList(sysBlogLabelPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统的博客标签 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客标签 列表", notes = "获取 系统的博客标签 列表")
    public ApiResult<List<SysBlogLabelQueryVo>> getSysBlogLabelList(@Valid @RequestBody SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
         List<SysBlogLabelQueryVo> paging = sysBlogLabelService.getSysBlogLabelList(sysBlogLabelQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统的博客标签 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的博客标签 总记录数", notes = "计算 系统的博客标签 总记录数")
    public ApiResult<Integer> countSysBlogLabel(@Valid @RequestBody SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception {
        int count = sysBlogLabelService.countSysBlogLabel(sysBlogLabelQueryParam);
        return ApiResult.ok(count);
    }

}