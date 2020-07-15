package org.tiankafei.monitor.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;
import org.tiankafei.monitor.admin.service.ActuatorService;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
public class ActuatorEruekaService implements ActuatorService {

    private Boolean status = Boolean.TRUE;

    @Override
    public Boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Health health() {
//        log.info("当前状态：{}", this.status);
        if (status) {
            // 上线
            return new Health.Builder().up().build();
        }
        // 下线
        return new Health.Builder().down().build();
    }

}
