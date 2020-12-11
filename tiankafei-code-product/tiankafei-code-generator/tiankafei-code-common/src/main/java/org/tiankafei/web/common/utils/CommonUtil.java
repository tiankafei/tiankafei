package org.tiankafei.web.common.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.regex.Pattern;

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
        if (CollectionUtils.isNotEmpty(urls)) {
            for (int index = 0, length = urls.size(); index < length; index++) {
                String url = urls.get(index);
                String regPath = getRegPath(url);
                if (filterUrls(regPath, path)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 通配符模式
     *
     * @param excludePath - 不过滤地址
     * @param reqUrl      - 请求地址
     * @return
     */
    private static boolean filterUrls(String excludePath, String reqUrl) {
        String regPath = getRegPath(excludePath);
        return Pattern.compile(regPath).matcher(reqUrl).matches();
    }

    /**
     * 将通配符表达式转化为正则表达式
     *
     * @param path
     * @return
     */
    private static String getRegPath(String path) {
        char[] chars = path.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        boolean preX = false;
        for (int i = 0; i < len; i++) {
            // 遇到*字符
            if (chars[i] == '*') {
                // 如果是第二次遇到*，则将**替换成.*
                if (preX) {
                    sb.append(".*");
                    preX = false;
                }
                // 如果是遇到单星，且单星是最后一个字符，则直接将*转成[^/]*
                else if (i + 1 == len) {
                    sb.append("[^/]*");
                }
                // 否则单星后面还有字符，则不做任何动作，下一把再做动作
                else {
                    preX = true;
                    continue;
                }
            }
            // 遇到非*字符
            else {
                // 如果上一把是*，则先把上一把的*对应的[^/]*添进来
                if (preX) {
                    sb.append("[^/]*");
                    preX = false;
                }
                // 接着判断当前字符是不是?，是的话替换成.
                if (chars[i] == '?') {
                    sb.append('.');
                }
                // 不是?的话，则就是普通字符，直接添进来
                else {
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

}
