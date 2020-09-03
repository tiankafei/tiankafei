package org.tiankafei.web.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取路径工具类
 *
 * @author tiankafei
 */
public class WebFilePathUtil {

    private WebFilePathUtil() {

    }

    /**
     * 获取工程根路径
     *
     * @param request request请求对象
     * @return 工程根路径
     */
    public static String getProjectRootFilePath(HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/");
        return filePath;
    }

    /**
     * 获取工程根路径
     *
     * @param request   request请求对象
     * @param directory 工作目录路径
     * @return 工程根路径
     */
    public static String getProjectRootFilePath(HttpServletRequest request, String directory) {
        String filePath = request.getSession().getServletContext().getRealPath(directory);
        return filePath;
    }

}
