package cn.tiankafei.bigdata.spark.api

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * RDD计算PV,UV
 */
object SparkSorted {

  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("sort")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    //PV,UV
    //需求：根据数据计算各网站的PV,UV，同时，只显示top5
    //解题：要按PV值，或者UV值排序，取前5名

    val file: RDD[String] = sc.textFile("data/pvuvdata",5)

    //pv：
    //  187.144.73.116	浙江	2018-11-12	1542011090255	3079709729743411785	www.jd.com	Comment
    println("----------PV:-----------")
//    val res1 = file.map(_.split("\t")(5)).map((_,1)).reduceByKey(_+_).sortBy(_._2, false).take(5)
    val res1 = file.map( line => (line.split("\t")(5), 1) ).reduceByKey(_+_).sortBy(_._2, false).take(5)
    res1.foreach(println)


    println("----------UV:-----------")
    //  187.144.73.116	浙江	2018-11-12	1542011090255	3079709729743411785	www.jd.com	Comment
    val res2 = file.map(line => {
      val array = line.split("\t")
      (array(0), array(5))
    }).distinct().map( key => (key._2, 1)).reduceByKey(_+_).sortBy(_._2, false).take(5)
    res2.foreach(println)


    while(true){

    }



  }

}
