package org.tiankafei.web.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.tiankafei.web.common.constants.StringConstants;

/**
 * @author tiankafei
 * @since 1.0
 **/
public final class IpUtil {
    private IpUtil() {
        throw new AssertionError();
    }

    /**
     * 获取请求用户的IP地址
     *
     * @return
     */
    public static String getRequestIp() {
        ServletRequestAttributes attributes = HttpServletUtil.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return getRequestIp(request);
    }

    /**
     * 获取请求用户的IP地址
     *
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || StringConstants.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || StringConstants.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || StringConstants.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (StringConstants.MAC_ADDRESS.equals(ip)) {
            ip = getLocalhostIp();
        }
        return ip;
    }

    public static String getLocalhostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        return null;
    }

}
