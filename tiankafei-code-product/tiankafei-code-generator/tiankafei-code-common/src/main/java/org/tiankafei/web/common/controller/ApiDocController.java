package org.tiankafei.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.CommonConstant;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Controller
@ApiIgnore
public class ApiDocController extends BaseController {

    /**
     * swaggerUI
     */
    @GetMapping("/docs")
    public String docs() {
        return "redirect:/swagger-ui.html";
    }

    /**
     * Knife4j API 文档
     */
    @GetMapping("/doc")
    public String doc() {
        return "redirect:/doc.html";
    }

    /**
     * api文档错误提示
     * @return
     */
    @GetMapping("/apiDocError")
    @ResponseBody
    public ApiResult apiDocError(){
        return ApiResult.error("只有在开发模式[" + CommonConstant.ACTIVE_PROFILE_DEV + "]才提供api文档支持");
    }

}
