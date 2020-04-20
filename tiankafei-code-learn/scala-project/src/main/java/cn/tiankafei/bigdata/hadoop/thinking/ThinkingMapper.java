package cn.tiankafei.bigdata.hadoop.thinking;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ThinkingMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text mapKey = new Text();
    private IntWritable mapValue = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 好友1 好友2 好友3 好友4

        String[] arr = StringUtils.split(value.toString(), ' ');
        for (int i = 0, length = arr.length; i < length; i++) {
            String v1 = arr[i];
            for (int j = i + 1; j < length; j++) {
                String v2 = arr[j];

                String key1 = "";
                int c1 = v1.compareTo(v2);
                if(c1 > 0){
                    key1 = v1 + " " + v2;
                }else{
                    key1 = v2 + " " + v1;
                }
                if(i == 0){
                    // 直接好友是0
                    mapKey.set(key1);
                    mapValue.set(0);
                    context.write(mapKey, mapValue);
                }else{
                    // 间接好友是1
                    mapKey.set(key1);
                    mapValue.set(1);
                    context.write(mapKey, mapValue);
                }
            }
        }
    }
}
