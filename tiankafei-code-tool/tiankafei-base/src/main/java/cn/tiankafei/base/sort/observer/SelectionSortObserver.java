package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.SelectionSortDecorator;
import cn.tiankafei.base.sort.selection.SelectionSortFactory;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class SelectionSortObserver implements SortObserver {

    @Override
    public void exec(SortDecorator sortDecorator) {
        //装饰着模式
        SelectionSortDecorator selectionSortDecorator = new SelectionSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new SelectionSortFactory();
        SortFactory<Integer> integerSortFactory = new SelectionSortFactory();

        selectionSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        selectionSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        selectionSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        selectionSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

//        StandSortChain standSortChain = new StandSortChain();
//        standSortChain.add(new SelectionSortChain());
//        standSortChain.execute(sortDecorator);
    }
}
