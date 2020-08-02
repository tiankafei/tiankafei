package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
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
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.service.UserLoginService;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

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
public class UserLoginController extends BaseController {

    @Autowired
    private UserLoginService userLoginService;

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
     * 添加 用户登录信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户登录信息表 对象", notes = "添加 用户登录信息表")
    public ApiResult<String> addSysUserLogin(@Valid @RequestBody UserLoginVo userLoginVo) throws Exception {
        Object id = userLoginService.addSysUserLogin(userLoginVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户登录信息表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 用户登录信息表 对象", notes = "修改 用户登录信息表")
    public ApiResult<Boolean> updateSysUserLogin(@Valid @RequestBody UserLoginVo userLoginVo) throws Exception {
        boolean flag = userLoginService.updateSysUserLogin(userLoginVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户登录信息表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 用户登录信息表 对象", notes = "删除 用户登录信息表")
    public ApiResult<Boolean> deleteSysUserLogin(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = userLoginService.deleteSysUserLogin(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户登录信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户登录信息表 对象详情", notes = "获取 用户登录信息表 对象详情")
    public ApiResult<UserLoginVo> getSysUserLogin(@PathVariable("id") String id) throws Exception {
        UserLoginVo userLoginVo = userLoginService.getSysUserLoginById(id);
        return ApiResult.ok(userLoginVo);
    }

    /**
     * 获取 用户登录信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户登录信息表 分页列表", notes = "获取 用户登录信息表 分页列表")
    public ApiResult<Paging<UserLoginVo>> getSysUserLoginPageList(@Valid @RequestBody UserLoginPageParam userLoginPageParam) throws Exception {
        Paging<UserLoginVo> paging = userLoginService.getSysUserLoginPageList(userLoginPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 用户登录信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户登录信息表 列表", notes = "获取 用户登录信息表 列表")
    public ApiResult<List<UserLoginVo>> getSysUserLoginList(@Valid @RequestBody UserLoginListParam userLoginListParam) throws Exception {
        List<UserLoginVo> paging = userLoginService.getSysUserLoginList(userLoginListParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 用户登录信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户登录信息表 总记录数", notes = "计算 用户登录信息表 总记录数")
    public ApiResult<Integer> countSysUserLogin(@Valid @RequestBody UserLoginListParam userLoginListParam) throws Exception {
        int count = userLoginService.countSysUserLogin(userLoginListParam);
        return ApiResult.ok(count);
    }

}