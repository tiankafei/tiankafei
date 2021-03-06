package org.tiankafei.proxy;

import org.tiankafei.proxy.impl.CglibProxy;
import org.tiankafei.proxy.impl.JdkProxy;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class ProxyUtil {

    public static <T> T getProxy(T t, IAspect IAspect) {
        Class<?>[] interfaces = t.getClass().getInterfaces();
        ProxyAdapter<T> proxyAdapter = new ProxyAdapter(t, IAspect);
        if (interfaces == null || interfaces.length == 0) {
            return new CglibProxy<T>().getProxy(t, proxyAdapter);
        } else {
            return new JdkProxy<T>().getProxy(t, proxyAdapter);
        }
    }

    public static <T> T getProxy(T t, InvocationHandler invocationHandler) {
        return new JdkProxy<T>().getProxy(t, invocationHandler);
    }

    public static <T> T getProxy(Class clazz, InvocationHandler invocationHandler) {
        return new JdkProxy<T>().getProxy(clazz, invocationHandler);
    }

    public static <T> T getProxy(T t, MethodInterceptor methodInterceptor) {
        return new CglibProxy<T>().getProxy(t, methodInterceptor);
    }

    public static <T> T getProxy(Class clazz, MethodInterceptor methodInterceptor) {
        return new CglibProxy<T>().getProxy(clazz, methodInterceptor);
    }

}
