package org.tiankafei.multidatasource.jpa.primary.service;

import java.io.Serializable;
import java.util.Map;
import org.tiankafei.multidatasource.jpa.primary.entity.BlogInfoEntity;

/**
 * <p>
 * 系统的博客数据 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface BlogInfoService {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoEntity getBlogInfoServiceByIdForJpa(Serializable id) throws Exception;

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception;

}
