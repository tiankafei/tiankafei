package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.LoginService;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import javax.validation.Valid;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/sysUserLogin")
@Api(value = "登录相关 API", tags = "登录")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     */
    @GetMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ApiResult<Boolean> login(@Valid @RequestBody LoginQueryVo loginQueryVo) throws Exception {
        loginService.login(loginQueryVo);
        return ApiResult.ok(true);
    }

    /**
     * 用户注销
     */
    @GetMapping("/logout/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ApiResult<Boolean> logout(@PathVariable String userId) throws Exception {
        loginService.logout(userId);
        return ApiResult.ok(true);
    }

}
