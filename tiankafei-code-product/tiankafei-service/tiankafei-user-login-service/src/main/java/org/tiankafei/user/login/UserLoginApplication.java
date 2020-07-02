package org.tiankafei.user.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringBootApplication
@EntityScan(basePackages = "org.tiankafei")
@EnableDiscoveryClient
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
@ComponentScan(basePackages = {"org.tiankafei"})
public class UserLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserLoginApplication.class, args);
    }

}
