package org.tiankafei.login.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.login.service.QueryUserService;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.bean.ApplicationContextHelper;
import org.tiankafei.web.common.exception.LoginException;

import java.util.Map;
import java.util.Set;

@Component
public class QueryUserClient implements InitializingBean {

    private Map<Integer, QueryUserService> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryUserService> beansOfType = applicationContextHelper.getBeansOfType(QueryUserService.class);
        Set<Map.Entry<String, QueryUserService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, QueryUserService> entry : entries) {
            QueryUserService queryUserService = entry.getValue();
            userExistsServiceMap.put(queryUserService.getUserFlag(), queryUserService);
        }
    }

    /**
     * 获取登录对象
     *
     * @param userFlag
     * @param keywords
     * @return
     * @throws LoginException
     */
    public UserLoginVo login(int userFlag, String keywords) throws LoginException {
        // 登录时，先加密然后从数据库取数
        return userExistsServiceMap.get(userFlag).login(keywords);
    }

}
