package cn.tiankafei.base.sort.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class TestAuthorityProxy implements SortProxy {

    private SortProxy sortProxy;

    public TestAuthorityProxy(SortProxy sortProxy) {
        this.sortProxy = sortProxy;
    }

    @Override
    public Boolean execute() {
        log.info("测试的权限代理执行开始============================================");
        sortProxy.execute();
        log.info("测试的权限代理执行结束============================================");
        return Boolean.TRUE;
    }
}
