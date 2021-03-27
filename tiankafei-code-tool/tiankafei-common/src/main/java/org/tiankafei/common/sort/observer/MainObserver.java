package org.tiankafei.common.sort.observer;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.common.sort.MainInterface;
import org.tiankafei.common.sort.observer.event.ObserverEvent;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class MainObserver implements MainInterface {

    /**
     * 观察者模式运行
     */
    @Override
    public void execute() {
        log.info("使用观察者模式运行开始=========================================================");
        //声明被观察者对象
        StandSortObservable standSortObservable = new StandSortObservable();
        //添加观察者
        standSortObservable.addObserver(new BubbleSortObserver());
        standSortObservable.addObserver(new InsertionSortObserver());
        standSortObservable.addObserver(new MergeSortObserver());
        standSortObservable.addObserver(new QuickSortObserver());
        standSortObservable.addObserver(new SelectionSortObserver());
        standSortObservable.addObserver(new ShellSortObserver());
        standSortObservable.execute(new ObserverEvent());
        log.info("使用观察者模式运行结束=========================================================");
    }

}
