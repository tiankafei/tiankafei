package org.tiankafei.bigdata.scala

object TestMatch {

  def main(args: Array[String]): Unit = {
    val tuple = (1.0, 88, "abc", false)

    val iterator = tuple.productIterator

    val res = iterator.map((x) => {
      x match {
        case x: Int => x + 99
        case x: Double => x + 100
        case x: String => x + "def"
        case x: Boolean => !x
        case false => false
        case 1 => 1 + 100
        case _ => x
      }
    })
//    res.foreach(println)

    while (res.hasNext) {
      println(res.next())
    }
  }

}
