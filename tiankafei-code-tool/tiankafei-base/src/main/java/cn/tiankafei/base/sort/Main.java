package cn.tiankafei.base.sort;

import cn.tiankafei.base.util.SystemTimeUtil;
import cn.tiankafei.base.sort.proxy.TestAuthorityProxy;
import cn.tiankafei.base.sort.proxy.TestProxy;
import cn.tiankafei.base.sort.proxy.TestTimeProxy;
import cn.tiankafei.proxy.interfaces.IAspect;
import cn.tiankafei.proxy.util.ProxyUtil;
import java.lang.reflect.Method;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用的模式如下：
 * 单例模式     获取策略对象
 * 工厂方法模式 比大小的算法实现（对于产品种类的扩种非常方便）
 * 抽象工厂（产品种类不变，扩充的是产品组，比如说移动电话的套餐）这个暂时没有用到
 * 策略模式     比大小的逻辑
 * 装饰着模式   执行比大小（把外部对象传进来，然后进行装饰（可以达到增加逻辑的处理））
 * 责任链模式   主方法调用多个执行比大小（先按顺序执行，然后再返序执行）
 * 观察者模式   主方法调用多个执行比大小（基于事件驱动，一个对象注册观察者之后，通过触发事件，然后观察者进行事件源对象的不同，做出不同的后续处理）
 * 静态代理模式     主方法调用多个执行比大小（代理内部new对象，对外隐藏使用的对象，可以达到增加逻辑的处理）
 * 嵌套代理（只是个demo）：这个暂时没有用到
 * 使用动态代理的方式进行执行（只针对实现的接口的类才能进行动态代理）
 *
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {
        MainInterface mainChain = new MainChain();
        MainInterface mainObserver = new MainObserver();
        MainInterface mainProxy = new MainProxy();

        log.info("使用动态代理模式运行开始=========================================================");
        MainInterface mainInterface = ProxyUtil.getProxy(mainChain, new DynamicProxyHandler());
        mainInterface.execute();
        mainInterface = ProxyUtil.getProxy(mainObserver, new DynamicProxyHandler());
        mainInterface.execute();
        mainInterface = ProxyUtil.getProxy(mainProxy, new DynamicProxyHandler());
        mainInterface.execute();
        log.info("使用动态代理模式运行结束=========================================================");
        log.info("使用嵌套代理模式运行开始=========================================================");
        new TestAuthorityProxy(new TestTimeProxy(new TestProxy())).execute();
        System.out.println();
        new TestTimeProxy(new TestAuthorityProxy(new TestProxy())).execute();
        log.info("使用嵌套代理模式运行结束=========================================================");
    }

    static class DynamicProxyHandler implements IAspect {

        @Override
        public Object executeBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap) {
            log.info("测试动态代理执行开始：动态执行类名 -> {}============================================", object.getClass());
            long currentTime = System.currentTimeMillis();
            paramMap.put("startTime", currentTime);
            log.info("method {} start......", method.getName());
            return null;
        }

        @Override
        public Object executeAfter(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
            return null;
        }

        @Override
        public Object executeThrowing(Object object, Method method, Object[] args, Map<String, Object> paramMap, Exception exception) {
            return null;
        }

        @Override
        public Object returnBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
            long currentTime = (long) paramMap.get("startTime");
            long useTime = SystemTimeUtil.now() - currentTime;
            log.info("method {} end......", method.getName());
            log.info("测试动态代理执行结束：动态执行类名 -> {}; 执行用时 -> {}ms============================================", object.getClass(), useTime);
            return null;
        }
    }


}
