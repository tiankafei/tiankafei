package org.tiankafei.base.sort.decorator;

import org.tiankafei.base.sort.factory.SortFactory;
import org.tiankafei.base.sort.shell.ShellSortFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BubbleSortDecorator
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class ShellSortDecorator implements SortDecorator {

    @Override
    public void execute() {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new ShellSortFactory();
        SortFactory<Integer> integerSortFactory = new ShellSortFactory();

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);
    }

}
