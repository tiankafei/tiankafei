package org.tiankafei.multidatasource.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import org.tiankafei.multidatasource.entity.UserInfoMpEntity;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoMpService extends BaseService<UserInfoMpEntity> {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoMpEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoMpEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception;

}
