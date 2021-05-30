package org.tiankafei.user;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringCloudApplication
@EntityScan(basePackages = "org.tiankafei")
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
@ComponentScan(basePackages = {"org.tiankafei"})
@EnableFeignClients(basePackages = {"org.tiankafei", "com.ruoyi"})
@EnableAutoConfiguration(exclude = DruidDataSourceAutoConfigure.class)
@EnableHystrixDashboard
@EnableTransactionManagement
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
