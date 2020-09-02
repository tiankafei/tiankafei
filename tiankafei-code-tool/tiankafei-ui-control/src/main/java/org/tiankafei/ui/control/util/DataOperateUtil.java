package org.tiankafei.ui.control.util;

public class DataOperateUtil {

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
        StringBuffer buffer = new StringBuffer();
        for (int index = 0; index < number; index++) {
            buffer.append("0");
        }
        return buffer.toString();
    }

    /**
     * 获取0的个数的字符串
     *
     * @param number 要获取0的个数
     * @return 0的个数的字符串
     */
    public static String getNullCount(int number) {
        StringBuffer buffer = new StringBuffer();
        for (int index = 0; index < number; index++) {
            buffer.append(" ");
        }
        return buffer.toString();
    }

}
