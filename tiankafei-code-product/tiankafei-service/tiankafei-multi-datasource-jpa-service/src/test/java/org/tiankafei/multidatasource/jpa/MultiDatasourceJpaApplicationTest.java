package org.tiankafei.multidatasource.jpa;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.multidatasource.jpa.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.jpa.primary.service.BlogInfoService;
import org.tiankafei.multidatasource.jpa.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.jpa.secondary.service.UserInfoService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceJpaApplication.class)
@Slf4j
public class MultiDatasourceJpaApplicationTest {

    @Autowired
    private BlogInfoService blogInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() throws Exception {
        Map<String, Object> resultMap = Maps.newLinkedHashMap();
        Long blogId = 1289742331580715010L;
        try {
            BlogInfoEntity blogInfoEntity = blogInfoService.getBlogInfoServiceByIdForJpa(blogId);
            resultMap.put("jpa 多数据源：第一个数据源", blogInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Map<String, Object> dataMap = blogInfoService.getBlogInfoServiceByIdForJdbc(blogId);
            resultMap.put("JdbcTemplate 多数据源：第一个数据源", dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================================================================");

        Long userId = 1285547947985457153L;
        try {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoServiceByIdForJpa(userId);
            resultMap.put("jpa 多数据源：第二个数据源", userInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Map<String, Object> dataMap = userInfoService.getUserInfoServiceByIdForJdbc(userId);
            resultMap.put("JdbcTemplate 多数据源：第二个数据源", dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultMap);
    }

}
