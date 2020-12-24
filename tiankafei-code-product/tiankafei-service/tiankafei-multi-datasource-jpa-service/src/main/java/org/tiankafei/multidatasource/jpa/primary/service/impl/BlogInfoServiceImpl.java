package org.tiankafei.multidatasource.jpa.primary.service.impl;

import java.io.Serializable;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.jpa.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.jpa.primary.jpa.BlogInfoJpa;
import org.tiankafei.multidatasource.jpa.primary.service.BlogInfoService;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BlogInfoJpa<BlogInfoEntity> blogInfoJpa;

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception {
        return blogInfoJpa.findById(Long.valueOf("" + id)).get();
    }

    @Override
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_blog_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if (CollectionUtils.isNotEmpty(dataMapList)) {
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }

//        jdbcTemplate.query((con) -> {
//            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//
//            // 这里因为MySQL驱动实现使用Integer.MIN_VALUE来判断是否使用流的方式；这两行缺一不可；
//            ps.setFetchSize(Integer.MIN_VALUE);
//
//            // PostgreSql中则需要
//            con.setAutoCommit(false);
//            // 流每一次读取的数据量
//            ps.setFetchSize(1000);
//
//
//            ps.setFetchDirection(ResultSet.FETCH_FORWARD);
//            return ps;
//        }, (rs) -> {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            Map<String, Object> dataMap = Maps.newHashMap();
//            for (int index = 0; index < columnCount; index++) {
//                String columnName = metaData.getColumnName(index);
//                Object value = rs.getObject(columnName);
//                dataMap.put(columnName, value);
//            }
//        });
        return null;
    }

}
