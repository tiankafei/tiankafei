package cn.tiankafei.bigdata.scala

object TestScala01 {

  val PARAM_NAME = "TEST_TEST"

  var name = "123";

  private val scala0 = new TestScala01("weishuangshuang")

  println(s"$name object里面上方的打印")

  def main(args: Array[String]): Unit = {
    println(PARAM_NAME)
    println("执行了object里面的打印")
    scala0.getMessage(PARAM_NAME)
    println(scala0.name)
    println(TestScala01.name)
  }

  println(s"object里面下方的打印$name")
  println(s"object里面下方的打印" + name)

}

class TestScala01(sex:Int) {

  var a = 1

  var name = "我是class里面的name值"

  println(s"class里面上方的打印$a")

  def this(namex:String) {
    this(1111111)
//    sex = 222222222
    println("这是一个构造方法")
    name = namex
  }

  def getMessage(message:String): Unit = {
    println(s"打印一下$sex")
    println(this.name)
    println("执行了calss里面的打印")
    println(s"传入的参数为$message")
  }

  println(s"class里面下方的打印${a+4}")

  def fun01()= {
    ""
  }




}