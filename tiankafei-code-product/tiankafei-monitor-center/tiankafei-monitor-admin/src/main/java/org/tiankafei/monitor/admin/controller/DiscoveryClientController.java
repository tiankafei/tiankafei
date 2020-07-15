package org.tiankafei.monitor.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/get1")
    public List<String> get1() {
        List<String> services = client.getServices();
        return services;
    }


}
