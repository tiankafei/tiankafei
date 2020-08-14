package org.tiankafei.blog;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.multidatasource.MultiDatasourceApplication;
import org.tiankafei.multidatasource.primary.entity.BlogInfoJpaEntity;
import org.tiankafei.multidatasource.primary.service.BlogInfoJpaService;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;
import org.tiankafei.multidatasource.secondary.service.UserInfoJpaService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceApplication.class)
@Slf4j
public class MultiDatasourceJpaApplicationTest {

    @Autowired
    private BlogInfoJpaService blogInfoJpaService;

    @Autowired
    private UserInfoJpaService userInfoJpaService;

    @Test
    public void test() throws Exception {
        Long blogId = 1289742331580715010L;
        try {
            Map<String, Object> dataMap = blogInfoJpaService.getBlogInfoServiceByIdForJdbc(blogId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoJpaEntity blogInfoJpaEntity = blogInfoJpaService.getBlogInfoServiceByIdForJpa(blogId);
            log.info("mybatis-plus多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoJpaEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=================================================================");

        Long userId = 1285547947985457153L;
        try {
            Map<String, Object> dataMap = userInfoJpaService.getUserInfoServiceByIdForJdbc(userId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            UserInfoJpaEntity userInfoJpaEntity = userInfoJpaService.getUserInfoServiceByIdForJpa(userId);
            log.info("mybatis-plus多数据源：第二个数据源：{}", JSON.toJSONString(userInfoJpaEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
