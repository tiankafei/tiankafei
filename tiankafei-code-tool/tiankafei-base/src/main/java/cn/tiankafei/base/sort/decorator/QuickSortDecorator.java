package cn.tiankafei.base.sort.decorator;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.factory.SortFactory;
import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BubbleSortDecorator
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class QuickSortDecorator implements SortDecorator {

    private SortDecorator sortDecorator;

    public QuickSortDecorator(SortDecorator sortDecorator) {
        this.sortDecorator = sortDecorator;
    }

    @Override
    public void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        log.info("快速排序：浮点型：从小到大：start============");
        sortDecorator.testDoubleMin(sortFactory, doubleSortComparator);
        log.info("快速排序：浮点型：从小到大：finished============");
    }

    @Override
    public void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        log.info("快速排序：浮点型：从大到小：start============");
        sortDecorator.testDoubleMax(sortFactory, doubleSortComparator);
        log.info("快速排序：浮点型：从大到小：finished============");
    }

    @Override
    public void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        log.info("快速排序：整型：从小到大：start============");
        sortDecorator.testIntegerMin(sortFactory, integerSortComparator);
        log.info("快速排序：整型：从小到大：finished============");
    }

    @Override
    public void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        log.info("快速排序：整型：从大到小：start============");
        sortDecorator.testIntegerMax(sortFactory, integerSortComparator);
        log.info("快速排序：整型：从大到小：finished============");
    }
}
