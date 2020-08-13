package org.tiankafei.multidatasource.secondary.service.impl;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.secondary.mapper.UserInfoMapper;
import org.tiankafei.multidatasource.secondary.service.UserInfoService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

    @Override
    public UserInfoEntity getUserInfoServiceById(Serializable id) throws Exception {
        return super.getById(id);
    }
}
