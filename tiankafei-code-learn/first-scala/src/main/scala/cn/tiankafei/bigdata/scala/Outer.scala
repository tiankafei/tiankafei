package cn.tiankafei.bigdata.scala

object TestMain {
  def main(args: Array[String]): Unit = {
    val outer = new Outer()


  }

}

class Outer{
  class Inner{
    private var name = "123"
    private def f(){println("f")}
    class InnerMost{
      f() // 正确
    }
  }
}