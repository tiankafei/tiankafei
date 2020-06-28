package org.tiankafei.base.base.sort.proxy;

import org.tiankafei.base.base.sort.bubble.BubbleSortFactory;
import org.tiankafei.base.base.sort.factory.SortFactory;
import org.tiankafei.base.base.sort.singleton.SortFactoryStrategy;
import cn.tiankafei.proxy.ProxyUtil;

/**
 * @Author 魏双双
 * @Date 2020/5/22
 * @Version V1.0
 **/
public class BubbleSortProxy implements SortProxy {

    @Override
    public void execute() {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new BubbleSortFactory();
        SortFactory<Integer> integerSortFactory = new BubbleSortFactory();

        SortFactoryStrategy sortFactoryStrategy = ProxyUtil.getProxy(SortProxy.sortFactoryStrategy, new SortProxyAspect("冒泡排序"));

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);
    }

}
