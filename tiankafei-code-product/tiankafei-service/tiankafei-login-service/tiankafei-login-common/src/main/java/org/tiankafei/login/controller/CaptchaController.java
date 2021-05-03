package org.tiankafei.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.login.service.CaptchaService;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.web.common.param.CaptchaParamVo;

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
     *
     * @param uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public ApiResult<CaptchaParamVo> createCaptcha(@RequestParam(value = "uuid", required = false) String uuid) throws Exception {
        CaptchaParamVo captchaParamVo = captchaService.createCaptcha(uuid);
        return ApiResult.ok(captchaParamVo);
    }

}
