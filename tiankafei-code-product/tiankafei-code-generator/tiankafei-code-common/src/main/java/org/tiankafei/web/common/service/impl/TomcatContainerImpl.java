package org.tiankafei.web.common.service.impl;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.service.Container;

/**
 * tomcat获取端口实现类
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class TomcatContainerImpl implements Container {

    @Override
    public Integer getContainerPort() {
        String port = "0";
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNameSet = mBeanServer.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            for (Iterator<ObjectName> i = objectNameSet.iterator(); i.hasNext(); ) {
                ObjectName objectName = i.next();
                port = objectName.getKeyProperty("port");
                if (StringUtils.isNotEmpty(port)) {
                    break;
                }
            }
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(port);
    }

}