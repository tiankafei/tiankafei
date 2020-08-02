package org.tiankafei.user.controller;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.feign.LoginCustomFeign;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.user.properties.UserProperties;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "用户登录相关 API", tags = "用户登录相关接口")
@RefreshScope
public class LoginController extends BaseController {

    @Resource
    private LoginCustomFeign loginFeign;

    @Autowired
    private UserProperties userProperties;

    @GetMapping("get1")
    public UserProperties get1() {
        return userProperties;
    }

    /**
     * 用户登录
     */
    @GetMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ApiResult<String> login() throws Exception {
        LoginParamVo loginParamVo = new LoginParamVo();
        loginParamVo.setKeywords("tiankafei").setPassword("tiankafei").setUuid(IdUtil.simpleUUID()).setVerificationCode("123");
        String data = loginFeign.login(loginParamVo).getData();
        return ApiResult.ok(data);
    }

    /**
     * 用户注销
     */
    @GetMapping("/logout/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ApiResult<Boolean> logout(@PathVariable String userId) throws Exception {
        Boolean flag = loginFeign.logout(userId).getData();
        return ApiResult.ok(flag);
    }

}
