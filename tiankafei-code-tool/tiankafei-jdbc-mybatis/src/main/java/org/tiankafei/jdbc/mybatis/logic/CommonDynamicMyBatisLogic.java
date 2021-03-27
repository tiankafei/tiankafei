package org.tiankafei.jdbc.mybatis.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.mybatis.dao.CommonDynamicMyBatisDaoImpl;
import org.tiankafei.jdbc.mybatis.dao.ICommonMyBatisDAO;

/**
 * 公共业务处理类
 *
 * @author tiankafei
 */
public class CommonDynamicMyBatisLogic implements ICommonMyBatisLogic {

    /**
     * mybatis动态DAO对象
     */
    private ICommonMyBatisDAO commonDynamicMyBatisDAO;

    /**
     * 构造公共业务处理类
     */
    public CommonDynamicMyBatisLogic() {
        this(null);
    }

    /**
     * 构造公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    public CommonDynamicMyBatisLogic(String myBatisResource) {
        initCommonDynamicMyBatisLogic(myBatisResource);
    }

    /**
     * 初始化公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    protected void initCommonDynamicMyBatisLogic(String myBatisResource) {
        commonDynamicMyBatisDAO = new CommonDynamicMyBatisDaoImpl(myBatisResource);
    }

    @Override
    public void transactionBegin() {
        commonDynamicMyBatisDAO.transactionBegin();
    }

    @Override
    public void transactionCommit() {
        commonDynamicMyBatisDAO.transactionCommit();
    }

    @Override
    public void transactionRollBack() {
        commonDynamicMyBatisDAO.transactionRollBack();
    }

    @Override
    public String getDbName() {
        return commonDynamicMyBatisDAO.getDbName();
    }

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        return commonDynamicMyBatisDAO.getPaginationSql(sql, currentPage, pageSize);
    }

    @Override
    public Timestamp getCurrentTimestamp() {
        return commonDynamicMyBatisDAO.getCurrentTimestamp();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return commonDynamicMyBatisDAO.getCurrentTimestampSql();
    }

    @Override
    public String getDatabaseProductName() {
        return commonDynamicMyBatisDAO.getDatabaseProductName();
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) {
        return commonDynamicMyBatisDAO.createDatabase(dbFilePath, sqlList);
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDAO.update(sqlParamDTO);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDAO.batchUpdate(sqlParamDTO);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return commonDynamicMyBatisDAO.queryDataMapList(sqlParamDTO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.checkTableExists(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.checkTableExistSql(physicalStorageTableDTO);
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.createTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.createTableSql(physicalStorageTableDTO);
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.dropTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicMyBatisDAO.dropTableSql(physicalStorageTableDTO);
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        return commonDynamicMyBatisDAO.getSqlSessionFactory();
    }

    @Override
    public void openSession(boolean autoCommit) {
        commonDynamicMyBatisDAO.openSession(autoCommit);
    }

    @Override
    public void transactionClose() {
        commonDynamicMyBatisDAO.transactionClose();
    }

    @Override
    public Object getMapper(Class<?> type) {
        return commonDynamicMyBatisDAO.getMapper(type);
    }

    @Override
    public void addMapper(Class<?> type) {
        commonDynamicMyBatisDAO.addMapper(type);
    }

}
