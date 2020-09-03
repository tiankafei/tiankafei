package org.tiankafei.jdbc.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.dao.CommonDynamicDaoImpl;
import org.tiankafei.jdbc.dao.ICommonDAO;

/**
 * 动态CommonLogic
 *
 * @author tiankafei
 */
public class CommonDynamicLogic implements ICommonLogic {

    /**
     * 数据库连接对象
     */
    private ICommonDAO commonDynamicDAO;

    /**
     * 构造公共业务处理类
     */
    public CommonDynamicLogic() {
        this(null);
    }

    /**
     * 构造公共业务处理类
     *
     * @param dbPropertis 数据库配置文件
     */
    public CommonDynamicLogic(String dbPropertis) {
        initCommonDynamicLogic(dbPropertis);
    }

    /**
     * 初始化公共业务处理类
     *
     * @param dbPropertis 数据库配置文件
     */
    protected void initCommonDynamicLogic(String dbPropertis) {
        commonDynamicDAO = new CommonDynamicDaoImpl(dbPropertis);
    }

    /**
     * 开启事物
     *
     * @throws BaseException 自定义异常
     */
    @Override
    public void transactionBegin() throws BaseException {
        commonDynamicDAO.transactionBegin();
    }

    /**
     * 提交事务
     *
     * @throws BaseException 自定义异常
     */
    @Override
    public void transactionCommit() throws BaseException {
        commonDynamicDAO.transactionCommit();
    }

    /**
     * 回滚事件
     *
     * @throws BaseException 自定义异常
     */
    @Override
    public void transactionRollBack() throws BaseException {
        commonDynamicDAO.transactionRollBack();
    }

    /**
     * 获取数据库名称
     *
     * @return 数据库名称
     */
    @Override
    public String getDbName() throws BaseException {
        return commonDynamicDAO.getDbName();
    }

    /**
     * 获取分页sql
     *
     * @param sql         需要分页的sql
     * @param currentPage 当前页
     * @param pageSize    每页显示的记录数
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
     * @throws BaseException 自定义异常
     */
    @Override
    public Timestamp getCurrentTimestamp() throws BaseException {
        return commonDynamicDAO.getCurrentTimestamp();
    }

    /**
     * 获取当前Timestamp时间sql
     *
     * @return 当前Timestamp时间sql
     * @throws BaseException 自定义异常
     */
    @Override
    public SqlParamDTO getCurrentTimestampSql() throws BaseException {
        return commonDynamicDAO.getCurrentTimestampSql();
    }

    /**
     * 获取数据库类型名称
     *
     * @return 数据库类型名称
     */
    @Override
    public String getDatabaseProductName() throws BaseException {
        return commonDynamicDAO.getDatabaseProductName();
    }

    /**
     * 创建数据库
     *
     * @param dbFilePath 数据库路径
     * @param sqlList    创建数据库的sql集合
     * @return 创建成功返回true, 创建失败返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean createDatabase(String dbFilePath, List<String> sqlList) throws BaseException {
        return commonDynamicDAO.createDatabase(dbFilePath, sqlList);
    }

    /**
     * 更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean update(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicDAO.update(sqlParamDTO);
    }

    /**
     * 批量更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicDAO.batchUpdate(sqlParamDTO);
    }

    /**
     * 查询数据
     *
     * @param sqlParamDTO SQL参数对象
     * @return 结果集
     */
    @Override
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) throws BaseException {
        return commonDynamicDAO.queryDataMapList(sqlParamDTO);
    }

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.checkTableExists(physicalStorageTableDTO);
    }

    /**
     * 验证物理表是否存在的sql
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 验证物理表是否存在的sql
     * @throws BaseException 自定义异常
     */
    @Override
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.checkTableExistSql(physicalStorageTableDTO);
    }

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.createTable(physicalStorageTableDTO);
    }

    /**
     * 获取创建表的sql集合
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建表的sql集合
     * @throws BaseException 自定义异常
     */
    @Override
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.createTableSql(physicalStorageTableDTO);
    }

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     * @throws BaseException 自定义异常
     */
    @Override
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.dropTable(physicalStorageTableDTO);
    }

    /**
     * 获取删除表SQL
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除表SQL
     * @throws BaseException 自定义异常
     */
    @Override
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return commonDynamicDAO.dropTableSql(physicalStorageTableDTO);
    }

}
