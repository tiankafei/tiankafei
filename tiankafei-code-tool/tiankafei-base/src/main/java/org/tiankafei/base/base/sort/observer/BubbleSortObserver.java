package org.tiankafei.base.base.sort.observer;

import org.tiankafei.base.base.sort.bubble.BubbleSortFactory;
import org.tiankafei.base.base.sort.factory.SortFactory;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class BubbleSortObserver implements SortObserver {

    @Override
    public void exec() {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new BubbleSortFactory();
        SortFactory<Integer> integerSortFactory = new BubbleSortFactory();

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);
    }

}
