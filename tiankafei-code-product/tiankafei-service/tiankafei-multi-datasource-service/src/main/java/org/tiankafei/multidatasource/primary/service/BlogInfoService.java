package org.tiankafei.multidatasource.primary.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.primary.entity.BlogInfoEntity;
import org.tiankafei.web.common.service.BaseService;

/**
 * <p>
 * 系统的博客数据 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface BlogInfoService extends BaseService<BlogInfoEntity> {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoEntity getBlogInfoServiceById(Serializable id) throws Exception;

}
