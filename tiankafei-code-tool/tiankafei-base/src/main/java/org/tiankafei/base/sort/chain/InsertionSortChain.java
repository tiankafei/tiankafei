package org.tiankafei.base.sort.chain;

import org.tiankafei.base.sort.factory.SortFactory;
import org.tiankafei.base.sort.insertion.InsertionSortFactory;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class InsertionSortChain implements SortChain {

    @Override
    public Boolean execute(StandSortChain standSortChain) {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new InsertionSortFactory();
        SortFactory<Integer> integerSortFactory = new InsertionSortFactory();

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute();
    }
}
