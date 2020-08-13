package org.tiankafei.multidatasource.mp.service.impl;

import java.io.Serializable;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.mp.entity.BlogInfoEntity;
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
public class BlogInfoServiceImpl implements BlogInfoService {

    @Override
    public BlogInfoEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception {
        return null;
    }

}
