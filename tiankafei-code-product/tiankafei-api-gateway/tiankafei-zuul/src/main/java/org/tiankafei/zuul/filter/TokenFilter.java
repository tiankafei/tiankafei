package org.tiankafei.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.ruoyi.common.core.constant.GatewayConstants;
import com.ruoyi.common.core.enums.ExceptionEnum;
import com.ruoyi.common.core.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.zuul.utils.ZuulUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 针对已经登录的url处理是否携带了token标识
 *
 * @author tiankafei
 */
@Slf4j
@Component
public class TokenFilter extends BaseZuulFilter {

    @Override
    public Object execFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 从请求参数中获取
        String token = request.getParameter(GatewayConstants.TOKEN_PARAM_NAME);
        if (StringUtils.isEmpty(token)) {
            // 从Cookie中获取
            token = CookieUtils.getCookieValue(request, GatewayConstants.TOKEN_PARAM_NAME);
            if (StringUtils.isEmpty(token)) {
                // 从header中获取
                token = request.getHeader(GatewayConstants.TOKEN_PARAM_NAME);
            }
        }
        if (StringUtils.isEmpty(token)) {
            // 返回错误提示内容
            ZuulUtil.setFilterFail(requestContext);
            ApiResult error = ApiResult.error(ExceptionEnum.LOGIN_TOKEN_EXCEPTION);
            log.info("{}, 请求的url为：{}", error.getMsg(), currentPath);
            ZuulUtil.returnValue(requestContext, error, serverProperties.getServlet().getEncoding().getCharset());
        }

        return null;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }
}
