package org.tiankafei.common.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * 异常处理工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ExceptionUtil {

    /**
     * 获取异常的堆栈信息
     *
     * @param throwable 接收到的异常对象
     * @return 异常的堆栈信息
     */
    public static String getStackTrace(Throwable throwable) {
        return ExceptionUtils.getStackTrace(throwable);
    }

}
