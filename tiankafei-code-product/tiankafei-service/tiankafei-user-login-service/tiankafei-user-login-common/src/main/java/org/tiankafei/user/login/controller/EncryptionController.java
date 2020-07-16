package org.tiankafei.user.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.service.EncryptionService;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "加密和摘要算法 API", tags = "加密和摘要算法 API")
public class EncryptionController {

    @Resource
    private EncryptionService encryptionService;

    /**
     * 生成验证码
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public ApiResult<String> createCaptcha(@RequestParam(value = "str") String str) throws Exception {
        String encryption = encryptionService.encryption(str);
        return ApiResult.ok(encryption);
    }

}
