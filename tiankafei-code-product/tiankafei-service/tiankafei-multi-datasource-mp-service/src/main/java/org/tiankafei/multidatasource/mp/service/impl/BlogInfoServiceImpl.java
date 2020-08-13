package org.tiankafei.multidatasource.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForMp(Serializable id) throws Exception {
        return blogInfoMapper.getBlogInfoServiceById(id);
    }

    @Override
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        return null;
    }

}
