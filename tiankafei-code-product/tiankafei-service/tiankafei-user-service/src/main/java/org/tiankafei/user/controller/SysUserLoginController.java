package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.tiankafei.web.common.vo.Paging;
import org.tiankafei.web.common.param.IdsParam;

import java.util.List;

/**
 * <pre>
 * 用户登录信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Slf4j
@RestController
@RequestMapping("/tkfUserLogin")
@Api(value = "用户登录信息表 API", tags = "用户登录信息表 功能维护")
public class SysUserLoginController extends BaseController {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    /**
     * 校验 用户名 是否已经存在
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    public ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception {
        Boolean flag = sysUserLoginService.checkUsernameExists(username);
        return ApiResult.ok(flag);
    }

    /**
     * 校验  邮箱 是否已经存在
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    public ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception {
        Boolean flag = sysUserLoginService.checkEmailExists(email);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 手机号码 是否已经存在
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    public ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception {
        Boolean flag = sysUserLoginService.checkTelephoneExists(telephone);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 用户登录信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户登录信息表 是否已经存在", notes = "校验 用户登录信息表 是否已经存在")
    public ApiResult<Boolean> checkTkfUserLoginExists(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        Boolean flag = sysUserLoginService.checkTkfUserLoginExists(sysUserLoginQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 用户登录信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户登录信息表 对象", notes = "添加 用户登录信息表")
    public ApiResult<String> addTkfUserLogin(@Valid @RequestBody SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        Object id = sysUserLoginService.saveTkfUserLogin(sysUserLoginQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户登录信息表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 用户登录信息表 对象", notes = "修改 用户登录信息表")
    public ApiResult<Boolean> updateTkfUserLogin(@Valid @RequestBody SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        boolean flag = sysUserLoginService.updateTkfUserLogin(sysUserLoginQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户登录信息表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 用户登录信息表 对象", notes = "删除 用户登录信息表")
    public ApiResult<Boolean> deleteTkfUserLogin(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysUserLoginService.deleteTkfUserLogin(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户登录信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户登录信息表 对象详情", notes = "获取 用户登录信息表 对象详情")
    public ApiResult<SysUserLoginQueryVo> getTkfUserLogin(@PathVariable("id") String id) throws Exception {
         SysUserLoginQueryVo sysUserLoginQueryVo = sysUserLoginService.getTkfUserLoginById(id);
        return ApiResult.ok(sysUserLoginQueryVo);
    }

    /**
     * 获取 用户登录信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户登录信息表 分页列表", notes = "获取 用户登录信息表 分页列表")
    public ApiResult<Paging<SysUserLoginQueryVo>> getTkfUserLoginPageList(@Valid @RequestBody SysUserLoginPageQueryParam sysUserLoginPageQueryParam) throws Exception {
         Paging<SysUserLoginQueryVo> paging = sysUserLoginService.getTkfUserLoginPageList(sysUserLoginPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 用户登录信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户登录信息表 列表", notes = "获取 用户登录信息表 列表")
    public ApiResult<List<SysUserLoginQueryVo>> getTkfUserLoginList(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
         List<SysUserLoginQueryVo> paging = sysUserLoginService.getTkfUserLoginList(sysUserLoginQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 用户登录信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户登录信息表 总记录数", notes = "计算 用户登录信息表 总记录数")
    public ApiResult<Integer> countTkfUserLogin(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        int count = sysUserLoginService.countTkfUserLogin(sysUserLoginQueryParam);
        return ApiResult.ok(count);
    }

}