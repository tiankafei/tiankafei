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
import org.tiankafei.multidatasource.entity.BlogInfoMpEntity;
import org.tiankafei.multidatasource.entity.UserInfoEntity;
import org.tiankafei.multidatasource.service.BlogInfoMpService;
import org.tiankafei.multidatasource.service.UserInfoMpService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDatasourceApplication.class)
@Slf4j
public class MultiDatasourceMpApplicationTest {

    @Autowired
    private BlogInfoMpService blogInfoMpService;

    @Autowired
    private UserInfoMpService userInfoMpService;

    @Test
    public void test() throws Exception {
        Long blogId = 1289742331580715010L;
        try {
            Map<String, Object> dataMap = blogInfoMpService.getBlogInfoServiceByIdForJdbc(blogId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoMpEntity blogInfoMpEntity = blogInfoMpService.getBlogInfoServiceByIdForMapper(blogId);
            log.info("mybatis-mapper多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoMpEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoMpEntity blogInfoMpEntity = blogInfoMpService.getBlogInfoServiceByIdForMp(blogId);
            log.info("mybatis-plus多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoMpEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=================================================================");

        Long userId = 1285547947985457153L;
        try {
            Map<String, Object> dataMap = userInfoMpService.getUserInfoServiceByIdForJdbc(userId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            org.tiankafei.multidatasource.entity.UserInfoEntity userInfoEntity = userInfoMpService.getUserInfoServiceByIdForMapper(userId);
            log.info("mybatis-mapper多数据源：第二个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            UserInfoEntity userInfoEntity = userInfoMpService.getUserInfoServiceByIdForMp(userId);
            log.info("mybatis-plus多数据源：第二个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
