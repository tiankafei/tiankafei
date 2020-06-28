package org.tiankafei.base.base.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

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
        PrintWriter printWriter = null;
        try {
            StringWriter stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            throwable.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}
