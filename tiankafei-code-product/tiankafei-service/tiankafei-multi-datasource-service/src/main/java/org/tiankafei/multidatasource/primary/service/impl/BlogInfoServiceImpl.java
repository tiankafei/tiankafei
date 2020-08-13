package org.tiankafei.multidatasource.primary.service.impl;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.primary.mapper.BlogInfoMapper;
import org.tiankafei.multidatasource.primary.service.BlogInfoService;
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
public class BlogInfoServiceImpl extends BaseServiceImpl<BlogInfoMapper, BlogInfoEntity> implements BlogInfoService {

    @Override
    public BlogInfoEntity getBlogInfoServiceById(Serializable id) throws Exception {
        return super.getById(id);
    }

}
