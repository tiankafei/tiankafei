package cn.tiankafei.proxy;

import cn.tiankafei.base.util.SystemTimeUtil;
import cn.tiankafei.proxy.util.ProxyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class ProxyTest {

    private static final int count = 1;

    @Test
    public void testJdkProxy(){
        long currentTime = SystemTimeUtil.now();
        IHandler handler = new HandlerImpl();
        for (int i = 0; i < count; i++) {
            IHandler proxyHandler = ProxyUtil.getProxy(handler, new AspectImpl());
            proxyHandler.process("小明");
        }
        long useTime = SystemTimeUtil.now() - currentTime;
        log.info("使用jdk动态代理执行{}次，用时：{}ms", count, useTime);
    }

    @Test
    public void testCglibProxy(){
        long currentTime = SystemTimeUtil.now();
        Handler handler = new Handler();
        for (int i = 0; i < count; i++) {
            Handler proxyHandler = ProxyUtil.getProxy(handler, new AspectImpl());
            proxyHandler.process("小明");
        }
        long useTime = SystemTimeUtil.now() - currentTime;
        log.info("使用Cglib动态代理执行{}次，用时：{}ms", count, useTime);
    }

}
