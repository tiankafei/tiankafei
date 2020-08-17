package org.tiankafei.web.common.utils;

import com.alibaba.fastjson.JSON;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HttpServletUtil {

    private static String UTF8 = "UTF-8";
    private static String CONTENT_TYPE = "application/json";

    private HttpServletUtil() {
        throw new AssertionError();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes;
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = getRequestAttributes().getRequest();
        return request;
    }

    public static void printJson(HttpServletResponse response, Object object) throws Exception {
        response.setCharacterEncoding(UTF8);
        response.setContentType(CONTENT_TYPE);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSON.toJSONString(object));
        printWriter.flush();
        printWriter.close();
    }

}
