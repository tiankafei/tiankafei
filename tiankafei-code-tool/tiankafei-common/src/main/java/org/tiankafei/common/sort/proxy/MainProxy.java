package org.tiankafei.common.sort.proxy;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.common.sort.MainInterface;

/**
 * @Author 魏双双
 * @Date 2020/5/22
 * @Version V1.0
 **/
@Slf4j
public class MainProxy implements MainInterface {

    @Override
    public void execute() {
        log.info("使用动态代理模式运行开始=========================================================");

        BubbleSortProxy bubbleSortProxy = new BubbleSortProxy();
        bubbleSortProxy.execute();

        InsertionSortProxy insertionSortProxy = new InsertionSortProxy();
        insertionSortProxy.execute();

        MergeSortProxy mergeSortProxy = new MergeSortProxy();
        mergeSortProxy.execute();

        QuickSortProxy quickSortProxy = new QuickSortProxy();
        quickSortProxy.execute();

        SelectionSortProxy selectionSortProxy = new SelectionSortProxy();
        selectionSortProxy.execute();

        ShellSortProxy shellSortProxy = new ShellSortProxy();
        shellSortProxy.execute();

        log.info("使用动态代理模式运行结束=========================================================");
    }

}
