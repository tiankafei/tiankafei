package cn.tiankafei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 代理对象
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ProxyAdapter implements InvocationHandler, MethodInterceptor {

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 切面的具体实现
     */
    private IAspect aspect;

    /**
     * 代理过程中用到的参数集合
     */
    private Map<String, Object> paramMap;

    /**
     * 构造代理对象
     *
     * @param object
     * @param aspect
     */
    public ProxyAdapter(Object object, IAspect aspect) {
        this.target = object;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        paramMap = new HashMap<>();
        Object result = null;
        try {
            aspect.executeBefore(target, method, args, paramMap);
            result = method.invoke(target, args);
            aspect.executeAfter(target, method, args, paramMap, result);
        } catch (Exception e) {
            aspect.executeThrowing(target, method, args, paramMap, e);
        } finally {
            aspect.returnBefore(target, method, args, paramMap, result);
        }
        return result;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        paramMap = new HashMap<>();
        Object result = null;
        try {
            aspect.executeBefore(proxy, method, args, paramMap);
            result = methodProxy.invokeSuper(proxy, args);
            aspect.executeAfter(proxy, method, args, paramMap, result);
        } catch (Exception e) {
            aspect.executeThrowing(proxy, method, args, paramMap, e);
        } finally {
            aspect.returnBefore(proxy, method, args, paramMap, result);
        }
        return result;

    }

}
