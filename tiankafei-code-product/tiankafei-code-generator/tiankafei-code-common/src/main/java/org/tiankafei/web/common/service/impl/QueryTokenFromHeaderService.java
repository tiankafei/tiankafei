package org.tiankafei.web.common.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CommonEnum;
import org.tiankafei.web.common.enums.TokenEnum;
import org.tiankafei.web.common.service.QueryTokenService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class QueryTokenFromHeaderService implements QueryTokenService {

    @Override
    public String getToken() {
        HttpServletRequest request = getRequest();
        String token = request.getHeader(CommonEnum.TOKEN_PARAM.getCode());
        return token;
    }

    @Override
    public Integer getType() {
        return TokenEnum.HEADER.getCode();
    }

}
