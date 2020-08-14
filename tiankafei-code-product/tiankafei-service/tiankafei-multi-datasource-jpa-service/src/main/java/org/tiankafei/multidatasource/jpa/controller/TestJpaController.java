package org.tiankafei.multidatasource.jpa.controller;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.multidatasource.jpa.primary.entity.BlogInfoEntity;
import org.tiankafei.multidatasource.jpa.primary.service.BlogInfoService;
import org.tiankafei.multidatasource.jpa.secondary.entity.UserInfoEntity;
import org.tiankafei.multidatasource.jpa.secondary.service.UserInfoService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@RestController
@Slf4j
public class TestJpaController {

    @Autowired
    private BlogInfoService blogInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public Map<String, Object> test() throws Exception {
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
        return resultMap;
    }

}
