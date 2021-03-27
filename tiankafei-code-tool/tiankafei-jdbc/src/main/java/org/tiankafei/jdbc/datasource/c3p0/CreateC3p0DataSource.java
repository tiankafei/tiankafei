package org.tiankafei.jdbc.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import org.tiankafei.common.exceptions.BaseException;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.jdbc.constant.DbConfigConstants;
import org.tiankafei.jdbc.datasource.AbstractCreateDataSource;
import org.tiankafei.jdbc.dto.C3p0DataSourceDTO;
import org.tiankafei.jdbc.dto.DataSourceDTO;

/**
 * 创建c3p0数据源
 *
 * @author 甜咖啡
 */
public class CreateC3p0DataSource extends AbstractCreateDataSource {

    @Override
    public DataSource createDataSource(DataSourceDTO dataSourceDTO) {
        try {
            C3p0DataSourceDTO c3p0DataSourceDTO = (C3p0DataSourceDTO) dataSourceDTO;
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            //设置用户名
            comboPooledDataSource.setUser(c3p0DataSourceDTO.getUsername());
            //设置密码
            comboPooledDataSource.setPassword(c3p0DataSourceDTO.getPassword());
            String ip = c3p0DataSourceDTO.getIp();
            int port = c3p0DataSourceDTO.getPort();
            String name = c3p0DataSourceDTO.getDbName();
            String jdbcUrl = "";
            String driver = "";
            if (DbConfigConstants.DB_ORACLE.equals(c3p0DataSourceDTO.getProductName())) {
                jdbcUrl = DbConfigConstants.DB_DRIVER_ORACLE_PREFIX + ip + ":" + port + ":" + name;
                driver = DbConfigConstants.DB_DRIVER_ORACLE;
            } else if (DbConfigConstants.DB_MYSQL.equals(c3p0DataSourceDTO.getProductName())) {
                jdbcUrl = DbConfigConstants.DB_DRIVER_MYSQL_PREFIX + ip + ":" + port + "/" + name + "?useSSL=false";
                driver = DbConfigConstants.DB_DRIVER_MYSQL;
            } else if (DbConfigConstants.DB_SQLITE.equals(c3p0DataSourceDTO.getProductName())) {
                jdbcUrl = DbConfigConstants.DB_DRIVER_SQLITE_PREFIX + c3p0DataSourceDTO.getDbFilePath();
                driver = DbConfigConstants.DB_DRIVER_SQLITE;
            }
            if (jdbcUrl == null || driver == null) {
                throw new BaseException(c3p0DataSourceDTO.getProductName() + "不支持当前数据库！");
            }
            //连接
            comboPooledDataSource.setJdbcUrl(jdbcUrl);
            //驱动
            comboPooledDataSource.setDriverClass(driver);
            //--------------------------------------------------------------------
            //初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3
            comboPooledDataSource.setInitialPoolSize(c3p0DataSourceDTO.getInitialPoolSize());
            //连接池中保留的最大连接数。默认值: 15
            comboPooledDataSource.setMaxPoolSize(c3p0DataSourceDTO.getMaxPoolSize());
            //连接池中保留的最小连接数，默认为：3
            comboPooledDataSource.setMinPoolSize(c3p0DataSourceDTO.getMinPoolSize());
            //最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0
            comboPooledDataSource.setMaxIdleTime(c3p0DataSourceDTO.getMaxIdleTime());
            //当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
            comboPooledDataSource.setCheckoutTimeout(c3p0DataSourceDTO.getCheckoutTimeout());
            //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值:3
            comboPooledDataSource.setAcquireIncrement(c3p0DataSourceDTO.getAcquireIncrement());
            //定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
            comboPooledDataSource.setAcquireRetryAttempts(c3p0DataSourceDTO.getAcquireRetryAttempts());
            //重新尝试的时间间隔，默认为：1000毫秒
            comboPooledDataSource.setAcquireRetryDelay(c3p0DataSourceDTO.getAcquireRetryDelay());
            //关闭连接时，是否提交未提交的事务，默认为false，即关闭连接，回滚未提交的事务
            comboPooledDataSource.setAutoCommitOnClose(c3p0DataSourceDTO.getAutoCommitOnClose());
            //c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。默认值: null
            comboPooledDataSource.setAutomaticTestTable(c3p0DataSourceDTO.getAutomaticTestTable());
            //如果为false，则获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常，但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认: false
            comboPooledDataSource.setBreakAfterAcquireFailure(c3p0DataSourceDTO.getBreakAfterAcquireFailure());
            //每600秒检查所有连接池中的空闲连接。默认值: 0，不检查
            comboPooledDataSource.setIdleConnectionTestPeriod(c3p0DataSourceDTO.getIdleConnectionTestPeriod());
            //c3p0全局的PreparedStatements缓存的大小。如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，只要有一个不为0，则语句的缓存就能生效。如果默认值: 0
            comboPooledDataSource.setMaxStatements(c3p0DataSourceDTO.getMaxStatements());
            //maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。默认值: 0
            comboPooledDataSource.setMaxStatementsPerConnection(c3p0DataSourceDTO.getMaxStatementsPerConnection());
            //因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable等方法来提升连接测试的性能。Default: false testConnectionOnCheckout
            comboPooledDataSource.setTestConnectionOnCheckout(c3p0DataSourceDTO.getTestConnectionOnCheckout());
            //如果设为true那么在取得连接的同时将校验连接的有效性。Default: false testConnectionOnCheckin
            comboPooledDataSource.setTestConnectionOnCheckin(c3p0DataSourceDTO.getTestConnectionOnCheckin());
            DataSource dataSource = comboPooledDataSource;
            return dataSource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("创建c3p0数据库连接失败");
        }
    }

}
