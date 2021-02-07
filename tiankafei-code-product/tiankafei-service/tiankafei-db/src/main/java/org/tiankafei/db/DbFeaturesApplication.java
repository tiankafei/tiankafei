package org.tiankafei.db;

import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringCloudApplication
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
@EnableFeignClients(basePackages = {"org.tiankafei", "com.ruoyi"})
@EnableHystrixDashboard
@EnableCustomSwagger2
public class DbFeaturesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DbFeaturesApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DbFeaturesApplication.class);
    }

}
