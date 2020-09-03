package org.tiankafei.jdbc.util;

import java.util.List;

/**
 * @author 甜咖啡
 */
public class TiankafeiJdbcUtils {

    /**
     * 获取匹配字符串
     *
     * @param value 值
     * @return 匹配字符串
     */
    public static String getLike(String value) {
        return "%" + value + "%";
    }

    /**
     * 获取左匹配字符串
     *
     * @param value 值
     * @return 匹配字符串
     */
    public static String getLeftLike(String value) {
        return "%" + value;
    }

    /**
     * 获取右匹配字符串
     *
     * @param value 值
     * @return 匹配字符串
     */
    public static String getRightLike(String value) {
        return value + "%";
    }

    /**
     * 组装inSQL
     *
     * @param dataList  数据集合
     * @param paramList 参数集合
     * @return sql
     */
    public static String packageInList(List<?> dataList, List<Object> paramList) {
        return packageInList(dataList.toArray(), paramList);
    }

    /**
     * 组装inSQL
     *
     * @param dataArray 数据集合
     * @param paramList 参数集合
     * @return sql
     */
    public static String packageInList(Object[] dataArray, List<Object> paramList) {
        StringBuffer sqlBuffer = new StringBuffer();
        for (int index = 0, length = dataArray.length; index < length; index++) {
            sqlBuffer.append(",?");
            paramList.add(dataArray[index]);
        }
        sqlBuffer.delete(0, 1);

        return sqlBuffer.toString();
    }

}
