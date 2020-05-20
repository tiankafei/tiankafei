package com.tiankafei.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tiankafei
 * @since 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class TiankafeiEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiankafeiEurekaServerApplication.class, args);
    }

}
