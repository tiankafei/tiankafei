package org.tiankafei.user.login.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@FeignClient(value = "login-service", contextId = "encryption")
public interface EncryptionFeign {

    /**
     * 生成验证码
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public ApiResult<String> createCaptcha(@RequestParam(value = "str") String str) throws Exception ;

}
