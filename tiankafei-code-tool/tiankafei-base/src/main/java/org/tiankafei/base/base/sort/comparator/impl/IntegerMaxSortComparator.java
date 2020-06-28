package org.tiankafei.base.base.sort.comparator.impl;

import org.tiankafei.base.base.sort.comparator.IntegerSortComparator;

/**
 * @ClassName SelectionSortUtil
 * @Description: 整型从大到小的策略模式的选择排序方法
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
public class IntegerMaxSortComparator implements IntegerSortComparator {

    /**
     * 前者大于后者返回1，前者小于后者返回-1，前者等于后者返回0
     *
     * @param t1
     * @param t2
     * @return 1,-1,0
     */
    @Override
    public int compareTo(Integer t1, Integer t2) {
        if (t1 > t2) {
            return -1;
        } else if (t1 < t2) {
            return 1;
        }
        return 0;
    }

}
