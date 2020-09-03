package org.tiankafei.jdbc.dao.mysql;

import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageColumnDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.dao.AbstractGeneralDAO;
import org.tiankafei.jdbc.util.GeneralSqlUtil;

/**
 * MySQL公共DAO对象
 *
 * @author 甜咖啡
 */
public class GeneralMysqlDAO extends AbstractGeneralDAO {

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("SELECT A.* FROM (").append(sql).append(") A LIMIT ").append((currentPage - 1) * pageSize).append(", ").append(pageSize);
        return sqlBuffer.toString();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        SqlParamDTO sqlParamDTO = new SqlParamDTO();
        sqlParamDTO.setSql("SELECT NOW() AS TIME FROM DUAL");
        return sqlParamDTO;
    }

    @Override
    public SqlParamDTO checkTableExistsSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        SqlParamDTO sqlParamDTO = new SqlParamDTO();
        sqlParamDTO.setSql("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA=? AND (TABLE_NAME=? OR TABLE_NAME=?) ");
        sqlParamDTO.getParamList().add(physicalStorageTableDTO.getDbName());
        sqlParamDTO.getParamList().add(physicalStorageTableDTO.getTableName());
        sqlParamDTO.getParamList().add(physicalStorageTableDTO.getTableName().toLowerCase());
        return sqlParamDTO;
    }

    @Override
    public String packageColumnTypeSql(PhysicalStorageColumnDTO physicalStorageColumnDTO) throws BaseException {
        return GeneralSqlUtil.getPackageColumnSqlMysqlAndSqlite(physicalStorageColumnDTO);
    }

}
