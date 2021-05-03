package org.tiankafei.zuul.fallback;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.web.domain.ApiResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 网关异常回调，返回统一格式
 *
 * @author 甜咖啡
 */
@Component
public class ExceptionFallBack implements FallbackProvider {

    @Override
    public String getRoute() {
        // 对所有服务生效
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                // 返回通用的结构
                ApiResult apiResult = ApiResult.fail();
                return new ByteArrayInputStream(JSONObject.toJSONBytes(apiResult));
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return "message is exception";
            }

            @Override
            public void close() {

            }
        };
    }

}
