package org.tiankafei.login.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.tiankafei.login.service.QueryUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
@Component
public class QueryUserClient implements InitializingBean {

    private Map<Integer, QueryUserService> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryUserService> beansOfType = applicationContext.getBeansOfType(QueryUserService.class);
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
