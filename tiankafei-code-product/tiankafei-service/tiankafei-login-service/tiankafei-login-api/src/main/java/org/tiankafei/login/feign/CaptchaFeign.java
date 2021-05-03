package org.tiankafei.login.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.web.common.param.CaptchaParamVo;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "login-service", contextId = "captchaFeign")
public interface CaptchaFeign {

    /**
     * 生成验证码
     *
     * @param uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    ApiResult<CaptchaParamVo> createCaptcha(@RequestParam(value = "uuid", required = false) String uuid) throws Exception;

}
