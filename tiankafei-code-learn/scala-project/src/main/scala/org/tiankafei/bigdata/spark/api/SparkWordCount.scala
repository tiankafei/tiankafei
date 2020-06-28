package org.tiankafei.bigdata.spark.api

import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCount {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("word-count")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val data = sc.parallelize(List(
      "hello world",
      "hello spark",
      "hello world",
      "hello hadoop",
      "hello world",
      "hello msb",
      "hello world"
    ))


//    mapValues和map
//    当key没有发生变化，分区器没有发生变化，分区数没有发生变化，mapValues可以比map少走一次shuffle
//    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).map(x=>(x._1,x._2*10)).groupByKey().foreach(println)
    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).mapValues(_*10).groupByKey().foreach(println)



    while(true){

    }
  }

}
