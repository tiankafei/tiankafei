package org.tiankafei.jdbc.dao;

import com.google.common.collect.Lists;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.CommonJdbcFactory;
import org.tiankafei.jdbc.constant.DbConfigConstants;
import org.tiankafei.jdbc.datasource.AbstractCreateDataSource;
import org.tiankafei.jdbc.dto.C3p0DataSourceDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * 动态CommonDAO
 *
 * @author tiankafei
 */
public class CommonDynamicDaoImpl implements ICommonDAO {

    /**
     * spring-jdbc连接数据库对象
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * 数据源对象
     */
    private DataSource dataSource;

    /**
     * 数据库连接对象
     */
    private C3p0DataSourceDTO c3p0DataSourceDTO;

    /**
     * 获取公共DAO对象
     */
    private AbstractGeneralDAO generalDAO;

    /**
     * 事物需要
     */
    private PlatformTransactionManager platformTransactionManager;
    /**
     * 事物需要
     */
    private DefaultTransactionDefinition defaultTransactionDefinition;
    /**
     * 事物需要
     */
    private TransactionStatus transactionStatus;

    /**
     * 构造公共数据库操作对象
     */
    public CommonDynamicDaoImpl() {
        this(null);
    }

    /**
     * 构造公共数据库操作对象
     *
     * @param dbPropertis db数据库配置文件
     */
    public CommonDynamicDaoImpl(String dbPropertis) {
        initCommonDynamicDAO(dbPropertis);
    }

    /**
     * 初始化获取数据库连接对象
     *
     * @param dbPropertis db数据库配置文件
     */
    protected void initCommonDynamicDAO(String dbPropertis) {
        c3p0DataSourceDTO = new C3p0DataSourceDTO(dbPropertis);
        generalDAO = CommonJdbcFactory.getGeneralDAO(getDatabaseProductName());
        if (DbConfigConstants.DB_SQLITE.equals(c3p0DataSourceDTO.getProductName())) {
            File file = new File(c3p0DataSourceDTO.getDbFilePath());
            if (!file.exists()) {
                //sqlite数据库文件不存在，则创建
                generalDAO.createDatabase(c3p0DataSourceDTO.getDbFilePath(), Lists.newArrayList(), this);
            }
        }
    }

    /**
     * 开启事物
     */
    @Override
    public void transactionBegin() {
        platformTransactionManager = new DataSourceTransactionManager(getDataSource());
        defaultTransactionDefinition = new DefaultTransactionDefinition();
        transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
    }

    /**
     * 提交事务
     */
    @Override
    public void transactionCommit() {
        platformTransactionManager.commit(transactionStatus);
    }

    /**
     * 回滚事件
     */
    @Override
    public void transactionRollBack() {
        platformTransactionManager.rollback(transactionStatus);
    }

    /**
     * 获取数据库连接
     *
     * @return 返回spring的JdbcTemplate
     */
    @Override
    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return jdbcTemplate;
    }

    /**
     * 获取数据源对象
     *
     * @return 返回DataSource的对象
     */
    @Override
    public DataSource getDataSource() {
        if (dataSource == null) {
            AbstractCreateDataSource createDataSource = CommonJdbcFactory.getCreateDataSource("1");
            dataSource = createDataSource.createDataSource(c3p0DataSourceDTO);
        }
        return dataSource;
    }

    /**
     * 获取数据库名称
     *
     * @return 数据库名称
     */
    @Override
    public String getDbName() {
        return c3p0DataSourceDTO.getDbName();
    }

    /**
     * 获取数据库类型名称
     *
     * @return 数据库类型名称
     */
    @Override
    public String getDatabaseProductName() {
        return c3p0DataSourceDTO.getProductName();
    }

    /**
     * 获取分页sql
     *
     * @param sql         要分页的sql
     * @param currentPage 当前页
     * @param pageSize    每页的记录条数
     * @return 分页sql
     */
    @Override
    public String getPaginationSql(String sql, int currentPage, int pageSize) {
        return generalDAO.getPaginationSql(sql, currentPage, pageSize);
    }

    /**
     * 获取当前Timestamp时间
     *
     * @return 当前Timestamp时间
     */
    @Override
    public Timestamp getCurrentTimestamp() {
        return generalDAO.getCurrentTimestamp(this);
    }

    /**
     * 获取当前Timestamp时间sql
     *
     * @return 当前Timestamp时间sql
     */
    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return generalDAO.getCurrentTimestampSql();
    }

    /**
     * 创建数据库
     *
     * @param dbFilePath 数据库路径
     * @param sqlList    创建数据库的sql集合
     * @return 创建成功返回true, 创建失败返回false
     */
    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) {
        return generalDAO.createDatabase(dbFilePath, sqlList, this);
    }

    /**
     * 更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     */
    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        getJdbcTemplate().update(sqlParamDTO.getSql(), sqlParamDTO.getParamList().toArray());
        return true;
    }

    /**
     * 批量更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     */
    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        List<List<Object>> paramListList = sqlParamDTO.getParamListList();
        getJdbcTemplate().batchUpdate(sqlParamDTO.getSql(), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                List<Object> paramList = paramListList.get(i);
                for (int index = 0, length = paramList.size(); index < length; index++) {
                    preparedStatement.setObject(index + 1, paramList.get(index));
                }
            }

            @Override
            public int getBatchSize() {
                return paramListList.size();
            }
        });
        return true;
    }

    /**
     * 查询数据
     *
     * @param sqlParamDTO SQL参数对象
     * @return 结果集
     */
    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return getJdbcTemplate().queryForList(sqlParamDTO.getSql(), sqlParamDTO.getParamList().toArray());
    }

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     */
    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        SqlParamDTO sqlParamDTO = checkTableExistSql(physicalStorageTableDTO);
        List<?> list = queryDataMapList(sqlParamDTO);
        if (CollectionUtils.isEmpty(list)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     */
    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return generalDAO.checkTableExistsSql(physicalStorageTableDTO);
    }

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     */
    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        SqlParamDTO sqlParamDTO = createTableSql(physicalStorageTableDTO);
        return update(sqlParamDTO);
    }

    /**
     * 获取创建表的sql集合
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建表的sql集合
     */
    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return generalDAO.createTableSql(physicalStorageTableDTO);
    }

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     */
    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        SqlParamDTO sqlParamDTO = dropTableSql(physicalStorageTableDTO);
        return update(sqlParamDTO);
    }

    /**
     * 获取删除表SQL
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除表SQL
     */
    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        //删除表
        String tableName = physicalStorageTableDTO.getTableName();
        StringBuffer sqlBuffer = new StringBuffer().append("DROP TABLE ").append(tableName);
        return new SqlParamDTO(sqlBuffer.toString());
    }

    /**
     * 查询记录总数
     *
     * @param sqlParamDTO SQL参数对象
     * @return 记录总数
     */
    public int queryRecordCount(SqlParamDTO sqlParamDTO) {
        Integer count = getJdbcTemplate().queryForObject(sqlParamDTO.getSql(), sqlParamDTO.getParamList().toArray(), Integer.class);
        return count;
    }

}
