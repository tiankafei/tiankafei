package org.tiankafei.bigdata.spark.stream

import java.time.Duration
import java.util
import java.util.Properties
import java.util.regex.Pattern

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRebalanceListener, KafkaConsumer, OffsetAndMetadata, OffsetCommitCallback}
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer

object ScalaKafkaConsumer {

  def main(args: Array[String]): Unit = {
    val prop = new Properties()
    prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "bigdata01:9092,bigdata02:9092,bigdata03:9092,bigdata04:9092")
    prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    prop.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "1000")
    prop.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "1024")

    // 消费最早的记录开始
    prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    // offset不自动提交
    prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
    prop.put(ConsumerConfig.GROUP_ID_CONFIG, "g11")

    val consumer = new KafkaConsumer[String, String](prop)
    val topicName = "topic01";
    consumer.subscribe(Pattern.compile(topicName), new ConsumerRebalanceListener {
      override def onPartitionsRevoked(partitions: util.Collection[TopicPartition]): Unit = {
        println("onPartitionsRevoked")
        val iter = partitions.iterator()
        while(iter.hasNext){
          val partition = iter.next()
          print(s"分区$partition\t")
        }
        println("不归我管了")
      }

      override def onPartitionsAssigned(partitions: util.Collection[TopicPartition]): Unit = {
        println("onPartitionsAssigned")
        val iter = partitions.iterator()
        while(iter.hasNext){
          val partition = iter.next()
          print(s"分区$partition\t")
        }
        println("归我管了")
      }
    })

    val partitionToMetadata = new util.HashMap[TopicPartition, OffsetAndMetadata]()
    var globalPartition = 0;
    var globalOffset: Long = 0;

    while(true){
      val records = consumer.poll(Duration.ofMillis(0))
      if(!records.isEmpty){
        println(s"本次接收到记录数${records.count()}")

        val iter = records.iterator()
        while(iter.hasNext){
          val record = iter.next()
          val topic = record.topic()
          val partition = record.partition()
          val offset = record.offset()
          val key = record.key()
          val value = record.value()
          val timestamp = record.timestamp()
          println(s"topic:$topic\tpartition:$partition\toffset:$offset\tkey:$key\tvalue:$value\ttimestamp:$timestamp")
          globalPartition = partition
          globalOffset = offset + 1
        }

        val topicPartition = new TopicPartition(topicName, globalPartition)
        val offsetAndMetadata = new OffsetAndMetadata(globalOffset)
        partitionToMetadata.put(topicPartition, offsetAndMetadata)

        consumer.commitAsync(partitionToMetadata, new OffsetCommitCallback {
          override def onComplete(offsets: util.Map[TopicPartition, OffsetAndMetadata], exception: Exception): Unit = {
//            println("手动提交offset完成")
          }
        })

      }
    }


  }

}
