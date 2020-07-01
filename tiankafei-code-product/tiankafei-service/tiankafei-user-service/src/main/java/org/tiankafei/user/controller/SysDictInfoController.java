package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysDictInfoService;
import org.tiankafei.user.param.SysDictInfoQueryParam;
import org.tiankafei.user.param.SysDictInfoPageQueryParam;
import org.tiankafei.user.vo.SysDictInfoQueryVo;
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
 * 系统数据字典表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysDictInfo")
@Api(value = "系统数据字典表 API", tags = "系统数据字典表 功能维护")
public class SysDictInfoController extends BaseController {

    @Autowired
    private SysDictInfoService sysDictInfoService;

    /**
     * 校验 系统数据字典表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 是否已经存在", notes = "校验 系统数据字典表 是否已经存在")
    public ApiResult<Boolean> checkSysDictInfoExists(@Valid @RequestBody SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        Boolean flag = sysDictInfoService.checkSysDictInfoExists(sysDictInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统数据字典表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统数据字典表 对象", notes = "添加 系统数据字典表")
    public ApiResult<String> addSysDictInfo(@Valid @RequestBody SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception {
        Object id = sysDictInfoService.addSysDictInfo(sysDictInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统数据字典表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统数据字典表 对象", notes = "修改 系统数据字典表")
    public ApiResult<Boolean> updateSysDictInfo(@Valid @RequestBody SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception {
        boolean flag = sysDictInfoService.updateSysDictInfo(sysDictInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统数据字典表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统数据字典表 对象", notes = "删除 系统数据字典表")
    public ApiResult<Boolean> deleteSysDictInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysDictInfoService.deleteSysDictInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统数据字典表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统数据字典表 对象详情", notes = "获取 系统数据字典表 对象详情")
    public ApiResult<SysDictInfoQueryVo> getSysDictInfo(@PathVariable("id") String id) throws Exception {
         SysDictInfoQueryVo sysDictInfoQueryVo = sysDictInfoService.getSysDictInfoById(id);
        return ApiResult.ok(sysDictInfoQueryVo);
    }

    /**
     * 获取 系统数据字典表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页列表", notes = "获取 系统数据字典表 分页列表")
    public ApiResult<Paging<SysDictInfoQueryVo>> getSysDictInfoPageList(@Valid @RequestBody SysDictInfoPageQueryParam sysDictInfoPageQueryParam) throws Exception {
         Paging<SysDictInfoQueryVo> paging = sysDictInfoService.getSysDictInfoPageList(sysDictInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统数据字典表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 列表", notes = "获取 系统数据字典表 列表")
    public ApiResult<List<SysDictInfoQueryVo>> getSysDictInfoList(@Valid @RequestBody SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
         List<SysDictInfoQueryVo> paging = sysDictInfoService.getSysDictInfoList(sysDictInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统数据字典表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统数据字典表 总记录数", notes = "计算 系统数据字典表 总记录数")
    public ApiResult<Integer> countSysDictInfo(@Valid @RequestBody SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception {
        int count = sysDictInfoService.countSysDictInfo(sysDictInfoQueryParam);
        return ApiResult.ok(count);
    }

}