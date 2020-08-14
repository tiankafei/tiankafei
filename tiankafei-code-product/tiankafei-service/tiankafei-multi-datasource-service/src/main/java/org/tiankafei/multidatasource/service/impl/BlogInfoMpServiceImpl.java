package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.entity.BlogInfoMpEntity;
import org.tiankafei.multidatasource.mapper.BlogInfoMapper;
import org.tiankafei.multidatasource.service.BlogInfoMpService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class BlogInfoMpServiceImpl extends BaseServiceImpl<BlogInfoMapper, BlogInfoMpEntity> implements BlogInfoMpService {

    @Autowired
    private DynamicDataSourceAutoConfiguration dynamicDataSourceAutoConfiguration;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @DS("blog")
    public BlogInfoMpEntity getBlogInfoServiceByIdForMp(Serializable id) throws Exception {
        System.out.println(dynamicDataSourceAutoConfiguration);
        return super.getById(id);
    }

    @Override
    @DS("blog")
    public BlogInfoMpEntity getBlogInfoServiceByIdForMapper(Serializable id) throws Exception {
        System.out.println(dynamicDataSourceAutoConfiguration);
        return blogInfoMapper.getBlogInfoServiceById(id);
    }

    @Override
    @DS("blog")
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        System.out.println(dynamicDataSourceAutoConfiguration);
        String sql = "select * from sys_blog_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if(CollectionUtils.isNotEmpty(dataMapList)){
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }
        return null;
    }

}
