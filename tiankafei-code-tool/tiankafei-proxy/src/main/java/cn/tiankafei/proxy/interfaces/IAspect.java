package cn.tiankafei.proxy.interfaces;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 切面接口
 *
 * @author tiankafei
 * @since 1.0
 **/
public interface IAspect {

    /**
     * 方法执行之前的切面
     *
     * @param object    被代理对象
     * @param method    被代理的方法
     * @param args  方法执行用到的参数
     * @param paramMap  代理过程中用到的参数集合
     * @return
     */
    Object executeBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap);

    /**
     * 方法执行之后的切面
     *
     * @param object    被代理对象
     * @param method    被代理的方法
     * @param args  方法执行用到的参数
     * @param paramMap  代理过程中用到的参数集合
     * @param result    被代理方法执行结果的返回值
     * @return
     */
    Object executeAfter(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result);

    /**
     * 方法执行异常的切面
     *
     * @param object    被代理对象
     * @param method    被代理的方法
     * @param args  方法执行用到的参数
     * @param paramMap  代理过程中用到的参数集合
     * @param exception 异常信息
     * @return
     */
    Object executeThrowing(Object object, Method method, Object[] args, Map<String, Object> paramMap, Exception exception);

    /**
     * 方法返回之前的切面
     *
     * @param object    被代理对象
     * @param method    被代理的方法
     * @param args  方法执行用到的参数
     * @param paramMap  代理过程中用到的参数集合
     * @param result    被代理方法执行结果的返回值
     * @return
     */
    Object returnBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result);

    /**
     * 环形切面
     * @param object
     * @param method
     * @param args
     * @param paramMap  代理过程中用到的参数集合
     * @return
     */
    Object around(Object object, Method method, Object[] args, Map<String, Object> paramMap);

}
