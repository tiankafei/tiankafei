package org.tiankafei.multidatasource.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfoEntity getUserInfoServiceByIdForMp(Serializable id) throws Exception {
        return super.getById(id);
    }

    @Override
    public UserInfoEntity getUserInfoServiceByIdForMapper(Serializable id) throws Exception {
        return userInfoMapper.getUserInfoServiceById(id);
    }

    @Override
    public Map<String, Object> getUserInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_user_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if (CollectionUtils.isNotEmpty(dataMapList)) {
            Map<String, Object> dataMap = dataMapList.get(0);
            return dataMap;
        }
        return null;
    }

}
