package org.tiankafei.monitor.admin.service;

import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface ActuatorService extends HealthIndicator {

    void setStatus(Boolean status) ;

    Boolean getStatus() ;

}
