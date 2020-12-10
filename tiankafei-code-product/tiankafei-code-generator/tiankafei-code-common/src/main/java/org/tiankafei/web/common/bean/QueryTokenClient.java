package org.tiankafei.web.common.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.service.QueryTokenService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class QueryTokenClient implements InitializingBean {

    private Map<Integer, QueryTokenService> tokenServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, QueryTokenService> beansOfType = applicationContext.getBeansOfType(QueryTokenService.class);
        Set<Map.Entry<String, QueryTokenService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, QueryTokenService> entry : entries) {
            QueryTokenService queryTokenService = entry.getValue();
            tokenServiceMap.put(queryTokenService.getType(), queryTokenService);
        }
    }

    /**
     * 获取token
     *
     * @param type
     * @return
     */
    public String getToken(Integer type) {
        String token = tokenServiceMap.get(type).getToken();
        if (StringUtils.isBlank(token)) {
            throw new ValidationException("token参数为空，请确认！");
        }
        return token;
    }

}
