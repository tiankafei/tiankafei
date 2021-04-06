package org.tiankafei.jdbc.mybatis.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
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
     */
    public Timestamp getCurrentTimestamp();

    /**
     * 获取当前时间(sqlite数据库返回的是字符串)
     *
     * @return 当前时间(sqlite数据库返回的是字符串)
     */
    public String getCurrentTimestampSqlite();

    /**
     * 验证物理表是否存在
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 存在返回true，不存在返回false
     */
    public List<PhysicalStorageTableDTO> checkTableExists(PhysicalStorageTableDTO physicalStorageTableDTO);

    /**
     * 创建物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 创建成功返回true，创建失败返回false
     */
    public int createTable(PhysicalStorageTableDTO physicalStorageTableDTO);

    /**
     * 删除物理表
     *
     * @param physicalStorageTableDTO 物理存表对象
     * @return 删除成功返回true，删除失败返回false
     */
    public int dropTable(PhysicalStorageTableDTO physicalStorageTableDTO);

    /**
     * 更新sql
     *
     * @param map 参数
     * @return 更新成功与否
     */
    public int update(Map<String, Object> map);

    /**
     * 查询数据结果集
     *
     * @param map 参数
     * @return 数据结果集
     */
    public List<Map<String, Object>> queryDataMapList(Map<String, Object> map);

}
