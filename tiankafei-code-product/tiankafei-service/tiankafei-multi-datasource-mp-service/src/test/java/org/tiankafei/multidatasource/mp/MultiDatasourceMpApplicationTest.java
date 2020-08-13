package org.tiankafei.multidatasource.mp;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.multidatasource.mp.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.mp.entity.UserInfoEntity;
import org.tiankafei.multidatasource.mp.service.BlogInfoService;
import org.tiankafei.multidatasource.mp.service.UserInfoService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceMpApplication.class)
@Slf4j
public class MultiDatasourceMpApplicationTest {

    @Autowired
    private BlogInfoService blogInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() throws Exception {
        Long blogId = 1289742331580715010L;
        try {
            Map<String, Object> dataMap = blogInfoService.getBlogInfoServiceByIdForJdbc(blogId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoEntity blogInfoEntity = blogInfoService.getBlogInfoServiceByIdForJpa(blogId);
            log.info("jpa多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }


        Long userId = 1285547947985457153L;
        try {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoServiceByIdForJpa(userId);
            log.info("jpa多数据源：第二个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Map<String, Object> dataMap = userInfoService.getUserInfoServiceByIdForJdbc(userId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
