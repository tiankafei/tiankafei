package org.tiankafei.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{DataType, DataTypes, StructField, StructType}
import org.apache.spark.sql.{Dataset, Encoders, Row, SaveMode, SparkSession}

import scala.beans.BeanProperty

object SparkSqlApi {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("spark-SQL-API")

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

    val rdd = sc.textFile("data/person.txt")
    val rddRow = rdd.map(_.split(" ")).map(arr => Row.apply(arr(0), arr(1).toInt))

    val fields = Array(StructField.apply("name", DataTypes.StringType), StructField.apply("age", DataTypes.IntegerType))
    val schema = StructType.apply(fields)
    val dataFrame = session.createDataFrame(rddRow, schema)
    dataFrame.show()
    dataFrame.printSchema()
    dataFrame.createTempView("person")
    session.sql("select * from person t where t.name='zhangsan'").show()

    session.catalog.listTables().show()

    println("------------------------person-------------------------")

    val userSchema = Array("name string", "age int", "sex int")


    def toData(vv: (String, Int)) = {
      userSchema(vv._2).split(" ")(1) match {
        case "string" => vv._1.toString
        case "int" => vv._1.toInt
      }
    }

    val rddRow1 = rdd.map(_.split(" ")).map(_.zipWithIndex).map(x => x.map(toData(_))).map(Row.fromSeq(_))
    rddRow1.foreach(println)

    def toDataType(dataType: String): DataType = {
      dataType match {
        case "string" => DataTypes.StringType
        case "int" => DataTypes.IntegerType
      }
    }

    val fields1 = userSchema.map(_.split(" ")).map(x => StructField.apply(x(0), toDataType(x(1))))
    val schema1 = StructType.apply(fields1)
    val dataFrame1 = session.createDataFrame(rddRow1, schema1)
    dataFrame1.show()
    dataFrame1.printSchema()
    dataFrame1.createTempView("person1")
    session.sql("select * from person1 t where t.name='zhangsan'").show()
    println("-----------------------------person1--------------------")

    val p = new SparkSqlApi()
    val beanRdd = rdd.map(line => {
      val strs = line.split(" ")
      p.setName(strs(0))
      p.setAge(strs(1).toInt)
      p.setSex(strs(2).toInt)
      p
    })

    val dataFrame2 = session.createDataFrame(beanRdd, classOf[SparkSqlApi])
    dataFrame2.show()
    dataFrame2.printSchema()
    dataFrame2.createTempView("person2")
    session.sql("select * from person2 t where t.name='zhangsan'").show()
    println("-----------------------------person2--------------------")


    val data = session.read.textFile("data/person.txt")
    import session.implicits._
    val dataset = data.map(line => {
      val strs = line.split(" ")
      (strs(0), strs(1).toInt, strs(2).toInt)
    })
//    val dataset = data.map(line => {
//      val strs = line.split(" ")
//      (strs(0), strs(1).toInt, strs(2).toInt)
//    })(Encoders.tuple(Encoders.STRING, Encoders.scalaInt, Encoders.scalaInt))
    val dataFrame3 = dataset.toDF("name", "age", "sex")
    dataFrame3.show()
    dataFrame3.printSchema()
    dataFrame3.createTempView("person3")
    session.sql("select * from person3 t where t.name='zhangsan'").show()
    println("-----------------------------person3--------------------")


    val dataList = List(
      "hello world",
      "hello world",
      "hello mashibing",
      "hello world",
      "hello hive",
      "hello sprak",
      "hello world",
      "hello hadoop",
      "hello world",
      "hello hbase",
    ).toDF("line")
    dataList.createTempView("words")
    session.sql("select * from words").show()
    println("-----------------------------words结果集--------------------")

    val subTab = dataList.selectExpr("explode(split(line, ' ')) as word")
    subTab.groupBy("word").count().show()
    println("-----------------------------api方式wordcount--------------------")

    session.sql("select word, count(1) from (select explode(split(line, ' ')) as word from words) group by word ").show()
    println("-----------------------------sql方式wordcount--------------------")

    val res = session.sql("select word, count(1) as count from (select explode(split(line, ' ')) as word from words) group by word ")
    res.write.mode(SaveMode.Overwrite).parquet("./data/words")
    println("-----------------------------测试结果集写文件--------------------")

    val dataFrame4 = session.read.parquet("./data/words")
    dataFrame4.show()
    dataFrame4.printSchema()
    println("-----------------------------测试结果集读文件--------------------")
  }


}

class SparkSqlApi extends Serializable {

  @BeanProperty
  var name = ""

  @BeanProperty
  var age = 0

  @BeanProperty
  var sex = 0
}
