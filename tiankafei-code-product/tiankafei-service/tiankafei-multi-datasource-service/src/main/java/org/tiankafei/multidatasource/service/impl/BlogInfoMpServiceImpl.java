package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
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
@DS("blog")
public class BlogInfoMpServiceImpl extends BaseServiceImpl<BlogInfoMapper, BlogInfoMpEntity> implements BlogInfoMpService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public BlogInfoMpEntity getBlogInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    public BlogInfoMpEntity getBlogInfoServiceByIdForMapper(Serializable id) throws Exception {
        return blogInfoMapper.getBlogInfoServiceById(id);
    }

}
