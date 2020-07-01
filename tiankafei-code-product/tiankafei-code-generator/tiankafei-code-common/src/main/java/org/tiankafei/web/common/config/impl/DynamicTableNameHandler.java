package org.tiankafei.web.common.config.impl;

import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.tiankafei.web.common.utils.DynamicTableNameUtil;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class DynamicTableNameHandler implements ITableNameHandler {

    @Override
    public String process(MetaObject metaObject, String sql, String tableName) {
        String dynamicTableName = dynamicTableName(metaObject, sql, tableName);
        if (null != dynamicTableName && !dynamicTableName.equalsIgnoreCase(tableName)) {
            String newSql = sql.replaceAll(tableName, dynamicTableName);
            return newSql;
        }
        return sql;
    }

    @Override
    public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
        return DynamicTableNameUtil.getDynamicTableName();
    }

}
