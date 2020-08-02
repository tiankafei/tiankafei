package org.tiankafei.web.common.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class ClientInfo implements Serializable {

    /**
     * ip
     */
    private String ip;

    /**
     * ip对应的地址
     */
    private String addree;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 浏览器版本
     */
    private String browserversion;

    /**
     * 浏览器引擎名称
     */
    private String engineName;

    /**
     * 浏览器引擎版本
     */
    private String engineVersion;

    /**
     * 系统名称
     */
    private String osName;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 是否是手机
     */
    private boolean mobile;

    /**
     * 移动端设备型号
     */
    private String deviceName;

    /**
     * 移动端设备型号
     */
    private String deviceModel;

}
