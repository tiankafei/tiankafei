package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.bubble.BubbleSortFactory;
import cn.tiankafei.base.sort.decorator.BubbleSortDecorator;

/**
 * 观察者模式：底层使用装饰着模式实现，注释掉责任链模式的实现
 *
 * @ClassName BubbleSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class BubbleSortObserver implements SortObserver {

    @Override
    public void exec(SortDecorator sortDecorator) {
        //装饰着模式
        BubbleSortDecorator bubbleSortDecorator = new BubbleSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new BubbleSortFactory();
        SortFactory<Integer> integerSortFactory = new BubbleSortFactory();

        bubbleSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        bubbleSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        bubbleSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        bubbleSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

//        StandSortChain standSortChain = new StandSortChain();
//        standSortChain.add(new BubbleSortChain());
//        standSortChain.execute(sortDecorator);
    }

}
