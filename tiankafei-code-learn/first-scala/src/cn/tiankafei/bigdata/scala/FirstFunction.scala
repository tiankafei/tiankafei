package cn.tiankafei.bigdata.scala

import java.util.Date

object FirstFunction {

//  定义方法，默认返回值为unit，也就是()
  def fun01(): Unit ={
    println("执行了fun01")
  }
  private val unit: Unit = fun01()
  println(unit)

//  定义方法，返回指定类型
  def fun02(): Int ={
    3
  }
  private val i: Int = fun02()
  println(i)

//  定义方法，带 return 返回的指定类型
  def fun03(): Int ={
    return 3
  }
  private val i1: Int = fun03()
  println(i1)

//  定义带参数的方法
  def fun04(a:Int): Int = {
    3 + a
  }
  private val i2: Int = fun04(1)
  println(i2)

//  定义递归函数的调用
  def fun05(num:Int): Int = {
    if(num == 1){
      1
    }else{
      num * fun05(num - 1)
    }
  }
  private val i3: Int = fun05(4)
  println(i3)

//  定义默认值函数
  def fun06(a:Int=8, b:String="abc"): Unit ={
    println(s"$a\t$b")
  }
  //第一个传值，第二个使用默认值
  private val unit1: Unit = fun06(2)
  //第一个使用默认值，第二个传值
  private val unit2: Unit = fun06(b="123")

//  定义匿名函数
  private val y: (Int, Int) => Int = (a:Int, b:Int) => {
    a + b
  }
  private val i4: Int = y(2, 5)
  println(i4)

//  嵌套函数
  def fun07(a:String): Unit = {
    def fun06(): Unit ={
      println(s"这是fun07里面的fun06：$a")
    }
    fun06()
  }
  fun07("hell0")

//  偏应用函数
  def fun08(date:Date, tp:String, msg:String): Unit ={
    println(s"$date\t$tp\t$msg")
  }
  // 直接调用
  fun08(new Date(), "info", "OK")
  // 再次封装函数info
  var info = fun08(_:Date, "info", _:String)
  // 再次封装函数error
  var error = fun08(_:Date, "error", _:String)

  info(new Date(), "这是一个成功的日志")
  error(new Date(), "这是一个错误的日志")

//  可变参数
  def fun09(a:Int*): Unit ={
    for (i <- a) println(i)

//    匿名函数：(a:Int) => {}
//    签名：(f:Int)
//    函数具体实现：{}
//    (f:Int) => {}
//    正常的匿名函数应该这样写：
//    a.foreach( (x:Int)=> { println(x) })
//    匿名函数，当参数在函数体当中只会使用一次的时候，可以简写为以下的方式：
//    a.foreach( println(_))
//    foreach要接收一个函数，而println正好是一个函数，可以再次简写为以下的方式：
    a.foreach( println )
  }
  fun09(1,2,3,4)

//  函数做为参数
  def computer(a:Int, b:Int, f:(Int,Int) => Int): Unit = {
    val i5 = f(a, b)
    println(i5)
  }
  computer(3, 8, (x:Int, y:Int) => {x+y})
  computer(3, 8, (x:Int, y:Int) => {x*y})
  //当参数的顺序，和后面使用的顺序一样的时候，可以使用以下面的语法糖
  computer(3, 8, _+_)
  computer(3, 8, _*_)

//  函数作为返回值
  def factory(i:String): (Int, Int) => Int = {
    def add(x:Int, y:Int): Int ={
      x+y
    }
    def sub(x:Int, y:Int): Int ={
      x-y
    }
    def mul(x:Int, y:Int): Int ={
      x*y
    }
    def div(x:Int, y:Int): Int ={
      x/y
    }
    def mod(x:Int, y:Int): Int ={
      x%y
    }
    def default(x:Int, y:Int): Int ={
      -1
    }

    if(i.equals("+")){
      add
    }else if(i.equals("-")){
      sub
    }else if(i.equals("*")) {
      mul
    }else if(i.equals("/")){
      div
    }else if(i.equals("%")){
      mod
    }else{
      default
    }
  }
  computer(3, 8, factory("+"))
  computer(3, 8, factory("-"))
  computer(3, 8, factory("*"))
  computer(3, 8, factory("/"))
  computer(3, 8, factory("%"))
  computer(3, 8, factory("="))

//  柯里化，规整参数
  def fun10(a:Int)(b:Int)(c:String): Unit ={
    println(s"$a\t$b\t$c")
  }
  fun10(3)(8)("asfdsa")

  def fun11(a:Int*)(b:String*): Unit ={
    a.foreach(println)
    b.foreach(println)
  }
  fun11(1,2,3)("a","b","c");


















  def main(args: Array[String]): Unit = {

  }

}
