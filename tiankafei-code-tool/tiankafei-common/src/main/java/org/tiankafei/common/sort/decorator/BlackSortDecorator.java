package org.tiankafei.common.sort.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/5/22
 * @Version V1.0
 **/
@Slf4j
public class BlackSortDecorator implements SortDecorator {

    private SortDecorator sortDecorator;

    public BlackSortDecorator(SortDecorator sortDecorator) {
        this.sortDecorator = sortDecorator;
    }

    @Override
    public void execute() {
        log.info("使用：{} 进行装饰", this.getClass());
        sortDecorator.execute();
    }
}
