package org.tiankafei.jdbc.mybatis.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
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
     *
     * @throws BaseException 自定义异常
     */
    public CommonMyBatisLogic() throws BaseException {
        this(null);
    }

    /**
     * 构造公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     * @throws BaseException 自定义异常
     */
    public CommonMyBatisLogic(String myBatisResource) throws BaseException {
        initCommonMyBatisLogic(myBatisResource);
    }

    /**
     * 初始化公共业务处理类
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     * @throws BaseException 自定义异常
     */
    protected void initCommonMyBatisLogic(String myBatisResource) throws BaseException {
        if (commonMyBatisDaoImpl == null) {
            commonMyBatisDaoImpl = new CommonMyBatisDaoImpl(myBatisResource);
        }
    }

    @Override
    public void transactionBegin() throws BaseException {
        commonMyBatisDaoImpl.transactionBegin();
    }

    @Override
    public void transactionCommit() throws BaseException {
        commonMyBatisDaoImpl.transactionCommit();
    }

    @Override
    public void transactionRollBack() throws BaseException {
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
    public Timestamp getCurrentTimestamp() throws BaseException {
        return commonMyBatisDaoImpl.getCurrentTimestamp();
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() throws BaseException {
        return commonMyBatisDaoImpl.getCurrentTimestampSql();
    }

    @Override
    public String getDatabaseProductName() {
        return commonMyBatisDaoImpl.getDatabaseProductName();
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) throws BaseException {
        return commonMyBatisDaoImpl.createDatabase(dbFilePath, sqlList);
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonMyBatisDaoImpl.update(sqlParamDTO);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonMyBatisDaoImpl.batchUpdate(sqlParamDTO);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonMyBatisDaoImpl.queryDataMapList(sqlParamDTO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonMyBatisDaoImpl.checkTableExists(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonMyBatisDaoImpl.checkTableExistSql(physicalStorageTableDTO);
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonMyBatisDaoImpl.createTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonMyBatisDaoImpl.createTableSql(physicalStorageTableDTO);
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonMyBatisDaoImpl.dropTable(physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
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
    public void transactionClose() throws BaseException {
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
