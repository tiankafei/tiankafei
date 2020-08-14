package org.tiankafei.multidatasource.service;

import java.io.Serializable;
import org.tiankafei.multidatasource.entity.UserInfoEntity;
import org.tiankafei.web.common.service.BaseService;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoMpService extends BaseService<UserInfoEntity> {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception;

}
