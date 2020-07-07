package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysRoleInfoService;
import org.tiankafei.user.param.SysRoleInfoQueryParam;
import org.tiankafei.user.param.SysRoleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRoleInfoQueryVo;
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
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysRoleInfo")
@Api(value = "角色信息表 API", tags = "角色信息表 功能维护")
public class SysRoleInfoController extends BaseController {

    @Autowired
    private SysRoleInfoService sysRoleInfoService;

    /**
     * 校验 角色信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 角色信息表 是否已经存在", notes = "校验 角色信息表 是否已经存在")
    public ApiResult<Boolean> checkSysRoleInfoExists(@Valid @RequestBody SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        Boolean flag = sysRoleInfoService.checkSysRoleInfoExists(sysRoleInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 角色信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 角色信息表 对象", notes = "添加 角色信息表")
    public ApiResult<String> addSysRoleInfo(@Valid @RequestBody SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception {
        Object id = sysRoleInfoService.addSysRoleInfo(sysRoleInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 角色信息表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 角色信息表 对象", notes = "修改 角色信息表")
    public ApiResult<Boolean> updateSysRoleInfo(@Valid @RequestBody SysRoleInfoQueryVo sysRoleInfoQueryVo) throws Exception {
        boolean flag = sysRoleInfoService.updateSysRoleInfo(sysRoleInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 角色信息表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 角色信息表 对象", notes = "删除 角色信息表")
    public ApiResult<Boolean> deleteSysRoleInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysRoleInfoService.deleteSysRoleInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 角色信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 角色信息表 对象详情", notes = "获取 角色信息表 对象详情")
    public ApiResult<SysRoleInfoQueryVo> getSysRoleInfo(@PathVariable("id") String id) throws Exception {
         SysRoleInfoQueryVo sysRoleInfoQueryVo = sysRoleInfoService.getSysRoleInfoById(id);
        return ApiResult.ok(sysRoleInfoQueryVo);
    }

    /**
     * 获取 角色信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 角色信息表 分页列表", notes = "获取 角色信息表 分页列表")
    public ApiResult<Paging<SysRoleInfoQueryVo>> getSysRoleInfoPageList(@Valid @RequestBody SysRoleInfoPageQueryParam sysRoleInfoPageQueryParam) throws Exception {
         Paging<SysRoleInfoQueryVo> paging = sysRoleInfoService.getSysRoleInfoPageList(sysRoleInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 角色信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 角色信息表 列表", notes = "获取 角色信息表 列表")
    public ApiResult<List<SysRoleInfoQueryVo>> getSysRoleInfoList(@Valid @RequestBody SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
         List<SysRoleInfoQueryVo> paging = sysRoleInfoService.getSysRoleInfoList(sysRoleInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 角色信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 角色信息表 总记录数", notes = "计算 角色信息表 总记录数")
    public ApiResult<Integer> countSysRoleInfo(@Valid @RequestBody SysRoleInfoQueryParam sysRoleInfoQueryParam) throws Exception {
        int count = sysRoleInfoService.countSysRoleInfo(sysRoleInfoQueryParam);
        return ApiResult.ok(count);
    }

}