package org.tiankafei.user.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.user.service.CheckExistService;
import org.tiankafei.web.common.bean.ApplicationContextHelper;
import org.tiankafei.web.common.exception.UserException;

import java.util.Map;
import java.util.Set;

@Component
public class CheckExistsClient implements InitializingBean {

    private Map<Integer, CheckExistService> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CheckExistService> beansOfType = applicationContextHelper.getBeansOfType(CheckExistService.class);
        Set<Map.Entry<String, CheckExistService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, CheckExistService> entry : entries) {
            CheckExistService userExistsService = entry.getValue();
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

}