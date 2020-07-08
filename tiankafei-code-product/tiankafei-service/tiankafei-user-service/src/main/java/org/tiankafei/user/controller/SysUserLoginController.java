package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.bean.CheckExistsClient;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

import javax.validation.Valid;
import java.util.List;

/**
 * <pre>
 * 用户登录信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysUserLogin")
@Api(value = "用户登录信息表 API", tags = "用户登录信息表 功能维护")
public class SysUserLoginController extends BaseController {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @Autowired
    private CheckExistsClient checkExistsClient;

    /**
     * 校验 用户名 是否已经存在
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    public ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception {
        Boolean flag = checkExistsClient.checkAddSysUserExists(UserEnums.USER_NAME.getCode(), username);
        return ApiResult.ok(flag);
    }

    /**
     * 校验  邮箱 是否已经存在
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    public ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception {
        Boolean flag = checkExistsClient.checkAddSysUserExists(UserEnums.EMAIL.getCode(), email);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 手机号码 是否已经存在
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    public ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception {
        Boolean flag = checkExistsClient.checkAddSysUserExists(UserEnums.PHONE.getCode(), telephone);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 用户登录信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户登录信息表 是否已经存在", notes = "校验 用户登录信息表 是否已经存在")
    public ApiResult<Boolean> checkSysUserLoginExists(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        Boolean flag = sysUserLoginService.checkSysUserLoginExists(sysUserLoginQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 用户登录信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户登录信息表 对象", notes = "添加 用户登录信息表")
    public ApiResult<String> addSysUserLogin(@Valid @RequestBody SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        sysUserLoginQueryVo.setId(null);
        Object id = sysUserLoginService.addSysUserLogin(sysUserLoginQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户登录信息表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 用户登录信息表 对象", notes = "修改 用户登录信息表")
    public ApiResult<Boolean> updateSysUserLogin(@Valid @RequestBody SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception {
        boolean flag = sysUserLoginService.updateSysUserLogin(sysUserLoginQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户登录信息表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 用户登录信息表 对象", notes = "删除 用户登录信息表")
    public ApiResult<Boolean> deleteSysUserLogin(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysUserLoginService.deleteSysUserLogin(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户登录信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户登录信息表 对象详情", notes = "获取 用户登录信息表 对象详情")
    public ApiResult<SysUserLoginQueryVo> getSysUserLogin(@PathVariable("id") String id) throws Exception {
        SysUserLoginQueryVo sysUserLoginQueryVo = sysUserLoginService.getSysUserLoginById(id);
        return ApiResult.ok(sysUserLoginQueryVo);
    }

    /**
     * 获取 用户登录信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户登录信息表 分页列表", notes = "获取 用户登录信息表 分页列表")
    public ApiResult<Paging<SysUserLoginQueryVo>> getSysUserLoginPageList(@Valid @RequestBody SysUserLoginPageQueryParam sysUserLoginPageQueryParam) throws Exception {
        Paging<SysUserLoginQueryVo> paging = sysUserLoginService.getSysUserLoginPageList(sysUserLoginPageQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 用户登录信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户登录信息表 列表", notes = "获取 用户登录信息表 列表")
    public ApiResult<List<SysUserLoginQueryVo>> getSysUserLoginList(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        List<SysUserLoginQueryVo> paging = sysUserLoginService.getSysUserLoginList(sysUserLoginQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 用户登录信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户登录信息表 总记录数", notes = "计算 用户登录信息表 总记录数")
    public ApiResult<Integer> countSysUserLogin(@Valid @RequestBody SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception {
        int count = sysUserLoginService.countSysUserLogin(sysUserLoginQueryParam);
        return ApiResult.ok(count);
    }

}