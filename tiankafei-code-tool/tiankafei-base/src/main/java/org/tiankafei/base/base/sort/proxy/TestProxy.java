package org.tiankafei.base.base.sort.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class TestProxy implements SortProxy {

    @Override
    public void execute() {
        log.info("代理需要执行的测试内容！！！！！！！！！！！！！！");
    }
}
