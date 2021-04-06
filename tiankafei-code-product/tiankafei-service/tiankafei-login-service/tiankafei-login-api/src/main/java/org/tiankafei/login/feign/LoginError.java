package org.tiankafei.login.feign;

import feign.hystrix.FallbackFactory;
import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.tiankafei.user.vo.LoginParamVo;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class LoginError implements FallbackFactory<LoginFeign> {

    @Override
    public LoginFeign create(Throwable throwable) {
        return new LoginFeign() {
            @Override
            public ApiResult<String> login(@Valid LoginParamVo loginParamVo) throws Exception {
                return ApiResult.ok("熔断了");
            }

            @Override
            public ApiResult<Boolean> logout(String userId) throws Exception {
                return ApiResult.ok(false);
            }
        };
    }
}
