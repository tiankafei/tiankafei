package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.entity.BlogInfoMpEntity;
import org.tiankafei.web.common.service.BaseService;

/**
 * <p>
 * 系统的博客数据 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface BlogInfoMpService extends BaseService<BlogInfoMpEntity> {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoMpEntity getBlogInfoServiceByIdForMp(Serializable id) throws Exception;

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoMpEntity getBlogInfoServiceByIdForMapper(Serializable id) throws Exception;

}
