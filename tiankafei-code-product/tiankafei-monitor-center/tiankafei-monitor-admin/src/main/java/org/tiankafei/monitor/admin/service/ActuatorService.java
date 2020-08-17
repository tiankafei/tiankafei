package org.tiankafei.monitor.admin.service;

import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface ActuatorService extends HealthIndicator {

    /**
     * 设置状态
     * @param status
     */
    void setStatus(Boolean status);

    /**
     * 获取状态
     * @return
     */
    Boolean getStatus();

}
