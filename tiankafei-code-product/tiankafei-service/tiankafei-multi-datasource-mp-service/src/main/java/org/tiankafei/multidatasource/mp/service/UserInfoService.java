package org.tiankafei.multidatasource.mp.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.Map;
import org.tiankafei.multidatasource.mp.entity.UserInfoEntity;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoService extends BaseService<UserInfoEntity> {

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

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception;

}
