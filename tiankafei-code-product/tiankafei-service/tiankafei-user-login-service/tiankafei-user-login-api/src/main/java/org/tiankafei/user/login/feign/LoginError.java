package org.tiankafei.user.login.feign;

import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class LoginError implements LoginFeign {
    @Override
    public ApiResult<String> login(@Valid LoginParamVo loginParamVo) throws Exception {
        return ApiResult.ok("熔断了");
    }

    @Override
    public ApiResult<Boolean> logout(String userId) throws Exception {
        return ApiResult.ok(false);
    }
}
