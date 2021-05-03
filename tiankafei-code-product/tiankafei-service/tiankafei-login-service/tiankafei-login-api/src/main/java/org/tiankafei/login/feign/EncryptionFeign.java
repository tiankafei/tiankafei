package org.tiankafei.login.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.core.web.domain.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@FeignClient(value = "login-service", contextId = "encryption")
public interface EncryptionFeign {

    /**
     * 加密
     *
     * @param str
     * @return
     * @throws Exception
     */
    @GetMapping("/encryption")
    @ApiOperation(value = "加密", notes = "加密")
    ApiResult<String> encryption(@RequestParam(value = "str") String str) throws Exception;

    /**
     * 生成token
     *
     * @param str
     * @return
     * @throws Exception
     */
    @GetMapping("/token")
    @ApiOperation(value = "生成token", notes = "生成token")
    ApiResult<String> token(@RequestParam(value = "str") String str) throws Exception;

}
