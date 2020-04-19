package cn.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TopNReduce extends Reducer<TopNKey, IntWritable, Text, IntWritable> {

    private Text reduceKey = new Text();
    private IntWritable reduceValue = new IntWritable();

    @Override
    protected void reduce(TopNKey key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // 因为是按照年月进行的分区，故每次迭代value，key会跟着发生变化；如果是根据key进行分区的，则值不会变化
        int index = 0;
        int dayFlag = 0;
        Iterator<IntWritable> iterator = values.iterator();
        while(iterator.hasNext()){
            IntWritable next = iterator.next();

            int year = key.getYear();
            int month = key.getMonth();
            int day = key.getDay();
            int wd = key.getWd();

            if(index == 0){
                reduceKey.set(year + "-" + month + "-" + day + "----" + key.getLocation());
                reduceValue.set(wd);
                context.write(reduceKey, reduceValue);
                dayFlag = day;
            }

            if(index != 0 && dayFlag != day){
                reduceKey.set(year + "-" + month + "-" + day + "----" + key.getLocation());
                reduceValue.set(wd);
                context.write(reduceKey, reduceValue);
                break;
            }
            index++;
        }
    }
}
