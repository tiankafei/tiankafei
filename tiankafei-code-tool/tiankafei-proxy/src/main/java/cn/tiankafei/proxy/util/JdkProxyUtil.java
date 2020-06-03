package cn.tiankafei.proxy.util;

import cn.tiankafei.proxy.model.AbstractInvocationHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk自带的动态代理工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class JdkProxyUtil {

    /**
     * 获取代理对象
     *
     * @param object            要代理的对象
     * @param invocationHandler 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, InvocationHandler invocationHandler) {
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        T t = (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return t;
    }

    /**
     * 获取代理对象
     *
     * @param object            要代理的对象
     * @param invocationHandler 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, AbstractInvocationHandler invocationHandler) {
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        T t = (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return t;
    }

}
