package org.tiankafei.web.common.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CommonEnum;
import org.tiankafei.web.common.enums.TokenEnum;
import org.tiankafei.web.common.service.QueryTokenService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Service
public class QueryTokenFromSessionService implements QueryTokenService {

    @Override
    public String getToken() {
        HttpServletRequest request = getRequest();
        Object token = request.getSession().getAttribute(CommonEnum.TOKEN_PARAM.getCode());
        if(token != null){
            return token.toString();
        }
        return null;
    }

    @Override
    public Integer getType() {
        return TokenEnum.SESSION.getCode();
    }

}
