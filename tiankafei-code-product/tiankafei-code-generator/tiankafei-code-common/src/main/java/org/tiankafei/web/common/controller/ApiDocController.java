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
    public String docs() {
        return "redirect:/swagger-ui.html";
    }

    /**
     * swaggerUI
     */
    @GetMapping("/doc")
    public String doc() {
        return "redirect:/doc.html";
    }

}
