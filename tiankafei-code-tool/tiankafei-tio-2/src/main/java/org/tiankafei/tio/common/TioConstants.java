package org.tiankafei.tio.common;

import org.tiankafei.common.util.SystemUtil;

/**
 * @author 甜咖啡
 */
public class TioConstants {

    /**
     * 服务器心跳超时时间
     */
    public static final int SERVER_TIMEOUT = 0;

    /**
     * 客户端心跳超时时间
     */
    public static final int CLIENT_TIMEOUT = 0;

    /**
     * 默认服务器ip
     */
    public static final String DEFAULT_SERVER = SystemUtil.getIp();

    /**
     * 默认监听端口
     */
    public static final int DEFAULT_PORT = 6789;

    /**
     * 默认分组名称
     */
    public static final String DEFAULT_GROUP_NAME = "tiankafei";

    /**
     * 测试端口数组
     */
    public static final Integer[] TEST_PORT_ARRAY = new Integer[]{6791, 6792, 6793, 6794};

    /**
     * 消息包头长度
     */
    public static final int PACKET_HEADER_LENGHT = 4;

    /**
     * 消息包字符编码
     */
    public static final String PACKET_CHARSET = "utf-8";

}
