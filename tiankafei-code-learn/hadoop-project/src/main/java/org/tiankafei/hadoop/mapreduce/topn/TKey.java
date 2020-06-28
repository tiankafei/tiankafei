package org.tiankafei.hadoop.mapreduce.topn;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * //自定义类型必须实现接口： 序列化/反序列化   比较器
 * <p>
 * ***************
 * 对key进行排序 *
 * 对key进行排序 *
 * 对key进行排序 *
 * ***************
 *
 * @Author tiankafei
 * @Date 2019/12/15
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class TKey implements WritableComparable<TKey> {

    private int year;

    private int month;

    private int days;

    private int wd;

    @Override
    public int compareTo(TKey that) {
        //我们为了让这个案例体现api开发，所以下边的逻辑是一种通用的逻辑：按照时间正序，
        //但是我们目前业务需要的是  年，月，温度，且温度倒序，所以一会还得开发一个sortComparator。。。。

        //the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
        int c1 = Integer.compare(this.year, that.getYear());

        if (c1 == 0) {
            int c2 = Integer.compare(this.month, that.getMonth());
            if (c2 == 0) {
                return Integer.compare(this.days, that.getDays());
            }
            return c2;
        }

        return c1;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(year);
        out.writeInt(month);
        out.writeInt(days);
        out.writeInt(wd);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.year = in.readInt();
        this.month = in.readInt();
        this.days = in.readInt();
        this.wd = in.readInt();
    }
}
