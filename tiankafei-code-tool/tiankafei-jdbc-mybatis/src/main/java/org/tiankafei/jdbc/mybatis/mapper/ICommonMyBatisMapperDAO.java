package org.tiankafei.jdbc.mybatis.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * MyBatis的公共DAO层接口
 *
 * @author tiankafei1
 */
public interface ICommonMyBatisMapperDAO {

    /**
     * 获取分页sql
     *
     * @param map 参数
     * @return 分页sql
     */
    public String getPaginationSql(Map<String, Object> map);

    /**
     * 获取当前时间
     *
     * @return 当前时间
     * @throws BaseException 自定义异常
     */
    public Timestamp getCurrentTimestamp() throws BaseException;

    /**
     * 获取当前时间(sqlite数据库返回的是字符串)
     *
     * @return 当前时间(sqlite数据库返回的是字符串)
     * @throws BaseException 自定义异常
     */
    public String getCurrentTimestampSqlite() throws BaseException;

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     * @throws BaseException 自定义异常
     */
    public List<PhysicalStorageTableDTO> checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     * @throws BaseException 自定义异常
     */
    public int createTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     * @throws BaseException 自定义异常
     */
    public int dropTable(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException;

    /**
     * 更新sql
     *
     * @param map 参数
     * @return 更新成功与否
     * @throws BaseException 自定义异常
     */
    public int update(Map<String, Object> map) throws BaseException;

    /**
     * 查询数据结果集
     *
     * @param map 参数
     * @return 数据结果集
     * @throws BaseException 自定义异常
     */
    public List<Map<String, Object>> queryDataMapList(Map<String, Object> map) throws BaseException;

}
