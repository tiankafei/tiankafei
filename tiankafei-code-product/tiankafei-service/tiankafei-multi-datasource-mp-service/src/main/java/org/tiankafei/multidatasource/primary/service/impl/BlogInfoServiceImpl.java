package org.tiankafei.multidatasource.primary.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.primary.mapper.BlogInfoMapper;
import org.tiankafei.multidatasource.primary.service.BlogInfoService;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@DS("first")
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BlogInfoEntity getBlogInfoServiceById(Serializable id) throws Exception {
        return null;
    }

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_blog_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if(CollectionUtils.isNotEmpty(dataMapList)){
            Map<String, Object> dataMap = dataMapList.get(0);

            BlogInfoEntity blogInfoEntity = new BlogInfoEntity();
            BeanUtils.populate(blogInfoEntity, dataMap);
            return blogInfoEntity;
        }
        return null;
    }

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForMapper(Serializable id) throws Exception {
        return blogInfoMapper.getBlogInfoServiceById(id);
    }

}
