package cn.tiankafei.bigdata.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * 打成jar包上传到集群环境上，在集群上通过java -jar 运行
 * @author tiankafei
 * @since 1.0
 **/
public class HadoopWordCountJar {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration(true);
        Job job = Job.getInstance(conf);
        job.setJarByClass(HadoopWordCountJar.class);
        job.setJobName("tiankafei-wordcount");

        Path inFile = new Path("/data/wc/input");
        TextInputFormat.addInputPath(job, inFile);

        Path outFile = new Path("/data/wc/output");
        if (outFile.getFileSystem(conf).exists(outFile)) {
            outFile.getFileSystem(conf).delete(outFile, true);
        }
        TextOutputFormat.setOutputPath(job, outFile);

        job.setMapperClass(HadoopMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(HadoopReduce.class);

        job.waitForCompletion(true);
    }

}
