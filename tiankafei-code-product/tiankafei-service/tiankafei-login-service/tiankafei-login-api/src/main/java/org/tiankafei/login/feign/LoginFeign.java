package org.tiankafei.login.feign;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.vo.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "login-service", contextId = "loginFeign", fallbackFactory = LoginError.class)
public interface LoginFeign {

    /**
     * 用户登录
     *
     * @param loginParamVo
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    ApiResult<String> login(@Valid @RequestBody LoginParamVo loginParamVo) throws Exception;

    /**
     * 用户注销
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @GetMapping("/logout/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    ApiResult<Boolean> logout(@PathVariable String userId) throws Exception;

}
