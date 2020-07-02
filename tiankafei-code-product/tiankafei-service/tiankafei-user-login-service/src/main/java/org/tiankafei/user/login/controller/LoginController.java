package org.tiankafei.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.service.LoginService;
import org.tiankafei.web.common.controller.BaseController;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RestController
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

}
