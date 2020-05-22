package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.SortObserver;
import cn.tiankafei.base.sort.decorator.MergeSortDecorator;
import cn.tiankafei.base.sort.merge.MergeSortFactory;
import cn.tiankafei.base.sort.observer.event.ObserverEvent;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class MergeSortObserver implements SortObserver {

    @Override
    public <T> void action(ObserverEvent<T> event) {
        SortDecorator sortDecorator = (SortDecorator) event.getSource();
        //装饰着模式
        MergeSortDecorator mergeSortDecorator = new MergeSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new MergeSortFactory();
        SortFactory<Integer> integerSortFactory = new MergeSortFactory();

        mergeSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        mergeSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        mergeSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        mergeSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

//        StandSortChain standSortChain = new StandSortChain();
//        standSortChain.add(new MergeSortChain());
//        standSortChain.execute(sortDecorator);
    }
}
