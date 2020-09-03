package org.tiankafei.jdbc;

import org.tiankafei.jdbc.constant.DbConfigConstants;
import org.tiankafei.jdbc.dao.AbstractGeneralDAO;
import org.tiankafei.jdbc.dao.mysql.GeneralMysqlDAO;
import org.tiankafei.jdbc.dao.oracle.GeneralOracleDAO;
import org.tiankafei.jdbc.dao.sqlite.GeneralSqliteDAO;
import org.tiankafei.jdbc.datasource.AbstractCreateDataSource;
import org.tiankafei.jdbc.datasource.c3p0.CreateC3p0DataSource;
import org.tiankafei.jdbc.datasource.druid.CreateDruidDataSource;
import org.tiankafei.jdbc.datasource.jndi.CreateJndiDataSource;

/**
 * 公共工厂类
 *
 * @author tiankafei
 */
public class CommonJdbcFactory {

    /**
     * 获取公共DAO对象
     *
     * @param dbType 数据库类型
     * @return 公共业务处理类对象
     */
    public static AbstractGeneralDAO getGeneralDAO(String dbType) {
        AbstractGeneralDAO generalDAO = null;
        if (DbConfigConstants.DB_ORACLE.equals(dbType)) {
            generalDAO = new GeneralOracleDAO();
        } else if (DbConfigConstants.DB_MYSQL.equals(dbType)) {
            generalDAO = new GeneralMysqlDAO();
        } else if (DbConfigConstants.DB_SQLITE.equals(dbType)) {
            generalDAO = new GeneralSqliteDAO();
        }
        return generalDAO;
    }

    /**
     * 获取创建数据源对象
     *
     * @param dataSourceType 数据源类型
     * @return 创建数据源对象
     */
    public static AbstractCreateDataSource getCreateDataSource(String dataSourceType) {
        AbstractCreateDataSource abstractCreateDataSource = null;
        if (DbConfigConstants.DATA_SOURCE_C3P0.equals(dataSourceType)) {
            abstractCreateDataSource = new CreateC3p0DataSource();
        } else if (DbConfigConstants.DATA_SOURCE_DRUID.equals(dataSourceType)) {
            abstractCreateDataSource = new CreateDruidDataSource();
        } else if (DbConfigConstants.DATA_SOURCE_JNDI.equals(dataSourceType)) {
            abstractCreateDataSource = new CreateJndiDataSource();
        }
        return abstractCreateDataSource;
    }

}
