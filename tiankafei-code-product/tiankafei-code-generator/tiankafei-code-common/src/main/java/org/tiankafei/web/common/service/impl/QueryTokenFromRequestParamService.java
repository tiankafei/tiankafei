package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.TokenEnum;
import org.tiankafei.web.common.service.QueryTokenService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Service
public class QueryTokenFromRequestParamService implements QueryTokenService {

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public Integer getType() {
        return TokenEnum.REQUEST_PARAM.getCode();
    }

}
