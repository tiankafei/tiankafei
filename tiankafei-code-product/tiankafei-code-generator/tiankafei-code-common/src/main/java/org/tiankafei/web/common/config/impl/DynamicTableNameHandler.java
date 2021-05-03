package org.tiankafei.web.common.config.impl;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.ruoyi.common.core.utils.DynamicTableNameUtil;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class DynamicTableNameHandler implements TableNameHandler {

    @Override
    public String dynamicTableName(String sql, String tableName) {
        // 获取当前动态表名
        String dynamicTableName = DynamicTableNameUtil.getDynamicTableName();
        sql = sql.replaceAll(tableName, dynamicTableName);
        return sql;
    }

}
