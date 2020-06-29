package org.tiankafei.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String swaggerUI() {
        return "redirect:/swagger-ui.html";
    }

}
