package org.tiankafei.user.feign;

import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class LoginCustomError implements LoginCustomFeign {
    @Override
    public ApiResult<String> login(@Valid LoginParamVo loginParamVo) throws Exception {
        return ApiResult.ok("熔断了11111111111111111");
    }

    @Override
    public ApiResult<Boolean> logout(String userId) throws Exception {
        return ApiResult.ok(false);
    }
}
