package org.tiankafei.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.exception.ZuulException;
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
public class LimitedFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    /**
     *  1.从请求参数中拿到用户id
     *  2.根据用户id去缓存中获取用户信息
     *  3.如果为空，则返回失败的数据
     *  4.如果不为空，则继续下一个过滤
     *
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        //TODO 基于zuul的限流在这里执行，限流成功返回true，失败返回false
//        boolean flag = Boolean.TRUE;
        boolean flag = RandomUtils.nextBoolean();
        if(flag){
            // 通过
            log.info("正在执行限流，限流通过的url：{}", currentPath);
        }else{
            // 不失败
            log.error("正在执行限流，限流没有通过的url：{}", currentPath);
            //返回错误提示内容
            ApiResult error = ApiResult.error(ExceptionEnum.LOGIN_LIMITED_EXCEPTION);
            ZuulUtil.returnValue(error, httpProperties.getEncoding().getCharset());

//            // 之所以要抛异常，是为了阻止执行下一个filter
//            throw new ZuulException(JSON.toJSONString(error), error.getStatus(), error.getMessage());
        }
        return null;
    }

}