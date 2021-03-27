package org.tiankafei.jdbc.mybatis.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.jdbc.dto.C3p0DataSourceDTO;
import org.tiankafei.jdbc.util.ConnectionUtil;

/**
 * 公共的mybatis框架数据操作工具类
 *
 * @author tiankafei
 */
public class ConnectionMyBatisUtil {

    /**
     * mybatis的session会话工厂类
     */
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 数据库连接参数对象
     */
    private C3p0DataSourceDTO c3p0DataSourceDTO;

    /**
     * 构造mybatis的session会话工厂类
     */
    public ConnectionMyBatisUtil() {
        this(null);
    }

    /**
     * 构造mybatis的session会话工厂类
     *
     * @param resource mybatis连接数据库的资源文件
     */
    public ConnectionMyBatisUtil(String resource) {
        initGetDatabaseConnectionUtil(resource);
    }

    /**
     * 构造mybatis的session会话工厂类
     *
     * @param driver   连接数据库驱动
     * @param url      连接数据库url
     * @param username 连接数据库的用户名
     * @param password 连接数据库的密码
     */
    public ConnectionMyBatisUtil(String driver, String url, String username, String password) {
        initGetDatabaseConnectionUtil(driver, url, username, password);
    }

    /**
     * 初始化获取数据库连接对象
     *
     * @param resource db数据库配置文件
     */
    protected void initGetDatabaseConnectionUtil(String resource) {
        createCommonMyBatisDAO(resource);
    }

    /**
     * 初始化获取数据库连接对象
     *
     * @param driver   连接数据库驱动
     * @param url      连接数据库url
     * @param username 连接数据库的用户名
     * @param password 连接数据库的密码
     */
    protected void initGetDatabaseConnectionUtil(String driver, String url, String username, String password) {
        createCommonMyBatisDAO(driver, url, username, password);
    }

    /**
     * 初始化公共的由xml创建的MyBatisDAO对象
     *
     * @param resource 资源文件路径
     */
    private void createCommonMyBatisDAO(String resource) {
        if (StringUtils.isEmpty(resource)) {
            throw new CommonException("缺失mybatis配置文件！");
        }
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            c3p0DataSourceDTO = ConnectionUtil.initDatabaseConnectionParamVO(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource());
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("获取资源文件失败！");
        }
    }

    /**
     * 初始化公共的mybatis框架数据操作对象
     *
     * @param driver   数据库驱动
     * @param url      数据库连接URL
     * @param username 用户名
     * @param password 密码
     */
    private void createCommonMyBatisDAO(String driver, String url, String username, String password) {
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        c3p0DataSourceDTO = ConnectionUtil.initDatabaseConnectionParamVO(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource());
    }

    /**
     * 获取数据库连接参数对象
     *
     * @return 数据库连接参数对象
     */
    public C3p0DataSourceDTO getC3p0DataSourceDTO() {
        return c3p0DataSourceDTO;
    }

    /**
     * 获取mybatis的session会话工厂类
     *
     * @return mybatis的session会话工厂类
     */
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
