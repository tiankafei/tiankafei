package org.tiankafei.web.common.service.impl;

import java.util.Enumeration;
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
public class QueryTokenFromRequestParamService implements QueryTokenService {

    @Override
    public String getToken() {
        HttpServletRequest request = getRequest();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (CommonEnum.TOKEN_PARAM.getCode().equals(paramName)) {
                return request.getParameter(paramName);
            }
        }
        return null;
    }

    @Override
    public Integer getType() {
        return TokenEnum.REQUEST_PARAM.getCode();
    }

}
