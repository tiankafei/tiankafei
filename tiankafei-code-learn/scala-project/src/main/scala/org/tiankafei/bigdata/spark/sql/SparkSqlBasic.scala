package org.tiankafei.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSqlBasic {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sparkSQL")

    val session = SparkSession
      .builder()
      .config(conf)
//      .config("truncate", false)
      //      .master("")
      //      .appName("")
      //      .config("","")
      //      .enableHiveSupport()
      .getOrCreate()
    val sc = session.sparkContext
    sc.setLogLevel("ERROR")

    session.catalog.listDatabases().show()
    session.catalog.listTables().show()
    session.catalog.listFunctions().show()

    val dataFrame = session.read.json("data/json")
    dataFrame.show()
    dataFrame.printSchema()

    dataFrame.createTempView("TEST")

    import scala.io.StdIn._
    while(true){
      try{
        val sql = readLine("请输入sql")

        session.sql(sql).show()
      }catch {
        case ex: Exception => {
          ex.printStackTrace()
        }
      }
    }


  }

}
