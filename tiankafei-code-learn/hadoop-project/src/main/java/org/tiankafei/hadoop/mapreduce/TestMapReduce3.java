package org.tiankafei.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * 客户端在windows上执行，map,reduce也在windows上运行
 * 需要配置本地hadoop环境变量，且hadoop的bin目录需要有winutils.exe这个文件
 *
 * @Author 魏双双
 * @Date 2019/12/13
 * @Version V1.0
 **/
public class TestMapReduce3 {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        System.setProperty("HADOOP_USER_NAME", "root");
        // 让框架知道在windows上执行，需要设置为true
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 让框架在本地运行
        conf.set("mapreduce.framework.name", "local");


        Job job = Job.getInstance(conf);
        job.setJarByClass(TestMapReduce3.class);
        job.setJobName("tiankafei-wordcount");

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
