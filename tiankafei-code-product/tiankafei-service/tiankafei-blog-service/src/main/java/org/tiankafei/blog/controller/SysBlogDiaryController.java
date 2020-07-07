package org.tiankafei.blog.controller;

import org.tiankafei.blog.service.SysBlogDiaryService;
import org.tiankafei.blog.param.SysBlogDiaryQueryParam;
import org.tiankafei.blog.param.SysBlogDiaryPageQueryParam;
import org.tiankafei.blog.vo.SysBlogDiaryQueryVo;
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
 * 系统的博客日记 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysBlogDiary")
@Api(value = "系统的博客日记 API", tags = "系统的博客日记 功能维护")
public class SysBlogDiaryController extends BaseController {

    @Autowired
    private SysBlogDiaryService sysBlogDiaryService;

    /**
     * 校验 系统的博客日记 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客日记 是否已经存在", notes = "校验 系统的博客日记 是否已经存在")
    public ApiResult<Boolean> checkSysBlogDiaryExists(@Valid @RequestBody SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        Boolean flag = sysBlogDiaryService.checkSysBlogDiaryExists(sysBlogDiaryQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的博客日记 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的博客日记 对象", notes = "添加 系统的博客日记")
    public ApiResult<String> addSysBlogDiary(@Valid @RequestBody SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception {
        Object id = sysBlogDiaryService.addSysBlogDiary(sysBlogDiaryQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的博客日记 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统的博客日记 对象", notes = "修改 系统的博客日记")
    public ApiResult<Boolean> updateSysBlogDiary(@Valid @RequestBody SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception {
        boolean flag = sysBlogDiaryService.updateSysBlogDiary(sysBlogDiaryQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的博客日记 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统的博客日记 对象", notes = "删除 系统的博客日记")
    public ApiResult<Boolean> deleteSysBlogDiary(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysBlogDiaryService.deleteSysBlogDiary(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的博客日记 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的博客日记 对象详情", notes = "获取 系统的博客日记 对象详情")
    public ApiResult<SysBlogDiaryQueryVo> getSysBlogDiary(@PathVariable("id") String id) throws Exception {
         SysBlogDiaryQueryVo sysBlogDiaryQueryVo = sysBlogDiaryService.getSysBlogDiaryById(id);
        return ApiResult.ok(sysBlogDiaryQueryVo);
    }

    /**
     * 获取 系统的博客日记 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客日记 分页列表", notes = "获取 系统的博客日记 分页列表")
    public ApiResult<Paging<SysBlogDiaryQueryVo>> getSysBlogDiaryPageList(@Valid @RequestBody SysBlogDiaryPageQueryParam sysBlogDiaryPageQueryParam) throws Exception {
         Paging<SysBlogDiaryQueryVo> paging = sysBlogDiaryService.getSysBlogDiaryPageList(sysBlogDiaryPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统的博客日记 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客日记 列表", notes = "获取 系统的博客日记 列表")
    public ApiResult<List<SysBlogDiaryQueryVo>> getSysBlogDiaryList(@Valid @RequestBody SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
         List<SysBlogDiaryQueryVo> paging = sysBlogDiaryService.getSysBlogDiaryList(sysBlogDiaryQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统的博客日记 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的博客日记 总记录数", notes = "计算 系统的博客日记 总记录数")
    public ApiResult<Integer> countSysBlogDiary(@Valid @RequestBody SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception {
        int count = sysBlogDiaryService.countSysBlogDiary(sysBlogDiaryQueryParam);
        return ApiResult.ok(count);
    }

}