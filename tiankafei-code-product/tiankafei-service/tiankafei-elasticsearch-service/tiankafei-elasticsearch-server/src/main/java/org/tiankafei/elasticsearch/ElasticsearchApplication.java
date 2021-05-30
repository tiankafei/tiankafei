package org.tiankafei.elasticsearch;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
@EnableFeignClients(basePackages = {"org.tiankafei", "com.ruoyi"})
@EnableAutoConfiguration(exclude = DruidDataSourceAutoConfigure.class)
@EnableHystrixDashboard
@EnableCustomSwagger2
public class ElasticsearchApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
