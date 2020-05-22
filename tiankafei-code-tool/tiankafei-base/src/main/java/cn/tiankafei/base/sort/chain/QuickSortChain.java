package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.QuickSortDecorator;
import cn.tiankafei.base.sort.quick.QuickSortFactory;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class QuickSortChain implements SortChain {

    @Override
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {
        //装饰着模式
        QuickSortDecorator quickSortDecorator = new QuickSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new QuickSortFactory();
        SortFactory<Integer> integerSortFactory = new QuickSortFactory();

        quickSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        quickSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        quickSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        quickSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
