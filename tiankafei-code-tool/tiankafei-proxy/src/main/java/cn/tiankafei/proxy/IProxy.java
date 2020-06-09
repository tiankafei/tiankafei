package cn.tiankafei.proxy;

/**
 * @Author 魏双双
 * @Date 2020/6/9
 * @Version V1.0
 **/
public interface IProxy<T, Call> {

    T getProxy(T t, IAspect IAspect) ;

    T getProxy(T t, Call call) ;

    T getProxy(Class clazz, Call call) ;

}
