package cn.tiankafei.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSqlStandaloneOnHive {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Spark-Sql-Standalone-On-Hive")
    val session = SparkSession
      .builder()
      .config(conf)
      .config("spark.sql.shuffle.partitions", 1)  // 默认200，当数据少的时候，可以适当把该值调低
      .config("spark.sql.warehouse.dir", "D:/software/bigdata/spark/data/warehouse")
      .enableHiveSupport()
      .getOrCreate()
    val sc = session.sparkContext

    import session.sql
    session.catalog.listDatabases().show()
    session.catalog.listTables().show()
    println("--------------------------------------")

//    sql("create database tiankafei")
//    sql("create table psn(name string)")

    session.catalog.listDatabases().show()
    session.catalog.listTables().show()
    println("--------------------------------------")

    sql("use tiankafei")
//    sql("create table psn(name string)")

    session.catalog.listTables().show()


    sql("insert into psn values ('张三3'),('李四3'),('张三2'),('李四2')")
    sql("select * from psn").show()
  }

}
