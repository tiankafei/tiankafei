package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysUserInfoService;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.service.UserService;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
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
 * 用户基本信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysUserInfo")
@Api(value = "用户基本信息表 API", tags = "用户基本信息表 功能维护")
public class SysUserInfoController extends BaseController {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Autowired
    private UserService userService;

    /**
     * 校验 用户名 是否已经存在
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    public ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception {
        Boolean flag = userService.checkUsernameExists(username);
        return ApiResult.ok(flag);
    }

    /**
     * 校验  邮箱 是否已经存在
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    public ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception {
        Boolean flag = userService.checkEmailExists(email);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 手机号码 是否已经存在
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    public ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception {
        Boolean flag = userService.checkTelephoneExists(telephone);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 用户基本信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户基本信息表 是否已经存在", notes = "校验 用户基本信息表 是否已经存在")
    public ApiResult<Boolean> checkSysUserInfoExists(@Valid @RequestBody SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        Boolean flag = sysUserInfoService.checkSysUserInfoExists(sysUserInfoQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 用户基本信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户基本信息表 对象", notes = "添加 用户基本信息表")
    public ApiResult<String> addSysUserInfo(@Valid @RequestBody SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        Object id = sysUserInfoService.addSysUserInfo(sysUserInfoQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户基本信息表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 用户基本信息表 对象", notes = "修改 用户基本信息表")
    public ApiResult<Boolean> updateSysUserInfo(@Valid @RequestBody SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception {
        boolean flag = sysUserInfoService.updateSysUserInfo(sysUserInfoQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户基本信息表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 用户基本信息表 对象", notes = "删除 用户基本信息表")
    public ApiResult<Boolean> deleteSysUserInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysUserInfoService.deleteSysUserInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户基本信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户基本信息表 对象详情", notes = "获取 用户基本信息表 对象详情")
    public ApiResult<SysUserInfoQueryVo> getSysUserInfo(@PathVariable("id") String id) throws Exception {
         SysUserInfoQueryVo sysUserInfoQueryVo = sysUserInfoService.getSysUserInfoById(id);
        return ApiResult.ok(sysUserInfoQueryVo);
    }

    /**
     * 获取 用户基本信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户基本信息表 分页列表", notes = "获取 用户基本信息表 分页列表")
    public ApiResult<Paging<SysUserInfoQueryVo>> getSysUserInfoPageList(@Valid @RequestBody SysUserInfoPageQueryParam sysUserInfoPageQueryParam) throws Exception {
         Paging<SysUserInfoQueryVo> paging = sysUserInfoService.getSysUserInfoPageList(sysUserInfoPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 用户基本信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户基本信息表 列表", notes = "获取 用户基本信息表 列表")
    public ApiResult<List<SysUserInfoQueryVo>> getSysUserInfoList(@Valid @RequestBody SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
         List<SysUserInfoQueryVo> paging = sysUserInfoService.getSysUserInfoList(sysUserInfoQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 用户基本信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户基本信息表 总记录数", notes = "计算 用户基本信息表 总记录数")
    public ApiResult<Integer> countSysUserInfo(@Valid @RequestBody SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception {
        int count = sysUserInfoService.countSysUserInfo(sysUserInfoQueryParam);
        return ApiResult.ok(count);
    }

}