package org.tiankafei.bigdata.flink

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._

object FlinkWorkCount {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val initStream = env.socketTextStream("bigdata01",8888)

    initStream.flatMap(_.split(" ")).map((_,1)).keyBy(0).sum(1).print()


    env.execute("first flink job")
  }


}
