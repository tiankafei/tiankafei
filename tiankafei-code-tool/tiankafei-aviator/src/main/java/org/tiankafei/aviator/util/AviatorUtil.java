package org.tiankafei.aviator.util;

import com.googlecode.aviator.AviatorEvaluator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.core.IFunManager;
import org.tiankafei.common.util.JdkSpiUtil;

/**
 * @author tiankafei
 */
@Slf4j
public class AviatorUtil {

    /**
     * 初始化函数
     */
    public static void initFun() {
        Iterator<IFunManager> providers = JdkSpiUtil.service(IFunManager.class);
        IFunManager funManager = providers.next();
        funManager.initialize();
    }

    /**
     * 直接执行审核
     *
     * @param expression
     */
    public static void execute(String expression) {
        execute(expression, new HashMap<>(0));
    }

    /**
     * 直接执行审核
     *
     * @param expression
     * @param dataMap
     */
    public static void execute(String expression, Map<String, Object> dataMap) {
        try {
            Object result = null;
            if (dataMap != null) {
                result = AviatorEvaluator.execute(expression, dataMap);
            } else {
                result = AviatorEvaluator.execute(expression);
            }
            log.info("表达式：{}的执行结果为：{}", expression, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        if (object == null || StringUtils.isBlank(object.toString())) {
            return Boolean.FALSE;
        }
        Boolean strResult = object.toString().matches("^[\\+\\-]?(0|[0-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
        return strResult;
    }

    /**
     * 转换成Boolean
     *
     * @param val
     * @return
     */
    public static Boolean toBooleanObj(Object val) {
        if (val == null) {
            return Boolean.FALSE;
        } else if (val instanceof Boolean) {
            return ((Boolean) val);
        } else if (val instanceof String) {
            return Boolean.valueOf((String) val);
        }
        return Boolean.FALSE;
    }

    /**
     * object 转 double类型
     *
     * @param object
     * @return
     */
    public static Double objectToDouble(Object object) {
        Double value = null;
        if (AviatorUtil.isString(object)) {
            if (AviatorUtil.isNumerics(object.toString())) {
                value = Double.parseDouble(object.toString());
            }
        } else if (object instanceof Number) {
            value = Double.parseDouble(object.toString());
        }
        return value;
    }

    /**
     * @param l
     * @return
     */
    public static Object parseNumber(long l) {
        int i = (int) l;
        if (i == l) {
            return new Integer(i);
        }
        return new Long(l);
    }

    /**
     * @param d
     * @return
     */
    public static Object parseNumber(double d) {
        long f = (long) d;
        if (f == d) {
            return parseNumber(f);
        }
        return new Double(d);
    }

    /**
     * 将字符串转换成数值
     *
     * @param str
     * @return
     */
    public static Object parseNumber(String str) {
        if (str != null) {
            String trimValue = str.trim();
            try {
                return parseNumber(Double.parseDouble(trimValue));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

}
