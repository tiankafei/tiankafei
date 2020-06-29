package org.tiankafei.web.common.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.enums.ExceptionEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 非法参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResult handleMethodArgumentException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> list = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            list.add(fieldError.getDefaultMessage());
        }
        Collections.sort(list);
        log.error("field Errors: {}", JSON.toJSONString(list));
        return ApiResult.fail(ExceptionEnum.REQUEST_PARAM_EXCEPTION, list);
    }

    /**
     * 数据库的异常处理
     *
     * @param daoException
     * @return
     */
    @ExceptionHandler(value = DaoException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exception(DaoException daoException) {
        log.error("exception:", daoException);
        return ApiResult.error(ExceptionEnum.DAO_EXCEPTION);
    }

    /**
     * 默认的异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exception(Exception exception) {
        log.error("exception:", exception);
        return ApiResult.error(ExceptionEnum.EXCEPTION);
    }

}
