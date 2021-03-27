package org.tiankafei.jdbc.dao.sqlite;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.tiankafei.common.datetime.DateTimeUtil;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.common.enums.DateTimeEnum;
import org.tiankafei.jdbc.dto.PhysicalStorageColumnDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.dao.AbstractGeneralDAO;
import org.tiankafei.jdbc.dao.ICommonDAO;
import org.tiankafei.jdbc.util.GeneralSqlUtil;

/**
 * SQLite公共DAO对象
 *
 * @author 甜咖啡
 */
public class GeneralSqliteDAO extends AbstractGeneralDAO {

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("SELECT A.* FROM (").append(sql).append(") A LIMIT ").append((currentPage - 1) * pageSize).append(", ").append(pageSize);
        return sqlBuffer.toString();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        SqlParamDTO sqlParamDTO = new SqlParamDTO();
        sqlParamDTO.setSql("SELECT DATETIME(CURRENT_TIMESTAMP,'LOCALTIME') AS DATETIME");
        return sqlParamDTO;
    }

    @Override
    public Timestamp getCurrentTimestamp(ICommonDAO commonDAO) {
        SqlParamDTO sqlParamDTO = getCurrentTimestampSql();
        List<Map<String, Object>> dataMapList = commonDAO.getJdbcTemplate().queryForList(sqlParamDTO.getSql(), sqlParamDTO.getParamList().toArray());
        String dateTime = dataMapList.get(0).get("DATETIME").toString();
        Timestamp timestamp = DateTimeUtil.stringToTimestamp(dateTime, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        return timestamp;
    }

    @Override
    public SqlParamDTO checkTableExistsSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        SqlParamDTO sqlParamDTO = new SqlParamDTO();
        sqlParamDTO.setSql("SELECT NAME FROM SQLITE_MASTER WHERE TYPE='table' AND NAME = ?");
        sqlParamDTO.getParamList().add(physicalStorageTableDTO.getTableName());
        return sqlParamDTO;
    }

    @Override
    public String packageColumnTypeSql(PhysicalStorageColumnDTO physicalStorageColumnDTO) {
        return GeneralSqlUtil.getPackageColumnSqlMysqlAndSqlite(physicalStorageColumnDTO);
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList, ICommonDAO commonDAO) {
        GeneralSqlUtil.createDatabaseSqlite(dbFilePath, sqlList);
        return true;
    }

}
