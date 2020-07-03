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

    /**
     * 需要鉴权的url路径
     */
    protected String path;

    @Autowired
    protected ExclusionsUrlsProperties exclusionsUrlsProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String pathInfo = request.getPathInfo();
        this.path = pathInfo;

        return checkShouldFilter();
    }

    /**
     * 验证是否需要走过滤器
     *
     * @return
     */
    protected boolean checkShouldFilter(){
        List<String> urls = exclusionsUrlsProperties.getUrls();
        boolean flag = CommonUtil.checkUrlStartsWith(urls, path);
        if(flag){
            log.info("不需要过滤的url：{}", path);
        }
        return !flag;
    }

}
