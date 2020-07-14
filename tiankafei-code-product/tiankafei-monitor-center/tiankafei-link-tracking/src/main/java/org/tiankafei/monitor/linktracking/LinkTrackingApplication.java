package org.tiankafei.monitor.linktracking;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tiankafei
 * @since 1.0
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"org.tiankafei"})
@EnableHystrixDashboard
public class LinkTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkTrackingApplication.class, args);
    }

}
