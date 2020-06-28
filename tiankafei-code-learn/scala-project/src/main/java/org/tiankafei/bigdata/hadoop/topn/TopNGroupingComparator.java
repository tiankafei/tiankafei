package org.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * reduce端按照年月分组排序
 * @author tiankafei
 * @since 1.0
 **/
public class TopNGroupingComparator extends WritableComparator {

    public TopNGroupingComparator() {
        super(TopNKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        TopNKey k1 = (TopNKey) a;
        TopNKey k2 = (TopNKey) b;

        int c1 = Integer.compare(k1.getYear(), k2.getYear());
        if(c1 == 0){
            int c2 = Integer.compare(k1.getMonth(), k2.getMonth());
            return c2;
        }
        return c1;
    }
}
