package org.tiankafei.multidatasource.controller;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.multidatasource.entity.BlogInfoMpEntity;
import org.tiankafei.multidatasource.entity.UserInfoEntity;
import org.tiankafei.multidatasource.service.BlogInfoMpService;
import org.tiankafei.multidatasource.service.UserInfoMpService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@RestController
@Slf4j
public class TestMybatisPlusController {

    @Autowired
    private BlogInfoMpService blogInfoMpService;

    @Autowired
    private UserInfoMpService userInfoMpService;

    @GetMapping("/mp")
    public String test() throws Exception {
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
            UserInfoEntity userInfoEntity = userInfoMpService.getUserInfoServiceByIdForMapper(userId);
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
        return "成功了";
    }

}
