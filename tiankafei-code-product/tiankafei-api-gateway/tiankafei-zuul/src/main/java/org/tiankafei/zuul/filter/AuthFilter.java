package org.tiankafei.zuul.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.utils.CommonUtil;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public Object run() throws ZuulException {

        return null;
    }

    @Override
    protected boolean checkShouldFilter() {
        List<String> authUrls = exclusionsUrlsProperties.getAuthUrls();
        boolean flag = CommonUtil.checkUrlStartsWith(authUrls, path);

        if(flag){
            log.info("不需要鉴权的url：{}", path);
        }else{
            log.info("需要鉴权的url：{}", path);
        }

        return !flag;
    }
}
