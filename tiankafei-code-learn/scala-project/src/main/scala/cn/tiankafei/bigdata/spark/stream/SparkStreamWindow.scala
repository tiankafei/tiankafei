package cn.tiankafei.bigdata.spark.stream

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Duration, State, StateSpec, StreamingContext}

/**
 * spark-stream 窗口练习
 */
object SparkStreamWindow {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Spark-Stream-Window")
    val sparkContext = new SparkContext(conf)
    sparkContext.setLogLevel("ERROR")
    sparkContext.setCheckpointDir(".")

    val stream = new StreamingContext(sparkContext, Duration(1000))

    val dataDStream = stream.socketTextStream("localhost", 8889)
    val format = dataDStream.map(_.split(" ")).map(x => (x(0), 1))

    format.mapWithState(StateSpec.function(
      (k: String, nv: Option[Int], ov: State[Int]) => {
        println(s"*************k:$k  nv:${nv.getOrElse(0)}   ov ${ov.getOption().getOrElse(0)}")
        (k, nv.getOrElse(0) + ov.getOption().getOrElse(0))
      }
    )).print()

    // 按批计算所有历史的批次的数据
    //    format.updateStateByKey(
    //      (nv: Seq[Int], ov: Option[Int]) => {
    //
    //        val count = nv.count(_ > 0)
    //        val oldValue = ov.getOrElse(0)
    //
    //        println(s"nv----------$nv------count:$count-----oldValue:$oldValue-------")
    //        Some(count + oldValue)
    //      }
    //    ).print()

    // windows api
    // 1秒打印一次
    //    format.reduceByKey(_+_).mapPartitions(iter => {println("1s"); iter}).print()

    // 5秒打印一次
    //    format.window(Duration(5000), Duration(5000)).reduceByKey(_+_).mapPartitions(iter => {println("5s"); iter}).print()

    //    format.reduceByKey(_+_).print()
    //    format.reduceByKey(_+_).window(Duration(5000)).print()
    //    format.window(Duration(5000)).reduceByKey(_+_).print()
    //    format.reduceByKeyAndWindow(_+_, Duration(5000)).print()

    //    format.reduceByKeyAndWindow(
    //      (ov:Int, nv:Int) => {
    //        ov + nv
    //      },
    //      (ov:Int, oov:Int) => {
    //        ov - oov
    //      },
    //      Duration(5000)
    //    ).print()
    //    format.reduceByKeyAndWindow(_ + _, _ - _, Duration(5000)).print()


    // 广播变量
    //    var broadcast = sparkContext.broadcast((1 to 5).toList)
    //    format.reduceByKeyAndWindow(_+_, Duration(5000)).filter(x=> broadcast.value.contains(x._2)).print()
    // 动态广播变量
    //    var jobNum = 0
    //    format.reduceByKeyAndWindow(_+_, Duration(5000
    //    )).transform(
    //      (rdd) => {
    //        jobNum += 1
    //        println(s"jobNum:$jobNum")
    //        if(jobNum <= 5){
    //          broadcast = sparkContext.broadcast((1 to 5).toList)
    //        }else{
    //          broadcast = sparkContext.broadcast((6 to 10).toList)
    //        }
    //        rdd.filter(x => broadcast.value.contains(x._2))
    //      }
    //    ).print()

    //    format.window(Duration(2000)).transform(
    //      (rdd) => {
    //        println(s"每job调用一次哦")
    //        rdd.map(x=>{
    //          println(s"这是记录级的")
    //          x
    //        })
    //      }
    //    ).print()
    // 最后处理
    //    format.foreachRDD((rdd) => {
    //      println("-----这是终结函数----------")
    //      rdd.foreach(x => {
    //        println(x)
    //      })
    //      println("---------------")
    //    })
    //中途加工
    //    format.transform((rdd) => {
    //      rdd.foreach(println)
    //      rdd.map(x => (x._1, x._2 * 10))
    //    }).print()


    stream.start()
    stream.awaitTermination()
  }


}
