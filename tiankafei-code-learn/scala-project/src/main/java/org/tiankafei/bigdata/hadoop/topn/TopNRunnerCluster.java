package org.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TopNRunnerCluster {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        System.setProperty("HADOOP_USER_NAME", "root");
        // 让框架知道在windows上执行，需要设置为true
        conf.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(conf);
        // 把本地jar包上传到hadoop上
        job.setJar("E:\\gits\\tiankafei\\tiankafei-code-learn\\scala-project\\target\\scala-project-1.1-SNAPSHOT.jar");
        job.addCacheFile(new Path("/data/topn/dict/dict.txt").toUri());
        job.setJarByClass(TopNRunnerCluster.class);
        // 指定job的名称
        job.setJobName("tiankafei-topn");
        // 指定输入文件的路径
        Path inFile = new Path("/data/topn/input");
        TextInputFormat.addInputPath(job, inFile);
        // 指定输出文件的路径
        Path outFile = new Path("/data/topn/jonioutput");
        if (outFile.getFileSystem(conf).exists(outFile)) {
            outFile.getFileSystem(conf).delete(outFile, true);
        }
        TextOutputFormat.setOutputPath(job, outFile);

        // mapper
        job.setMapperClass(TopNMapper.class);
        // 自定义分区器
        job.setPartitionerClass(TopNPartitioner.class);
        // 自定义mapper的key类型
        job.setMapOutputKeyClass(TopNKey.class);
        job.setMapOutputValueClass(IntWritable.class);
        // 自定义mapper端的排序
        job.setSortComparatorClass(TopNSortComparator.class);
//        job.setCombinerClass(TopNReduce.class);

        // 自定义reduce端的排序
        job.setGroupingComparatorClass(TopNGroupingComparator.class);
        // reduce
        job.setReducerClass(TopNReduce.class);

        job.waitForCompletion(true);
    }

}