package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.SelectionSortDecorator;
import cn.tiankafei.base.sort.selection.SelectionSortFactory;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class SelectionSortChain implements SortChain {

    @Override
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {
        //装饰着模式
        SelectionSortDecorator selectionSortDecorator = new SelectionSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new SelectionSortFactory();
        SortFactory<Integer> integerSortFactory = new SelectionSortFactory();

        selectionSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        selectionSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        selectionSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        selectionSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
