package org.tiankafei.user.login.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;

import javax.validation.Valid;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-login-service", contextId = "login")
public interface LoginFeign {

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ApiResult<String> login(@Valid @RequestBody LoginParamVo loginParamVo) throws Exception;

    /**
     * 用户注销
     */
    @GetMapping("/logout/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ApiResult<Boolean> logout(@PathVariable String userId) throws Exception;

}
