package org.tiankafei.bigdata.scala

object FirstScala {

  var name = 1

  println(s"$name 这是主方法上面定义的输入$name")

  private val scala = new FirstScala("name3的值")

  def main(args: Array[String]): Unit = {
    scala.getMessage("name2的值")
    println(s"$name 这是主方法里面定义的输入${name+2}")
    scala.test()
  }

  println(s"$name 这是主方法下面定义的输入${name + 1}")

}

class FirstScala(name3:String) {

  var name1 = "abc"

  def this(name2:Int) {
    this("")
    name1 = s"外部传参$name2"
  }

  def this(){
    this("无参构造调用类名构造")
  }

  println(s"$name1 这是主方法上面定义的输入$name1")

  def getMessage(name2:String): Unit = {
    println(s"这是name1的值：$name1")
    println(s"这是name2的值：$name2")
    println(s"这是name3的值：$name3")
  }

  println(s"$name1 这是主方法下面定义的输入${name1 + 1}")

  def test(): Unit ={
    val inclusive = 1 to 10
    for (i <- inclusive) println(i)

    for (i <- 1 to 10) println(i)

    for (i <- 1 to (10,2)) println(i)

    println("----------------------------------")

    for (i <- 1 to 10 if(i <= 6)) println(i)
    println("----------------------------------")

    var count = 0
    for (i <- 1 to 9; j <- 1 to 9 if(j <= i)){
      count+=1
      if(j <= i) print(s"$i * $j = ${i*j}\t")
      if(j == i) println()
    }
    println(count)
    println("----------------------------------")

    val unit = for (i <- 1 to (10,2)) yield {
      i + i
    }
    for (i <- unit) println(i)

  }

}