package org.tiankafei.base.common.declared;

/**
 * @Author tiankafei
 * @Date 2020/3/17
 * @Version V1.0
 **/
public class UserController extends BaseController {

    @Autowired
    private UserService usService;

    private UserService userService;

    public UserService service;

    public UserService getUsService() {
        return usService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserService getService() {
        return service;
    }
}
