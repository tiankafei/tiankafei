package org.tiankafei.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * 客户端在windows上执行，map,reduce在集群环境上运行
 *
 * @Author 魏双双
 * @Date 2019/12/13
 * @Version V1.0
 **/
public class TestMapReduce2 {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        System.setProperty("HADOOP_USER_NAME", "root");
        // 让框架知道在windows上执行，需要设置为true
        conf.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(conf);
        // 把本地jar包上传到hadoop上
        job.setJar("E:\\gits\\tiankafei\\tiankafei-code-learn\\hadoop-project\\target\\hadoop-project-1.1-SNAPSHOT.jar");
        job.setJarByClass(TestMapReduce2.class);
        job.setJobName("tiankafei-wordcount");

//        hdfs dfs -mkdir /data/wc/input
//        hdfs dfs -mkdir /data/wc/output

//        hdfs dfs -ls /
//        hdfs dfs -ls /data/wc/input
//        hdfs dfs -ls /data/wc/output

//        hdfs dfs -put data.txt /data/wc/input
        Path inFile = new Path("/data/wc/input");
        TextInputFormat.addInputPath(job, inFile);

        Path outFile = new Path("/data/wc/output");
        if (outFile.getFileSystem(conf).exists(outFile)) {
            outFile.getFileSystem(conf).delete(outFile, true);
        }
        TextOutputFormat.setOutputPath(job, outFile);

        job.setMapperClass(TestMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(TestReduce.class);

        job.waitForCompletion(true);
    }

}
