package org.tiankafei.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.tiankafei.login.feign.LoginFeign;

/**
 * @author 魏双双
 * @since 1.0
 **/
@FeignClient(value = "login-service", contextId = "loginCustomFeign", fallbackFactory = LoginCustomError.class)
public interface LoginCustomFeign extends LoginFeign {
}
