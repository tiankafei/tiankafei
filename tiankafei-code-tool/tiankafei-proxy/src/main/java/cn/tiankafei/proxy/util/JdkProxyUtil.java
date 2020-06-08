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
public abstract class JdkProxyUtil {

    /**
     * 获取代理对象
     *
     * @param object            要代理的对象
     * @param invocationHandler 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, InvocationHandler invocationHandler) {
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return getProxy(object.getClass(), interfaces, invocationHandler);
    }

    /**
     * 根据接口类获取代理对象
     * @param clazz
     * @param invocationHandler
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class clazz, InvocationHandler invocationHandler){
        return getProxy(clazz, new Class[]{clazz}, invocationHandler);
    }

    /**
     * 获取代理对象
     * @param clazz
     * @param clazzArray
     * @param invocationHandler
     * @param <T>
     * @return
     */
    private static <T> T getProxy(Class clazz, Class[] clazzArray, InvocationHandler invocationHandler){
        ClassLoader classLoader = clazz.getClassLoader();
        T t = (T) Proxy.newProxyInstance(classLoader, clazzArray, invocationHandler);
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
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return getProxy(object.getClass(), interfaces, invocationHandler);
    }

    /**
     * 获取代理对象
     * @param clazz
     * @param invocationHandler
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class clazz, AbstractInvocationHandler invocationHandler) {
        return getProxy(clazz, new Class[]{clazz}, invocationHandler);
    }

    /**
     * 获取代理对象
     * @param clazz
     * @param clazzArray
     * @param invocationHandler
     * @param <T>
     * @return
     */
    private static <T> T getProxy(Class clazz, Class[] clazzArray, AbstractInvocationHandler invocationHandler) {
        ClassLoader classLoader = clazz.getClassLoader();
        T t = (T) Proxy.newProxyInstance(classLoader, clazzArray, invocationHandler);
        return t;
    }

}
