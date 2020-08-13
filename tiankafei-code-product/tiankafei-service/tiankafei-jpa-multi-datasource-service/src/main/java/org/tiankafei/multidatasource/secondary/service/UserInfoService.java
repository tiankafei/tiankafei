package org.tiankafei.multidatasource.secondary.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.secondary.entity.UserInfoEntity;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoService {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoEntity getUserInfoServiceByIdForJdbc(Serializable id) throws Exception;

}
