package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortObserver;
import cn.tiankafei.base.sort.observer.event.ObserverEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StandSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class StandSortObserver {

    /**
     * 已注册的观察者
     */
    private List<SortObserver> observerList = new ArrayList<>();

    /**
     * 然观察者进行执行
     *
     * @param event
     */
    public void execute(ObserverEvent event) {
        for (int index = 0, length = observerList.size(); index < length; index++) {
            SortObserver sortObserver = observerList.get(index);
            sortObserver.action(event);
        }
    }

    /**
     * 添加观察者的实现
     *
     * @param observer
     */
    public void addObserver(SortObserver observer) {
        observerList.add(observer);
    }

}
