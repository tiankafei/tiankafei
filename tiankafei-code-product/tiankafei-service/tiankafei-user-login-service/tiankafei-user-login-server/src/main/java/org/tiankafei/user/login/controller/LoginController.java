package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.service.LoginService;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import javax.validation.Valid;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "用户登录相关 API", tags = "用户登录相关接口")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ApiResult<String> login(@Valid @RequestBody LoginParamVo loginParamVo) throws Exception {
        String token = loginService.login(loginParamVo);
        return ApiResult.ok(token);
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
