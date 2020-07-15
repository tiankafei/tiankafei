package org.tiankafei.web.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.bean.QueryTokenClient;
import org.tiankafei.web.common.enums.TokenEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
@ConfigurationProperties(prefix = "tiankafei")
public class TokenConfig {

    @Autowired
    protected QueryTokenClient queryTokenClient;

    private Integer tokenType;

    /**
     * 获取token
     *
     * @return
     */
    public String getToken() {
        if (tokenType == null || tokenType == 0) {
            // 默认从header中获取
            tokenType = TokenEnum.HEADER.getCode();
        }
        return queryTokenClient.getToken(tokenType);
    }

}
