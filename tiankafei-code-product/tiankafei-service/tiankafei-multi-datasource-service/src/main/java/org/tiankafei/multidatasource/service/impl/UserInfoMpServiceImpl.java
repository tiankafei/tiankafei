package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class UserInfoMpServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoMpService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @DS("user")
    public UserInfoEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    @DS("user")
    public UserInfoEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception {
        return userInfoMapper.getUserInfoServiceById(id);
    }

    @Override
    @DS("user")
    public Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_user_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if(CollectionUtils.isNotEmpty(dataMapList)){
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }
        return null;
    }

}
