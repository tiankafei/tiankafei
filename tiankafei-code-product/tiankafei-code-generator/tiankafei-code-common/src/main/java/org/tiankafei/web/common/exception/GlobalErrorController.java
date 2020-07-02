package org.tiankafei.web.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.enums.ExceptionEnum;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 * @since 1.0
 **/
@ApiIgnore
@RestController
@Slf4j
public class GlobalErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ApiResult handleError(HttpServletRequest request, HttpServletResponse response){
        int status = response.getStatus();
        switch (status){
            case HttpServletResponse.SC_NOT_FOUND:
                return ApiResult.error(ExceptionEnum.NOT_FOUND.getMessage());
            default:
                break;
        }
        return ApiResult.fail();
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
