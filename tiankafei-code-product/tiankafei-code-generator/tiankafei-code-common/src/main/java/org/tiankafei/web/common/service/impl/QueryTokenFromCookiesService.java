package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CommonEnum;
import org.tiankafei.web.common.enums.TokenEnum;
import org.tiankafei.web.common.service.QueryTokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class QueryTokenFromCookiesService implements QueryTokenService {

    @Override
    public String getToken() {
        HttpServletRequest request = getRequest();
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (CommonEnum.TOKEN_PARAM.getCode().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    @Override
    public Integer getType() {
        return TokenEnum.COOKIES.getCode();
    }

}
