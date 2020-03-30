package cn.tiankafei.bigdata.scala

import java.util

object TestImplicitMethod {

  def main(args: Array[String]): Unit = {
    implicit def cgfdghda[T](list: util.ArrayList[T]): Iterator[T] ={
      val iter:util.Iterator[T] = list.iterator()
      new Iterator(iter)
    }
    implicit def asfdasdfs[T](list: util.LinkedList[T]): Iterator[T] ={
      val iter:util.Iterator[T] = list.iterator()
      new Iterator(iter)
    }
    val linkedList = new util.LinkedList[Int]()
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)
    val listXXX = new Iterator[Int](linkedList.iterator())
    listXXX.foreach(println)
    println("listXXX.foreach(println)--------------------------")
    linkedList.foreach(println)
    println("linkedList.foreach(println)--------------------------")

    val arrayList = new util.ArrayList[Int]()
    arrayList.add(11)
    arrayList.add(22)
    arrayList.add(33)
    val arrayXXX = new Iterator[Int](arrayList.iterator())
    arrayXXX.foreach(println)
    println("arrayXXX.foreach(println)--------------------------")
    arrayList.foreach(println)
    println("arrayList.foreach(println)--------------------------")
  }

  class Iterator[T](list: util.Iterator[T]) {
    def foreach(f: (T) => Unit): Unit = {
      while (list.hasNext) {
        f(list.next())
      }
    }
  }
}
