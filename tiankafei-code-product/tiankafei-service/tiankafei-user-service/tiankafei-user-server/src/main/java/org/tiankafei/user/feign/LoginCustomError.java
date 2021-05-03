package org.tiankafei.user.feign;

import feign.hystrix.FallbackFactory;
import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.tiankafei.user.vo.LoginParamVo;
import com.ruoyi.common.core.web.domain.ApiResult;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class LoginCustomError implements FallbackFactory<LoginCustomFeign> {

    @Override
    public LoginCustomFeign create(Throwable throwable) {
        return new LoginCustomFeign() {
            @Override
            public ApiResult<String> login(@Valid LoginParamVo loginParamVo) throws Exception {
                return ApiResult.ok("熔断了11111111111111111");
            }

            @Override
            public ApiResult<Boolean> logout(String userId) throws Exception {
                return ApiResult.ok(false);
            }
        };
    }
}
