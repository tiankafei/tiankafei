package org.tiankafei.zuul.utils;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.MediaType;
import org.tiankafei.web.common.api.ApiResult;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author tiankafei
 */
public abstract class ZuulUtil {

    /**
     * 返回值
     * @param apiResult
     */
    public static void returnValue(ApiResult apiResult){
        returnValue(apiResult, getDefaultCharset());
    }

    /**
     * 返回值
     * @param apiResult
     */
    public static void returnValue(ApiResult apiResult, Charset charset){
        RequestContext currentContext = RequestContext.getCurrentContext();
        returnValue(currentContext, apiResult, charset);
    }

    /**
     * 返回值
     * @param currentContext
     * @param apiResult
     */
    public static void returnValue(RequestContext currentContext, ApiResult apiResult){
        returnValue(currentContext, apiResult, getDefaultCharset());
    }

    /**
     * 返回值
     * @param currentContext
     * @param apiResult
     */
    public static void returnValue(RequestContext currentContext, ApiResult apiResult, Charset charset){
        //false  不会继续往下执行 不会调用服务接口了 网关直接响应给客户了
        currentContext.setSendZuulResponse(false);

        String contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + getDefaultCharset();
        if(charset != null){
            contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + charset;
        }
        currentContext.getResponse().setContentType(contentType);
        currentContext.setResponseBody(JSON.toJSONString(apiResult));
        currentContext.setResponseStatusCode(apiResult.getStatus());
    }

    private static Charset getDefaultCharset(){
        return StandardCharsets.UTF_8;
    }

}
