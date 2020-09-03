package org.tiankafei.jdbc.mybatis.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.dao.ICommonDAO;
import org.tiankafei.jdbc.mybatis.mapper.ICommonMyBatisMapperDAO;

/**
 * @author 甜咖啡
 */
public class MyBatisGeneralSqlUtil {

    /**
     * 查询数据结果集
     *
     * @param sqlParamDTO            sql参数对象
     * @param commonMyBatisMapperDAO mybatis接口对象
     * @return 数据结果集
     * @throws BaseException 自定义异常
     */
    public static List<Map<String, Object>> queryDataMapList(SqlParamDTO sqlParamDTO, ICommonMyBatisMapperDAO commonMyBatisMapperDAO) throws BaseException {
        String sql = getSql(sqlParamDTO);
        int length = sqlParamDTO.getParamList().size();
        Map<String, Object> map = new HashMap<String, Object>(length + 1);
        map.put("sql", sql);

        for (int i = 0; i < length; i++) {
            map.put(i + "", sqlParamDTO.getParamList().get(i));
        }
        List<Map<String, Object>> dataMapList = commonMyBatisMapperDAO.queryDataMapList(map);
        return dataMapList;
    }

    /**
     * mybatis直接操作sql
     *
     * @param sqlParamDTO            sql参数对象
     * @param commonMyBatisMapperDAO mybatis接口对象
     * @param commonDAO              dao层处理对象
     * @return 操作成功与否
     * @throws BaseException 自定义异常
     */
    public static boolean executeUpdateSql(SqlParamDTO sqlParamDTO, ICommonMyBatisMapperDAO commonMyBatisMapperDAO, ICommonDAO commonDAO) throws BaseException {
        String sql = getSql(sqlParamDTO);
        int length = sqlParamDTO.getParamList().size();
        Map<String, Object> map = new HashMap<String, Object>(length + 1);
        map.put("sql", sql);

        List<Object> paramList = sqlParamDTO.getParamList();
        for (int paramIndex = 0; paramIndex < length; paramIndex++) {
            map.put(paramIndex + "", paramList.get(paramIndex));
        }
        int count = commonMyBatisMapperDAO.update(map);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * mybatis直接批量操作sql
     *
     * @param sqlParamDTO            sql参数对象
     * @param commonMyBatisMapperDAO mybatis接口对象
     * @param commonDAO              dao层处理对象
     * @return 操作成功与否
     * @throws BaseException 自定义异常
     */
    public static boolean executeBatchUpdateSql(SqlParamDTO sqlParamDTO, ICommonMyBatisMapperDAO commonMyBatisMapperDAO, ICommonDAO commonDAO) throws BaseException {
        String sql = getSql(sqlParamDTO);
        boolean flag = true;

        for (int index = 0, length = sqlParamDTO.getParamListList().size(); index < length; index++) {
            List<Object> paramList = sqlParamDTO.getParamListList().get(index);
            int paramLength = paramList.size();
            Map<String, Object> map = new HashMap<String, Object>(length + 1);
            map.put("sql", sql);

            for (int paramIndex = 0; paramIndex < paramLength; paramIndex++) {
                map.put(paramIndex + "", paramList.get(paramIndex));
            }

            int count = commonMyBatisMapperDAO.update(map);
            if (count > 0) {
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 获取mybatis执行的SQL
     *
     * @param sqlParamDTO sql参数对象
     * @return mybatis执行的SQL
     */
    private static String getSql(SqlParamDTO sqlParamDTO) throws BaseException {
        String str = "?";
        if (!sqlParamDTO.getSql().contains(str)) {
            return sqlParamDTO.getSql();
        }
        ///
//        int index = 0;
//        String sql = new String(sqlParamDTO.getSql());
//        while (sql.contains(str)) {
//            int columnType = paramTypeList.get(index);
//            switch (columnType) {
//                case ColumnNameConstants.COLUMN_TYPE_CHAR:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=CHAR}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_VARCHAR:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=VARCHAR}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_INTEGER:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=INTEGER}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_NUMBER:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=INTEGER}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_TIMESTAMP:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=TIMESTAMP}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_CLOB:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=CLOB}");
//                    break;
//                case ColumnNameConstants.COLUMN_TYPE_BLOB:
//                    sql = sql.replaceFirst("\\?", "#{" + index + ", jdbcType=BLOB}");
//                    break;
//                default:
//                    break;
//            }
//            index++;
//        }
        return sqlParamDTO.getSql();
    }

}
