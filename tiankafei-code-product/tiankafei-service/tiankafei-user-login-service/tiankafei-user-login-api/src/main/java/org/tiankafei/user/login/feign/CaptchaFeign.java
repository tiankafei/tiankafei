package org.tiankafei.user.login.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.CaptchaParamVo;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-login-service", contextId = "captcha")
public interface CaptchaFeign {

    /**
     * 生成验证码
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public ApiResult<CaptchaParamVo> createCaptcha(@RequestParam(value = "uuid", required = false) String uuid) throws Exception ;

}
