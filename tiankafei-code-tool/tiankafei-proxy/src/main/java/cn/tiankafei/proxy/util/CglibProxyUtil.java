package cn.tiankafei.proxy.util;

import cn.tiankafei.proxy.model.AbstractMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * cglib动态代理工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class CglibProxyUtil {

    /**
     * 获取代理对象
     *
     * @param object            要代理的对象
     * @param methodInterceptor 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, MethodInterceptor methodInterceptor) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer要代理的对象
        enhancer.setSuperclass(object.getClass());
        // 设置enhancer的回调对象
        enhancer.setCallback(methodInterceptor);
        // 创建代理对象
        T t = (T) enhancer.create();
        return t;
    }

    /**
     * 获取代理对象
     *
     * @param object            要代理的对象
     * @param methodInterceptor 代理的具体实现
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object object, AbstractMethodInterceptor methodInterceptor) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer要代理的对象
        enhancer.setSuperclass(object.getClass());
        // 设置enhancer的回调对象
        enhancer.setCallback(methodInterceptor);
        // 创建代理对象
        T t = (T) enhancer.create();
        return t;
    }


}
