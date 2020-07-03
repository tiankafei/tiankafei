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
            log.info("不需要过滤的url：{}", path);
            return false;
        }

        return true;
    }

}
