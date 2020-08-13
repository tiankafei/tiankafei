package org.tiankafei.blog;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.multidatasource.mp.MultiDatasourceMpApplication;
import org.tiankafei.multidatasource.mp.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.mp.primary.jpa.BlogInfoJpa;
import org.tiankafei.multidatasource.mp.primary.service.BlogInfoService;
import org.tiankafei.multidatasource.mp.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.mp.secondary.jpa.UserInfoJpa;
import org.tiankafei.multidatasource.mp.secondary.service.UserInfoService;

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

    @Autowired
    private BlogInfoJpa<BlogInfoEntity> blogInfoJpa;

    @Autowired
    private UserInfoJpa<UserInfoEntity> userInfoJpa;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void test() throws Exception {
        Long blogId = 1289742331580715010L;
        try {
            BlogInfoEntity blogInfoEntity = blogInfoJpa.findById(blogId).get();
            log.info("jpa多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println(blogInfoService.getBlogInfoServiceById(blogId));
        }catch (Exception e){
            e.printStackTrace();
        }


        Long userId = 1285547947985457153L;
        try {
            UserInfoEntity userInfoEntity = userInfoJpa.findById(userId).get();
            log.info("jpa多数据源：第二个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.out.println(userInfoService.getUserInfoServiceById(userId));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
