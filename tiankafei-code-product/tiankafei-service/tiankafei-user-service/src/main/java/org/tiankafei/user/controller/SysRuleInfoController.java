package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysRuleInfoService;
import org.tiankafei.user.param.SysRuleInfoQueryParam;
import org.tiankafei.user.param.SysRuleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRuleInfoQueryVo;
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
 * 角色信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysRuleInfo")
@Api(value = "角色信息表 API", tags = "角色信息表 功能维护")
public class SysRuleInfoController extends BaseController {

    @Autowired
    private SysRuleInfoService sysRuleInfoService;

    /**
     * 校验 角色信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 角色信息表 是否已经存在", notes = "校验 角色信息表 是否已经存在")
    public ApiResult<Boolean> checkSysRuleInfoExists(@Valid @RequestBody SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        Boolean flag = sysRuleInfoService.checkSysRuleInfoExists(sysRuleInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 角色信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 角色信息表 对象", notes = "添加 角色信息表")
    public ApiResult<String> addSysRuleInfo(@Valid @RequestBody SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception {
        Object id = sysRuleInfoService.saveSysRuleInfo(sysRuleInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 角色信息表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 角色信息表 对象", notes = "修改 角色信息表")
    public ApiResult<Boolean> updateSysRuleInfo(@Valid @RequestBody SysRuleInfoQueryVo sysRuleInfoQueryVo) throws Exception {
        boolean flag = sysRuleInfoService.updateSysRuleInfo(sysRuleInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 角色信息表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 角色信息表 对象", notes = "删除 角色信息表")
    public ApiResult<Boolean> deleteSysRuleInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysRuleInfoService.deleteSysRuleInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 角色信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 角色信息表 对象详情", notes = "获取 角色信息表 对象详情")
    public ApiResult<SysRuleInfoQueryVo> getSysRuleInfo(@PathVariable("id") String id) throws Exception {
         SysRuleInfoQueryVo sysRuleInfoQueryVo = sysRuleInfoService.getSysRuleInfoById(id);
        return ApiResult.ok(sysRuleInfoQueryVo);
    }

    /**
     * 获取 角色信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 角色信息表 分页列表", notes = "获取 角色信息表 分页列表")
    public ApiResult<Paging<SysRuleInfoQueryVo>> getSysRuleInfoPageList(@Valid @RequestBody SysRuleInfoPageQueryParam sysRuleInfoPageQueryParam) throws Exception {
         Paging<SysRuleInfoQueryVo> paging = sysRuleInfoService.getSysRuleInfoPageList(sysRuleInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 角色信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 角色信息表 列表", notes = "获取 角色信息表 列表")
    public ApiResult<List<SysRuleInfoQueryVo>> getSysRuleInfoList(@Valid @RequestBody SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
         List<SysRuleInfoQueryVo> paging = sysRuleInfoService.getSysRuleInfoList(sysRuleInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 角色信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 角色信息表 总记录数", notes = "计算 角色信息表 总记录数")
    public ApiResult<Integer> countSysRuleInfo(@Valid @RequestBody SysRuleInfoQueryParam sysRuleInfoQueryParam) throws Exception {
        int count = sysRuleInfoService.countSysRuleInfo(sysRuleInfoQueryParam);
        return ApiResult.ok(count);
    }

}