package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface BlogJdbcTemplateService {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> getBlogInfoServiceByIdForJdbc(Serializable id) throws Exception;

}
