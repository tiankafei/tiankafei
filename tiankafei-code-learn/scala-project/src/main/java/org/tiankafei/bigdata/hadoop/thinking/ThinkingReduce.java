package org.tiankafei.bigdata.hadoop.thinking;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ThinkingReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable reduceValue = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        Iterator<IntWritable> iterator = values.iterator();
        while(iterator.hasNext()){
            IntWritable next = iterator.next();

            int v = next.get();
            if(v == 0){
                // 如果是直接好友，则直接跳出
                break;
            }
            // 间接好友+1，数值越大，共同好友越多
            sum += v;
        }
        if(sum != 0){
            // 只输出间接好友
            reduceValue.set(sum);
            context.write(key, reduceValue);
        }
    }
}
