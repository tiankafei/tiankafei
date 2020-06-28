package org.tiankafei.base.base.sort.decorator;

import org.tiankafei.base.base.sort.MainInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/5/22
 * @Version V1.0
 **/
@Slf4j
public class MainDecorator implements MainInterface {

    /**
     * 观察者模式运行
     */
    @Override
    public void execute() {
        log.info("使用装饰者模式运行开始=========================================================");

        SortDecorator bubbleSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new BubbleSortDecorator())));
        bubbleSortDecorator.execute();

        SortDecorator insertionSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new InsertionSortDecorator())));
        insertionSortDecorator.execute();

        SortDecorator mergeSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new MergeSortDecorator())));
        mergeSortDecorator.execute();

        SortDecorator quickSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new QuickSortDecorator())));
        quickSortDecorator.execute();

        SortDecorator selectionSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new SelectionSortDecorator())));
        selectionSortDecorator.execute();

        SortDecorator shellSortDecorator = new BlackSortDecorator(new BlueSortDecorator(new RedSortDecorator(new ShellSortDecorator())));
        shellSortDecorator.execute();

        log.info("使用装饰者模式运行结束=========================================================");
    }

}
