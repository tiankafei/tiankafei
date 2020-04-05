package cn.tiankafei.bigdata.spark.sql

import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkSqlOnHive {

  def main(args: Array[String]): Unit = {

    val session = SparkSession
      .builder()
      .master("local")
      .appName("Spark-Sql-On-Hive")
      .config("hive.metastore.uris", "thrift://bigdata02:9083")
      .enableHiveSupport()
      .getOrCreate()

    val sc = session.sparkContext
    sc.setLogLevel("ERROR")

    import session.implicits._

    val df01 = List(
      "zhangsan",
      "lisi"
    ).toDF("name")

    df01.createTempView("ooxx")

    session.sql("select * from ooxx").show()

    df01.write.mode(SaveMode.Overwrite).saveAsTable("oxox")


    session.catalog.listDatabases().show()
    session.catalog.listTables().show()

//    session.sql("create table xxoo(id int)")
//    session.sql("insert into xxoo values (3),(4),(5)")
    session.sql("select * from xxoo")




  }

}
