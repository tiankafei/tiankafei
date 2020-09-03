package org.tiankafei.jdbc.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * @author 甜咖啡
 */
public interface ICommonLogic {

    /**
     * 开启事物
     *
     * @throws BaseException 自定义异常
     */
    public void transactionBegin() throws BaseException;

    /**
     * 提交事务
     *
     * @throws BaseException 自定义异常
     */
    public void transactionCommit() throws BaseException;

    /**
     * 回滚事件
     *
     * @throws BaseException 自定义异常
     */
    public void transactionRollBack() throws BaseException;

    /**
     * 获取数据库名称
     *
     * @return 数据库名称
     * @throws BaseException 自定义异常
     */
    public String getDbName() throws BaseException;

    /**
     * 获取分页sql
     *
     * @param sql         需要分页的sql
     * @param currentPage 当前页
     * @param pageSize    每页显示的记录数
     * @return 分页sql
     */
    public String getPaginationSql(String sql, int currentPage, int pageSize);

    /**
     * 获取当前Timestamp时间
     *
     * @return 当前Timestamp时间
     * @throws BaseException 自定义异常
     */
    public Timestamp getCurrentTimestamp() throws BaseException;

    /**
     * 获取当前Timestamp时间sql
     *
     * @return 当前Timestamp时间sql
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO getCurrentTimestampSql() throws BaseException;

    /**
     * 获取数据库类型名称
     *
     * @return 数据库类型名称
     * @throws BaseException 自定义异常
     */
    public String getDatabaseProductName() throws BaseException;

    /**
     * 创建数据库
     *
     * @param dbFilePath 数据库路径
     * @param sqlList    创建数据库的sql集合
     * @return 创建成功返回true, 创建失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean createDatabase(String dbFilePath, List<String> sqlList) throws BaseException;

    /**
     * 更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean update(SqlParamDTO sqlParamDTO) throws BaseException;

    /**
     * 批量更新
     *
     * @param sqlParamDTO SQL参数对象
     * @return 更新成功返回true, 更新失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean batchUpdate(SqlParamDTO sqlParamDTO) throws BaseException;

    /**
     * 查询数据
     *
     * @param sqlParamDTO SQL参数对象
     * @return 结果集
     * @throws BaseException 自定义异常
     */
    public List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO) throws BaseException;

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     * @throws BaseException 自定义异常
     */
    public boolean checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 验证物理表是否存在的sql
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 验证物理表是否存在的sql
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO checkTableExistSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean createTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 获取创建表的sql集合
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建表的sql集合
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 获取删除表SQL
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除表SQL
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO dropTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

}
