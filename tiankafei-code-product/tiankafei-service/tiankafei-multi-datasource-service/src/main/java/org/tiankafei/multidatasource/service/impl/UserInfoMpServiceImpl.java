package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.entity.UserInfoEntity;
import org.tiankafei.multidatasource.mapper.UserInfoMapper;
import org.tiankafei.multidatasource.service.UserInfoMpService;
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
@DS("user")
public class UserInfoMpServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoMpService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    public UserInfoEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception {
        return userInfoMapper.getUserInfoServiceById(id);
    }

}
