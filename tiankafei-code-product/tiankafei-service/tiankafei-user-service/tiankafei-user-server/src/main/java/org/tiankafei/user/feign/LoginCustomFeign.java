package org.tiankafei.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.tiankafei.user.login.feign.LoginFeign;

/**
 * @author 魏双双
 * @since 1.0
 **/
@FeignClient(value = "user-login-service", contextId = "loginCustomFeign", fallback = LoginCustomError.class)
public interface LoginCustomFeign extends LoginFeign {
}
