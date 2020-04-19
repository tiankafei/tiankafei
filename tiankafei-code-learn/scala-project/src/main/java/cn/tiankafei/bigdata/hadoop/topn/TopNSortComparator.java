package cn.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * map端排序：按照年月正序，温度倒序，减少reduce端IO的拉取
 * @author tiankafei
 * @since 1.0
 **/
public class TopNSortComparator extends WritableComparator {

    public TopNSortComparator() {
        super(TopNKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        TopNKey k1 = (TopNKey) a;
        TopNKey k2 = (TopNKey) b;

        int c1 = Integer.compare(k1.getYear(), k2.getYear());
        if(c1 == 0){
            int c2 = Integer.compare(k1.getMonth(), k2.getMonth());
            if(c2 == 0){
                return -Integer.compare(k1.getWd(), k2.getWd());
            }
            return c2;
        }
        return c1;
    }
}
