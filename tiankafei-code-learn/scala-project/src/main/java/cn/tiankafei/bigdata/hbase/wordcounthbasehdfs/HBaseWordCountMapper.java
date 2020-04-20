package cn.tiankafei.bigdata.hbase.wordcounthbasehdfs;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HBaseWordCountMapper extends TableMapper<Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(ImmutableBytesWritable key, Result result, Context context) throws IOException, InterruptedException {
        String mapKey = Bytes.toString(key.get());
        Cell cell = result.getColumnLatestCell(Bytes.toBytes("cf"),Bytes.toBytes("word"));
        String line = Bytes.toString(CellUtil.cloneValue(cell));
        word.set(mapKey + "---" + line);
        context.write(word, one);
    }
}