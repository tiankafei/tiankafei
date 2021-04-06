package org.tiankafei.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * 校验工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ValidatorUtil {

    /**
     * @Description: 全部为数字的校验
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkAllNumberRegEx(Object value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        return value.toString().matches("^[\\+\\-]?(0|[1-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
    }

    /**
     * @Description: 验证特殊字符
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkSpecialStringRegEx(String value) {
        String regEx = "[^`~!@#$%^&*()_+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]{1,}";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 全部为中文的验证
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkAllChineseRegEx(String value) {
        String regEx = "^[\u4e00-\u9fa5]+$";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 部分中文的验证
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkPartChineseRegEx(String value) {
        String regEx = "[\u4e00-\u9fa5]+";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 验证手机号码是否合法
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkMobilePhoneRegEx(String value) {
        String regEx = "[1][3,5,7,8][0-9]{9}$";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 验证固定电话是否合法
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkTelephoneRegEx(String value) {
        String regEx = "[0]{1}[0-9]{2,3}-[0-9]{5,10}$";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 验证电子邮件是否合法
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkEmailRegEx(String value) {
        String regEx = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*${5,100}";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 验证QQ是否合法
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkQqRegEx(String value) {
        String regEx = "[1-9]{1}[0-9]{4,11}$";
        return checkRegEx(value, regEx);
    }

    /**
     * @Description: 验证微信是否合法
     * @Param: [value]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static boolean checkWechatRegEx(String value) {
        String regEx = "[a-zA-Z]{1}[a-zA-Z0-9_-]{5,19}$";
        return checkRegEx(value, regEx);
    }


    /**
     * @Description: 验证正则表达式是否合法
     * @Param: [value, regEx]
     * @Return: 验证成功返回true，否则返回false
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static boolean checkRegEx(String value, String regEx) {
        boolean result = false;
        if (StringUtils.isNotEmpty(value)) {
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(value);
            if (m.matches()) {
                result = true;
            }
        }
        return result;
    }


}
