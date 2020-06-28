package org.tiankafei.bigdata.scala

object TestPartiaFunction {

  def main(args: Array[String]): Unit = {

    def xxx:PartialFunction[ Any, Any ] = {
      case x:String => s"$x 你好"
      case 44 => 44 * 2
      case _  => "none"
    }
    println(xxx("张三"))
    println(xxx(44))
    println(xxx(45))
  }

}
