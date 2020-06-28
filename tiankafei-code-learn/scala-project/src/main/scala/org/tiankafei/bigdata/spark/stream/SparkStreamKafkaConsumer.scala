package org.tiankafei.bigdata.spark.stream

import java.util

import org.apache.kafka.clients.consumer.{ConsumerConfig, OffsetAndMetadata, OffsetCommitCallback}
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{CanCommitOffsets, ConsumerStrategies, HasOffsetRanges, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreamKafkaConsumer {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("Spark-Stream-Kafka-Consumer").setMaster("local[8]")

    val stream = new StreamingContext(conf,Seconds(5))
    stream.sparkContext.setLogLevel("ERROR")

    val map = Map(
      (ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "bigdata01:9092,bigdata02:9092,bigdata03:9092,bigdata04:9092"),
      (ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer]),
      (ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer]),
      (ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "1000"),
      (ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "1024"),
      (ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest"),
      (ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"),
      (ConsumerConfig.GROUP_ID_CONFIG, "g12"),

    )
    val topics = List("topic01")

    val kafka = KafkaUtils.createDirectStream(stream, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](topics, map))
    kafka.map(record => {
      val topic = record.topic()
      val partition = record.partition()
      val offset = record.offset()
      val key = record.key()
      val value = record.value()
      val timestamp = record.timestamp()
//      println(s"topic:$topic\tpartition:$partition\toffset:$offset\tkey:$key\tvalue:$value\ttimestamp:$timestamp")

      (topic, partition, offset, key, value, timestamp)
    }).print()

//    kafka.foreachRDD(rdd => {
//      val ranges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
//
//      // 提交offset
//      rdd.asInstanceOf[CanCommitOffsets].commitAsync(ranges, new OffsetCommitCallback {
//        override def onComplete(offsets: util.Map[TopicPartition, OffsetAndMetadata], exception: Exception): Unit = {
//
//
//        }
//      })
//
//    })

    stream.start()
    stream.awaitTermination()
  }


}
