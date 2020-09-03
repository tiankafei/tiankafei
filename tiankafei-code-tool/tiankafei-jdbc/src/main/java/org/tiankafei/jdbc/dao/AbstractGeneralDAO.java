package org.tiankafei.jdbc.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageColumnDTO;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;

/**
 * 获取公共DAO对象
 *
 * @author tiankafei1
 */
public abstract class AbstractGeneralDAO {

    /**
     * 获取分页sql
     *
     * @param sql         要分页的sql
     * @param currentPage 当前页
     * @param pageSize    每页的记录条数
     * @return 分页sql
     */
    public abstract String getPaginationSql(String sql, int currentPage, int pageSize);

    /**
     * 获取当前Timestamp时间的SQL
     *
     * @return 当前Timestamp时间SQL
     */
    public abstract SqlParamDTO getCurrentTimestampSql();

    /**
     * 获取当前时间
     *
     * @param commonDAO 公共数据库操作方法
     * @return 当前时间
     * @throws BaseException 自定义异常
     */
    public Timestamp getCurrentTimestamp(ICommonDAO commonDAO) throws BaseException {
        try {
            SqlParamDTO sqlParamDTO = getCurrentTimestampSql();
            Timestamp timestamp = (Timestamp) commonDAO.getJdbcTemplate().queryForObject(sqlParamDTO.getSql(), sqlParamDTO.getParamList().toArray(), Timestamp.class);
            return timestamp;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 验证物理表是否存在的SQL
     *
     * @param physicalStorageTableDTO 物理存储表对象
     * @return 存在返回true，不存在返回false
     */
    public abstract SqlParamDTO checkTableExistsSql(PhysicalStorageTableDTO physicalStorageTableDTO);

    /**
     * 获取创建表的sql集合
     *
     * @param physicalStorageTableDTO 物理存储表对象
     * @return 创建表的sql集合
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO createTableSql(PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        List<PhysicalStorageColumnDTO> physicalStorageColumnList = physicalStorageTableDTO.getPhysicalStorageColumnList();
        if (CollectionUtils.isNotEmpty(physicalStorageColumnList)) {
            SqlParamDTO sqlParamDTO = new SqlParamDTO();

            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("CREATE TABLE ").append(physicalStorageTableDTO.getTableName()).append("(");

            String primaryKey = physicalStorageTableDTO.getPrimaryKey();
            for (int index = 0, length = physicalStorageColumnList.size(); index < length; index++) {
                PhysicalStorageColumnDTO physicalStorageColumnDTO = physicalStorageColumnList.get(index);
                //字段名 字段类型 默认值 是否为空
                sqlBuffer.append(packageColumnTypeSql(physicalStorageColumnDTO));
                if (StringUtils.isEmpty(primaryKey) && index == length - 1) {

                } else {
                    sqlBuffer.append(",");
                }
            }
            if (StringUtils.isNotEmpty(primaryKey)) {
                sqlBuffer.append(" PRIMARY KEY (").append(physicalStorageTableDTO.getPrimaryKey()).append(")");
            }

            sqlBuffer.append(")");
            sqlParamDTO.setSql(sqlBuffer.toString());
            return sqlParamDTO;
        } else {
            throw new BaseException(physicalStorageTableDTO.getTableName() + "没有获取到字段信息，请检查！");
        }
    }

    /**
     * 获取字段类型sql
     *
     * @param physicalStorageColumnDTO 字段对象
     * @return 字段类型sql
     * @throws BaseException 自定义异常
     */
    public abstract String packageColumnTypeSql(PhysicalStorageColumnDTO physicalStorageColumnDTO) throws BaseException;

    /**
     * 创建数据库
     *
     * @param dbFilePath 数据库路径
     * @param sqlList    创建数据库的sql集合
     * @param commonDAO  公共数据库操作方法
     * @return 创建成功返回true, 创建失败返回false
     * @throws BaseException 自定义异常
     */
    public boolean createDatabase(String dbFilePath, List<String> sqlList, ICommonDAO commonDAO) throws BaseException {
        throw new BaseException(commonDAO.getDatabaseProductName() + "不支持程序创建数据库！");
    }

}
