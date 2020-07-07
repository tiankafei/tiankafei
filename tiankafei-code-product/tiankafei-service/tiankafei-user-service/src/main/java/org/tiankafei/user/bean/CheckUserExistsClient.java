package org.tiankafei.user.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.user.service.QueryUserExistsService;
import org.tiankafei.web.common.component.ApplicationContextHelper;
import org.tiankafei.web.common.exception.UserException;

import java.util.Map;
import java.util.Set;

@Component
public class CheckUserExistsClient implements InitializingBean {

    private Map<Integer, QueryUserExistsService> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryUserExistsService> beansOfType = applicationContextHelper.getBeansOfType(QueryUserExistsService.class);
        Set<Map.Entry<String, QueryUserExistsService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, QueryUserExistsService> entry : entries) {
            QueryUserExistsService userExistsService = entry.getValue();
            userExistsServiceMap.put(userExistsService.getUserFlag(), userExistsService);
        }
    }

    /**
     * 新增时验证系统用户是否存在
     *
     * @param userFlag
     * @param keywords
     * @return
     */
    public Boolean checkSysUserExists(int userFlag, String keywords) throws UserException {
        return userExistsServiceMap.get(userFlag).checkSysUserExists(keywords);
    }

    /**
     * 编辑时验证系统用户是否存在
     *
     * @param userFlag
     * @param keywords
     * @return
     */
    public Boolean checkSysUserExists(int userFlag, String keywords, String oldKeywords) throws UserException {
        return userExistsServiceMap.get(userFlag).checkSysUserExists(keywords, oldKeywords);
    }

}
