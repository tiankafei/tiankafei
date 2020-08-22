package org.tiankafei.multidatasource.custom.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 设置数据源类型
     *
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        log.info("切换到{}数据源", dataSourceType);
        THREAD_LOCAL.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     *
     * @return
     */
    public static String getDataSourceType() {
        return THREAD_LOCAL.get();
    }

    /**
     * 清空数据源类型
     */
    public static void clearDataSourceType() {
        THREAD_LOCAL.remove();
    }

}
