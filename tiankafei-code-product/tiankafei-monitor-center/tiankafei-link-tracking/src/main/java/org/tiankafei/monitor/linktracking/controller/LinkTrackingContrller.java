package org.tiankafei.monitor.linktracking.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.login.feign.LoginFeign;
import org.tiankafei.user.param.LoginParamVo;

/**
 * @author tiankafei
 * @since 1.0
 */
@RestController
public class LinkTrackingContrller {

    @Autowired
    private LoginFeign loginFeign;

    @GetMapping("/get1")
    public String get1() throws Exception {
        LoginParamVo loginParamVo = new LoginParamVo();
        loginParamVo.setKeywords("tiankafei").setPassword("tiankafei").setUuid(IdUtil.simpleUUID()).setVerificationCode("abcd");
        String data = loginFeign.login(loginParamVo).getData();
        return data;
    }

}
