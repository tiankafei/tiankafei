package org.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 按照年月进行分区，年月会拉到一个组里
 * @author tiankafei
 * @since 1.0
 **/
public class TopNPartitioner extends Partitioner<TopNKey, IntWritable> {

    @Override
    public int getPartition(TopNKey topNKey, IntWritable intWritable, int numPartitions) {
        return (topNKey.getYear() + topNKey.getMonth()) % numPartitions;
    }
}
