package cn.tiankafei.bigdata.scala

object TestCaseClass {

  def main(args: Array[String]): Unit = {
    val person1 = new Person1("张三", 22)
    val person2 = new Person1("张三", 22)
    println(person1.equals(person2))
    println(person1 == person2)

    val person3 = Person2("张三", 22)
    val person4 = Person2("张三", 22)
    println(person3.equals(person4))
    println(person3 == person4)
  }

  case class Person2(name:String, age:Int) {
    println(s"name值为$name,age值为$age")
  }

  class Person1(name:String, age:Int) {
    println(s"name值为$name,age值为$age")
  }

}
