package org.tiankafei.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageColumnDTO;
import org.tiankafei.jdbc.constant.ColumnNameConstants;
import org.tiankafei.jdbc.constant.DbConfigConstants;

/**
 * @author 甜咖啡
 */
public class GeneralSqlUtil {

    /**
     * 获取组装字段sql(mysql和sqlite数据库分页)
     *
     * @param physicalStorageColumnDTO 字段信息
     * @return 组装字段sql
     */
    public static String getPackageColumnSqlMysqlAndSqlite(PhysicalStorageColumnDTO physicalStorageColumnDTO) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(physicalStorageColumnDTO.getColumnName());
        //char类型
        if (ColumnNameConstants.COLUMN_TYPE_CHAR == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" CHAR(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(")");
            if (defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //varchar类型
        else if (ColumnNameConstants.COLUMN_TYPE_VARCHAR == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" VARCHAR(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(")");
            if (defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //integer类型
        else if (ColumnNameConstants.COLUMN_TYPE_INTEGER == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" INTEGER(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(") ");
            if (defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //number类型
        else if (ColumnNameConstants.COLUMN_TYPE_NUMBER == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" NUMERIC(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(", ").append(physicalStorageColumnDTO.getColumnDataPrecision()).append(")");
            if (defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //timestamp
        else if (ColumnNameConstants.COLUMN_TYPE_TIMESTAMP == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" TIMESTAMP ");
        }
        //text,clob类型
        else if (ColumnNameConstants.COLUMN_TYPE_CLOB == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" TEXT ");
            if (defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //blob类型
        else if (ColumnNameConstants.COLUMN_TYPE_BLOB == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" BLOB ");
        }

        //是否为空
        if (ColumnNameConstants.COLUMN_TYPE_TIMESTAMP == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" NULL ");
        } else {
            if (!physicalStorageColumnDTO.getNullFlag()) {
                sqlBuffer.append(" NOT NULL");
            } else {
                if (!physicalStorageColumnDTO.getPrimaryKeyFlag()) {
                    sqlBuffer.append(" NULL ");
                }
            }
        }

        return sqlBuffer.toString();
    }

    /**
     * 默认值不为空
     *
     * @param physicalStorageColumnDTO 字段信息
     * @return 默认值不为空返回true，否则返回false
     */
    public static boolean defaultValueIsNotNull(PhysicalStorageColumnDTO physicalStorageColumnDTO) {
        if (physicalStorageColumnDTO.getDefaultValue() != null) {
            String value = physicalStorageColumnDTO.getDefaultValue().toString();
            if (StringUtils.isNotEmpty(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建sqlite数据库文件
     *
     * @param dbFilePath 数据库文件路径
     * @param sqlList    要执行的sql集合
     * @throws BaseException 自定义异常
     */
    public static void createDatabaseSqlite(String dbFilePath, List<String> sqlList) throws BaseException {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DbConfigConstants.DB_DRIVER_SQLITE);
            connection = DriverManager.getConnection(DbConfigConstants.DB_DRIVER_SQLITE_PREFIX + dbFilePath);
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = null;
            for (int i = 0; i < sqlList.size(); i++) {
                sql = sqlList.get(i);
                if (StringUtils.isNotEmpty(sql)) {
                    statement.executeUpdate(sql);
                }
            }
            statement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new BaseException(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取新对象值
     *
     * @param object      对象值
     * @param productName 数据库产品
     * @param paramType   参数类型
     * @return 新对象值
     */
    public static Object getNewObject(Object object, String productName, int paramType) {
        Object result = object;
        if (DbConfigConstants.DB_SQLITE.equals(productName)) {
            //只有是sqlite的时候，针对clob字段需要在前面增加一个空格
            if (ColumnNameConstants.COLUMN_TYPE_CLOB == paramType) {
                if (object == null || StringUtils.isBlank(object.toString())) {
                    result = " ";
                } else {
                    result = " " + object.toString();
                }
            }
        }
        return result;
    }

}
