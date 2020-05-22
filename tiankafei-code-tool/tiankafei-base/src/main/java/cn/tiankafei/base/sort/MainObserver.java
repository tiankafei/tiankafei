package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.decorator.StandSortDecorator;
import cn.tiankafei.base.sort.observer.BubbleSortObserver;
import cn.tiankafei.base.sort.observer.InsertionSortObserver;
import cn.tiankafei.base.sort.observer.MergeSortObserver;
import cn.tiankafei.base.sort.observer.QuickSortObserver;
import cn.tiankafei.base.sort.observer.SelectionSortObserver;
import cn.tiankafei.base.sort.observer.ShellSortObserver;
import cn.tiankafei.base.sort.observer.StandSortObserver;
import cn.tiankafei.base.sort.observer.event.ObserverEvent;
import lombok.extern.slf4j.Slf4j;

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
        //装饰着模式
        SortDecorator sortDecorator = new StandSortDecorator();
        //声明观察者管理类
        StandSortObserver standSortObserver = new StandSortObserver();
        //添加观察者
        standSortObserver.addObserver(new BubbleSortObserver());
        standSortObserver.addObserver(new InsertionSortObserver());
        standSortObserver.addObserver(new MergeSortObserver());
        standSortObserver.addObserver(new QuickSortObserver());
        standSortObserver.addObserver(new SelectionSortObserver());
        standSortObserver.addObserver(new ShellSortObserver());
        /**
         * 触发观察者观察的事件（可能是别的线程的调用）
         *      standSortObserver.execute(event);
         * 声明事件源对象（调用线程创建的）
         *      ObserverEvent event = new ObserverEvent();
         *      event.setSource(sortDecorator);
         */
        ObserverEvent event = new ObserverEvent();
        event.setSource(sortDecorator);
        standSortObserver.execute(event);
        log.info("使用观察者模式运行结束=========================================================");
    }

}
