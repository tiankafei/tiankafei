package org.tiankafei.user.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.service.GetLoginService;
import org.tiankafei.web.common.component.ApplicationContextHelper;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @Author 魏双双
 * @Date 2020/7/6
 * @Version V1.0
 **/
@Component
public class LoginClient implements InitializingBean {

    private Map<Integer, GetLoginService> loginServiceMap = Maps.newConcurrentMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, GetLoginService> beansOfType = applicationContextHelper.getBeansOfType(GetLoginService.class);
        Set<Map.Entry<String, GetLoginService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, GetLoginService> entry : entries) {
            GetLoginService loginService = entry.getValue();
            loginServiceMap.put(loginService.getLoginType().getCode(), loginService);
        }
    }

    /**
     * 获取用户对象
     *
     * @param loginType
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    public SysUserLoginEntity login(Integer loginType, String keywords, String password) throws LoginException {
        return loginServiceMap.get(loginType).getLoginEntity(keywords, password);
    }

    /**
     * 登录时验证用户是否存在
     *
     * @param loginType
     * @param keywords
     * @return
     * @throws LoginException
     */
    public Boolean userExists(Integer loginType, String keywords) throws LoginException {
        return loginServiceMap.get(loginType).checkSysUserExists(keywords);
    }

}
