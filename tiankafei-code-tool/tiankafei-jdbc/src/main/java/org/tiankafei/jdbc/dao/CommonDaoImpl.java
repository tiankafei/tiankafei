package org.tiankafei.jdbc.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * 静态CommonDAO
 *
 * @author tiankafei
 */
public class CommonDaoImpl implements ICommonDAO {

    /**
     * 连接数据库对象
     */
    private static ICommonDAO commonDynamicDAO;

    /**
     * 构造公共数据库操作方法对象
     */
    public CommonDaoImpl() {
        this(null);
    }

    /**
     * 构造公共数据库操作方法对象
     *
     * @param dbPropertis db数据库配置文件
     */
    public CommonDaoImpl(String dbPropertis) {
        initCommonDAO(dbPropertis);
    }

    /**
     * 初始化获取数据库连接对象
     *
     * @param dbPropertis db数据库配置文件
     */
    protected void initCommonDAO(String dbPropertis) {
        if (commonDynamicDAO == null) {
            commonDynamicDAO = new CommonDynamicDaoImpl(dbPropertis);
        }
    }

    /**
     * 开启事物
     */
    @Override
    public void transactionBegin() {
        commonDynamicDAO.transactionBegin();
    }

    /**
     * 提交事务
     */
    @Override
    public void transactionCommit() {
        commonDynamicDAO.transactionCommit();
    }

    /**
     * 回滚事件
     */
    @Override
    public void transactionRollBack() {
        commonDynamicDAO.transactionRollBack();
    }

    /**
     * 获取数据库连接
     *
     * @return 返回spring的JdbcTemplate
     */
    @Override
    public JdbcTemplate getJdbcTemplate() {
        return commonDynamicDAO.getJdbcTemplate();
    }

    /**
     * 获取数据源对象
     *
     * @return 返回DataSource的对象
     */
    @Override
    public DataSource getDataSource() {
        return commonDynamicDAO.getDataSource();
    }

    /**
     * 获取数据库名称
     *
     * @return 数据库名称
     */
    @Override
    public String getDbName() {
        return commonDynamicDAO.getDbName();
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
        return commonDynamicDAO.getPaginationSql(sql, currentPage, pageSize);
    }

    /**
     * 获取当前Timestamp时间
     *
     * @return 当前Timestamp时间
     */
    @Override
    public Timestamp getCurrentTimestamp() {
        return commonDynamicDAO.getCurrentTimestamp();
    }

    /**
     * 获取当前Timestamp时间sql
     *
     * @return 当前Timestamp时间sql
     */
    @Override
    public SqlParamDTO getCurrentTimestampSql() {
        return commonDynamicDAO.getCurrentTimestampSql();
    }

    /**
     * 获取数据库类型名称
     *
     * @return 数据库类型名称
     */
    @Override
    public String getDatabaseProductName() {
        return commonDynamicDAO.getDatabaseProductName();
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
        return commonDynamicDAO.createDatabase(dbFilePath, sqlList);
    }

    /**
     * 更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     */
    @Override
    public boolean update(SqlParamDTO sqlParamDTO) {
        return commonDynamicDAO.update(sqlParamDTO);
    }

    /**
     * 批量更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     */
    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) {
        return commonDynamicDAO.batchUpdate(sqlParamDTO);
    }

    /**
     * 查询数据
     *
     * @param sqlParamDTO SQL参数对象
     * @return 结果集
     */
    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) {
        return commonDynamicDAO.queryDataMapList(sqlParamDTO);
    }

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     */
    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.checkTableExists(physicalStorageTableDTO);
    }

    /**
     * 验证物理表是否存在的sql
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 验证物理表是否存在的sql
     */
    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.checkTableExistSql(physicalStorageTableDTO);
    }

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     */
    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.createTable(physicalStorageTableDTO);
    }

    /**
     * 获取创建表的sql集合
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建表的sql集合
     */
    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.createTableSql(physicalStorageTableDTO);
    }

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     */
    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.dropTable(physicalStorageTableDTO);
    }

    /**
     * 获取删除表SQL
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除表SQL
     */
    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) {
        return commonDynamicDAO.dropTableSql(physicalStorageTableDTO);
    }

}
