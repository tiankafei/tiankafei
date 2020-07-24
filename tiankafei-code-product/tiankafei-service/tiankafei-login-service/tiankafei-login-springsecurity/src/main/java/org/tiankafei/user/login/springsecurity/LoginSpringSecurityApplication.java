package org.tiankafei.user.login.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringCloudApplication
@EntityScan(basePackages = "org.tiankafei")
@MapperScan(basePackages = {"org.tiankafei.**.mapper"})
@ComponentScan(basePackages = {"org.tiankafei"})
@EnableHystrixDashboard
@EnableWebSecurity
public class LoginSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSpringSecurityApplication.class, args);
    }

}
