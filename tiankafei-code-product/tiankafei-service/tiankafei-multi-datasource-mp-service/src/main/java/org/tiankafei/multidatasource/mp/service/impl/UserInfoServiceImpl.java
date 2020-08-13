package org.tiankafei.multidatasource.mp.service.impl;

import java.io.Serializable;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.mp.entity.UserInfoEntity;
import org.tiankafei.multidatasource.mp.service.UserInfoService;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfoEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception {
        return null;
    }

}
