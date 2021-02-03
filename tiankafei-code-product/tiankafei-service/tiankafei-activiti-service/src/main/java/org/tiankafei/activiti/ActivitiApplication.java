package org.tiankafei.activiti;

import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringCloudApplication
@EntityScan(basePackages = "org.tiankafei")
@MapperScan(basePackages = {"org.tiankafei.**.mapper", "com.ruoyi.**.mapper"})
@ComponentScan(basePackages = {"org.tiankafei"})
@EnableFeignClients(basePackages = {"org.tiankafei", "com.ruoyi"})
@EnableHystrixDashboard
@EnableCustomSwagger2
public class ActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }

}
