package org.tiankafei.jdbc.dto;

import java.util.Properties;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.exceptions.BaseException;
import org.tiankafei.common.util.LogUtil;
import org.tiankafei.common.util.PropertiesUtil;
import org.tiankafei.jdbc.constant.C3p0DataSourceConstants;

/**
 * 获取连接数据库参数工具类
 *
 * @author tiankafei
 */
@Getter
@ToString
public class C3p0DataSourceDTO extends DataSourceDTO {

    private static final long serialVersionUID = 3207046121264231170L;

    //##############################################################################
    /**
     * 初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3
     */
    private Integer initialPoolSize;

    /**
     * 连接池中保留的最大连接数。默认值: 15
     */
    private Integer maxPoolSize;

    /**
     * 连接池中保留的最小连接数，默认为：3
     */
    private Integer minPoolSize;

    /**
     * 最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0
     */
    private Integer maxIdleTime;

    /**
     * 当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
     */
    private Integer checkoutTimeout;

    /**
     * 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值:3
     */
    private Integer acquireIncrement;

    /**
     * 定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
     */
    private Integer acquireRetryAttempts;

    /**
     * 重新尝试的时间间隔，默认为：1000毫秒
     */
    private Integer acquireRetryDelay;

    /**
     * 关闭连接时，是否提交未提交的事务，默认为false，即关闭连接，回滚未提交的事务
     */
    private Boolean autoCommitOnClose;

    /**
     * c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。默认值: null
     */
    private String automaticTestTable;

    /**
     * 如果为false，则获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常，但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认: false
     */
    private Boolean breakAfterAcquireFailure;

    /**
     * 每600秒检查所有连接池中的空闲连接。默认值: 0，不检查
     */
    private Integer idleConnectionTestPeriod;

    /**
     * c3p0全局的PreparedStatements缓存的大小。如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，只要有一个不为0，则语句的缓存就能生效。如果默认值: 0
     */
    private Integer maxStatements;

    /**
     * maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。默认值: 0
     */
    private Integer maxStatementsPerConnection;

    /**
     * 因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable等方法来提升连接测试的性能。Default: false testConnectionOnCheckout
     */
    private Boolean testConnectionOnCheckout;

    /**
     * 如果设为true那么在取得连接的同时将校验连接的有效性。Default: false testConnectionOnCheckin
     */
    private Boolean testConnectionOnCheckin;

    /**
     * 文件型数据库db文件路径
     */
    private String dbFilePath;

    /**
     * 构造数据库连接参数对象
     */
    public C3p0DataSourceDTO() {
        initialPoolSize = 3;
        maxPoolSize = 15;
        minPoolSize = 3;
        maxIdleTime = 0;
        checkoutTimeout = 0;
        acquireIncrement = 3;
        acquireRetryAttempts = 30;
        acquireRetryDelay = 1000;
        autoCommitOnClose = false;

        breakAfterAcquireFailure = false;
        idleConnectionTestPeriod = 0;
        maxStatements = 0;
        maxStatementsPerConnection = 0;
        testConnectionOnCheckout = false;
        testConnectionOnCheckin = false;
    }

    /**
     * 构造数据库连接参数对象
     *
     * @param dbPropertis 数据库配置文件
     */
    public C3p0DataSourceDTO(String dbPropertis) {
        this();
        initC3p0DataSourceDTO(dbPropertis);
    }

    /**
     * 初始化C3p0数据库连接对象
     *
     * @param dbPropertis 数据库配置文件
     */
    protected void initC3p0DataSourceDTO(String dbPropertis) {
        try {
            Properties dbProperties = null;
            if (StringUtils.isNotEmpty(dbPropertis)) {
                dbProperties = PropertiesUtil.getInstance(dbPropertis);
            } else {
                throw new BaseException("没有传入jdbc配置文件！");
            }
            //数据库类型：1Oracle;2MySql,3SQLServer,4DB2,5SQLite;
            setProductName(getStringValue(dbProperties, C3p0DataSourceConstants.DATABASE_PRODUCT_NAME));
            //数据库服务器IP
            setIp(getStringValue(dbProperties, C3p0DataSourceConstants.DB_IP));
            //数据库服务器端口
            setPort(getIntegerValue(dbProperties, C3p0DataSourceConstants.DB_PORT));
            //数据库名称
            setDbName(getStringValue(dbProperties, C3p0DataSourceConstants.DB_NAME));
            //数据库用户名
            setUsername(getStringValue(dbProperties, C3p0DataSourceConstants.DB_USERNAME));
            //数据库密码
            setPassword(getStringValue(dbProperties, C3p0DataSourceConstants.DB_PASSWORD));
            //--------------------------------------------------------------------------------
            //初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3
            initialPoolSize = getIntegerValue(dbProperties, C3p0DataSourceConstants.INITIAL_POOL_SIZE);
            //连接池中保留的最大连接数。默认值: 15
            maxPoolSize = getIntegerValue(dbProperties, C3p0DataSourceConstants.MAX_POOL_SIZE);
            //连接池中保留的最小连接数，默认为：3
            minPoolSize = getIntegerValue(dbProperties, C3p0DataSourceConstants.MIN_POOL_SIZE);
            //最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0
            maxIdleTime = getIntegerValue(dbProperties, C3p0DataSourceConstants.MAX_IDLE_TIME);
            //当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
            checkoutTimeout = getIntegerValue(dbProperties, C3p0DataSourceConstants.CHECK_OUT_TIME_OUT);
            //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值:3
            acquireIncrement = getIntegerValue(dbProperties, C3p0DataSourceConstants.ACQUIRE_INCREMENT);
            //定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
            acquireRetryAttempts = getIntegerValue(dbProperties, C3p0DataSourceConstants.ACQUIRE_RETRY_ATTEMPTS);
            //重新尝试的时间间隔，默认为：1000毫秒
            acquireRetryDelay = getIntegerValue(dbProperties, C3p0DataSourceConstants.ACQUIRE_RETRY_DELAY);
            //关闭连接时，是否提交未提交的事务，默认为false，即关闭连接，回滚未提交的事务
            autoCommitOnClose = getBooleanValue(dbProperties, C3p0DataSourceConstants.AUTO_COMMIT_ON_CLOSE);
            //c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。默认值: null
            automaticTestTable = getStringValue(dbProperties, C3p0DataSourceConstants.AUTOMATIC_TEST_TABLE);
            //如果为false，则获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常，但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认: false
            breakAfterAcquireFailure = getBooleanValue(dbProperties, C3p0DataSourceConstants.BREAK_AFTER_ACQUIRE_FAILURE);
            //每600秒检查所有连接池中的空闲连接。默认值: 0，不检查
            idleConnectionTestPeriod = getIntegerValue(dbProperties, C3p0DataSourceConstants.IDLE_CONNECTION_TEST_PERIOD);
            //c3p0全局的PreparedStatements缓存的大小。如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，只要有一个不为0，则语句的缓存就能生效。如果默认值: 0
            maxStatements = getIntegerValue(dbProperties, C3p0DataSourceConstants.MAX_STATEMENTS);
            //maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。默认值: 0
            maxStatementsPerConnection = getIntegerValue(dbProperties, C3p0DataSourceConstants.MAX_STATEMENTS_PER_CONNECTION);
            //因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable等方法来提升连接测试的性能。Default: false testConnectionOnCheckout
            testConnectionOnCheckout = getBooleanValue(dbProperties, C3p0DataSourceConstants.TEST_CONNECTION_ON_CHECKOUT);
            //如果设为true那么在取得连接的同时将校验连接的有效性。Default: false testConnectionOnCheckin
            testConnectionOnCheckin = getBooleanValue(dbProperties, C3p0DataSourceConstants.TEST_CONNECTION_ON_CHECKIN);
            //文件型数据库db文件路径
            dbFilePath = getStringValue(dbProperties, C3p0DataSourceConstants.DB_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.error("解析数据库配置文件失败：" + e.getMessage());
        }
    }

    /**
     * 获取字符串值
     *
     * @param dbProperties 资源配置文件
     * @param paramName    参数名称
     * @return 字符串值
     */
    protected String getStringValue(Properties dbProperties, String paramName) {
        return PropertiesUtil.getStringValue(dbProperties, paramName);
    }

    /**
     * 获取数值型值
     *
     * @param dbProperties 资源配置文件
     * @param paramName    参数名称
     * @return 数值型值
     * @throws BaseException 自定义异常
     */
    protected int getIntegerValue(Properties dbProperties, String paramName) throws BaseException {
        return PropertiesUtil.getIntegerValue(dbProperties, paramName);
    }

    /**
     * 获取boolean类型值
     *
     * @param dbProperties 资源配置文件
     * @param paramName    参数名称
     * @return boolean类型值
     * @throws BaseException 自定义异常
     */
    protected boolean getBooleanValue(Properties dbProperties, String paramName) throws BaseException {
        return PropertiesUtil.getBooleanValue(dbProperties, paramName);
    }

}
