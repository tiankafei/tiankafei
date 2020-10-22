package org.tiankafei.web.common.utils;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class CommonUtil {

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
        boolean flag = false;

        if (CollectionUtils.isNotEmpty(urls)) {
            for (int index = 0, length = urls.size(); index < length; index++) {
                String url = urls.get(index);
                if (path.startsWith(url)) {
                    flag = true;
                }
            }
        }

        return flag;
    }

}
