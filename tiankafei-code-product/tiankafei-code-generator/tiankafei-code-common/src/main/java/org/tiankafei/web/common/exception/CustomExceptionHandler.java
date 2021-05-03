package org.tiankafei.web.common.exception;

import com.ruoyi.common.core.enums.ApiStatusEnum;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.security.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends GlobalExceptionHandler {

    /**
     * 验证码异常处理
     *
     * @param verificationException
     * @return
     */
    @ExceptionHandler(value = VerificationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exception(VerificationException verificationException) {
        log.error("exception:", verificationException);
        return ApiResult.fail(ApiStatusEnum.FAIL, verificationException.getMessage());
    }

    /**
     * 登录异常处理
     *
     * @param loginException
     * @return
     */
    @ExceptionHandler(value = LoginException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exception(LoginException loginException) {
        log.error("exception:", loginException);
        return ApiResult.fail(ApiStatusEnum.FAIL, loginException.getMessage());
    }

    /**
     * 用户的异常处理
     *
     * @param userException
     * @return
     */
    @ExceptionHandler(value = UserException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exception(UserException userException) {
        log.error("exception:", userException);
        return ApiResult.fail(ApiStatusEnum.FAIL, userException.getMessage());
    }

}
