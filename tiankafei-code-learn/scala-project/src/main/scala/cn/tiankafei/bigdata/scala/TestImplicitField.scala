package tiankafei.bigdata.scala

object TestImplicitField {

  def main(args: Array[String]): Unit = {

    implicit val fdasfdasfdasf:String = "lisi"
    def ooxx1(implicit name:String): Unit ={
      println(name)
    }
    ooxx1("zhangsan")
    ooxx1
    println("-----------------------------")
    implicit val sfdasfas:Int = 22
    def ooxx2(implicit name:String, age:Int): Unit ={
      println(s"$name\t$age")
    }
    ooxx2("abc", 33)
    ooxx2
    println("-----------------------------")
    def ooxx3(age:Int)(implicit name:String): Unit ={
      println(s"$name\t$age")
    }
    ooxx3(22)("abc")
    ooxx3(12)
  }

}
