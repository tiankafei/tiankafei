package cn.tiankafei.proxy;

import cn.tiankafei.proxy.util.CglibProxyUtil;
import cn.tiankafei.proxy.util.JdkProxyUtil;
import cn.tiankafei.proxy.util.ProxyUtil;
import com.google.common.base.Stopwatch;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class ProxyTest {

    private static final int count = 1;

    @Test
    public void testJdkProxy1() {
        IHandler handler = JdkProxyUtil.getProxy(IHandler.class, (proxy, method, args) -> {
            System.out.println(method.getName());
            return null;
        });
        System.out.println(handler.process("test"));

        IHandler handler1 = CglibProxyUtil.getProxy(IHandler.class, (obj, method, args, proxy) -> {
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
