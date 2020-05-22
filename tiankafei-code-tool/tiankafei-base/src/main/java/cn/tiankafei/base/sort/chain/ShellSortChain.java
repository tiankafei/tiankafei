package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.SortChain;
import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.decorator.ShellSortDecorator;
import cn.tiankafei.base.sort.shell.ShellSortFactory;

/**
 * 责任链模式：底层使用装饰着模式实现
 *
 * @ClassName BubbleSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class ShellSortChain implements SortChain {

    @Override
    public Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain) {
        //装饰着模式
        ShellSortDecorator shellSortDecorator = new ShellSortDecorator(sortDecorator);

        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new ShellSortFactory();
        SortFactory<Integer> integerSortFactory = new ShellSortFactory();

        shellSortDecorator.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        shellSortDecorator.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        shellSortDecorator.testIntegerMin(integerSortFactory, integerMinSortComparator);
        shellSortDecorator.testIntegerMax(integerSortFactory, integerMaxSortComparator);

        return standSortChain.execute(sortDecorator);
//        return Boolean.TRUE;
    }
}
