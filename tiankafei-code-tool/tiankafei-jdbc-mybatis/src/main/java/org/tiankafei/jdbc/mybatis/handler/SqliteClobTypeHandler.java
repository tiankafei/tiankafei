package org.tiankafei.jdbc.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.ClobTypeHandler;
import org.tiankafei.base.util.LogUtil;
import org.tiankafei.jdbc.constant.DbConfigConstants;

/**
 * @author 甜咖啡
 */
public class SqliteClobTypeHandler extends ClobTypeHandler {

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String productName = rs.getStatement().getConnection().getMetaData().getDatabaseProductName();
        if (DbConfigConstants.DB_SQLITE.equals(productName)) {
            Clob clob = rs.getClob(columnName);
            return getColbValue(clob);
        } else {
            return super.getNullableResult(rs, columnName);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String productName = rs.getStatement().getConnection().getMetaData().getDatabaseProductName();
        if (DbConfigConstants.DB_SQLITE.equals(productName)) {
            Clob clob = rs.getClob(columnIndex);
            return getColbValue(clob);
        } else {
            return super.getNullableResult(rs, columnIndex);
        }
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String productName = cs.getResultSet().getStatement().getConnection().getMetaData().getDatabaseProductName();
        if (DbConfigConstants.DB_SQLITE.equals(productName)) {
            Clob clob = cs.getClob(columnIndex);
            return getColbValue(clob);
        } else {
            return super.getNullableResult(cs, columnIndex);
        }
    }

    private String getColbValue(Clob clob) throws SQLException {
        String value = "";
        if (clob != null) {
            try {
                int size = (int) clob.length();
                value = clob.getSubString(0L, size);
            } catch (SQLException e) {
                LogUtil.error(e.getMessage());
                String str = "no data";
                if (!str.equals(e.getMessage())) {
                    throw e;
                }
            }
        }
        return value;
    }

}
