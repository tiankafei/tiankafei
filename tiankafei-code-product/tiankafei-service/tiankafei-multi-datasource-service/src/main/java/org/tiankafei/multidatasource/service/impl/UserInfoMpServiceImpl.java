package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.entity.UserInfoMpEntity;
import org.tiankafei.multidatasource.mapper.UserInfoMapper;
import org.tiankafei.multidatasource.service.UserInfoMpService;

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
public class UserInfoMpServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoMpEntity> implements UserInfoMpService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoMpEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    public UserInfoMpEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception {
        return userInfoMapper.getUserInfoServiceById(id);
    }

}
