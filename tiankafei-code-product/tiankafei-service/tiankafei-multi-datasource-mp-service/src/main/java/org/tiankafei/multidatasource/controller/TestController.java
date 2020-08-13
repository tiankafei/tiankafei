package org.tiankafei.multidatasource.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
            BlogInfoEntity blogInfoEntity = blogInfoService.getBlogInfoServiceByIdForJdbc(blogId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoEntity blogInfoEntity = blogInfoService.getBlogInfoServiceByIdForMapper(blogId);
            log.info("mybatis-mapper多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BlogInfoEntity blogInfoEntity = blogInfoService.getBlogInfoServiceById(blogId);
            log.info("mybatis-plus多数据源：第一个数据源：{}", JSON.toJSONString(blogInfoEntity));
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
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoServiceByIdForJdbc(userId);
            log.info("JdbcTemplate多数据源：第一个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoServiceByIdForMapper(userId);
            log.info("mybatis-mapper多数据源：第一个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoServiceById(userId);
            log.info("mybatis-plus多数据源：第二个数据源：{}", JSON.toJSONString(userInfoEntity));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功了";
    }

}
