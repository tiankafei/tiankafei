package cn.tiankafei.springbootproject.repository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Repository
public class SpringBootRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllData(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from tjcp_bbxx_business_test");
        List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(stringBuilder.toString());
        return dataMapList;
    }

}
