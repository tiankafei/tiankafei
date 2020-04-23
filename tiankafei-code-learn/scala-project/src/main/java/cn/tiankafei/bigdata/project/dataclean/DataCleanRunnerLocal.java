package cn.tiankafei.bigdata.project.dataclean;

import cn.tiankafei.bigdata.hbase.wordcounthdfshbase.HBaseWordCountLocal;
import cn.tiankafei.bigdata.hbase.wordcounthdfshbase.HBaseWordCountReduce;
import cn.tiankafei.bigdata.project.constants.EventLogConstants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * 使用MR对数据进行清洗
 * @author tiankafei
 * @since 1.0
 **/
public class DataCleanRunnerLocal implements Tool {

    private Configuration conf = null;

    public static void main(String[] args) {
        try {
            System.setProperty("HADOOP_USER_NAME", "root");
            ToolRunner.run(new Configuration(true), new DataCleanRunnerLocal(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf());
        // 指定job的名称
        job.setJobName("tiankafei-hbase");

        // 指定输入文件的路径
        Path inFile = new Path("/project/20200423");
        TextInputFormat.addInputPath(job, inFile);

        job.setJarByClass(HBaseWordCountLocal.class);
        job.setMapperClass(DataCleanMapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Put.class);

        TableMapReduceUtil.initTableReducerJob(EventLogConstants.HBASE_NAME_EVENT_LOGS, null, job, null, null, null, null, false);
        job.setNumReduceTasks(0);

        return job.waitForCompletion(true) ? 0 : -1;
    }

    @Override
    public void setConf(Configuration conf) {
        conf.set("hbase.zookeeper.quorum","bigdata01,bigdata02,bigdata03,bigdata04");
        // 让框架知道在windows上执行，需要设置为true
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 让框架在本地运行
        conf.set("mapreduce.framework.name", "local");
        this.conf = HBaseConfiguration.create(conf);
    }

    @Override
    public Configuration getConf() {
        return this.conf;
    }

}
