package org.tiankafei.multidatasource.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.primary.jpa.BlogInfoJpa;
import org.tiankafei.multidatasource.primary.entity.BlogInfoJpaEntity;
import org.tiankafei.multidatasource.service.BlogInfoJpaService;

/**
 * <p>
 * 系统的博客数据 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class BlogInfoJpaServiceImpl implements BlogInfoJpaService {

    @Autowired
    private BlogInfoJpa<BlogInfoJpaEntity> blogInfoJpa;

    @Override
    public BlogInfoJpaEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception {
        return blogInfoJpa.findById(Long.valueOf("" + id)).get();
    }

}
