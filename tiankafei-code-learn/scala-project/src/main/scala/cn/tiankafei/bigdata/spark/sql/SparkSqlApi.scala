package cn.tiankafei.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{DataType, DataTypes, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

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

    println("-------------------------------------------------")

    val userSchema = Array("name string","age int", "sex int")


    def toData(vv: (String, Int)) ={
      userSchema(vv._2).split(" ")(1) match {
        case "string" => vv._1.toString
        case "int" => vv._1.toInt
      }
    }

    val rddRow1 = rdd.map(_.split(" ")).map(_.zipWithIndex).map(x=>x.map(toData(_))).map(Row.fromSeq(_))
    rddRow1.foreach(println)

    def toDataType(dataType:String): DataType ={
      dataType match {
        case "string" => DataTypes.StringType
        case "int" => DataTypes.IntegerType
      }
    }
    val fields1 = userSchema.map(_.split(" ")).map( x=> StructField.apply(x(0), toDataType(x(1))))
    val schema1 = StructType.apply(fields1)
    val dataFrame1 = session.createDataFrame(rddRow1, schema1)
    dataFrame1.show()
    dataFrame1.printSchema()
    dataFrame1.createTempView("person1")
    session.sql("select * from person1 t where t.name='zhangsan'").show()
    println("-------------------------------------------------")

    val p = new PersonTest()
    val beanRdd = rdd.map(line => {
      val strs = line.split(" ")
      p.setName(strs(0))
      p.setAge(strs(1).toInt)
      p.setSex(strs(2).toInt)
      p
    })

    val dataFrame2 = session.createDataFrame(beanRdd, classOf[PersonTest])
    dataFrame2.show()
    dataFrame2.printSchema()
    dataFrame2.createTempView("person2")
    session.sql("select * from person2 t where t.name='zhangsan'").show()
  }

}

class PersonTest extends Serializable {

  @BeanProperty
  var name = ""

  @BeanProperty
  var age = 0

  @BeanProperty
  var sex = 0
}
