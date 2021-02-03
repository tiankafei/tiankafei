package org.tiankafei.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.login.service.EncryptionService;
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
     * 加密
     *
     * @param str
     * @return
     * @throws Exception
     */
    @GetMapping("/encryption")
    @ApiOperation(value = "加密", notes = "加密")
    public ApiResult<String> encryption(@RequestParam(value = "str") String str) throws Exception {
        String encryption = encryptionService.encryption(str);
        return ApiResult.ok(encryption);
    }

    /**
     * 生成token
     *
     * @param str
     * @return
     * @throws Exception
     */
    @GetMapping("/token")
    @ApiOperation(value = "生成token", notes = "生成token")
    public ApiResult<String> token(@RequestParam(value = "str") String str) throws Exception {
        String encryption = encryptionService.token(str);
        return ApiResult.ok(encryption);
    }

}
