package org.tiankafei.common.sort.proxy;

import org.tiankafei.common.sort.factory.SortFactory;
import org.tiankafei.common.sort.insertion.InsertionSortFactory;
import org.tiankafei.common.sort.singleton.SortFactoryStrategy;
import org.tiankafei.proxy.ProxyUtil;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class InsertionSortProxy implements SortProxy {

    @Override
    public void execute() {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new InsertionSortFactory();
        SortFactory<Integer> integerSortFactory = new InsertionSortFactory();

        SortFactoryStrategy sortFactoryStrategy = ProxyUtil.getProxy(SortProxy.sortFactoryStrategy, new SortProxyAspect("冒泡排序"));

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);
    }
}
