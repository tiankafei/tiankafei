package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.QuickSortDecorator;
import cn.tiankafei.base.sort.quick.QuickSortFactory;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class QuickSortObserver implements SortObserver {

    @Override
    public void exec(SortDecorator sortDecorator) {
        //装饰着模式
        QuickSortDecorator quickSortDecorator = new QuickSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new QuickSortFactory();
        SortFactory<Integer> integerSortFactory = new QuickSortFactory();

        quickSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        quickSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        quickSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        quickSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

//        StandSortChain standSortChain = new StandSortChain();
//        standSortChain.add(new QuickSortChain());
//        standSortChain.execute(sortDecorator);
    }
}
