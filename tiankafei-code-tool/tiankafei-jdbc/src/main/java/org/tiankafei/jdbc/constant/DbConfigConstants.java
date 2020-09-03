package org.tiankafei.jdbc.constant;

/**
 * @author 甜咖啡
 */
public class DbConfigConstants {

    //数据库相关常量
    /**
     * oralce数据库标识(jdbc:oracle:thin:@localhost:1521:tiankafei)
     */
    public static final String DB_ORACLE = "Oracle";

    /**
     * mysql数据库标识(jdbc:mysql://localhost:3306/common)
     */
    public static final String DB_MYSQL = "MySQL";

    /**
     * sqlite数据库标识(jdbc:sqlite:+dbFilePath)
     */
    public static final String DB_SQLITE = "SQLite";

    /**
     * oracle驱动
     */
    public static final String DB_DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";

    /**
     * oracle数据库连接前缀
     */
    public static final String DB_DRIVER_ORACLE_PREFIX = "jdbc:oracle:thin:@";

    /**
     * MySql驱动
     */
    public static final String DB_DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";

//    /**
//     * MySql驱动
//     */
//    public static final String DB_DRIVER_MYSQL_5_7 = "com.mysql.cj.jdbc.Driver";

    /**
     * MySql数据库连接前缀
     */
    public static final String DB_DRIVER_MYSQL_PREFIX = "jdbc:mysql://";

    /**
     * SQLite数据文件驱动类名
     */
    public static final String DB_DRIVER_SQLITE = "org.sqlite.JDBC";

    /**
     * SQLite数据连接地址前缀
     */
    public static final String DB_DRIVER_SQLITE_PREFIX = "jdbc:sqlite:";

    /**
     * 数据源类型（c3p0）
     */
    public static final String DATA_SOURCE_C3P0 = "1";

    /**
     * 数据源类型（druid）
     */
    public static final String DATA_SOURCE_DRUID = "2";

    /**
     * 数据源类型（jndi）
     */
    public static final String DATA_SOURCE_JNDI = "3";

}
