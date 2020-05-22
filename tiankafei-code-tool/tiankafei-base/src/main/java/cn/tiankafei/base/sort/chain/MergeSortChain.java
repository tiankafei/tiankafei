package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.MergeSortDecorator;
import cn.tiankafei.base.sort.merge.MergeSortFactory;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class MergeSortChain implements SortChain {

    @Override
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {

        //装饰着模式
        MergeSortDecorator mergeSortDecorator = new MergeSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new MergeSortFactory();
        SortFactory<Integer> integerSortFactory = new MergeSortFactory();

        mergeSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        mergeSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        mergeSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        mergeSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
