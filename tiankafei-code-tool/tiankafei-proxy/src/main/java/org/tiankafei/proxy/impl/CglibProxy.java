package org.tiankafei.proxy.impl;

import org.tiankafei.proxy.IAspect;
import org.tiankafei.proxy.IProxy;
import org.tiankafei.proxy.ProxyAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author 魏双双
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class CglibProxy<T> implements IProxy<T, MethodInterceptor> {

    @Override
    public T getProxy(T t, IAspect IAspect) {
        ProxyAdapter proxyAdapter = new ProxyAdapter(t, IAspect);
        return getProxy(t.getClass(), proxyAdapter);
    }

    @Override
    public T getProxy(T t, MethodInterceptor methodInterceptor) {
        return getProxy(t.getClass(), methodInterceptor);
    }

    @Override
    public T getProxy(Class clazz, MethodInterceptor methodInterceptor) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer要代理的对象
        enhancer.setSuperclass(clazz);
        // 设置enhancer的回调对象
        enhancer.setCallback(methodInterceptor);
        // 创建代理对象
        T t = (T) enhancer.create();
        return t;
    }

}
