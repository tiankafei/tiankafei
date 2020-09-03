package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.service.Container;

/**
 * jetty获取端口实现类
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class JettyContainerImpl implements Container {

    @Override
    public Integer getContainerPort() {
        return 0;
    }

}