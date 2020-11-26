package org.tiankafei.zuul.utils;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.MediaType;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.GatewayConstants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author tiankafei
 */
public class ZuulUtil {

    private ZuulUtil(){}

    /**
     * 验证是否需要执行后面的过滤器
     *
     * @param currentContext
     * @return
     */
    public static boolean checkIsExecuteFilter(RequestContext currentContext) {
        boolean flag = Boolean.TRUE;
        Object object = currentContext.get(GatewayConstants.FILTER_FLAG);
        if (object instanceof Boolean) {
            flag = Boolean.valueOf(object.toString());
        }
        return flag;
    }

    public static void setFilterFail(RequestContext currentContext) {
        currentContext.set(GatewayConstants.FILTER_FLAG, false);
    }

    /**
     * 返回值
     *
     * @param currentContext
     * @param apiResult
     */
    public static void returnValue(RequestContext currentContext, ApiResult apiResult) {
        returnValue(currentContext, apiResult, getDefaultCharset());
    }

    /**
     * 返回值
     *
     * @param currentContext
     * @param apiResult
     */
    public static void returnValue(RequestContext currentContext, ApiResult apiResult, Charset charset) {
        String contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + getDefaultCharset();
        if (charset != null) {
            contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + charset;
        }
        // 设置为false，用接口将访问不到结果
        currentContext.setSendZuulResponse(true);
        currentContext.getResponse().setContentType(contentType);
        currentContext.setResponseBody(JSON.toJSONString(apiResult));
        currentContext.setResponseStatusCode(apiResult.getStatus());
    }

    private static Charset getDefaultCharset() {
        return StandardCharsets.UTF_8;
    }

}
