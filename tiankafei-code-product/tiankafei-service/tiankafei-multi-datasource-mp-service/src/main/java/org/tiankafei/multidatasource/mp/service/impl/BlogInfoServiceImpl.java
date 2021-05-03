package org.tiankafei.multidatasource.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.mp.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.mp.mapper.BlogInfoMapper;
import org.tiankafei.multidatasource.mp.service.BlogInfoService;

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
public class BlogInfoServiceImpl extends BaseServiceImpl<BlogInfoMapper, BlogInfoEntity> implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForMapper(Serializable id) throws Exception {
        return blogInfoMapper.getBlogInfoServiceById(id);
    }

    @Override
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_blog_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if (CollectionUtils.isNotEmpty(dataMapList)) {
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }
        return null;
    }

}
