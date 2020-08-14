package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface UserJdbcTemplateService {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception;

}
