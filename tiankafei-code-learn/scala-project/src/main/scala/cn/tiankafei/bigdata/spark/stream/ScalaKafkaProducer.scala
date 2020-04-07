package cn.tiankafei.bigdata.spark.stream

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

object ScalaKafkaProducer {

  def main(args: Array[String]): Unit = {
    val prop = new Properties()
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "bigdata01:9092,bigdata02:9092,bigdata03:9092,bigdata04:9092");
    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])

    val producer = new KafkaProducer[String, String](prop)

    val topicName = "topic01";
    while(true){
      for(i <- 1 to 3; j <- 1 to 3){
        val key = s"key$j"
        val value = s"value$i"
        val record = new ProducerRecord[String, String](topicName, key, value)
        val res = producer.send(record)

        val metadata = res.get()
        val partition = metadata.partition()
        val offset = metadata.offset()
        println(s"key:$key\tvalue:$value\tpatition$partition\toffset:$offset")
      }
//      Thread.sleep(1000)
    }


  }

}
