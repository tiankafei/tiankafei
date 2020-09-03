package org.tiankafei.jdbc.mybatis;

import org.tiankafei.jdbc.constant.DbConfigConstants;
import org.tiankafei.jdbc.mybatis.dao.AbstractGeneralMyBatisDAO;
import org.tiankafei.jdbc.mybatis.dao.mysql.GeneralMysqlMyBatisDAO;
import org.tiankafei.jdbc.mybatis.dao.oracle.GeneralOracleMyBatisDAO;
import org.tiankafei.jdbc.mybatis.dao.sqlite.GeneralSqliteMyBatisDAO;

/**
 * 公共的mybatis框架数据操作工厂对象
 *
 * @author tiankafei
 */
public class CommonMybatisFactory {

    /**
     * 获取公共DAO对象
     *
     * @param databaseProductName 数据库产品
     * @return 公共业务处理类对象
     */
    public static AbstractGeneralMyBatisDAO getAbstractGeneralMyBatisDAO(String databaseProductName) {
        AbstractGeneralMyBatisDAO generalMyBatisDAO = null;
        if (DbConfigConstants.DB_ORACLE.equals(databaseProductName)) {
            generalMyBatisDAO = new GeneralOracleMyBatisDAO();
        } else if (DbConfigConstants.DB_MYSQL.equals(databaseProductName)) {
            generalMyBatisDAO = new GeneralMysqlMyBatisDAO();
        } else if (DbConfigConstants.DB_SQLITE.equals(databaseProductName)) {
            generalMyBatisDAO = new GeneralSqliteMyBatisDAO();
        }
        return generalMyBatisDAO;
    }

}
