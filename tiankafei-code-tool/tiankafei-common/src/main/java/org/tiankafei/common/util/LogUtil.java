package org.tiankafei.common.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Slf4j
public class LogUtil {

    /**
     * 打印调试信息
     *
     * @param message 调试信息
     */
    public static void debug(String message) {
        log.debug(message);
    }

    /**
     * 打印错误信息(程序仍能运行)
     *
     * @param message 错误信息
     */
    public static void error(String message) {
        log.error(message);
    }

    /**
     * 打印输出信息
     *
     * @param message 输出的信息
     */
    public static void info(String message) {
        log.info(message);
    }

    /**
     * 打印严重错误信息，程序终止运行
     *
     * @param message 严重的错误信息
     */
    public static void warn(String message) {
        log.warn(message);
    }

}
