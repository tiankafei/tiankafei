package org.tiankafei.jdbc.mybatis.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.C3p0DataSourceDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.mybatis.CommonMybatisFactory;
import org.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO;
import org.tiankafei.jdbc.mybatis.util.ConnectionMyBatisUtil;
import org.tiankafei.jdbc.mybatis.util.MyBatisGeneralSqlUtil;

/**
 * mybatis动态DAO对象
 *
 * @author 甜咖啡
 */
public class CommonDynamicMyBatisDaoImpl implements ICommonMyBatisDAO {

    /**
     * mybatis的session会话工厂类
     */
    private SqlSessionFactory sqlSessionFactory;

    /**
     * mybatis的session会话
     */
    private SqlSession sqlSession;

    /**
     * 数据库连接参数对象
     */
    private C3p0DataSourceDTO c3p0DataSourceDTO;

    /**
     * 通用mybatis数据层对象
     */
    private AbstractGeneralMyBatisDAO generalMyBatisDAO;

    /**
     * mybatis数据源mapper
     */
    private ICommonMyBatisMapperDAO commonMyBatisMapperDAO;

    /**
     * 构造mybatis动态DAO对象
     */
    public CommonDynamicMyBatisDaoImpl() {
        this(null);
    }

    /**
     * 构造mybatis动态DAO对象
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    public CommonDynamicMyBatisDaoImpl(String myBatisResource) {
        initCommonDynamicMyBatisDAO(myBatisResource);
    }

    /**
     * 初始化mybatis动态DAO对象
     *
     * @param myBatisResource mybatis连接数据库的资源文件
     */
    protected void initCommonDynamicMyBatisDAO(String myBatisResource) {
        ConnectionMyBatisUtil connectionMyBatisUtil = new ConnectionMyBatisUtil(myBatisResource);
        sqlSessionFactory = connectionMyBatisUtil.getSqlSessionFactory();
        c3p0DataSourceDTO = connectionMyBatisUtil.getC3p0DataSourceDTO();
        generalMyBatisDAO = CommonMybatisFactory.getAbstractGeneralMyBatisDAO(getDatabaseProductName());
        openSession(true);
        commonMyBatisMapperDAO = (ICommonMyBatisMapperDAO) getMapper(ICommonMyBatisMapperDAO.class);
    }

    @Override
    public void transactionBegin() {
        openSession(false);
    }

    @Override
    public void transactionCommit() {
        sqlSession.commit();
    }

    @Override
    public void transactionRollBack() {
        sqlSession.rollback();
    }

    @Override
    public void transactionClose() {
        sqlSession.close();
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Override
    public void openSession(boolean autoCommit) {
        sqlSession = sqlSessionFactory.openSession(autoCommit);
    }

    @Override
    public Object getMapper(Class<?> type) {
        return sqlSession.getMapper(type);
    }

    @Override
    public void addMapper(Class<?> type) {
        sqlSessionFactory.getConfiguration().addMapper(type);
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return null;
    }

    @Override
    public String getDbName() {
        return c3p0DataSourceDTO.getDbName();
    }

    @Override
    public String getDatabaseProductName() {
        return c3p0DataSourceDTO.getProductName();
    }

    @Override
    public Timestamp getCurrentTimestamp() {
        return generalMyBatisDAO.getCurrentTimestamp(commonMyBatisMapperDAO);
    }

    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) {
        return generalMyBatisDAO.createDatabase(dbFilePath, sqlList, getDatabaseProductName());
    }

    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        return MyBatisGeneralSqlUtil.executeUpdateSql(sqlParamDTO, commonMyBatisMapperDAO, this);
    }

    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        return MyBatisGeneralSqlUtil.executeBatchUpdateSql(sqlParamDTO, commonMyBatisMapperDAO, this);
    }

    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return MyBatisGeneralSqlUtil.queryDataMapList(sqlParamDTO, commonMyBatisMapperDAO);
    }

    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        List<PhysicalStorageTableDTO> physicalStorageTableList = commonMyBatisMapperDAO.checkTableExists(physicalStorageTableDTO);
        if (CollectionUtils.isNotEmpty(physicalStorageTableList)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        commonMyBatisMapperDAO.createTable(physicalStorageTableDTO);
        return true;
    }

    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        commonMyBatisMapperDAO.dropTable(physicalStorageTableDTO);
        return true;
    }

    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("sql", sql);
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        return commonMyBatisMapperDAO.getPaginationSql(map);
    }

    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return generalMyBatisDAO.getCurrentTimestampSql(sqlSessionFactory);
    }

    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return generalMyBatisDAO.checkTableExistSql(sqlSessionFactory, physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return generalMyBatisDAO.createTableSql(sqlSessionFactory, physicalStorageTableDTO);
    }

    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return generalMyBatisDAO.dropTableSql(sqlSessionFactory, physicalStorageTableDTO);
    }

}
