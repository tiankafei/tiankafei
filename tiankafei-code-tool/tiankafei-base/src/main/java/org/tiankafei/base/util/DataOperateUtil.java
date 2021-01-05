package org.tiankafei.base.util;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;

/**
 * 数据操作工具类
 *
 * @author tiankafei
 * @since 1.0
 */
public class DataOperateUtil {

    private DataOperateUtil() {

    }

    /**
     * 四舍五入
     */
    public static int ROUND_HALF_UP = BigDecimal.ROUND_HALF_UP;

    /**
     * 退一
     */
    public static int ROUND_DOWN = BigDecimal.ROUND_DOWN;

    /**
     * 进一
     */
    public static int ROUND_UP = BigDecimal.ROUND_UP;

    /**
     * double类型返回值
     */
    public static int DOUBLE_RESULT_TYPE = 1;

    /**
     * int类型返回值
     */
    public static int INTEGER_RESULT_TYPE = 2;

    /**
     * 加
     */
    public static int ADD_TYPE = 1;

    /**
     * 减
     */
    public static int SUB_TYPE = 2;

    /**
     * 乘
     */
    public static int MUL_TYPE = 3;

    /**
     * 除
     */
    public static int DIV_TYPE = 4;

    /**
     * 除求余
     */
    public static int MOD_TYPE = 5;

    /**
     * 获取值(四舍五入)
     *
     * @param value     当前值
     * @param precision 要保留的小数位
     * @return 返回要获取的值
     */
    public static double getRoundValue(double value, int precision) {
        return getDoubleValue(value, precision, ROUND_HALF_UP);
    }

    /**
     * 获取值(退一)
     *
     * @param value     当前值
     * @param precision 要保留的小数位
     * @return 返回要获取的值
     */
    public static double getRoundDownValue(double value, int precision) {
        return getDoubleValue(value, precision, ROUND_DOWN);
    }

    /**
     * 获取值(进一)
     *
     * @param value     当前值
     * @param precision 要保留的小数位
     * @return 返回要获取的值
     */
    public static double getRoundUpValue(double value, int precision) {
        return getDoubleValue(value, precision, ROUND_UP);
    }

    /**
     * 获取值
     *
     * @param value       当前值
     * @param precision   要保留的小数位
     * @param operateType 获取值类型(ROUND_HALF_UP四舍五入、ROUND_DOWN退一、ROUND_UP进一)
     * @return 返回要获取的值
     */
    private static double getDoubleValue(double value, int precision, int operateType) {
        return new BigDecimal(value).setScale(precision, operateType).doubleValue();
    }

    /**
     * int类型相加
     *
     * @param left  相加前的值
     * @param right 相加后的值
     * @return 相加后的值
     * @throws BaseException 自定义异常
     */
    public static int addValue(Object left, Object right) throws BaseException {
        return (int) getValue(left, right, ADD_TYPE);
    }

    /**
     * int类型相加
     *
     * @param left  相加前的值
     * @param right 相加后的值
     * @return 相加后的值
     * @throws BaseException 自定义异常
     */
    public static int subValue(Object left, Object right) throws BaseException {
        return (int) getValue(left, right, SUB_TYPE);
    }

    /**
     * int类型相加
     *
     * @param left  相加前的值
     * @param right 相加后的值
     * @return 相加后的值
     * @throws BaseException 自定义异常
     */
    public static int mulValue(Object left, Object right) throws BaseException {
        return (int) getValue(left, right, MUL_TYPE);
    }

    /**
     * int类型相加
     *
     * @param left  相加前的值
     * @param right 相加后的值
     * @return 相加后的值
     * @throws BaseException 自定义异常
     */
    public static int divValue(Object left, Object right) throws BaseException {
        return (int) getValue(left, right, DIV_TYPE);
    }

    /**
     * int类型相加
     *
     * @param left  相加前的值
     * @param right 相加后的值
     * @return 相加后的值
     * @throws BaseException 自定义异常
     */
    public static int modValue(Object left, Object right) throws BaseException {
        return (int) getValue(left, right, MOD_TYPE);
    }

    /**
     * 获取值
     *
     * @param left        操作前值
     * @param right       操作后值
     * @param operateType 操作类型(ADD_TYPE加、SUB_TYPE减、MUL_TYPE乘、DIV_TYPE除、MOD_TYPE求余)
     * @return 返回值
     * @throws BaseException 自定义异常
     */
    private static Object getValue(Object left, Object right, int operateType) throws BaseException {
        BigDecimal valueBigDecimal = null;

        if (left != null && !StringUtils.isNumeric(left.toString())) {
            throw new BaseException("字符串不能参与运算，请检查！");
        }
        if (right != null && !StringUtils.isNumeric(right.toString())) {
            throw new BaseException("字符串不能参与运算，请检查！");
        }
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());

        if (ADD_TYPE == operateType) {
            valueBigDecimal = leftBigDecimal.add(rightBigDecimal);
        } else if (SUB_TYPE == operateType) {
            valueBigDecimal = leftBigDecimal.subtract(rightBigDecimal);
        } else if (MUL_TYPE == operateType) {
            valueBigDecimal = leftBigDecimal.multiply(rightBigDecimal);
        } else if (DIV_TYPE == operateType) {
            if (rightBigDecimal.doubleValue() == 0.0) {
                throw new BaseException("除数不能为0，请检查！");
            }
            double d = leftBigDecimal.doubleValue() / rightBigDecimal.doubleValue();
            valueBigDecimal = new BigDecimal(d);
        } else if (MOD_TYPE == operateType) {
            if (rightBigDecimal.doubleValue() == 0.0) {
                throw new BaseException("除数不能为0，请检查！");
            }
            valueBigDecimal = leftBigDecimal.remainder(rightBigDecimal);
        }
        return parseNumber(valueBigDecimal.toString());
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

    /**
     * @param d
     * @return
     */
    private static Object parseNumber(double d) {
        long f = (long) d;
        if (f == d) {
            return parseNumber(f);
        }
        return new Double(d);
    }

    /**
     * @param l
     * @return
     */
    private static Object parseNumber(long l) {
        int i = (int) l;
        if (i == l) {
            return new Integer(i);
        }
        return new Long(l);
    }

    /**
     * 获取数组
     *
     * @param number 数量
     * @return 数组
     */
    public static String[] getFromZeroArray(int number) {
        return getArray(0, number);
    }

    /**
     * 获取数组
     *
     * @param number 数量
     * @return 数组
     */
    public static String[] getFromOneArray(int number) {
        return getArray(1, number + 1);
    }

    /**
     * 获取数组
     *
     * @param beginNumber 开始位置
     * @param endNumber   结束位置
     * @return 数组
     */
    public static String[] getArray(int beginNumber, int endNumber) {
        String[] array = new String[endNumber - beginNumber];
        for (int i = beginNumber; i < endNumber; i++) {
            if (i < 10) {
                array[i - beginNumber] = "0" + i;
            } else {
                array[i - beginNumber] = String.valueOf(i);
            }
        }
        return array;
    }

    /**
     * 获取0的个数的字符串
     *
     * @param number 要获取0的个数
     * @return 0的个数的字符串
     */
    public static String getZeroCount(int number) {
        return StringUtils.rightPad("", number, "0");
    }

    /**
     * 获取0的个数的字符串
     *
     * @param number 要获取0的个数
     * @return 0的个数的字符串
     */
    public static String getNullCount(int number) {
        return StringUtils.rightPad("", number, " ");
    }

}
