package org.tiankafei.jdbc.dao.oracle;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageColumnDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.constant.ColumnNameConstants;
import org.tiankafei.jdbc.dao.AbstractGeneralDAO;
import org.tiankafei.jdbc.util.GeneralSqlUtil;

/**
 * Oracle公共DAO对象
 *
 * @author 甜咖啡
 */
public class GeneralOracleDAO extends AbstractGeneralDAO {

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("SELECT * FROM ")
                .append(" ( SELECT T.*,ROWNUM RN FROM ( ").append(sql).append(" ) T ").append(" WHERE ROWNUM <= ").append(currentPage * pageSize).append(") ")
                .append(" WHERE RN > ").append((currentPage - 1) * pageSize).append("");
        return sqlBuffer.toString();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return new SqlParamDTO("SELECT SYSDATE AS TIME FROM DUAL");
    }

    @Override
    public SqlParamDTO checkTableExistsSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        StringBuffer sqlBuffer = new StringBuffer().append("SELECT T.TABLE_NAME FROM USER_TABLES T WHERE T.TABLE_NAME=?");
        List<Object> paramList = Lists.newArrayList();
        paramList.add(physicalStorageTableDTO.getTableName());
        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String packageColumnTypeSql(PhysicalStorageColumnDTO physicalStorageColumnDTO) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(physicalStorageColumnDTO.getColumnName());
        //char类型
        if (ColumnNameConstants.COLUMN_TYPE_CHAR == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" CHAR(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(")");
            if (GeneralSqlUtil.defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //varchar类型
        else if (ColumnNameConstants.COLUMN_TYPE_VARCHAR == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" VARCHAR2(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(")");
            if (GeneralSqlUtil.defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //integer类型
        else if (ColumnNameConstants.COLUMN_TYPE_INTEGER == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" INTEGER ");
            if (GeneralSqlUtil.defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //number类型
        else if (ColumnNameConstants.COLUMN_TYPE_NUMBER == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" NUMBER(").append(physicalStorageColumnDTO.getColumnMaxLength()).append(", ").append(physicalStorageColumnDTO.getColumnDataPrecision()).append(")");
            if (GeneralSqlUtil.defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //timestamp
        else if (ColumnNameConstants.COLUMN_TYPE_TIMESTAMP == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" TIMESTAMP ");
        }
        //text,clob类型
        else if (ColumnNameConstants.COLUMN_TYPE_CLOB == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" CLOB ");
            if (GeneralSqlUtil.defaultValueIsNotNull(physicalStorageColumnDTO)) {
                sqlBuffer.append(" DEFAULT ").append(physicalStorageColumnDTO.getDefaultValue());
            }
        }
        //blob类型
        else if (ColumnNameConstants.COLUMN_TYPE_BLOB == physicalStorageColumnDTO.getColumnType()) {
            sqlBuffer.append(" BLOB ");
        }

        //是否为空
        if (!physicalStorageColumnDTO.getNullFlag()) {
            sqlBuffer.append(" NOT NULL");
        }
        return sqlBuffer.toString();
    }

}
