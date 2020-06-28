package org.tiankafei.bigdata.scala

import java.util

import scala.collection.mutable.ListBuffer

object FirstCollections {

  def main(args: Array[String]): Unit = {
    val strings = new util.LinkedList[String]()
    strings.add("111")
    strings.add("222")
    strings.forEach(println)
    println("LinkedList----------------------")

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
    println("Array----------------------")

    //    链表
    // scala中collections中有2个包，immutable,mutable，默认是不可变的immutable
    val list01 = List(1, 2, 3, 4, 1, 3, 2, 4, 2, 1)
    for (i <- list01) println(i)
    list01.foreach(println)
    println("List不可变----------------------")

    // 可变的list
    val list02 = new ListBuffer[Int]()
    list02.+=(33)
    list02.+=(34)
    list02.+=(35)
    list02.+=(36)
    list02.+=(37)
    //TODO 学习 scala数据终端饿  ++ += ++: :++
    list02.foreach(println)
    println("List可变----------------------")

    // 默认不可变
    val set01 = Set(1, 2, 3, 4, 3, 2, 1)
    for (e <- set01) println(e)
    set01.foreach(println)
    println("set不可变----------------------")

    // 导入可变的
    import scala.collection.mutable.Set
    val set02 = Set(11, 22, 33, 11, 22)
    set02.add(44)
    set02.add(33)
    set02.foreach(println)
    println("set可变----------------------")

    // 再次使用不可变的
    val set03 = scala.collection.immutable.Set(111, 222, 333, 111)
    set03.foreach(println)
    println("set不可变----------------------")

    // tuple
    val tuple2 = new Tuple2(111, "abc")
    val tuple3 = Tuple3(3, "asfdas", "dsgfd")
    val tuple4 = (1, 2, 3, 4)
    val tuple = ((a:Int) => a+8, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    println(tuple2._1)
    println(tuple4._3)
    println(tuple._1(11))

    val iterator = tuple.productIterator
    while(iterator.hasNext){
      println(iterator.next())
    }
    println("tuple----------------------")

    // 不可变map
    val map01 = Map( ("a", 33), "b"->22, ("c",42), ("a", 333) )
    println(map01.get("a").getOrElse("hello world"))
    println(map01.get("w").getOrElse("hello world"))

    val keys = map01.keys
    for (key <- keys) {
      println(s"key：$key\tvalue=${map01.get(key).get}")
    }

    // 可变map
    val map02 = scala.collection.mutable.Map( ("a","b"), ("c","d") )
    map02.put("e","f")
    println(map02.get("a").get)
    println(map02.get("s").getOrElse("hello world"))
    val keys1 = map02.keys
    for (key <- keys1) {
      println(s"key：$key\tvalue=${map02.get(key).get}")
    }
    println("map----------------------")


    val list = List("hello world", "hello mashibing", "goog idea")
    val flatMap = list.flatMap(_.split(" ")).map((_, 1))
    flatMap.foreach(println)
    println("list直接调用--------------------------------")

    val map = list.iterator.flatMap(_.split(" ")).map((_, 1))
    map.foreach(println)
    println("list的迭代器调用--------------------------------")


    val unit = 1 + 2
    println(unit)

    //    val inclusive = 1.to(10)
    val inclusive = 1 to 10
    inclusive.foreach(println)

  }

}
