package org.tiankafei.multidatasource.secondary.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;
import org.tiankafei.multidatasource.secondary.jpa.UserInfoJpa;
import org.tiankafei.multidatasource.secondary.service.UserInfoJpaService;

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
public class UserInfoJpaServiceImpl implements UserInfoJpaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserInfoJpa<UserInfoJpaEntity> userInfoJpa;

    @Override
    public UserInfoJpaEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception {
        return userInfoJpa.findById(Long.valueOf("" + id)).get();
    }

    @Override
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
