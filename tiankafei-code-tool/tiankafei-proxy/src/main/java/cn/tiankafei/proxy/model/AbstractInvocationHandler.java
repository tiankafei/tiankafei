package cn.tiankafei.proxy.model;

import java.lang.reflect.InvocationHandler;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class AbstractInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    protected Object object;

    public AbstractInvocationHandler() {
    }

    public AbstractInvocationHandler(Object object) {
        this.object = object;
    }
}
