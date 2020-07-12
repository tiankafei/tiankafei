package org.tiankafei.monitor.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手动负载均衡处理
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
public class LoadBalancerController {

    @Autowired
    private LoadBalancerClient client;

    @GetMapping("/client")
    public String client(){

        ServiceInstance serviceInstance = client.choose("");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        return "";
    }

}
