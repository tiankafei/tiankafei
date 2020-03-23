package cn.tiankafei.proxy.model;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class AbstractMethodInterceptor implements MethodInterceptor {

    /**
     * 被代理的对象
     */
    protected Object object;

    public AbstractMethodInterceptor() {
    }

    public AbstractMethodInterceptor(Object object) {
        this.object = object;
    }
}
