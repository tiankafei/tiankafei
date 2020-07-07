package org.tiankafei.user.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.user.service.QueryUserAndCheckExistsService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.component.ApplicationContextHelper;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.UserException;

import java.util.Map;
import java.util.Set;

@Component
public class QueryUserAndCheckExistsClient implements InitializingBean {

    private Map<Integer, QueryUserAndCheckExistsService> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryUserAndCheckExistsService> beansOfType = applicationContextHelper.getBeansOfType(QueryUserAndCheckExistsService.class);
        Set<Map.Entry<String, QueryUserAndCheckExistsService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, QueryUserAndCheckExistsService> entry : entries) {
            QueryUserAndCheckExistsService userExistsService = entry.getValue();
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
    public Boolean checkAddSysUserExists(int userFlag, String keywords) throws UserException {
        return userExistsServiceMap.get(userFlag).checkAddSysUserExists(keywords);
    }

    /**
     * 编辑时验证系统用户是否存在
     *
     * @param userFlag
     * @param keywords
     * @return
     */
    public Boolean checkUpdateSysUserExists(int userFlag, String keywords, String oldKeywords) throws UserException {
        return userExistsServiceMap.get(userFlag).checkUpdateSysUserExists(keywords, oldKeywords);
    }

    /**
     * 登录时验证系统用户是否存在
     *
     * @param userFlag
     * @param keywords
     * @return
     */
    public Boolean checkLoginSysUserExists(int userFlag, String keywords) throws LoginException {
        return userExistsServiceMap.get(userFlag).checkLoginSysUserExists(keywords);
    }

    /**
     * 获取登录对象
     * @param userFlag
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    public SysUserLoginQueryVo getSysUserLoginQueryVo(int userFlag, String keywords, String password) throws LoginException {
        return userExistsServiceMap.get(userFlag).getSysUserLoginQueryVo(keywords, password);
    }

}
