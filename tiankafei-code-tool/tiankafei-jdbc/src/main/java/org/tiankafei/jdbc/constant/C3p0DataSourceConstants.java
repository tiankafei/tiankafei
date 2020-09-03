package org.tiankafei.jdbc.constant;

/**
 * 数据库连接配置参数常量类
 *
 * @author tiankafei
 */
public class C3p0DataSourceConstants {

    /**
     * 数据库类型：Oracle;MySql,SQLServer,DB2,SQLite;
     */
    public static final String DATABASE_PRODUCT_NAME = "productName";

    /**
     * 数据库服务器IP
     */
    public static final String DB_IP = "ip";

    /**
     * 数据库服务器端口
     */
    public static final String DB_PORT = "port";

    /**
     * 数据库名称
     */
    public static final String DB_NAME = "dbName";

    /**
     * 数据库用户名
     */
    public static final String DB_USERNAME = "username";

    /**
     * 数据库密码
     */
    public static final String DB_PASSWORD = "password";

    /**
     * 文件型数据库db文件路径
     */
    public static final String DB_FILE_PATH = "dbFilePath";

    /**
     * 初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3
     */
    public static final String INITIAL_POOL_SIZE = "initialPoolSize";

    /**
     * 连接池中保留的最大连接数。默认值: 15
     */
    public static final String MAX_POOL_SIZE = "maxPoolSize";

    /**
     * 连接池中保留的最小连接数，默认为：3
     */
    public static final String MIN_POOL_SIZE = "minPoolSize";

    /**
     * 最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0
     */
    public static final String MAX_IDLE_TIME = "maxIdleTime";

    /**
     * 当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
     */
    public static final String CHECK_OUT_TIME_OUT = "checkoutTimeout";

    /**
     * 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值:3
     */
    public static final String ACQUIRE_INCREMENT = "acquireIncrement";

    /**
     * 定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
     */
    public static final String ACQUIRE_RETRY_ATTEMPTS = "acquireRetryAttempts";

    /**
     * 重新尝试的时间间隔，默认为：1000毫秒
     */
    public static final String ACQUIRE_RETRY_DELAY = "acquireRetryDelay";

    /**
     * 关闭连接时，是否提交未提交的事务，默认为false，即关闭连接，回滚未提交的事务
     */
    public static final String AUTO_COMMIT_ON_CLOSE = "autoCommitOnClose";

    /**
     * c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。默认值: null
     */
    public static final String AUTOMATIC_TEST_TABLE = "automaticTestTable";

    /**
     * 如果为false，则获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常，但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认: false
     */
    public static final String BREAK_AFTER_ACQUIRE_FAILURE = "breakAfterAcquireFailure";

    /**
     * 每600秒检查所有连接池中的空闲连接。默认值: 0，不检查
     */
    public static final String IDLE_CONNECTION_TEST_PERIOD = "idleConnectionTestPeriod";

    /**
     * c3p0全局的PreparedStatements缓存的大小。如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，只要有一个不为0，则语句的缓存就能生效。如果默认值: 0
     */
    public static final String MAX_STATEMENTS = "maxStatements";

    /**
     * maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。默认值: 0
     */
    public static final String MAX_STATEMENTS_PER_CONNECTION = "maxStatementsPerConnection";

    /**
     * 因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable等方法来提升连接测试的性能。Default: false testConnectionOnCheckout
     */
    public static final String TEST_CONNECTION_ON_CHECKOUT = "testConnectionOnCheckout";

    /**
     * 如果设为true那么在取得连接的同时将校验连接的有效性。Default: false testConnectionOnCheckin
     */
    public static final String TEST_CONNECTION_ON_CHECKIN = "testConnectionOnCheckin";

}
