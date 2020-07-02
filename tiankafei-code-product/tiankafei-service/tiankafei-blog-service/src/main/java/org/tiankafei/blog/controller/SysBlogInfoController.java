package org.tiankafei.blog.controller;

import org.tiankafei.blog.service.SysBlogInfoService;
import org.tiankafei.blog.param.SysBlogInfoQueryParam;
import org.tiankafei.blog.param.SysBlogInfoPageQueryParam;
import org.tiankafei.blog.vo.SysBlogInfoQueryVo;
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
 * 系统的博客数据 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-02
 */
@Slf4j
@RestController
@RequestMapping("/sysBlogInfo")
@Api(value = "系统的博客数据 API", tags = "系统的博客数据 功能维护")
public class SysBlogInfoController extends BaseController {

    @Autowired
    private SysBlogInfoService sysBlogInfoService;

    /**
     * 校验 系统的博客数据 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客数据 是否已经存在", notes = "校验 系统的博客数据 是否已经存在")
    public ApiResult<Boolean> checkSysBlogInfoExists(@Valid @RequestBody SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        Boolean flag = sysBlogInfoService.checkSysBlogInfoExists(sysBlogInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的博客数据 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的博客数据 对象", notes = "添加 系统的博客数据")
    public ApiResult<String> addSysBlogInfo(@Valid @RequestBody SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception {
        Object id = sysBlogInfoService.addSysBlogInfo(sysBlogInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的博客数据 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统的博客数据 对象", notes = "修改 系统的博客数据")
    public ApiResult<Boolean> updateSysBlogInfo(@Valid @RequestBody SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception {
        boolean flag = sysBlogInfoService.updateSysBlogInfo(sysBlogInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的博客数据 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统的博客数据 对象", notes = "删除 系统的博客数据")
    public ApiResult<Boolean> deleteSysBlogInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysBlogInfoService.deleteSysBlogInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的博客数据 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的博客数据 对象详情", notes = "获取 系统的博客数据 对象详情")
    public ApiResult<SysBlogInfoQueryVo> getSysBlogInfo(@PathVariable("id") String id) throws Exception {
         SysBlogInfoQueryVo sysBlogInfoQueryVo = sysBlogInfoService.getSysBlogInfoById(id);
        return ApiResult.ok(sysBlogInfoQueryVo);
    }

    /**
     * 获取 系统的博客数据 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客数据 分页列表", notes = "获取 系统的博客数据 分页列表")
    public ApiResult<Paging<SysBlogInfoQueryVo>> getSysBlogInfoPageList(@Valid @RequestBody SysBlogInfoPageQueryParam sysBlogInfoPageQueryParam) throws Exception {
         Paging<SysBlogInfoQueryVo> paging = sysBlogInfoService.getSysBlogInfoPageList(sysBlogInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统的博客数据 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客数据 列表", notes = "获取 系统的博客数据 列表")
    public ApiResult<List<SysBlogInfoQueryVo>> getSysBlogInfoList(@Valid @RequestBody SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
         List<SysBlogInfoQueryVo> paging = sysBlogInfoService.getSysBlogInfoList(sysBlogInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统的博客数据 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的博客数据 总记录数", notes = "计算 系统的博客数据 总记录数")
    public ApiResult<Integer> countSysBlogInfo(@Valid @RequestBody SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception {
        int count = sysBlogInfoService.countSysBlogInfo(sysBlogInfoQueryParam);
        return ApiResult.ok(count);
    }

}