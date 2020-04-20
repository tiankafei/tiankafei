package cn.tiankafei.bigdata.hbase.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HBaseWordCountLocal {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        System.setProperty("HADOOP_USER_NAME", "root");
        conf.set("hbase.zookeeper.quorum","bigdata01,bigdata02,bigdata03,bigdata04");
        // 让框架知道在windows上执行，需要设置为true
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 让框架在本地运行
        conf.set("mapreduce.framework.name", "local");

        Job job = Job.getInstance(conf);
        job.setJarByClass(HBaseWordCountLocal.class);
        // 指定job的名称
        job.setJobName("tiankafei-hbase");
        // 指定输入文件的路径
        Path inFile = new Path("/data/wc/input");
        TextInputFormat.addInputPath(job, inFile);

        // 指定Map处理类
        job.setMapperClass(HBaseWordCountMapper.class);
        // 指定map的输出key类型
        job.setMapOutputKeyClass(Text.class);
        // 指定map的输出value类型
        job.setMapOutputValueClass(IntWritable.class);

        // 指定reduce处理类
        TableMapReduceUtil.initTableReducerJob("wc", HBaseWordCountReduce.class, job, null, null, null, null, false);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Put.class);

        job.waitForCompletion(true);
    }

}
