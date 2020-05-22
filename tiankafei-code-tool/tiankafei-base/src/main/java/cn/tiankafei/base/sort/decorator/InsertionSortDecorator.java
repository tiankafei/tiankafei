package cn.tiankafei.base.sort.decorator;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
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
public class InsertionSortDecorator implements SortDecorator {

    private SortDecorator sortDecorator;

    public InsertionSortDecorator(SortDecorator sortDecorator) {
        this.sortDecorator = sortDecorator;
    }

    @Override
    public void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        log.info("直接插入排序：浮点型：从小到大：start============");
        sortDecorator.testDoubleMin(sortFactory, doubleSortComparator);
        log.info("直接插入排序：浮点型：从小到大：finished============");
    }

    @Override
    public void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        log.info("直接插入排序：浮点型：从大到小：start============");
        sortDecorator.testDoubleMax(sortFactory, doubleSortComparator);
        log.info("直接插入排序：浮点型：从大到小：finished============");
    }

    @Override
    public void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        log.info("直接插入排序：整型：从小到大：start============");
        sortDecorator.testIntegerMin(sortFactory, integerSortComparator);
        log.info("直接插入排序：整型：从小到大：finished============");
    }

    @Override
    public void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        log.info("直接插入排序：整型：从大到小：start============");
        sortDecorator.testIntegerMax(sortFactory, integerSortComparator);
        log.info("直接插入排序：整型：从大到小：finished============");
    }
}
