package org.tiankafei.multidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
@EntityScan(basePackages = "org.tiankafei")
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
//@ComponentScan(basePackages = {"org.tiankafei"})
@EnableFeignClients(basePackages = {"org.tiankafei"})
@EnableHystrixDashboard
public class MultiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

}
