package org.tiankafei.multidatasource.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.secondary.jpa.UserInfoJpa;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;
import org.tiankafei.multidatasource.service.UserInfoJpaService;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class UserInfoJpaServiceImpl implements UserInfoJpaService {

    @Autowired
    private UserInfoJpa<UserInfoJpaEntity> userInfoJpa;

    @Override
    public UserInfoJpaEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception {
        return userInfoJpa.findById(Long.valueOf("" + id)).get();
    }

}
