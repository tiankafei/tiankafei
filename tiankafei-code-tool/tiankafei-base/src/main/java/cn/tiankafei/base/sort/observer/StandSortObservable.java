package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import java.util.Observable;

/**
 * 这是被监听的对象
 *
 * @ClassName StandSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class StandSortObservable extends Observable {

    public void execute(SortDecorator sortDecorator) {
        setChanged();
        notifyObservers(sortDecorator);
        clearChanged();
    }

}
