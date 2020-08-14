package org.tiankafei.blog;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.multidatasource.MultiDatasourceApplication;
import org.tiankafei.multidatasource.entity.BlogInfoMpEntity;
import org.tiankafei.multidatasource.entity.UserInfoEntity;
import org.tiankafei.multidatasource.primary.entity.BlogInfoJpaEntity;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;
import org.tiankafei.multidatasource.service.BlogInfoJpaService;
import org.tiankafei.multidatasource.service.BlogInfoMpService;
import org.tiankafei.multidatasource.service.BlogJdbcTemplateService;
import org.tiankafei.multidatasource.service.UserInfoJpaService;
import org.tiankafei.multidatasource.service.UserInfoMpService;
import org.tiankafei.multidatasource.service.UserJdbcTemplateService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceApplication.class)
@Slf4j
public class MultiDatasourceApplicationTest {

    @Autowired
    private BlogInfoJpaService blogInfoJpaService;

    @Autowired
    private BlogJdbcTemplateService blogJdbcTemplateService;

    @Autowired
    private BlogInfoMpService blogInfoMpService;

    @Autowired
    private UserInfoJpaService userInfoJpaService;

    @Autowired
    private UserJdbcTemplateService userJdbcTemplateService;

    @Autowired
    private UserInfoMpService userInfoMpService;

    @Test
    public void test() throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        Long blogId = 1289742331580715010L;
        try {
            BlogInfoJpaEntity blogInfoJpaEntity = blogInfoJpaService.getBlogInfoServiceByIdForJpa(blogId);
            resultMap.put("jpa 多数据源：第一个数据源", blogInfoJpaEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Map<String, Object> dataMap = blogJdbcTemplateService.getBlogInfoServiceByIdForJdbc(blogId);
            resultMap.put("JdbcTemplate 多数据源：第一个数据源", dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BlogInfoMpEntity blogInfoMpEntity = blogInfoMpService.getBlogInfoServiceByIdForMapper(blogId);
            resultMap.put("Mybatis-Mapper 多数据源：第一个数据源", blogInfoMpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BlogInfoMpEntity blogInfoMpEntity = blogInfoMpService.getBlogInfoServiceByIdForMp(blogId);
            resultMap.put("Mybatis-Plus 多数据源：第一个数据源", blogInfoMpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================================================================");

        Long userId = 1285547947985457153L;
        try {
            UserInfoJpaEntity userInfoJpaEntity = userInfoJpaService.getUserInfoServiceByIdForJpa(userId);
            resultMap.put("jpa 多数据源：第二个数据源", userInfoJpaEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Map<String, Object> dataMap = userJdbcTemplateService.getUserInfoServiceByIdForJdbc(userId);
            resultMap.put("JdbcTemplate 多数据源：第二个数据源", dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UserInfoEntity userInfoEntity = userInfoMpService.getUserInfoServiceByIdForMapper(userId);
            resultMap.put("Mybatis-Mapper 多数据源：第二个数据源", userInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UserInfoEntity userInfoEntity = userInfoMpService.getUserInfoServiceByIdForMp(userId);
            resultMap.put("Mybatis-Plus 多数据源：第二个数据源", userInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultMap);
    }

}
