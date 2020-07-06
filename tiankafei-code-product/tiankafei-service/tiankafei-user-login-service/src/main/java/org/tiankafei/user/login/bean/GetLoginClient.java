package org.tiankafei.user.login.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @Author 魏双双
 * @Date 2020/7/6
 * @Version V1.0
 **/
@Component
public class GetLoginClient implements InitializingBean {

    private Map<Integer, GetLoginService> loginServiceMap = Maps.newConcurrentMap();

    @Override
    public void afterPropertiesSet() throws Exception {
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        Map<String, GetLoginService> beansOfType = applicationContext.getBeansOfType(GetLoginService.class);
        Set<Map.Entry<String, GetLoginService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, GetLoginService> entry : entries) {
            GetLoginService loginService = entry.getValue();
            loginServiceMap.put(loginService.getLoginType().getCode(), loginService);
        }
    }

    /**
     * 执行处理逻辑
     * @param loginType
     * @param loginQueryVo
     * @return
     * @throws LoginException
     */
    public LoginEntity doHandler(Integer loginType, LoginQueryVo loginQueryVo) throws LoginException {
        LoginEntity loginEntity = loginServiceMap.get(loginType).getLoginEntity(loginQueryVo);
        return loginEntity;
    }

}
