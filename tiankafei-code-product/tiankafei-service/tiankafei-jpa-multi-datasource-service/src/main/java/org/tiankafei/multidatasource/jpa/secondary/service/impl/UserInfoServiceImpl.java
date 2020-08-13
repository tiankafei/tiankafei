package org.tiankafei.multidatasource.jpa.secondary.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.jpa.secondary.jpa.UserInfoJpa;
import org.tiankafei.multidatasource.jpa.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.jpa.secondary.service.UserInfoService;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserInfoJpa<UserInfoEntity> userInfoJpa;

    @Override
    public UserInfoEntity getUserInfoServiceByIdForJpa(Serializable id) throws Exception {
        return userInfoJpa.findById(Long.valueOf("" + id)).get();
    }

    @Override
    public UserInfoEntity getUserInfoServiceByIdForJdbc(Serializable id) throws Exception {
        String sql = "select * from sys_user_info where id = ?";
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql, new Serializable[]{id});
        if(CollectionUtils.isNotEmpty(dataMapList)){
            Map<String, Object> dataMap = dataMapList.get(0);

            UserInfoEntity userInfoEntity = new UserInfoEntity();
            BeanUtils.populate(userInfoEntity, dataMap);
            return userInfoEntity;
        }
        return null;
    }

}
