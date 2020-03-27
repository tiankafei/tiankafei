package cn.tiankafei.bigdata.scala

object TestOther {

  def main(args: Array[String]): Unit = {
    var testOther = new TestOther();
    println(testOther.name)
    println(testOther.age)

  }

}

class TestOther {

  // 只能在当前文件内部，通过对象进行访问
  private var name = "123456";

  // 只能在类内部使用，对象都不能直接使用
  private[this] var age = 10;



}
