package org.tiankafei.monitor.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.monitor.admin.service.ActuatorService;

/**
 * @author tiankafei
 * @since 1.0
 */
@RestController
public class ActuatorController {

    @Autowired
    private ActuatorService actuatorService;

    @GetMapping("health/{status}")
    public boolean health(@PathVariable String status){
        actuatorService.setStatus(Boolean.valueOf(status));
        return actuatorService.getStatus();
    }


}
