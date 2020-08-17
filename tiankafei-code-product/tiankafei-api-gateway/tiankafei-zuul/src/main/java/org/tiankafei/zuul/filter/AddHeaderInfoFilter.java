package org.tiankafei.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.constants.GatewayConstants;
import org.tiankafei.web.common.utils.SequenceUtil;

import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Component
public class AddHeaderInfoFilter extends BaseZuulFilter {

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public Object execFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        String value = SequenceUtil.generatorStrId();
        log.info("执行了添加header信息的过滤器：添加的header值为：{}", value);
        response.setHeader(GatewayConstants.ADD_HREADER_PARAM_NAME, value);

        return null;
    }
}
