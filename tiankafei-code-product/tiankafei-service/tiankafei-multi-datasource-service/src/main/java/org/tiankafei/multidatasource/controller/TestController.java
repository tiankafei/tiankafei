package org.tiankafei.multidatasource.controller;

import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.multidatasource.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.primary.jpa.BlogInfoJpa;
import org.tiankafei.multidatasource.primary.service.BlogInfoService;
import org.tiankafei.multidatasource.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.secondary.jpa.UserInfoJpa;
import org.tiankafei.multidatasource.secondary.service.UserInfoService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@RestController
@Slf4j
public class TestController {

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

    @GetMapping
    public String test() throws Exception {
        Long blogId = 1289742331580715010L;
        try {
            BlogInfoEntity blogInfoEntity = blogInfoJpa.findById(blogId).get();
            log.info("jpa多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            String sql = "select * from sys_blog_info where id = ?";
            List<Map<String, Object>> dataMapList = jdbcTemplate1.queryForList(sql, new Long[]{blogId});
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMapList));
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
            String sql = "select * from sys_user_info where id = ?";
            List<Map<String, Object>> dataMapList = jdbcTemplate2.queryForList(sql, new Long[]{blogId});
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(dataMapList));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.out.println(userInfoService.getUserInfoServiceById(userId));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功了";
    }

}
