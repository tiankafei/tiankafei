package org.tiankafei.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.tiankafei.multidatasource.service.UserJdbcTemplateService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@DS("user")
public class UserJdbcTemplateServiceImpl implements UserJdbcTemplateService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
