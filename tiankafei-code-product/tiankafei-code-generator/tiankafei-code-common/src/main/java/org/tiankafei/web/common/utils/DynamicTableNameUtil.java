package org.tiankafei.web.common.utils;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class DynamicTableNameUtil {

    private static ThreadLocal<String> myTableNameLocal = new ThreadLocal<>();

    /**
     * 设置动态表名
     * @param dataTable
     */
    public static void setDynamicTableName(String dataTable){
        myTableNameLocal.set(dataTable);
    }

    /**
     * 获取动态表名
     * @return
     */
    public static String getDynamicTableName(){
        String tableName = myTableNameLocal.get();
        myTableNameLocal.remove();
        return tableName;
    }

}
