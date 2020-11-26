package org.tiankafei.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.enums.ExceptionEnum;
import org.tiankafei.zuul.utils.ZuulUtil;

/**
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

    /**
     * 1.从请求参数中拿到用户id
     * 2.根据用户id去缓存中获取用户信息
     * 3.如果为空，则返回失败的数据
     * 4.如果不为空，则继续下一个过滤
     *
     * @return
     */
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
            ZuulUtil.returnValue(requestContext, error, httpProperties.getEncoding().getCharset());
        }
        return null;
    }

}