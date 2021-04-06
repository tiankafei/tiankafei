package org.tiankafei.web.common.service.impl;

import com.ruoyi.common.core.exception.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class QueryDbNameService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getDbName() throws DaoException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            return connection.getCatalog();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("获取数据库名发生异常");
        }
    }

}
