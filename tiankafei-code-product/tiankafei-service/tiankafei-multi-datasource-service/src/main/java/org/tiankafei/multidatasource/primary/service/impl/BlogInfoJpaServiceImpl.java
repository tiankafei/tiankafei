package org.tiankafei.multidatasource.primary.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.primary.entity.BlogInfoJpaEntity;
import org.tiankafei.multidatasource.primary.jpa.BlogInfoJpa;
import org.tiankafei.multidatasource.primary.service.BlogInfoJpaService;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@DS("blog")
public class BlogInfoJpaServiceImpl implements BlogInfoJpaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BlogInfoJpa<BlogInfoJpaEntity> blogInfoJpa;

    @Override
    public BlogInfoJpaEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception {
        return blogInfoJpa.findById(Long.valueOf("" + id)).get();
    }

    @Override
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_blog_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if(CollectionUtils.isNotEmpty(dataMapList)){
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }
        return null;
    }

}
