package com.tiankafei.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @Author 魏双双
 * @Date 2019/12/13
 * @Version V1.0
 **/
public class TestMapReduce2 {

    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");

        Configuration conf = new Configuration(true);
        conf.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(conf);
        job.setJar("E:\\gits\\tiankafei-core\\tiankafei-bigdata\\target\\tiankafei-bigdata-1.0-RELEASE.jar");
        job.setJarByClass(TestMapReduce2.class);
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
