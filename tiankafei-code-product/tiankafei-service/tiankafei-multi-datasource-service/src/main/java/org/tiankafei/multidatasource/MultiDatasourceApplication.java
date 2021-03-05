package org.tiankafei.multidatasource;

import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
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
public class MultiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

}
