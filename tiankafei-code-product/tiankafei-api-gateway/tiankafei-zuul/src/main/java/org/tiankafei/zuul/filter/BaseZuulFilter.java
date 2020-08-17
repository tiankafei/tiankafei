package org.tiankafei.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.tiankafei.web.common.utils.CommonUtil;
import org.tiankafei.zuul.properties.ExclusionsUrlsProperties;
import org.tiankafei.zuul.utils.ZuulUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * zuul pre filter base class, other filter extend this, if have special logic, need Rewrite {@link BaseZuulFilter#shouldFilter} method,
 * for example:
 * {@link org.tiankafei.zuul.filter}
 *
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class BaseZuulFilter extends ZuulFilter {

    @Autowired
    protected ExclusionsUrlsProperties exclusionsUrlsProperties;

    @Autowired
    protected HttpProperties httpProperties;

    protected RequestContext currentContext;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     * 当前url路径
     */
    protected String currentPath;

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
        this.currentPath = path;

        boolean flag = CommonUtil.checkUrlStartsWith(urls, path);
        if (flag) {
            // 其他filter继承这个filter，如果没有特殊要求，则走父类这个方法，能够保证，全局都不需要过滤的url
            //
            log.info("不需要过滤的url：{}", path);
            return false;
        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        this.currentContext = RequestContext.getCurrentContext();
        this.request = currentContext.getRequest();
        this.response = currentContext.getResponse();
        boolean executeFilterFlag = ZuulUtil.checkIsExecuteFilter(request);
        if (!executeFilterFlag) {
            return null;
        }
        Object object = execFilter();

        return null;
    }

    /**
     * 执行过滤器
     * @return
     */
    public abstract Object execFilter();

}
