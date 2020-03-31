package cn.tiankafei.bigdata.spark.api

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
 * RDD迭代器
 */
object SparkIterator {

  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("iterator")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    println("--------------map------------------")
    val data = sc.parallelize(1 to 10, 2)
    val res01 = data.map(
      (value: Int) => {
        println("------conn--mysql----")
        println(s"-----select $value-----")
        println("-----close--mysql------")
        value + "selected"
      }
    )
    res01.foreach(println)

    println("--------------mapPartitionsWithIndex集合------------------")

    val res02 = data.mapPartitionsWithIndex(
      (pindex, piter) => {
        val lb = new ListBuffer[String]  //致命的！！！！  根据之前源码发现  spark就是一个pipeline，迭代器嵌套的模式
        //数据不会再内存积压
        println(s"--$pindex----conn--mysql----")
        while (piter.hasNext) {
          val value: Int = piter.next()
          println(s"---$pindex--select $value-----")
          lb.+=(value + "selected")
        }
        println("-----close--mysql------")
        lb.iterator
      }
    )
    res02.foreach(println)


    println("--------------mapPartitionsWithIndex迭代器------------------")
    val res03 = data.mapPartitionsWithIndex(
      (pindex, piter) => {

        new Iterator[String] {
          println(s"--------$pindex---con---mysql--------")

          override def hasNext: Boolean = if(piter.hasNext) true else {close; false}

          override def next(): String = {
            val value = piter.next()

            println(s"--------$pindex---select---$value--------")

            value + "selected"
          }

          def close: Unit = {
            println(s"--------$pindex---close---mysql--------")
          }
        }
      }
    )
    res03.foreach(println)
    println("---------------------------------------------------")

    val list = List("hello world","hello mashibing"," good idea", "hello spark", "hello1 world1","hello1 mashibing1"," good1 idea1", "hello1 spark1")

    val data1 = sc.parallelize(list, 2)
    val res04 = data1.mapPartitionsWithIndex(
      (pindex, piter) => {

        new Iterator[String] {
          println(s"--------$pindex---con---mysql--------")

          override def hasNext: Boolean = if(piter.hasNext) true else {close; false}

          var concurrent:Iterator[String] = null

          override def next(): String = {
            val value = piter.next()
            val array = value.split(" ")
            val res = for (context <- array) yield {
              println(s"--------$pindex---select---$context--------")

              context + "selected"
            }

            value
          }

          def close: Unit = {
            println(s"--------$pindex---close---mysql--------")
          }
        }
      }
    )
    res04.foreach(println)





  }


}
