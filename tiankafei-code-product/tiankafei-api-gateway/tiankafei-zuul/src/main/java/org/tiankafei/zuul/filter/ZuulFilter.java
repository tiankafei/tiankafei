package org.tiankafei.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.tiankafei.web.common.utils.CommonUtil;
import org.tiankafei.zuul.properties.ExclusionsUrlsProperties;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * zuul pre filter base class, other filter extend this, if have special logic, need Rewrite {@link org.tiankafei.zuul.filter.ZuulFilter#shouldFilter} method,
 * for example:
 *      {@link org.tiankafei.zuul.filter}
 *
 *      if fail, need return value :
 *             //返回错误提示内容
 *             RequestContext currentContext = RequestContext.getCurrentContext();
 *             ApiResult error = ApiResult.error(ExceptionEnum.LOGIN_AUTHENTICATION_EXCEPTION);
 *
 *             //false  不会继续往下执行 不会调用服务接口了 网关直接响应给客户了
 *             currentContext.setSendZuulResponse(false);
 *             currentContext.setResponseBody(JSON.toJSONString(error));
 *             currentContext.setResponseStatusCode(Integer.valueOf(error.getStatus()));
 *             return null;
 *
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class ZuulFilter extends com.netflix.zuul.ZuulFilter {

    @Autowired
    protected ExclusionsUrlsProperties exclusionsUrlsProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        List<String> urls = exclusionsUrlsProperties.getUrls();

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String path = request.getServletPath();

        boolean flag = CommonUtil.checkUrlStartsWith(urls, path);
        if(flag){
            // 其他filter继承这个filter，如果没有特殊要求，则走父类这个方法，能够保证，全局都不需要过滤的url
            //
            log.info("不需要过滤的url：{}", path);
            return false;
        }

        return true;
    }

}
