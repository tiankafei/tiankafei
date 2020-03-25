package cn.tiankafei.proxy.util;

import cn.tiankafei.proxy.interfaces.IAspect;
import cn.tiankafei.proxy.model.ProxyProcess;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ProxyUtil {

    /**
     * 获取代理对象
     *
     * @param object    要代理的对象
     * @param IAspect 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, IAspect IAspect) {
        Class<?>[] interfaces = object.getClass().getInterfaces();

        ProxyProcess proxyProcess = new ProxyProcess(object, IAspect);
        if(interfaces == null || interfaces.length == 0){
            // 没有实现接口，使用Cglib代理
            return CglibProxyUtil.getProxy(object, proxyProcess);
        }else{
            // 有接口实现，使用jdk代理
            return JdkProxyUtil.getProxy(object, proxyProcess);
        }
    }

}