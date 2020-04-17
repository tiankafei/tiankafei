package cn.tiankafei.bigdata.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * 打成jar包上传到集群环境上，在集群上通过 hadoop -jar 运行
 * @author tiankafei
 * @since 1.0
 **/
public class HadoopWordCountJar {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        Job job = Job.getInstance(conf);
        job.setJarByClass(HadoopWordCountJar.class);
        // 指定job的名称
        job.setJobName("tiankafei-wordcount");
        // 指定输入文件的路径
        Path inFile = new Path("/data/wc/input");
        TextInputFormat.addInputPath(job, inFile);
        // 指定输出文件的路径
        Path outFile = new Path("/data/wc/output");
        if (outFile.getFileSystem(conf).exists(outFile)) {
            outFile.getFileSystem(conf).delete(outFile, true);
        }
        TextOutputFormat.setOutputPath(job, outFile);

        // 指定Map处理类
        job.setMapperClass(HadoopMapper.class);
        // 指定map的输出key类型
        job.setMapOutputKeyClass(Text.class);
        // 指定map的输出value类型
        job.setMapOutputValueClass(IntWritable.class);

        // 指定reduce处理类
        job.setReducerClass(HadoopReduce.class);

        job.waitForCompletion(true);
    }

}
