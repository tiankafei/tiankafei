package org.tiankafei.jdbc.mybatis.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dto.PhysicalStorageTableDTO;
import org.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO;

/**
 * @author 甜咖啡
 */
public abstract class AbstractGeneralMyBatisDAO {

    /**
     * 创建数据库
     *
     * @param dbFilePath          数据库文件路径
     * @param sqlList             要执行的sql集合
     * @param databaseProductName 数据库类型名称
     * @return 创建数据库成功与否
     * @throws BaseException 自定义异常
     */
    public boolean createDatabase(String dbFilePath, List<String> sqlList, String databaseProductName) throws BaseException {
        throw new BaseException(databaseProductName + "不支持程序创建数据库！");
    }

    /**
     * 获取当前时间
     *
     * @param commonMyBatisMapperDAO mybatis执行数据库的对象
     * @return 当前时间
     * @throws BaseException 自定义异常
     */
    public Timestamp getCurrentTimestamp(ICommonMyBatisMapperDAO commonMyBatisMapperDAO) throws BaseException {
        return commonMyBatisMapperDAO.getCurrentTimestamp();
    }

    /**
     * 获取当前时间
     *
     * @param sqlSessionFactory mybatis的sqlSessionFactory对象
     * @return 获取当前时间的sql执行对象
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO getCurrentTimestampSql(SqlSessionFactory sqlSessionFactory) throws BaseException {
        return getMapperSql(sqlSessionFactory, null, "getCurrentTimestamp");
    }

    /**
     * 验证物理表是否存在
     *
     * @param sqlSessionFactory       mybatis的sqlSessionFactory对象
     * @param physicalStorageTableDTO 物理表对象
     * @return 验证物理表是否存在的sql执行对象
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO checkTableExistSql(SqlSessionFactory sqlSessionFactory, PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return getMapperSql(sqlSessionFactory, physicalStorageTableDTO, "checkTableExists");
    }

    /**
     * 创建物理表SQL
     *
     * @param sqlSessionFactory       mybatis的sqlSessionFactory对象
     * @param physicalStorageTableDTO 物理表对象
     * @return 创建物理表SQL
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO createTableSql(SqlSessionFactory sqlSessionFactory, PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return getMapperSql(sqlSessionFactory, physicalStorageTableDTO, "createTable");
    }

    /**
     * 删除物理表SQL
     *
     * @param sqlSessionFactory       mybatis的sqlSessionFactory对象
     * @param physicalStorageTableDTO 物理表对象
     * @return 删除物理表SQL
     * @throws BaseException 自定义异常
     */
    public SqlParamDTO dropTableSql(SqlSessionFactory sqlSessionFactory, PhysicalStorageTableDTO physicalStorageTableDTO) throws BaseException {
        return getMapperSql(sqlSessionFactory, physicalStorageTableDTO, "dropTable");
    }

    /**
     * 获取mybatis执行期间sql
     *
     * @param sqlSessionFactory mybatis的sql工厂类
     * @param object            参数对象
     * @param methodName        执行的放方法名
     * @return mybatis执行期间sql
     * @throws BaseException 自定义异常
     */
    protected SqlParamDTO getMapperSql(SqlSessionFactory sqlSessionFactory, Object object, String methodName) throws BaseException {
        try {
            SqlParamDTO sqlParamDTO = new SqlParamDTO();

            String id = "com.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO." + methodName;
            String sql = sqlSessionFactory.getConfiguration().getMappedStatement(id).getBoundSql(object).getSql();
            sql = sql.replaceAll("\t", " ").replaceAll("\n", " ").replaceAll("          ", " ").replaceAll("     ", " ").replaceAll("    ", " ").replaceAll("  ", " ");

            sqlParamDTO.setSql(sql);
            return sqlParamDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

}
