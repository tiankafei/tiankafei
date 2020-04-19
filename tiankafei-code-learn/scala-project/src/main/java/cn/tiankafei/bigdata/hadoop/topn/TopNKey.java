package cn.tiankafei.bigdata.hadoop.topn;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 使用默认通用的排序比较器：按照年月日正序
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class TopNKey implements WritableComparable<TopNKey> {

    private int year;
    private int month;
    private int day;
    private int wd;

    @Override
    public int compareTo(TopNKey that) {
        int c1 = Integer.compare(this.year, that.getYear());
        if(c1 == 0){
            int c2 = Integer.compare(this.month, that.getMonth());
            if(c2 == 0){
                return Integer.compare(this.day, that.getDay());
            }
        }
        return c1;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.year);
        out.writeInt(this.month);
        out.writeInt(this.day);
        out.writeInt(this.wd);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.wd = in.readInt();
    }
}
