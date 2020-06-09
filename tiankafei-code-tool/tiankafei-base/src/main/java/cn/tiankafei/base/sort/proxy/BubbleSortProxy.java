package cn.tiankafei.base.sort.proxy;

import cn.tiankafei.base.sort.bubble.BubbleSortFactory;
import cn.tiankafei.base.sort.factory.SortFactory;
import cn.tiankafei.base.sort.singleton.SortFactoryStrategy;
import cn.tiankafei.proxy.utils.ProxyUtil;

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
