package org.tiankafei.bigdata.spark.sql

import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, IntegerType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SparkSqlFunction {

  def main(args: Array[String]): Unit = {
    val ss = SparkSession
      .builder()
      .master("local")
      .appName("Spark-Sql-Function")
      .getOrCreate()

    val sc = ss.sparkContext
    sc.setLogLevel("ERROR")

    import ss.implicits._

    val dataDF: DataFrame = List(
      ("A", 1, 90),
      ("B", 1, 90),
      ("A", 2, 50),
      ("C", 1, 80),
      ("B", 2, 60)
    ).toDF("name", "class", "score")

    dataDF.createTempView("users")

    // over开窗函数
    ss.sql("select *, " +
      "count(score) over (partition by class) as num,  " +
      "sum(score) over (partition by name) as sum " +
      "from users").show()
    // rank 排序按照字段排序
    ss.sql("select * ," +
      " rank()  over(partition by class order by score desc  )  as rank ,   " +
      " row_number()  over(partition by class order by score desc  )  as number    " +
      "from users ").show()

    // 普通的group by
    ss.sql("select  class , count(score) as num   from users   group by class ").show()

    // 列转行
    ss.sql("select name , " +
      "explode( " +
      "split( " +
      "     concat(case when class = 1 then 'AA' else 'BB' end ,' ',score) , ' ' " +
      " ))  " +
      "as ox  " +
      "from users").show()

    // 自定义函数
    ss.udf.register("ooxx", new MyAggFun) // avg
    ss.sql("select name,    " +
      " ooxx(score)    " +
      "from users  " +
      "group by name  ")
      .show()

    val res = ss.sql("select  name,   " +
      " sum(score) " +
      "from users " +
      "group by name " +
      "order by name desc")

    res.show()
    println("-----------")
    // 分析语法树
    res.explain(true)

  }

  class MyAggFun extends UserDefinedAggregateFunction {
    // 输入的参数
    override def inputSchema: StructType = {
      StructType.apply(Array(StructField.apply("score", IntegerType, false)))
    }

    // 缓存的数据类型
    override def bufferSchema: StructType = {
      StructType.apply(
        Array(
          StructField.apply("sum", IntegerType, false),
          StructField.apply("count", IntegerType, false),
        ))
    }

    // 返回的数据类型
    override def dataType: DataType = DoubleType

    // 是否幂等
    override def deterministic: Boolean = true

    // 初始化赋默认值
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0
      buffer(1) = 0
    }

    // 第二条及以后的记录来了之后，如何处理
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer(0) = buffer.getInt(0) + input.getInt(0)
      buffer(1) = buffer.getInt(1) + 1
    }

    // 分区合并后的操作
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getInt(0) + buffer2.getInt(0)
      buffer1(1) = buffer1.getInt(1) + buffer2.getInt(1)
    }

    // 最终执行的操作
    override def evaluate(buffer: Row): Double = {
      buffer.getInt(0) / buffer.getInt(1)
    }
  }

}
