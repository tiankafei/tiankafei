package org.tiankafei.jdbc.mybatis.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * mybatis动态DAO对象
 *
 * @author 甜咖啡
 */
public class CommonMyBatisDaoImpl implements ICommonMyBatisDAO {

    private static CommonDynamicMyBatisDaoImpl commonDynamicMyBatisDaoImpl;

    /**
     * 构造mybatis动态DAO对象
     */
    public CommonMyBatisDaoImpl() {
        this(null);
    }

    /**
     * 构造mybatis动态DAO对象
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    public CommonMyBatisDaoImpl(String myBatisResource) {
        initCommonDynamicMyBatisDAO(myBatisResource);
    }

    /**
     * 初始化mybatis动态DAO对象
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    protected void initCommonDynamicMyBatisDAO(String myBatisResource) {
        if (commonDynamicMyBatisDaoImpl == null) {
            commonDynamicMyBatisDaoImpl = new CommonDynamicMyBatisDaoImpl(myBatisResource);
        }
    }

    @Override
    public void transactionBegin() {
        openSession(false);
    }

    @Override
    public void transactionCommit() {
        commonDynamicMyBatisDaoImpl.transactionCommit();
    }

    @Override
    public void transactionRollBack() {
        commonDynamicMyBatisDaoImpl.transactionRollBack();
    }

    @Override
    public void transactionClose() {
        commonDynamicMyBatisDaoImpl.transactionClose();
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        return commonDynamicMyBatisDaoImpl.getSqlSessionFactory();
    }

    @Override
    public void openSession(boolean autoCommit) {
        commonDynamicMyBatisDaoImpl.openSession(autoCommit);
    }

    @Override
    public Object getMapper(Class<?> type) {
        return commonDynamicMyBatisDaoImpl.getMapper(type);
    }

    @Override
    public void addMapper(Class<?> type) {
        commonDynamicMyBatisDaoImpl.addMapper(type);
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return commonDynamicMyBatisDaoImpl.getJdbcTemplate();
    }

    @Override
    public DataSource getDataSource() {
        return commonDynamicMyBatisDaoImpl.getDataSource();
    }

    @Override
    public String getDbName() {
        return commonDynamicMyBatisDaoImpl.getDbName();
    }

    @Override
    public String getDatabaseProductName() {
        return commonDynamicMyBatisDaoImpl.getDatabaseProductName();
    }

    @Override
    public Timestamp getCurrentTimestamp() {
        return commonDynamicMyBatisDaoImpl.getCurrentTimestamp();
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) {
        return commonDynamicMyBatisDaoImpl.createDatabase(dbFilePath, sqlList);
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDaoImpl.update(sqlParamDTO);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDaoImpl.batchUpdate(sqlParamDTO);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDaoImpl.queryDataMapList(sqlParamDTO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.checkTableExists(physicalStorageTableDTO);
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.createTable(physicalStorageTableDTO);
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.dropTable(physicalStorageTableDTO);
    }

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        return commonDynamicMyBatisDaoImpl.getPaginationSql(sql, currentPage, pageSize);
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return commonDynamicMyBatisDaoImpl.getCurrentTimestampSql();
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.checkTableExistSql(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.createTableSql(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDaoImpl.dropTableSql(physicalStorageTableDTO);
    }

}
