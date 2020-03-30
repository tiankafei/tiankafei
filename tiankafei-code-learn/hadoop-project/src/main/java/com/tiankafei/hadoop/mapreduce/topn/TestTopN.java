package com.tiankafei.hadoop.mapreduce.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @Author tiankafei
 * @Date 2019/12/15
 * @Version V1.0
 **/
public class TestTopN {

    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");

        Configuration conf = new Configuration(true);
        conf.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(conf);
        job.setJarByClass(TestTopN.class);

        job.setJobName("tiankafei-topn");

        job.setJar("E:\\gits\\tiankafei-core\\tiankafei-bigdata\\target\\tiankafei-bigdata-1.0-RELEASE.jar");
//        //客户端规划的时候讲join的右表cache到mapTask出现的节点上
//        job.addCacheFile(new Path("/data/topn/dict/dict.txt").toUri());

        //输入目录
        Path inPath = new Path("/data/topn/input");
        TextInputFormat.addInputPath(job, inPath);

        //输出目录
        Path outPath = new Path("/data/topn/output");
        if (outPath.getFileSystem(conf).exists(outPath)) {
            outPath.getFileSystem(conf).delete(outPath, true);
        }
        TextOutputFormat.setOutputPath(job, outPath);

        //==========mapTask=============
        //mapper
        //key
        //value
        //partitioner  按  年，月  分区  -》  分区 > 分组  按 年分区！！！！！！分区器潜台词：满足  相同的key获得相同的分区号就可以~！
        //sortComparator  年，月，温度  且  温度倒序
        //combine
//        job.setCombinerClass();
        job.setMapperClass(TMapper.class);
        job.setMapOutputKeyClass(TKey.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setPartitionerClass(TPartitioner.class);
        job.setSortComparatorClass(TSortComparator.class);

        //reduceTask
        //reduce
        //groupingComparator
        job.setReducerClass(TReduce.class);
        job.setGroupingComparatorClass(TGroupingComparator.class);

        job.waitForCompletion(true);
    }

}
