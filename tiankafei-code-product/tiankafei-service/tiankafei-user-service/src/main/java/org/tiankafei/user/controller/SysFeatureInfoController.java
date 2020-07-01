package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysFeatureInfoService;
import org.tiankafei.user.param.SysFeatureInfoQueryParam;
import org.tiankafei.user.param.SysFeatureInfoPageQueryParam;
import org.tiankafei.user.vo.SysFeatureInfoQueryVo;
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
 * 系统功能菜单信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysFeatureInfo")
@Api(value = "系统功能菜单信息表 API", tags = "系统功能菜单信息表 功能维护")
public class SysFeatureInfoController extends BaseController {

    @Autowired
    private SysFeatureInfoService sysFeatureInfoService;

    /**
     * 校验 系统功能菜单信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统功能菜单信息表 是否已经存在", notes = "校验 系统功能菜单信息表 是否已经存在")
    public ApiResult<Boolean> checkSysFeatureInfoExists(@Valid @RequestBody SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        Boolean flag = sysFeatureInfoService.checkSysFeatureInfoExists(sysFeatureInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统功能菜单信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统功能菜单信息表 对象", notes = "添加 系统功能菜单信息表")
    public ApiResult<String> addSysFeatureInfo(@Valid @RequestBody SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception {
        Object id = sysFeatureInfoService.saveSysFeatureInfo(sysFeatureInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统功能菜单信息表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统功能菜单信息表 对象", notes = "修改 系统功能菜单信息表")
    public ApiResult<Boolean> updateSysFeatureInfo(@Valid @RequestBody SysFeatureInfoQueryVo sysFeatureInfoQueryVo) throws Exception {
        boolean flag = sysFeatureInfoService.updateSysFeatureInfo(sysFeatureInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统功能菜单信息表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统功能菜单信息表 对象", notes = "删除 系统功能菜单信息表")
    public ApiResult<Boolean> deleteSysFeatureInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysFeatureInfoService.deleteSysFeatureInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统功能菜单信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统功能菜单信息表 对象详情", notes = "获取 系统功能菜单信息表 对象详情")
    public ApiResult<SysFeatureInfoQueryVo> getSysFeatureInfo(@PathVariable("id") String id) throws Exception {
         SysFeatureInfoQueryVo sysFeatureInfoQueryVo = sysFeatureInfoService.getSysFeatureInfoById(id);
        return ApiResult.ok(sysFeatureInfoQueryVo);
    }

    /**
     * 获取 系统功能菜单信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统功能菜单信息表 分页列表", notes = "获取 系统功能菜单信息表 分页列表")
    public ApiResult<Paging<SysFeatureInfoQueryVo>> getSysFeatureInfoPageList(@Valid @RequestBody SysFeatureInfoPageQueryParam sysFeatureInfoPageQueryParam) throws Exception {
         Paging<SysFeatureInfoQueryVo> paging = sysFeatureInfoService.getSysFeatureInfoPageList(sysFeatureInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统功能菜单信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统功能菜单信息表 列表", notes = "获取 系统功能菜单信息表 列表")
    public ApiResult<List<SysFeatureInfoQueryVo>> getSysFeatureInfoList(@Valid @RequestBody SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
         List<SysFeatureInfoQueryVo> paging = sysFeatureInfoService.getSysFeatureInfoList(sysFeatureInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统功能菜单信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统功能菜单信息表 总记录数", notes = "计算 系统功能菜单信息表 总记录数")
    public ApiResult<Integer> countSysFeatureInfo(@Valid @RequestBody SysFeatureInfoQueryParam sysFeatureInfoQueryParam) throws Exception {
        int count = sysFeatureInfoService.countSysFeatureInfo(sysFeatureInfoQueryParam);
        return ApiResult.ok(count);
    }

}