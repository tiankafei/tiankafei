package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysUserRoleService;
import org.tiankafei.user.param.SysUserRoleQueryParam;
import org.tiankafei.user.param.SysUserRolePageQueryParam;
import org.tiankafei.user.vo.SysUserRoleQueryVo;
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
 * 用户拥有的角色关系表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysUserRole")
@Api(value = "用户拥有的角色关系表 API", tags = "用户拥有的角色关系表 功能维护")
public class SysUserRoleController extends BaseController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户拥有的角色关系表 是否已经存在", notes = "校验 用户拥有的角色关系表 是否已经存在")
    public ApiResult<Boolean> checkSysUserRoleExists(@Valid @RequestBody SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        Boolean flag = sysUserRoleService.checkSysUserRoleExists(sysUserRoleQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 用户拥有的角色关系表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户拥有的角色关系表 对象", notes = "添加 用户拥有的角色关系表")
    public ApiResult<String> addSysUserRole(@Valid @RequestBody SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception {
        Object id = sysUserRoleService.addSysUserRole(sysUserRoleQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户拥有的角色关系表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 用户拥有的角色关系表 对象", notes = "修改 用户拥有的角色关系表")
    public ApiResult<Boolean> updateSysUserRole(@Valid @RequestBody SysUserRoleQueryVo sysUserRoleQueryVo) throws Exception {
        boolean flag = sysUserRoleService.updateSysUserRole(sysUserRoleQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户拥有的角色关系表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 用户拥有的角色关系表 对象", notes = "删除 用户拥有的角色关系表")
    public ApiResult<Boolean> deleteSysUserRole(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysUserRoleService.deleteSysUserRole(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户拥有的角色关系表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户拥有的角色关系表 对象详情", notes = "获取 用户拥有的角色关系表 对象详情")
    public ApiResult<SysUserRoleQueryVo> getSysUserRole(@PathVariable("id") String id) throws Exception {
         SysUserRoleQueryVo sysUserRoleQueryVo = sysUserRoleService.getSysUserRoleById(id);
        return ApiResult.ok(sysUserRoleQueryVo);
    }

    /**
     * 获取 用户拥有的角色关系表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户拥有的角色关系表 分页列表", notes = "获取 用户拥有的角色关系表 分页列表")
    public ApiResult<Paging<SysUserRoleQueryVo>> getSysUserRolePageList(@Valid @RequestBody SysUserRolePageQueryParam sysUserRolePageQueryParam) throws Exception {
         Paging<SysUserRoleQueryVo> paging = sysUserRoleService.getSysUserRolePageList(sysUserRolePageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 用户拥有的角色关系表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户拥有的角色关系表 列表", notes = "获取 用户拥有的角色关系表 列表")
    public ApiResult<List<SysUserRoleQueryVo>> getSysUserRoleList(@Valid @RequestBody SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
         List<SysUserRoleQueryVo> paging = sysUserRoleService.getSysUserRoleList(sysUserRoleQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 用户拥有的角色关系表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户拥有的角色关系表 总记录数", notes = "计算 用户拥有的角色关系表 总记录数")
    public ApiResult<Integer> countSysUserRole(@Valid @RequestBody SysUserRoleQueryParam sysUserRoleQueryParam) throws Exception {
        int count = sysUserRoleService.countSysUserRole(sysUserRoleQueryParam);
        return ApiResult.ok(count);
    }

}