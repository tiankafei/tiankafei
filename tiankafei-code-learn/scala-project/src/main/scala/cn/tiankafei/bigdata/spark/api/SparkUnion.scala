package cn.tiankafei.bigdata.spark.api

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * RDD关联操作
 */
object SparkUnion {

  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("union")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")


    val data = sc.parallelize( List(1,2,3,4,5,4,3,2,1) )
    println("-------------------map-------------------")
    data.map(x=> (x,1)).foreach(println)
    println("-------------------filter------------------")
    data.filter(x=>x>2).foreach(println)
    println("-------------------collect------------------")
    data.filter(_>=2).collect().foreach(println)
    println("-------------------reduceByKey------------------")
    data.map((_,1)).reduceByKey(_+_).foreach(println)
    println("-------------------distinct------------------")
    data.distinct().foreach(println)



    println("---------------------------------------------")
    val rdd1 = sc.parallelize( List( 1,2,3,4,5)  )
    val rdd2 = sc.parallelize( List( 3,4,5,6,7)  )

    println("-------------------cartesian笛卡尔集-----------------")
    rdd1.cartesian(rdd2).foreach(println)
    println("-------------------左侧差集-----------------")
    rdd1.subtract(rdd2).foreach(println)
    println("-------------------右侧差集-----------------")
    rdd2.subtract(rdd1).foreach(println)
    println("-------------------交集-----------------")
    rdd1.intersection(rdd2).foreach(println)
    println("-------------------并集去重-----------------")
    val unionRdd = rdd1.union(rdd2).distinct()
    println(unionRdd.partitions.size)
    println(rdd1.partitions.size)
    println(rdd2.partitions.size)
    println("-------------------并集去重打印-----------------")
    unionRdd.foreach(println)

    println("---------------------------------------------")
    val kv1: RDD[(String, Int)] = sc.parallelize(List(
      ("zhangsan", 11),
      ("zhangsan", 12),
      ("lisi", 13),
      ("wangwu", 14)
    ))
    val kv2: RDD[(String, Int)] = sc.parallelize(List(
      ("zhangsan", 21),
      ("zhangsan", 22),
      ("lisi", 23),
      ("zhaoliu", 28)
    ))
    println("-------------------kv的交集-----------------")
    kv1.join(kv2).foreach(println)
    println("-------------------kv左关联-----------------")
    kv1.leftOuterJoin(kv2).foreach(println)
    println("-------------------kv右关联-----------------")
    kv1.rightOuterJoin(kv2).foreach(println)
    println("-------------------kv全关联-----------------")
    kv1.fullOuterJoin(kv2).foreach(println)
    println("-------------------kv  cogroup（全关联的基础上相同的key变成了一条记录）-----------------")
    kv1.cogroup(kv2).foreach(println)

    while(true){

    }



















  }

}
