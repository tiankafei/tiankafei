package org.tiankafei.web.common.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.component.ApplicationContextHelper;
import org.tiankafei.web.common.service.QueryTokenService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class QueryTokenClient implements InitializingBean {

    private Map<Integer, QueryTokenService> tokenServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryTokenService> beansOfType = applicationContextHelper.getBeansOfType(QueryTokenService.class);
        Set<Map.Entry<String, QueryTokenService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, QueryTokenService> entry : entries) {
            QueryTokenService queryTokenService = entry.getValue();
            tokenServiceMap.put(queryTokenService.getType(), queryTokenService);
        }
    }

    /**
     * 获取token
     * @param type
     * @return
     */
    public String getToken(Integer type){
        return tokenServiceMap.get(type).getToken();
    }

}