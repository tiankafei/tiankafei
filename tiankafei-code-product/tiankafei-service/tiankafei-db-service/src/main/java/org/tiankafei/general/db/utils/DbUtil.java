package org.tiankafei.general.db.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.tiankafei.web.common.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class DbUtil {

    /**
     * 获取数据库名称
     * @param jdbcTemplate
     * @return
     * @throws DaoException
     */
    public static String getTableSchema(JdbcTemplate jdbcTemplate) throws DaoException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            return connection.getCatalog();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("获取数据库名称发生异常！");
        }
    }

}
