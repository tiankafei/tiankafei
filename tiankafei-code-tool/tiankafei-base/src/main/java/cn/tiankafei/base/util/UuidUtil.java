package cn.tiankafei.base.util;

import java.util.UUID;

/**
 * uuid生成工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class UuidUtil {

    private UuidUtil() {

    }

    /**
     * 获取随机数的字符串
     *
     * @return 返回最终需要的字符串
     */
    public static String getUuid() {
        return getUuid(32);
    }

    /**
     * 获取随机数的字符串
     *
     * @param number 获取随机数字符串的位数
     * @return 返回最终需要的字符串
     */
    public static String getUuid(int number) {
        int count = 32;
        if (number > count) {
            number = count;
        }
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, number);
    }

    /**
     * 获取随机数的字符串
     *
     * @return 返回最终需要的字符串
     */
    public static String getStandardUuid() {
        return getStandardUuid(36);
    }

    /**
     * 获取随机数的字符串
     *
     * @param number 获取随机数字符串的位数
     * @return 返回最终需要的字符串
     */
    public static String getStandardUuid(int number) {
        int count = 36;
        if (number > count) {
            number = count;
        }
        return UUID.randomUUID().toString().substring(0, number);
    }


}
