package org.tiankafei.web.common.utils;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import org.tiankafei.web.common.vo.ClientInfo;
import org.tiankafei.web.common.vo.DeviceInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ClientInfoUtil {

    private static Pattern deviceInfo1Pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?Build/(\\S*?)[;)]");

    private static Pattern deviceInfo2Pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?\\)");

    /**
     * 获取用户客户端信息
     *
     * @param request
     * @return
     */
    public static ClientInfo get(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return get(userAgent);
    }

    /**
     * 获取用户客户端信息
     *
     * @param userAgentString
     * @return
     */
    public static ClientInfo get(String userAgentString) {
        ClientInfo clientInfo = new ClientInfo();

        UserAgent userAgent = UserAgentUtil.parse(userAgentString);

        // 浏览器名称
        clientInfo.setBrowserName(userAgent.getBrowser().getName());
        // 浏览器版本
        clientInfo.setBrowserversion(userAgent.getVersion());
        // 浏览器引擎名称
        clientInfo.setEngineName(userAgent.getEngine().getName());
        // 浏览器引擎版本
        clientInfo.setEngineVersion(userAgent.getEngineVersion());
        // 用户操作系统名称
        clientInfo.setOsName(userAgent.getOs().getName());
        // 用户操作平台名称
        clientInfo.setPlatformName(userAgent.getPlatform().getName());
        // 是否是手机
        clientInfo.setMobile(userAgent.isMobile());

        // 获取移动设备名称和机型
        DeviceInfo deviceInfo = getDeviceInfo(userAgentString);
        // 设置移动设备名称和机型
        clientInfo.setDeviceName(deviceInfo.getName());
        clientInfo.setDeviceModel(deviceInfo.getModel());

        // ip
        clientInfo.setIp(IpUtil.getRequestIp());

        return clientInfo;
    }

    /**
     * 获取移动端用户设备的名称和机型
     *
     * @param userAgentString
     * @return
     */
    public static DeviceInfo getDeviceInfo(String userAgentString) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            Matcher matcher = deviceInfo1Pattern.matcher(userAgentString);
            String model = null;
            String name = null;

            if (matcher.find()) {
                model = matcher.group(1);
                name = matcher.group(2);
            }

            if (model == null && name == null) {
                matcher = deviceInfo2Pattern.matcher(userAgentString);
                if (matcher.find()) {
                    model = matcher.group(1);
                }
            }

            deviceInfo.setName(name);
            deviceInfo.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceInfo;
    }
}
