package org.tiankafei.multidatasource.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.mp.entity.UserInfoEntity;
import org.tiankafei.multidatasource.mp.mapper.UserInfoMapper;
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
@DS("user")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoEntity getUserInfoServiceByIdForJMp(Serializable id) throws Exception {
        return userInfoMapper.getUserInfoServiceById(id);
    }

    @Override
    public Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception {
        return null;
    }

}
