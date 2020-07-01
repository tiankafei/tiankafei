package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysRoleFeatureService;
import org.tiankafei.user.param.SysRoleFeatureQueryParam;
import org.tiankafei.user.param.SysRoleFeaturePageQueryParam;
import org.tiankafei.user.vo.SysRoleFeatureQueryVo;
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
 * 系统角色对应的功能配置表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysRoleFeature")
@Api(value = "系统角色对应的功能配置表 API", tags = "系统角色对应的功能配置表 功能维护")
public class SysRoleFeatureController extends BaseController {

    @Autowired
    private SysRoleFeatureService sysRoleFeatureService;

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统角色对应的功能配置表 是否已经存在", notes = "校验 系统角色对应的功能配置表 是否已经存在")
    public ApiResult<Boolean> checkSysRoleFeatureExists(@Valid @RequestBody SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        Boolean flag = sysRoleFeatureService.checkSysRoleFeatureExists(sysRoleFeatureQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统角色对应的功能配置表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统角色对应的功能配置表 对象", notes = "添加 系统角色对应的功能配置表")
    public ApiResult<String> addSysRoleFeature(@Valid @RequestBody SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception {
        Object id = sysRoleFeatureService.saveSysRoleFeature(sysRoleFeatureQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统角色对应的功能配置表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统角色对应的功能配置表 对象", notes = "修改 系统角色对应的功能配置表")
    public ApiResult<Boolean> updateSysRoleFeature(@Valid @RequestBody SysRoleFeatureQueryVo sysRoleFeatureQueryVo) throws Exception {
        boolean flag = sysRoleFeatureService.updateSysRoleFeature(sysRoleFeatureQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统角色对应的功能配置表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统角色对应的功能配置表 对象", notes = "删除 系统角色对应的功能配置表")
    public ApiResult<Boolean> deleteSysRoleFeature(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysRoleFeatureService.deleteSysRoleFeature(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统角色对应的功能配置表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统角色对应的功能配置表 对象详情", notes = "获取 系统角色对应的功能配置表 对象详情")
    public ApiResult<SysRoleFeatureQueryVo> getSysRoleFeature(@PathVariable("id") String id) throws Exception {
         SysRoleFeatureQueryVo sysRoleFeatureQueryVo = sysRoleFeatureService.getSysRoleFeatureById(id);
        return ApiResult.ok(sysRoleFeatureQueryVo);
    }

    /**
     * 获取 系统角色对应的功能配置表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统角色对应的功能配置表 分页列表", notes = "获取 系统角色对应的功能配置表 分页列表")
    public ApiResult<Paging<SysRoleFeatureQueryVo>> getSysRoleFeaturePageList(@Valid @RequestBody SysRoleFeaturePageQueryParam sysRoleFeaturePageQueryParam) throws Exception {
         Paging<SysRoleFeatureQueryVo> paging = sysRoleFeatureService.getSysRoleFeaturePageList(sysRoleFeaturePageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统角色对应的功能配置表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统角色对应的功能配置表 列表", notes = "获取 系统角色对应的功能配置表 列表")
    public ApiResult<List<SysRoleFeatureQueryVo>> getSysRoleFeatureList(@Valid @RequestBody SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
         List<SysRoleFeatureQueryVo> paging = sysRoleFeatureService.getSysRoleFeatureList(sysRoleFeatureQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统角色对应的功能配置表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统角色对应的功能配置表 总记录数", notes = "计算 系统角色对应的功能配置表 总记录数")
    public ApiResult<Integer> countSysRoleFeature(@Valid @RequestBody SysRoleFeatureQueryParam sysRoleFeatureQueryParam) throws Exception {
        int count = sysRoleFeatureService.countSysRoleFeature(sysRoleFeatureQueryParam);
        return ApiResult.ok(count);
    }

}