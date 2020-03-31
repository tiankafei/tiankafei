package cn.tiankafei.bigdata.spark.api

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * RDD聚合操作
 */
object SparkAggregation {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("aggregation")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val data: RDD[(String, Int)] = sc.parallelize(List(
      ("zhangsan", 234),
      ("zhangsan", 5667),
      ("zhangsan", 343),
      ("lisi", 212),
      ("lisi", 44),
      ("lisi", 33),
      ("wangwu", 535),
      ("wangwu", 22)
    ))
    println("-----------行转列（多行变一行）-----------")
    val groupByData = data.groupByKey()

    groupByData.foreach(println)
    println("-----------列转行（一行变多行）-----------")
    groupByData.flatMap(  e => e._2.map( (e._1, _) ) ).foreach(println)

    println("-----------列转行（一行变多行）-----------")
    groupByData.flatMapValues(_.iterator).foreach(println)

    println("-----------取每个key最大的前两位（一行还是一行）-----------")
    groupByData.mapValues(v => v.toList.sortBy(x => -x).take(2)).foreach(println)

    println("-----------取每个key最大的前两位（一行变多行）-----------")
    groupByData.flatMapValues(v => v.toList.sortBy(x => -x).take(2)).foreach(println)

    println("-----------sum,count,max,min,age-----------")
    val sumRes = data.reduceByKey(_ + _)
    val maxRes = data.reduceByKey((a, b) => if (a > b) a else b)
    val minRes = data.reduceByKey((a, b) => if (a < b) a else b)
//    val countRes = data.map(x => (x._1, 1)).reduceByKey(_ + _)
    val countRes = data.mapValues(x=>1).reduceByKey(_ + _)

//    val avgRes = sumRes.join(countRes).map(e => (e._1, e._2._1/e._2._2))
    val avgRes = sumRes.join(countRes).mapValues(e => e._1/e._2)

    println("-----------sum-----------")
    sumRes.foreach(println)

    println("-----------max-----------")
    maxRes.foreach(println)

    println("-----------min-----------")
    minRes.foreach(println)

    println("-----------count-----------")
    countRes.foreach(println)

    println("-----------avg-----------")
    avgRes.foreach(println)

    println("-----------avg优化-----------")
    var res = data.combineByKey(
//      createCombiner: V => C,
//      mergeValue: (C, V) => C,
//      mergeCombiners: (C, C) => C,
      (value:Int) => (value, 1),
      (oldValue:(Int, Int), newValue:Int) => (oldValue._1+newValue, oldValue._2+1),
      (value1:(Int, Int), value2:(Int, Int)) => (value1._1+value2._1, value1._2+value2._2)
    )
    res.mapValues(e => e._1 / e._2).foreach(println)


    while(true){

    }
  }

}
