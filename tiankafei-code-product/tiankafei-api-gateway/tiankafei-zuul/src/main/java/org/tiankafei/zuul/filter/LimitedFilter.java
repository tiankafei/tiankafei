package org.tiankafei.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.ruoyi.common.core.enums.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.zuul.utils.ZuulUtil;

/**
 * 限流过滤器
 *
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class LimitedFilter extends BaseZuulFilter {

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public Object execFilter() {
        boolean flag = RandomUtils.nextBoolean();
        if (flag) {
            // 通过
            log.info("正在执行限流，限流通过的url：{}", currentPath);
        } else {
            RequestContext requestContext = RequestContext.getCurrentContext();
            ZuulUtil.setFilterFail(requestContext);
            // 不失败
            log.error("正在执行限流，限流没有通过的url：{}", currentPath);
            //返回错误提示内容
            ApiResult error = ApiResult.error(ExceptionEnum.LOGIN_LIMITED_EXCEPTION);
            ZuulUtil.returnValue(requestContext, error, serverProperties.getServlet().getEncoding().getCharset());
        }
        return null;
    }

}