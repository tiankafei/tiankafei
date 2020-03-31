package cn.tiankafei.bigdata.spark.api

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object SparkTopn {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("topn")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    implicit val asfdasf = new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = y._2.compareTo(x._2)
    }

    //    2019-6-1	39
    //    2019-5-21	33
    //    2019-6-1	38
    //    2019-6-2	31
    //    2018-3-11	18
    //    2018-4-23	22
    //    1970-8-23	23
    //    1970-8-8	32
    val data = sc.textFile("data/tqdata").map(line => {
      val array = line.split("\t");
      val date = array(0).split("-");
      (date(0).toInt, date(1).toInt, date(2).toInt, array(1).toInt)
    })
    //分组    取topN  (排序)

    val res04 = data.map(t4 => ((t4._1, t4._2), (t4._3, t4._4))).combineByKey(
      (v1:(Int,Int)) => {Array(v1, (0,0), (0,0))},
      (oldv:Array[(Int,Int)], nv:(Int,Int)) => {
        var flg = 0
        for (i <- 0 until oldv.length) {
          if(oldv(i)._1 == nv._1){
            if(oldv(i)._2 < nv._2){
              // 新元素比集合中的元素。天数一致，温度大，需要进行替换
              oldv(i) = nv
              flg = 1
            }else{
              flg = 2
            }
          }
        }
        if(flg == 0){
          // 天数不一样的时候，加入最后一个位置
          oldv(oldv.length - 1) = nv
        }
//        oldv.sorted
        // 为了防止频繁gc，使用的隐式变量，必须要放到上面，否则找不着
        scala.util.Sorting.quickSort(oldv)
        oldv
      },

      (v1:Array[(Int,Int)], v2:Array[(Int,Int)]) => {
        val res = v1.union(v2)
//        res.sorted
        // TODO 需要增加一个去重操作
        scala.util.Sorting.quickSort(res)
        res
      }
    )
    res04.map(x=>(x._1,x._2.toList)).foreach(println)






    // 优先按照年月温度倒叙全排序（排序绝对不会出现内存溢出的问题），再按照年月分组，再进行去重
    println("-------------------------第三种方法，，，优先按照年月温度倒叙全排序（排序绝对不会出现内存溢出的问题），再按照年月分组，再进行去重----------------------------------------")
    val groupd03 = data.sortBy(t4 => ((t4._1, t4._2, t4._4), t4._3), false)
      .map(t4 => ((t4._1, t4._2), (t4._3, t4._4))).groupByKey()
    // 对值进行按天去重
    val res03 = groupd03.mapValues(arr => {
      // 需要使用有序的map
      val map = mutable.LinkedHashMap[Int, Int]()
      for (elem <- arr if (map.size < 3)) {
        val k1 = elem._1;
        val k2 = elem._2;
        if (!map.contains(k1)) {
          // 当已经存在的时候，就不管了（因为这个顺序已经是按照温度倒序了）
          map.put(k1, k2)
        }
      }
      map.toList
    })
    res03.foreach(println)



    // 先按天去重，相同的天就没有重复数据了，然后在按照年月分组
    println("-------------------------第二种方法，，，先按天去重，相同的天就没有重复数据了，然后在按照年月分组，----------------------------------------")
    val groupd02 = data.map(t4 => ((t4._1, t4._2, t4._3), t4._4)) // 转换key为年月日
      .reduceByKey((x, y) => (if (x > y) x else y)) // 按照年月日去重，且取出温度最大的那一条数据
      .map(t2 => ((t2._1._1, t2._1._2), (t2._1._3, t2._2))) // 转换key为年月
      .groupByKey()
    val res02 = groupd02.mapValues(arr => {
      arr.toList.sorted // 按照年月分组后的值进行排序
    })
    res02.foreach(println)


    // 用了groupByKey 容易OOM   且自己的算子实现了函数：去重、排序
    println("-------------------------第一种方法，，，按照年月分组，数据量大的时候很容易OOM----------------------------------------")
    val groupd01 = data.map(t4 => ((t4._1, t4._2), (t4._3, t4._4))).groupByKey()
    val res01 = groupd01.mapValues(t2 => {
      // 使用map，当数据量很大的时候，很占用内存，容易产生OOM
      val map = mutable.HashMap[Int, Int]()
      t2.foreach((e => {
        val k1 = e._1
        val k2 = e._2
        val value = map.get(k1).getOrElse(0)
        if (value < k2) {
          map.put(k1, k2)
        }
      }))
      map.toList.sorted
    })
    res01.foreach(println)


    while (true) {
    }
  }

}
