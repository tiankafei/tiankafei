

# Centos7安装Scala

## 下载Scala

选择对应的版本进行下载，这里选择的是2.12.11

```http
# scala所有版本列表
https://www.scala-lang.org/download/all.html
# rpm 安装包下载路径
https://downloads.lightbend.com/scala/2.12.11/scala-2.12.11.rpm
# tgz 解压包下载路径
https://downloads.lightbend.com/scala/2.12.11/scala-2.12.11.tgz
```

## 安装配置Scala

```
rpm -i scala-2.12.11.rpm
```

## 设置环境变量

```shell
vi /etc/profile
```

```shell
export SCALA_HOME=/usr/share/scala
export PATH=$PATH:$SCALA_HOME/bin
```

```shell
source /etc/profile
```

# centos7安装配置Spark

## 下载Spark

选择对应的版本进行下载，这里选择的是： spark-2.4.5-bin-hadoop2.7

```http
# spark全部版本下载地址
http://spark.apache.org/news/index.html
# tgz 解压包下载路径
https://mirrors.tuna.tsinghua.edu.cn/apache/spark/spark-2.4.5/spark-2.4.5-bin-hadoop2.7.tgz
```

## Spark单机版安装

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/spark-2.4.5-local
tar -zvxf spark-2.4.5-bin-hadoop2.7.tgz -C /opt/bigdata/spark-2.4.5-local
cd /opt/bigdata/spark-2.4.5-local
mv spark-2.4.5-bin-hadoop2.7/* /opt/bigdata/spark-2.4.5-local/
rm -rf spark-2.4.5-bin-hadoop2.7/
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export SPARK_HOME=/opt/bigdata/spark-2.4.5-local
export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin
```

```shell
source /etc/profile
```

### 单机启动测试

```shell
# 进入spark的sbin目录
cd /opt/bigdata/spark-2.4.5-local/sbin

# 执行命令启动spark的master节点
./start-master.sh

# 启动完成之后访问地址
http://bigdata01:8080

# 进入spark的bin目录
cd /opt/bigdata/spark-2.4.5-local/bin

# 使用spark-shell 连接测试
./spark-shell --master spark://bigdata01:7077

# 如果出现scala的命令行窗口模式，则说明连接成功，至此单机版的spark安装测试完成

# 进入spark的sbin目录
cd /opt/bigdata/spark-2.4.5-local/sbin

# 停止单机版的Spark单机主程序
./stop-master.sh
```

## Spark集群高可用安装-on-master

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/spark-2.4.5-master
tar -zvxf spark-2.4.5-bin-hadoop2.7.tgz -C /opt/bigdata/spark-2.4.5-master
cd /opt/bigdata/spark-2.4.5-master
mv spark-2.4.5-bin-hadoop2.7/* /opt/bigdata/spark-2.4.5-master/
rm -rf spark-2.4.5-bin-hadoop2.7/
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export SPARK_HOME=/opt/bigdata/spark-2.4.5-master
export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin
```

```shell
source /etc/profile
```

```shelll
reboot
```

### 执行配置

cd $SPARK_HOME/conf

> ```shell
> cp slaves.template slaves
> vim slaves
> ```
>
> ```sh
> bigdata02
> bigdata03
> bigdata04
> ```

> ```shell
> cp spark-env.sh.template spark-env.sh
> vim spark-env.sh
> ```
>
> ```sh
> export HADOOP_CONF_DIR=/opt/bigdata/hadoop-2.8.3-ha/hadoop-2.8.3/etc/hadoop
> export SPARK_MASTER_HOST=bigdata01   # 每台master改成自己的主机名
> export SPARK_MASTER_PORT=7077
> export SPARK_MASTER_WEBUI_PORT=8080
> export SPARK_WORKER_CORES=4
> export SPARK_WORKER_MEMORY=4g
> ```

### 向其他机器分发配置

cd $SPARK_HOME/conf

```shell
scp -r slaves spark-env.sh bigdata02:`pwd`
scp -r slaves spark-env.sh bigdata03:`pwd`
scp -r slaves spark-env.sh bigdata04:`pwd`
```

### 执行启动

#### 启动hadoop集群

```shell
# 所有机器启动zookeeper
zkServer.sh start

# 查看zookeeper状态
zkServer.sh status

# 启动 yarn 的 resourcemanager 角色
yarn-daemons.sh start resourcemanager

# 启动 hdfs 集群
start-dfs.sh
# 启动 yarn 的 NodeManager 角色
start-yarn.sh
```

#### 启动Spark

```shell
# 进入 spark 的 sbin 目录
cd /opt/bigdata/spark-2.4.5-master/sbin

# 执行启动命令
./start-all.sh
```

#### Spark资源层角色为

```
主节点：Master
从节点：Worker
```

#### Spark资源层webUI访问url

```http
http://bigdata01:8080
```

#### 集群应用测试

##### 生成本地文件

```sh
vi data.txt
```

```
hello world
hello mashibing
hello spark
good idea
```

##### 文件上传到hdfs上

```shell
# hdfs上创建目录
hdfs dfs -mkdir -p /sparktest
# 文本文件上传
hdfs dfs -put data.txt /sparktest
# 查看文件是否上传成功
hdfs dfs -ls /sparktest
# 或者访问url
http://bigdata01:50070/explorer.html
```

##### 测试spark程序

```shell
# 进入Spark的bin目录
cd /opt/bigdata/spark-2.4.5-master/bin

# 查看帮助
./spark-shell --help

# 使用spark-shell进行测试
./spark-shell --master spark://bigdata01:7077

# 启动完成之后，可以从spark资源ui管理界面看到相对应的application
http://bigdata01:8080

# 执行scala测试语句
sc.textFile("hdfs://mycluster/sparktest/data.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
```

### 设置zookeeper高可用

```shell
# 进入 Spark 的配置文件
cd /opt/bigdata/spark-2.4.5-master/conf

# 赋值模版文件
cp spark-defaults.conf.template spark-defaults.conf

# 编辑spark-defaults.conf
vim spark-defaults.conf
```

```sh
spark.deploy.recoveryMode       ZOOKEEPER
spark.deploy.zookeeper.url      bigdata01:2181,bigdata02:2181,bigdata03:2181,bigdata04:2181
spark.deploy.zookeeper.dir      /spark
```

### 向其他机器分发配置

```shell
scp -r spark-defaults.conf bigdata02:`pwd`
scp -r spark-defaults.conf bigdata03:`pwd`
scp -r spark-defaults.conf bigdata04:`pwd`

```

### 进入第二台机器，修改配置

cd $SPARK_HOME/conf

```shell
vim spark-env.sh
```

```shell
export SPARK_MASTER_HOST=bigdata02   # 每台master改成自己的主机名
```

```shell
# 重启Spark集群
cd $SPARK_HOME/sbin

# 停止Spark
./stop-all.sh

# 再次启动
## 进入第一台机器启动
cd $SPARK_HOME/sbin
./start-all.sh

## 进入第二台机器，手动启动master
cd $SPARK_HOME/sbin
./start-master.sh
```

## Spark执行日志持久化

计算层把日志持久化，history-server去获取展示

cd $SPARK_HOME/conf

```shell
vim spark-defaults.conf
```

```shell
# 把日志持久化到hdfs上，所以先在hdfs创建存放日志的目录
hdfs dfs -mkdir -p /spark_log
hdfs dfs -ls /spark_log

spark.eventLog.enabled true
spark.eventLog.dir hdfs://mycluster/spark_log
spark.history.fs.logDirectory  hdfs://mycluster/spark_log
```

### 向其他机器分发配置

```shell
scp -r spark-defaults.conf bigdata02:`pwd`
scp -r spark-defaults.conf bigdata03:`pwd`
scp -r spark-defaults.conf bigdata04:`pwd`

# 进去第一台机器 停止Spark集群
cd $SPARK_HOME/sbin
# 停止Spark
./stop-all.sh

# 进入第二台机器 停止 master节点
cd $SPARK_HOME/sbin
./stop-master.sh

# 再次启动
## 进入第一台机器启动
cd $SPARK_HOME/sbin
./start-all.sh

## 进入第二台机器，手动启动master
cd $SPARK_HOME/sbin
./start-master.sh

```

### 执行测试程序，查看记录的日志

```shell
# 进入Spark的bin目录
cd /opt/bigdata/spark-2.4.5-master/bin

# 使用spark-shell进行测试
./spark-shell --master spark://bigdata01:7077,bigdata02:7077

# 执行scala测试语句
sc.textFile("hdfs://mycluster/sparktest/data.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)

# 然后 重启Spark集群

# 要想查看历史日志，在任意一台机器启动以下脚本
cd $SPARK_HOME/sbin
./start-history-server.sh
./stop-history-server.sh

# 访问日志地址(这个结果会出现浏览器兼容性问题：360极速浏览器不好使，其他浏览器都好用)
http://bigdata02:18080
```

### 使用集群模式运行

```shell
$SPARK_HOME/bin/spark-submit   \
--master spark://bigdata01:7077,bigdata02:7077 \
--deploy-mode cluster \
--class 'org.apache.spark.examples.SparkPi'  \
"$SPARK_HOME/examples/jars/spark-examples_2.11-2.4.5.jar" \
10
```

## Spark高可用集群 On-Yarn

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/spark-2.4.5-yarn
tar -zvxf spark-2.4.5-bin-hadoop2.7.tgz -C /opt/bigdata/spark-2.4.5-yarn
cd /opt/bigdata/spark-2.4.5-yarn
mv spark-2.4.5-bin-hadoop2.7/* /opt/bigdata/spark-2.4.5-yarn/
rm -rf spark-2.4.5-bin-hadoop2.7/
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export SPARK_HOME=/opt/bigdata/spark-2.4.5-yarn
export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin
```

```shell
source /etc/profile
```

```shell
reboot
```

### 执行配置

cd $SPARK_HOME/conf

> ```shell
> cp spark-env.sh.template spark-env.sh
> vim spark-env.sh
> ```
>
> ```shell
> export HADOOP_CONF_DIR=/opt/bigdata/hadoop-2.8.3-ha/hadoop-2.8.3/etc/hadoop
> ```
> 
> ```shell
> cp spark-defaults.conf.template spark-defaults.conf
> vim spark-defaults.conf
> ```
>
> ```shell
> spark.eventLog.enabled true
> spark.eventLog.dir hdfs://mycluster/spark_yarn_log
> spark.history.fs.logDirectory  hdfs://mycluster/spark_yarn_log
>```
> 
> ```shell
> # hdfs创建 历史日志文件夹
> hdfs dfs -mkdir -p /spark_yarn_log
> hdfs dfs -ls /spark_yarn_log
> ```

### 向其他机器分发配置

```shell
scp -r spark-env.sh spark-defaults.conf bigdata02:`pwd`
scp -r spark-env.sh spark-defaults.conf bigdata03:`pwd`
scp -r spark-env.sh spark-defaults.conf bigdata04:`pwd`
```

### 更新yarn配置

```shell
cd $HADOOP_HOME/etc/hadoop
vim yarn-site.xml
```

```xml
    <property>
        <name>yarn.nodemanager.resource.memory-mb</name>
        <value>4096</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.cpu-vcores</name>
        <value>4</value>
    </property>
    <property>
        <name>yarn.nodemanager.vmem-check-enabled</name>
        <value>false</value>
    </property>
```

### MapReduce 的历史日志的配置

```shell
cd $HADOOP_HOME/etc/hadoop
vim mapred-site.xml
```

```xml
<property>
	<name>mapred.job.history.server.embedded</name>
	<value>true</value>
</property>
<property>
	<name>mapreduce.jobhistory.address</name>
	<value>bigdata04:10020</value>
</property>
<property>
	<name>mapreduce.jobhistory.webapp.address</name>
	<value>bigdata04:50060</value>
</property>
<property>
	<name>mapreduce.jobhistory.intermediate-done-dir</name>
	<value>/work/mr-history-tmp</value>
</property>
<property>
	<name>mapreduce.jobhistory.done-dir</name>
	<value>/work/mr-history-done</value>
</property>
```

### 分发配置

```shell
scp -r yarn-site.xml mapred-site.xml bigdata02:`pwd`
scp -r yarn-site.xml mapred-site.xml bigdata03:`pwd`
scp -r yarn-site.xml mapred-site.xml bigdata04:`pwd`
```

### 启动hadoop集群

```shell
# 所有机器启动zookeeper
zkServer.sh start

# 查看zookeeper状态
zkServer.sh status

# 启动 yarn 的 resourcemanager 角色
yarn-daemons.sh start resourcemanager

# 启动 hdfs 集群
start-dfs.sh

# 启动 yarn 的 NodeManager 角色
start-yarn.sh

# 测试hadoop计算的日志
cd /opt/bigdata/hadoop-2.8.3-ha/hadoop-2.8.3/share/hadoop/mapreduce
hadoop jar hadoop-mapreduce-examples-2.8.3.jar wordcount /data/wc/input /data/wc/output1
# 启动bigdata04的日志服务
mr-jobhistory-daemon.sh start historyserver
# 然后就可以在yarn上通过history链接点进去了

###########################################################################################
# 如果启动报错，全部关闭后，单个启动，然后再尝试上面的批量启动
# 1,2,3,4
zkServer.sh start
zkServer.sh status
# 1,2,3
hadoop-daemon.sh start journalnode
# 1
yarn-daemons.sh start resourcemanager
# 1
yarn-daemons.sh start nodemanager
# 1,2
hadoop-daemon.sh start zkfc
# 1,2
hadoop-daemon.sh start namenode
# 1
start-dfs.sh
```

### 不需要再启动Spark的主程序服务了，可直接运行程序

```shell
# 进入Spark的bin目录
cd /opt/bigdata/spark-2.4.5-yarn/bin

# 使用spark-shell进行测试
./spark-shell --master yarn
# 当发现启动特别慢的时候，出现以下报错时，的解决方案
WARN yarn.Client: Neither spark.yarn.jars nor spark.yarn.archive is set, falling back to uploading libraries under SPARK_HOME

# 解决方案：可以将本地spark目录下的jar包上报到hdfs上，然后更改配置文件
cd /opt/bigdata/spark-2.4.5-yarn/jars
# 创建hdfs目录，存放jar包
hdfs dfs -mkdir -p /work/spark_lib/jars
# 上传jar包
hdfs dfs -put ./* /work/spark_lib/jars
hdfs dfs -ls /work/spark_lib/jars
# 进入spark配置目录，编辑spark-defaults.conf文件
cd /opt/bigdata/spark-2.4.5-yarn/conf
vim spark-defaults.conf
# 增加下面这一行的配置
spark.yarn.jars  hdfs://mycluster/work/spark_lib/jars/*
# 配置分发
scp -r spark-defaults.conf bigdata02:`pwd`
scp -r spark-defaults.conf bigdata03:`pwd`
scp -r spark-defaults.conf bigdata04:`pwd`
```

### 在Spark集群环境上测试

```shell
# 再次使用spark-shell进行测试（只能在客户端执行）
cd /opt/bigdata/spark-2.4.5-yarn/bin
./spark-shell --master yarn

sc.textFile("hdfs://mycluster/sparktest/data.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)

# 要想查看历史日志，在04机器启动以下脚本
cd $SPARK_HOME/sbin
./start-history-server.sh
./stop-history-server.sh

# 使用集群模式运行
$SPARK_HOME/bin/spark-submit   \
--master yarn \
--deploy-mode cluster \
--class 'org.apache.spark.examples.SparkPi'  \
"$SPARK_HOME/examples/jars/spark-examples_2.11-2.4.5.jar" \
10
```

### 启动集群总结

```shell
# 所有机器启动zookeeper
zkServer.sh start

# 查看zookeeper状态
zkServer.sh status

# 启动 yarn 的 resourcemanager 角色
yarn-daemons.sh start resourcemanager

# 启动 hdfs 集群
start-dfs.sh

# 启动 yarn 的 NodeManager 角色
start-yarn.sh

# 启动hadoop的日志服务（在04机器上）
mr-jobhistory-daemon.sh start historyserver

# 启动Spark的日志服务（在04机器上）
start-history-server.sh
```

