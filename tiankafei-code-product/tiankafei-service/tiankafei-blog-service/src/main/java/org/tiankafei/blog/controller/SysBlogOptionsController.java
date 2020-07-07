package org.tiankafei.blog.controller;

import org.tiankafei.blog.service.SysBlogOptionsService;
import org.tiankafei.blog.param.SysBlogOptionsQueryParam;
import org.tiankafei.blog.param.SysBlogOptionsPageQueryParam;
import org.tiankafei.blog.vo.SysBlogOptionsQueryVo;
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
 * 系统的博客选项设置 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysBlogOptions")
@Api(value = "系统的博客选项设置 API", tags = "系统的博客选项设置 功能维护")
public class SysBlogOptionsController extends BaseController {

    @Autowired
    private SysBlogOptionsService sysBlogOptionsService;

    /**
     * 校验 系统的博客选项设置 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客选项设置 是否已经存在", notes = "校验 系统的博客选项设置 是否已经存在")
    public ApiResult<Boolean> checkSysBlogOptionsExists(@Valid @RequestBody SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        Boolean flag = sysBlogOptionsService.checkSysBlogOptionsExists(sysBlogOptionsQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的博客选项设置 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的博客选项设置 对象", notes = "添加 系统的博客选项设置")
    public ApiResult<String> addSysBlogOptions(@Valid @RequestBody SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception {
        Object id = sysBlogOptionsService.addSysBlogOptions(sysBlogOptionsQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的博客选项设置 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统的博客选项设置 对象", notes = "修改 系统的博客选项设置")
    public ApiResult<Boolean> updateSysBlogOptions(@Valid @RequestBody SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception {
        boolean flag = sysBlogOptionsService.updateSysBlogOptions(sysBlogOptionsQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的博客选项设置 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统的博客选项设置 对象", notes = "删除 系统的博客选项设置")
    public ApiResult<Boolean> deleteSysBlogOptions(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysBlogOptionsService.deleteSysBlogOptions(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的博客选项设置 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的博客选项设置 对象详情", notes = "获取 系统的博客选项设置 对象详情")
    public ApiResult<SysBlogOptionsQueryVo> getSysBlogOptions(@PathVariable("id") String id) throws Exception {
         SysBlogOptionsQueryVo sysBlogOptionsQueryVo = sysBlogOptionsService.getSysBlogOptionsById(id);
        return ApiResult.ok(sysBlogOptionsQueryVo);
    }

    /**
     * 获取 系统的博客选项设置 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客选项设置 分页列表", notes = "获取 系统的博客选项设置 分页列表")
    public ApiResult<Paging<SysBlogOptionsQueryVo>> getSysBlogOptionsPageList(@Valid @RequestBody SysBlogOptionsPageQueryParam sysBlogOptionsPageQueryParam) throws Exception {
         Paging<SysBlogOptionsQueryVo> paging = sysBlogOptionsService.getSysBlogOptionsPageList(sysBlogOptionsPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统的博客选项设置 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客选项设置 列表", notes = "获取 系统的博客选项设置 列表")
    public ApiResult<List<SysBlogOptionsQueryVo>> getSysBlogOptionsList(@Valid @RequestBody SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
         List<SysBlogOptionsQueryVo> paging = sysBlogOptionsService.getSysBlogOptionsList(sysBlogOptionsQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统的博客选项设置 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的博客选项设置 总记录数", notes = "计算 系统的博客选项设置 总记录数")
    public ApiResult<Integer> countSysBlogOptions(@Valid @RequestBody SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception {
        int count = sysBlogOptionsService.countSysBlogOptions(sysBlogOptionsQueryParam);
        return ApiResult.ok(count);
    }

}