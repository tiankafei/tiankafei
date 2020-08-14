package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.primary.entity.BlogInfoJpaEntity;

/**
 * <p>
 * 系统的博客数据 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface BlogInfoJpaService {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoJpaEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception;

}
