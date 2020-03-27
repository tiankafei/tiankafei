package cn.tiankafei.bigdata.scala

import java.util

import scala.collection.mutable.ListBuffer

object FirstCollections {

  def main(args: Array[String]): Unit = {
    val strings = new util.LinkedList[String]()
    strings.add("111")
    strings.add("222")
    strings.forEach(println)

    //    java泛型是<>，scala中是[]，所以数组用(n)
    //    val 约等于 final 不可变描述的是：val指定的引用的值
    //    数组
    val arr01 = Array[Int](1, 2, 3, 4)
    arr01(1) = 99
    println(arr01(1))
    for (elem <- arr01) {
      println(elem)
    }
    // 遍历元素，需要函数接收元素
    arr01.foreach(println)
    println("----------------------")

    //    链表
    // scala中collections中有2个包，immutable,mutable，默认是不可变的immutable
    val list01 = List(1, 2, 3, 4, 1, 3, 2, 4, 2, 1)
    for (i <- list01) println(i)
    list01.foreach(println)
    println("----------------------")

    // 可变的list
    val list02 = new ListBuffer[Int]()
    list02.+=(33)
    list02.+=(34)
    list02.+=(35)
    list02.+=(36)
    list02.+=(37)
    //TODO 学习 scala数据终端饿  ++ += ++: :++
    list02.foreach(println)
    println("----------------------")

    val set01 = Set(1, 2, 3, 4, 3, 2, 1)
    for (e <- set01) println(e)
    set01.foreach(println)
    println("----------------------")

    import scala.collection.mutable.Set
    val set02 = Set(11, 22, 33, 11, 22)
    set02.add(44)
    set02.add(33)
    set02.foreach(println)

    val set03 = scala.collection.immutable.Set(111, 222, 333, 111)
    set03.foreach(println)

    // tuple
    val tuple2 = new Tuple2(111, "abc")


    val list = List("hello world", "hello mashibing", "goog idea")

    val flatMap = list.flatMap(_.split(" ")).map((_, 1))
    flatMap.foreach(println)


    val map = list.iterator.flatMap(_.split(" ")).map((_, 1))
    map.foreach(println)


  }

}
