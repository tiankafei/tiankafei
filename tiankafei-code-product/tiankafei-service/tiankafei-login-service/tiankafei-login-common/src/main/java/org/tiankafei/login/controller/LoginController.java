package org.tiankafei.login.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.login.model.LoginResultDto;
import org.tiankafei.login.service.LoginService;
import org.tiankafei.user.vo.LoginParamVo;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.config.TokenConfig;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@RestController
@Api(value = "用户登录相关 API", tags = "用户登录相关接口")
public class LoginController extends BaseController {

    @Resource
    private LoginService loginService;

    @Autowired
    private TokenConfig tokenConfig;

    /**
     * 用户登录
     *
     * @param loginParamVo
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ApiResult<LoginResultDto> login(@Valid @RequestBody LoginParamVo loginParamVo) throws Exception {
        LoginResultDto loginResultDto = loginService.login(loginParamVo);
        return ApiResult.ok(loginResultDto);
    }

    /**
     * 获取用户详细信息，以及角色和权限
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取用户详细信息，以及角色和权限", notes = "获取用户详细信息，以及角色和权限")
    public ApiResult<UserInfoVo> getUserInfo() throws Exception {
        UserInfoVo userInfoVo = loginService.getUserInfo(tokenConfig.getToken());
        return ApiResult.ok(userInfoVo);
    }

    /**
     * 用户注销
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @GetMapping("/logout/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ApiResult<Boolean> logout(@PathVariable String userId) throws Exception {
        loginService.logout(userId);
        return ApiResult.ok(true);
    }

}
