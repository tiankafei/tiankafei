package org.tiankafei.jdbc.mybatis.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.mybatis.dao.CommonMyBatisDaoImpl;

/**
 * 公共业务处理类
 *
 * @author tiankafei
 */
public class CommonMyBatisLogic implements ICommonMyBatisLogic {

    /**
     * mybatis动态DAO对象
     */
    private static CommonMyBatisDaoImpl commonMyBatisDaoImpl;

    /**
     * 构造公共业务处理类
     */
    public CommonMyBatisLogic() {
        this(null);
    }

    /**
     * 构造公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    public CommonMyBatisLogic(String myBatisResource) {
        initCommonMyBatisLogic(myBatisResource);
    }

    /**
     * 初始化公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    protected void initCommonMyBatisLogic(String myBatisResource) {
        if (commonMyBatisDaoImpl == null) {
            commonMyBatisDaoImpl = new CommonMyBatisDaoImpl(myBatisResource);
        }
    }

    @Override
    public void transactionBegin() {
        commonMyBatisDaoImpl.transactionBegin();
    }

    @Override
    public void transactionCommit() {
        commonMyBatisDaoImpl.transactionCommit();
    }

    @Override
    public void transactionRollBack() {
        commonMyBatisDaoImpl.transactionRollBack();
    }

    @Override
    public String getDbName() {
        return commonMyBatisDaoImpl.getDbName();
    }

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        return commonMyBatisDaoImpl.getPaginationSql(sql, currentPage, pageSize);
    }

    @Override
    public Timestamp getCurrentTimestamp() {
        return commonMyBatisDaoImpl.getCurrentTimestamp();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return commonMyBatisDaoImpl.getCurrentTimestampSql();
    }

    @Override
    public String getDatabaseProductName() {
        return commonMyBatisDaoImpl.getDatabaseProductName();
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) {
        return commonMyBatisDaoImpl.createDatabase(dbFilePath, sqlList);
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        return commonMyBatisDaoImpl.update(sqlParamDTO);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        return commonMyBatisDaoImpl.batchUpdate(sqlParamDTO);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return commonMyBatisDaoImpl.queryDataMapList(sqlParamDTO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.checkTableExists(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.checkTableExistSql(physicalStorageTableDTO);
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.createTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.createTableSql(physicalStorageTableDTO);
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.dropTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonMyBatisDaoImpl.dropTableSql(physicalStorageTableDTO);
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        return commonMyBatisDaoImpl.getSqlSessionFactory();
    }

    @Override
    public void openSession(boolean autoCommit) {
        commonMyBatisDaoImpl.openSession(autoCommit);
    }

    @Override
    public void transactionClose() {
        commonMyBatisDaoImpl.transactionClose();
    }

    @Override
    public Object getMapper(Class<?> type) {
        return commonMyBatisDaoImpl.getMapper(type);
    }

    @Override
    public void addMapper(Class<?> type) {
        commonMyBatisDaoImpl.addMapper(type);
    }

}
