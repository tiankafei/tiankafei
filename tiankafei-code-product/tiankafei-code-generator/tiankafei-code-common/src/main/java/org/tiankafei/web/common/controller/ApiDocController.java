package org.tiankafei.web.common.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiankafei.web.common.api.ApiResult;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Controller
@ApiIgnore
public class ApiDocController extends BaseController {

    /**
     * api文档错误提示
     *
     * @return
     */
    @GetMapping("/apiDocError")
    @ResponseBody
    public ApiResult apiDocError() {
        return ApiResult.error("只有 swagger.enable 设置为true的时候，才提供api文档支持");
    }

}
