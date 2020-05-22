package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.bubble.BubbleSortFactory;
import cn.tiankafei.base.sort.decorator.BubbleSortDecorator;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class BubbleSortChain implements SortChain {

    @Override
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {
        //装饰着模式
        BubbleSortDecorator bubbleSortDecorator = new BubbleSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new BubbleSortFactory();
        SortFactory<Integer> integerSortFactory = new BubbleSortFactory();

        bubbleSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        bubbleSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        bubbleSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        bubbleSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
