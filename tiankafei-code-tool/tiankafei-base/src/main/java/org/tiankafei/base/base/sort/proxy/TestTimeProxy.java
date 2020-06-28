package org.tiankafei.base.base.sort.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class TestTimeProxy implements SortProxy {

    private SortProxy sortProxy;

    public TestTimeProxy(SortProxy sortProxy) {
        this.sortProxy = sortProxy;
    }

    @Override
    public void execute() {
        log.info("测试的时间代理执行开始============================================");
        long currentTime = System.currentTimeMillis();
        sortProxy.execute();
        log.info("测试的时间代理执行结束：执行用时" + (System.currentTimeMillis() - currentTime) + "ms============================================");
    }
}
