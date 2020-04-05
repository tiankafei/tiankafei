package cn.tiankafei.bigdata.spark.sql

import java.util.Properties

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSqlMysql {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("spark-SQL-mysql")

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

    val properties = new Properties()
    properties.put("url", "jdbc:mysql://software:3306/master?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true")
    properties.put("user", "root")
    properties.put("password", "tiankafei")
    properties.put("driver", "com.mysql.cj.jdbc.Driver")

    val businessData = session.read.jdbc(properties.getProperty("url"), "TKF_BUSINESS_DATA", properties)

    businessData.createTempView("TKF_BUSINESS_DATA")
    session.sql("select * from TKF_BUSINESS_DATA").show()


    val roleBusinessData = session.read.jdbc(properties.getProperty("url"), "TKF_ROLE_BUSINESS_DATA", properties)
    roleBusinessData.createTempView("TKF_ROLE_BUSINESS_DATA")

    val roleData = session.read.jdbc(properties.getProperty("url"), "TKF_ROLE_DATA", properties)
    roleData.createTempView("TKF_ROLE_DATA")

    val sql =
      """
        |select t1.ROLE_CODE,t1.ROLE_NAME,t3.BUSINESS_CODE,t3.BUSINESS_NAME from TKF_ROLE_DATA t1
        |join TKF_ROLE_BUSINESS_DATA t2 on t1.ROLE_CODE=t2.ROLE_CODE
        |join TKF_BUSINESS_DATA t3 on t2.BUSINESS_CODE=t3.BUSINESS_CODE
        |where t1.ROLE_CODE='foreRole'
        |order by t1.ROLE_CODE, t3.BUSINESS_CODE
        |""".stripMargin
    println(sql)

    val res = session.sql(sql)
    res.show(99)
    res.printSchema()

    res.write.jdbc(properties.getProperty("url"), "TKF_TEST_RES", properties)
  }

}
