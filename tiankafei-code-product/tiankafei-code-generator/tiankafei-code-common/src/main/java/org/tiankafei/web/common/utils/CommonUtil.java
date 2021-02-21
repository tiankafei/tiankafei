package org.tiankafei.web.common.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class CommonUtil {

    /**
     * ant风格路径匹配对象
     */
    private static PathMatcher pathMatcher = new AntPathMatcher();

    private CommonUtil() {
    }

    /**
     * 验证该path是否已制定的url开始
     *
     * @param urls
     * @param path
     * @return
     */
    public static boolean checkUrlStartsWith(List<String> urls, String path) {
        if (CollectionUtils.isNotEmpty(urls)) {
            for (int index = 0, length = urls.size(); index < length; index++) {
                String url = urls.get(index);
                if (pathMatcher.match(url, path)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

}
