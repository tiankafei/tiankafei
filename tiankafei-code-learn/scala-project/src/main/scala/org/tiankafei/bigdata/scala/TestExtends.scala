package org.tiankafei.bigdata.scala

object TestExtends {

  def main(args: Array[String]): Unit = {
    val p = new Dog("abc");
    p.test()
    p.test1()
    p.test2()
    p.test3()
  }
  trait Dog3 {
    def test3(): Unit ={
      println("执行了test3方法")
    }
  }
  trait Dog2 {
    def test2(): Unit ={
      println("执行了test2方法")
    }
  }
  trait Dog1 {
    def test1(): Unit ={
      println("执行了tes1方法")
    }
  }
  class Dog(name:String) extends Dog1 with Dog2 with Dog3 {
    def test(): Unit ={
      println(s"执行了test方法$name")
    }
  }

}
