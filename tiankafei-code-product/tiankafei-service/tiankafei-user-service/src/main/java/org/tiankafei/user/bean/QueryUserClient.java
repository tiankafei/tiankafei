package org.tiankafei.user.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.user.service.QueryUserService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.component.ApplicationContextHelper;
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
     * 登录时验证系统用户是否存在
     *
     * @param userFlag
     * @param keywords
     * @return
     */
    public Boolean checkUserExists(int userFlag, String keywords) throws LoginException {
        return userExistsServiceMap.get(userFlag).checkUserExists(keywords);
    }

    /**
     * 获取登录对象
     * @param userFlag
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    public SysUserLoginQueryVo login(int userFlag, String keywords, String password) throws LoginException {
        return userExistsServiceMap.get(userFlag).login(keywords, password);
    }

}
