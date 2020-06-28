package org.tiankafei.bigdata.spark.stream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * 第一个时间段如果没有执行完成，会阻止后面的继续执行往下执行
 *
 * 使用socketTextStream这个直接接收数据流
 */
object SparkStreamReceiver {

  def main(args: Array[String]): Unit = {
    //local[n]  2个就够了：
    val conf: SparkConf = new SparkConf().setAppName("Spark-Stream-Receiver").setMaster("local[8]")

    // 1个给receiverjob的task，
    // 另一个给beatch计算的job（只不过如果batch比较大，你期望n>2,因为多出来的线程可以跑并行的batch@job@task）

    val stream = new StreamingContext(conf,Seconds(5))
    stream.sparkContext.setLogLevel("ERROR")

    val dataDStream = stream.socketTextStream("localhost",8889)
//    val res = dataDStream.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
//    res.print()

    dataDStream.map(_.split(" ")).map(vars => {
      Thread.sleep(1000 * 5)
      (vars(0), vars(1))
    }).print()

    stream.start()
    stream.awaitTermination()

  }

}
