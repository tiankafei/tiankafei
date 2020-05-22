package cn.tiankafei.base.sort.decorator;

import cn.tiankafei.base.sort.factory.SortFactory;
import cn.tiankafei.base.sort.selection.SelectionSortFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BubbleSortDecorator
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class SelectionSortDecorator implements SortDecorator {

    @Override
    public void execute() {
        //工厂方法模式
        SortFactory<Double> doubleSortFactory = new SelectionSortFactory();
        SortFactory<Integer> integerSortFactory = new SelectionSortFactory();

        sortFactoryStrategy.testDoubleMin(doubleSortFactory, doubleMinSortComparator);
        sortFactoryStrategy.testDoubleMax(doubleSortFactory, doubleMaxSortComparator);
        sortFactoryStrategy.testIntegerMin(integerSortFactory, integerMinSortComparator);
        sortFactoryStrategy.testIntegerMax(integerSortFactory, integerMaxSortComparator);
    }

}
