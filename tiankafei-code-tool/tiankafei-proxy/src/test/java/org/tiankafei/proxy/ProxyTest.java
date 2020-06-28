package org.tiankafei.proxy;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class ProxyTest {

    private static final int count = 1;

    @Test
    public void testDynamicProxy() {
        //使用jdk自带的动态代理
        IHandler handler = ProxyUtil.getProxy(IHandler.class, (proxy, method, args) -> {
            System.out.println(method.getName());
            return null;
        });
        System.out.println(handler.process("test"));

        //使用cglib动态代理
        IHandler handler1 = ProxyUtil.getProxy(IHandler.class, (obj, method, args, proxy) -> {
            System.out.println(method.getName());
            return null;
        });
        System.out.println(handler1.process("test"));
    }

    @Test
    public void testJdkProxy() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        IHandler handler = new HandlerImpl();
        for (int i = 0; i < count; i++) {
            IHandler proxyHandler = ProxyUtil.getProxy(handler, new AspectImpl());
            proxyHandler.process("小明");
        }
        log.info("使用jdk动态代理执行{}次，用时：{}ms", count, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void testCglibProxy() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Handler handler = new Handler();
        for (int i = 0; i < count; i++) {
            Handler proxyHandler = ProxyUtil.getProxy(handler, new AspectImpl());
            proxyHandler.process("小明");
        }
        log.info("使用Cglib动态代理执行{}次，用时：{}ms", count, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
