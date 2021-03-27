package org.tiankafei.jdbc.util;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.jdbc.constant.DbConfigConstants;
import org.tiankafei.jdbc.dto.C3p0DataSourceDTO;

/**
 * @author 甜咖啡
 */
public class ConnectionUtil {

    /**
     * 初始化数据库连接参数对象
     *
     * @param dataSource 数据源
     * @return 数据库连接参数对象
     */
    public static C3p0DataSourceDTO initDatabaseConnectionParamVO(DataSource dataSource) {
        try {
            DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
            String databaseProductName = databaseMetaData.getDatabaseProductName();
            String url = databaseMetaData.getURL();

            C3p0DataSourceDTO c3p0DataSourceDTO = new C3p0DataSourceDTO();
            String ip = "";
            int port = 0;
            String dbName = "";
            if (url.startsWith(DbConfigConstants.DB_DRIVER_ORACLE_PREFIX)) {
                String[] array = url.split(DbConfigConstants.DB_DRIVER_ORACLE_PREFIX)[1].split(":");
                ip = array[0];
                port = Integer.valueOf(array[1]);
                dbName = array[2];
            } else if (url.startsWith(DbConfigConstants.DB_DRIVER_MYSQL_PREFIX)) {
                String[] array = url.split(DbConfigConstants.DB_DRIVER_MYSQL_PREFIX)[1].split(":");
                ip = array[0];

                String[] arr = array[1].split("/");
                port = Integer.valueOf(arr[0]);
                dbName = arr[1].split("\\?")[0];
            } else if (url.startsWith(DbConfigConstants.DB_DRIVER_SQLITE_PREFIX)) {
                String filePath = url.split(DbConfigConstants.DB_DRIVER_SQLITE_PREFIX)[1];
                dbName = new File(filePath).getName();
            } else {
                throw new CommonException("系统不支持连接当前的数据库类型！");
            }

            c3p0DataSourceDTO.setDbName(dbName);
            c3p0DataSourceDTO.setIp(ip);
            c3p0DataSourceDTO.setPort(port);
            c3p0DataSourceDTO.setProductName(databaseProductName);

            return c3p0DataSourceDTO;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommonException("获取数据库连接失败！");
        }
    }

}
