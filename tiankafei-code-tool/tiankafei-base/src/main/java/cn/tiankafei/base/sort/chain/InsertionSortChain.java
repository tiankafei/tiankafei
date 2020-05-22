package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.InsertionSortDecorator;
import cn.tiankafei.base.sort.insertion.InsertionSortFactory;

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
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {
        //装饰着模式
        InsertionSortDecorator insertionSortDecorator = new InsertionSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new InsertionSortFactory();
        SortFactory<Integer> integerSortFactory = new InsertionSortFactory();

        insertionSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        insertionSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        insertionSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        insertionSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
