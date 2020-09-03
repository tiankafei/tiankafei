package org.tiankafei.jdbc.mybatis.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
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
     *
     * @throws BaseException 自定义异常
     */
    public CommonDynamicMyBatisLogic() throws BaseException {
        this(null);
    }

    /**
     * 构造公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     * @throws BaseException 自定义异常
     */
    public CommonDynamicMyBatisLogic(String myBatisResource) throws BaseException {
        initCommonDynamicMyBatisLogic(myBatisResource);
    }

    /**
     * 初始化公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     * @throws BaseException 自定义异常
     */
    protected void initCommonDynamicMyBatisLogic(String myBatisResource) throws BaseException {
        commonDynamicMyBatisDAO = new CommonDynamicMyBatisDaoImpl(myBatisResource);
    }

    @Override
    public void transactionBegin() throws BaseException {
        commonDynamicMyBatisDAO.transactionBegin();
    }

    @Override
    public void transactionCommit() throws BaseException {
        commonDynamicMyBatisDAO.transactionCommit();
    }

    @Override
    public void transactionRollBack() throws BaseException {
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
    public Timestamp getCurrentTimestamp() throws BaseException {
        return commonDynamicMyBatisDAO.getCurrentTimestamp();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() throws BaseException {
        return commonDynamicMyBatisDAO.getCurrentTimestampSql();
    }

    @Override
    public String getDatabaseProductName() throws BaseException {
        return commonDynamicMyBatisDAO.getDatabaseProductName();
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) throws BaseException {
        return commonDynamicMyBatisDAO.createDatabase(dbFilePath, sqlList);
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicMyBatisDAO.update(sqlParamDTO);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicMyBatisDAO.batchUpdate(sqlParamDTO);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicMyBatisDAO.queryDataMapList(sqlParamDTO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicMyBatisDAO.checkTableExists(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicMyBatisDAO.checkTableExistSql(physicalStorageTableDTO);
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicMyBatisDAO.createTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicMyBatisDAO.createTableSql(physicalStorageTableDTO);
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicMyBatisDAO.dropTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
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
    public void transactionClose() throws BaseException {
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
