package org.tiankafei.jdbc.mybatis.dao.sqlite;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.base.datetime.DateTimeUtil;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.enums.DateTimeEnum;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.mybatis.dao.AbstractGeneralMyBatisDAO;
import org.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO;
import org.tiankafei.jdbc.util.GeneralSqlUtil;

/**
 * @author 甜咖啡
 */
public class GeneralSqliteMyBatisDAO extends AbstractGeneralMyBatisDAO {

    @Override
    public Timestamp getCurrentTimestamp(ICommonMyBatisMapperDAO commonMyBatisMapperDAO) throws BaseException {
        String currentTime = commonMyBatisMapperDAO.getCurrentTimestampSqlite();
        Timestamp timestamp = DateTimeUtil.stringToTimestamp(currentTime, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        return timestamp;
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql(SqlSessionFactory sqlSessionFactory) throws BaseException {
        return getMapperSql(sqlSessionFactory, new Object(), "getCurrentTimestampSqlite");
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList, String databaseProductName) throws BaseException {
        GeneralSqlUtil.createDatabaseSqlite(dbFilePath, sqlList);
        return true;
    }

}
