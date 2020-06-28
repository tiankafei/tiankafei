package org.tiankafei.proxy.impl;

import org.tiankafei.proxy.IAspect;
import org.tiankafei.proxy.IProxy;
import org.tiankafei.proxy.ProxyAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author 魏双双
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class JdkProxy<T> implements IProxy<T, InvocationHandler> {

    @Override
    public T getProxy(T t, IAspect IAspect) {
        ProxyAdapter proxyAdapter = new ProxyAdapter(t, IAspect);
        Class<?>[] interfaces = t.getClass().getInterfaces();
        return getProxy(t.getClass(), interfaces, proxyAdapter);
    }

    @Override
    public T getProxy(T t, InvocationHandler invocationHandler) {
        Class<?>[] interfaces = t.getClass().getInterfaces();
        return getProxy(t.getClass(), interfaces, invocationHandler);
    }

    @Override
    public T getProxy(Class clazz, InvocationHandler invocationHandler) {
        return getProxy(clazz, new Class[]{clazz}, invocationHandler);
    }

    private T getProxy(Class clazz, Class[] clazzArray, InvocationHandler invocationHandler) {
        ClassLoader classLoader = clazz.getClassLoader();
        T t = (T) Proxy.newProxyInstance(classLoader, clazzArray, invocationHandler);
        return t;
    }

}
