package org.tiankafei.common.ioc.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.tiankafei.proxy.ProxyUtil;

/**
 * @Author tiankafei
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class ProxyTest {

    @Test
    public void testProxy() {
        //真正的业务处理执行
        BusinessInterface businessService = new BusinessService();
        businessService.exec();
        businessService.process();
        System.out.println("=======================================");

        //静态代理：被代理对象对外不可见，故不需要把当前对象作为参数传递
        BusinessStaticProxy businessStaticProxy = new BusinessStaticProxy();
        businessStaticProxy.exec();
        businessStaticProxy.process();
        System.out.println("=======================================");

        //动态代理：动态代理，可以代理各种各样的对象，故需需要把被代理的对象作为参数传入
        BusinessInterface businessInterface = ProxyUtil.getProxy(businessService, new BusinessDynamicProxy(businessService));
        businessInterface.exec();
        businessInterface.process();
        System.out.println("=======================================");

        NoBusinessService noBusinessService = new NoBusinessService();
        NoBusinessService proxy = ProxyUtil.getProxy(noBusinessService, ProxyTest::intercept);
        proxy.exec();
        proxy.process();
    }

    public static Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }

}
