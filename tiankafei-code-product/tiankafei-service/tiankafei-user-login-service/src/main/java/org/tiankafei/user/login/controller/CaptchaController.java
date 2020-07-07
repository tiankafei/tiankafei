package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.service.CaptchaService;

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
    public void createCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        captchaService.createCaptcha(request, response);
        String captcha = (String) request.getSession().getAttribute("happy-captcha");
        log.info("生成的验证码：{}", captcha);
    }

}
