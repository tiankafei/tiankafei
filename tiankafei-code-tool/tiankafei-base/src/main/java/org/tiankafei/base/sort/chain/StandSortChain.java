package org.tiankafei.base.sort.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式的链路管理集合
 *
 * @ClassName StandSortChain
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class StandSortChain {

    private List<SortChain> chainList = new ArrayList<>();

    private int index = 0;

    public StandSortChain add(SortChain sortChain) {
        chainList.add(sortChain);
        return this;
    }

    public Boolean execute() {
        if (index == chainList.size()) {
            return false;
        }
        SortChain c = chainList.get(index);
        index++;
        return c.execute(this);
    }
}
