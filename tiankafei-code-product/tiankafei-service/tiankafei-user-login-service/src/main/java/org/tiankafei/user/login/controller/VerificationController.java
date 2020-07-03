package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.service.VerificationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "验证码 API", tags = "验证码")
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    /**
     * 验证码
     */
    @GetMapping("/verificationCode")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public void verificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

        verificationService.verificationCode(request, response);
    }

}
