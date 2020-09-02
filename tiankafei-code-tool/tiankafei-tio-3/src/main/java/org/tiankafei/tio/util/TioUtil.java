package org.tiankafei.tio.util;

import org.tio.core.Node;

/**
 * @author 甜咖啡
 */
public class TioUtil {

    public static String getUserId(Node node) {
        return getUserId(node.getIp(), node.getPort());
    }

    public static String getUserId(String ip, int port) {
        return ip + "@" + port;
    }

}
