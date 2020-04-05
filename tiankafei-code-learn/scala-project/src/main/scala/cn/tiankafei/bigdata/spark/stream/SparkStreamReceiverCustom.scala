package cn.tiankafei.bigdata.spark.stream

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * 自定义数据流，receiverStream需要继承Receiver
 */
object SparkStreamReceiverCustom {

  def main(args: Array[String]): Unit = {
    //local[n]  2个就够了：
    val conf: SparkConf = new SparkConf().setAppName("Spark-Stream-Receiver").setMaster("local[8]")

    // 1个给receiverjob的task，
    // 另一个给beatch计算的job（只不过如果batch比较大，你期望n>2,因为多出来的线程可以跑并行的batch@job@task）

    val stream = new StreamingContext(conf,Seconds(5))
    stream.sparkContext.setLogLevel("ERROR")

    val dstream = stream.receiverStream(new CustormReceiver("localhost", 8889))
    dstream.print()

    stream.start()
    stream.awaitTermination()

  }

  class CustormReceiver(host:String, port:Int) extends Receiver[String](StorageLevel.DISK_ONLY) {
    override def onStart(): Unit = {
      new Thread{
        override def run(): Unit = {
          ooxx()
        }
      }.start()
    }

    private def ooxx(): Unit ={
      val server = new Socket(host,port)

      val reader = new BufferedReader(new InputStreamReader(server.getInputStream))
      var line: String = reader.readLine()
      while(!isStopped()  &&  line != null ){
        store(line)
        line  = reader.readLine()
      }
    }

    override def onStop(): Unit = ???
  }

}
