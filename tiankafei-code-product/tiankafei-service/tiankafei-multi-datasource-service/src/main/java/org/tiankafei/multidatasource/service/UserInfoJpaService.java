package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoJpaService {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoJpaEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception;

}
