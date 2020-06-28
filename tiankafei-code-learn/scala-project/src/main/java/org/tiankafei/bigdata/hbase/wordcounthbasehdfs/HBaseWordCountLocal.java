package org.tiankafei.bigdata.hbase.wordcounthbasehdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

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
        // 指定输出文件的路径
        Path outFile = new Path("/data/wc/hbaseoutput");
        if (outFile.getFileSystem(conf).exists(outFile)) {
            outFile.getFileSystem(conf).delete(outFile, true);
        }
        TextOutputFormat.setOutputPath(job, outFile);

        Scan scan = new Scan();
        scan.setCaching(500);
        scan.setCacheBlocks(false);

        // 指定Map处理类
        TableMapReduceUtil.initTableMapperJob("line", scan, HBaseWordCountMapper.class, Text.class, IntWritable.class, job, false);

        // 指定reduce处理类
//        job.setNumReduceTasks(0);
        job.setReducerClass(HBaseWordCountReduce.class);
        job.setOutputValueClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.waitForCompletion(true);
    }

}
