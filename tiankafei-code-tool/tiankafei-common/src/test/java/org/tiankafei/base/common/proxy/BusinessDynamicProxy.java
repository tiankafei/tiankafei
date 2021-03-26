package org.tiankafei.base.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author tiankafei
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class BusinessDynamicProxy implements InvocationHandler {

    private Object object;

    public BusinessDynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前的处理");
        Object obj = method.invoke(object, args);
        System.out.println("动态代理后的处理");
        return obj;
    }
}
