package org.tiankafei.web.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.tiankafei.web.common.bean.QueryTokenClient;
import org.tiankafei.web.common.enums.TokenEnum;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Configuration
public class TokenConfig {

    @Autowired
    protected QueryTokenClient queryTokenClient;

    @Value("${tokenType}")
    private Integer tokenType;

    /**
     * 获取token
     * @return
     */
    public String getToken(){
        if(tokenType == null || tokenType == 0){
            // 默认从header中获取
            tokenType = TokenEnum.HEADER.getCode();
        }
        return queryTokenClient.getToken(tokenType);
    }

}
