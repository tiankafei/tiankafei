package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.web.common.param.CaptchaParamVo;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "验证码 API", tags = "验证码 API")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    /**
     * 生成验证码
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public ApiResult<CaptchaParamVo> createCaptcha(@RequestParam(value = "uuid", required = false) String uuid) throws Exception {
        CaptchaParamVo captchaParamVo = captchaService.createCaptcha(uuid);
        return ApiResult.ok(captchaParamVo);
    }

}
