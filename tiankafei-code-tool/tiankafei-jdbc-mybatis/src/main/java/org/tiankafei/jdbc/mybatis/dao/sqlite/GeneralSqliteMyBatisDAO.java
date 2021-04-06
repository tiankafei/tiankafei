package org.tiankafei.jdbc.mybatis.dao.sqlite;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.common.datetime.DateTimeUtil;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.common.enums.DateTimeEnum;
import org.tiankafei.jdbc.mybatis.dao.AbstractGeneralMyBatisDAO;
import org.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO;
import org.tiankafei.jdbc.util.GeneralSqlUtil;

/**
 * @author 甜咖啡
 */
public class GeneralSqliteMyBatisDAO extends AbstractGeneralMyBatisDAO {

    @Override
    public Timestamp getCurrentTimestamp(ICommonMyBatisMapperDAO commonMyBatisMapperDAO) {
        String currentTime = commonMyBatisMapperDAO.getCurrentTimestampSqlite();
        Timestamp timestamp = DateTimeUtil.stringToTimestamp(currentTime, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        return timestamp;
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql(SqlSessionFactory sqlSessionFactory) {
        return getMapperSql(sqlSessionFactory, new Object(), "getCurrentTimestampSqlite");
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList, String databaseProductName) {
        GeneralSqlUtil.createDatabaseSqlite(dbFilePath, sqlList);
        return true;
    }

}
