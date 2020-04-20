package cn.tiankafei.bigdata.hbase.wordcounthbasehdfs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HBaseWordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();

    /**
     * 相同的key为一组 ，这一组数据调用一次reduce
     * @param key          map阶段的key值
     * @param values       map阶段的value值
     * @param context      上下文对象
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        Iterator<IntWritable> iterator = values.iterator();
        if(iterator.hasNext()){
            IntWritable next = iterator.next();
            sum += next.get();
        }
        result.set(sum);
        context.write(key, result);
    }

}
