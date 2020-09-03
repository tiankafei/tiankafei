package org.tiankafei.web.common.service.impl;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.service.Container;

/**
 * weblogic容器集成类
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class WeblogicContainerImpl implements Container {

    @Override
    public Integer getContainerPort() {
        String port = "0";
        try {
            Context ctx = new InitialContext();
            MBeanServer tMbeanServer = (MBeanServer) ctx.lookup("java:comp/env/jmx/runtime");
            ObjectName tObjectName = new ObjectName("com.bea:Name=RuntimeService,Type=weblogic.management.mbeanservers.runtime.RuntimeServiceMBean");
            ObjectName serverrt = (ObjectName) tMbeanServer.getAttribute(tObjectName, "ServerRuntime");
            port = String.valueOf(tMbeanServer.getAttribute(serverrt, "ListenPort"));
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(port);
    }

}