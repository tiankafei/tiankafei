package cn.tiankafei.aviator.extend.util;

/**
 * @author tiankafei
 */
public class FunctionUtils {

    /**
     * 是字符串
     *
     * @param object
     * @return
     */
    public static Boolean isString(Object object) {
        Boolean flag = Boolean.FALSE;
        if (object instanceof CharSequence) {
            flag = Boolean.TRUE;
        } else if (object instanceof Character) {
            flag = Boolean.TRUE;
        }
        return flag;
    }

    /**
     * 字符串是否是数字
     *
     * @param object
     * @return
     */
    public static Boolean isNumerics(Object object) {
        if (object == null) {
            return Boolean.FALSE;
        }
        Boolean strResult = object.toString().matches("^[\\+\\-]?(0|[0-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
        return strResult;
    }

}
