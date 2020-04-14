# centos7安装配置HBase

> 面向列的数据存储（十亿级别的行，百万级别的列）

## 下载hbase

选择对应的版本进行下载，这里选择的是2.2.4

```http
# hbase所有版本列表
https://hbase.apache.org/downloads.html
# tgz 解压包下载路径
https://mirrors.tuna.tsinghua.edu.cn/apache/hbase/2.2.4/hbase-2.2.4-bin.tar.gz
```

## 单机部署

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/hbase-2.2.4-local
tar -xzvf /root/hbase-2.2.4-bin.tar.gz -C /opt/bigdata/hbase-2.2.4-local
cd /opt/bigdata/hbase-2.2.4-local/hbase-2.2.4
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export HBASE_HOME=/opt/bigdata/hbase-2.2.4-local/hbase-2.2.4
export PATH=$PATH:$HBASE_HOME/bin
```

```shell
source /etc/profile
```

### 执行配置

cd $HBASE_HOME/conf

> vi hbase-env.sh 
>
> ```sh
> # 设置JAVA的环境变量
> export JAVA_HOME=/usr/java/default
> ```
>
> vi hbase-site.xml
>
> ```xml
> <property>
>  <name>hbase.rootdir</name>
>  <value>file:///var/bigdata/hbase/local/data</value>
> </property>
> <property>
>  <name>hbase.zookeeper.property.dataDir</name>
>  <value>/var/bigdata/hbase/local/zookeeper</value>
> </property>
> <property>
>  <name>hbase.unsafe.stream.capability.enforce</name>
>  <value>false</value>
>  <description>
>    Controls whether HBase will check for stream capabilities (hflush/hsync).
> 
>    Disable this if you intend to run on LocalFileSystem, denoted by a rootdir
>    with the 'file://' scheme, but be mindful of the NOTE below.
> 
>    WARNING: Setting this to false blinds you to potential data loss and
>    inconsistent system state in the event of process and/or node failures. If
>    HBase is complaining of an inability to use hsync or hflush it's most
>    likely not a false positive.
>  </description>
> </property>
> ```

### 运行

```shell
# 启动hbase服务
./start-hbase.sh

# 进入hbase命令行
hbase shell
```

## 完全分布式

### 解压到指定目录

```shell
mkdir -p /opt/bigdata/hbase-2.2.4-full
tar -xzvf /root/hbase-2.2.4-bin.tar.gz -C /opt/bigdata/hbase-2.2.4-full
cd /opt/bigdata/hbase-2.2.4-full/hbase-2.2.4
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export HBASE_HOME=/opt/bigdata/hbase-2.2.4-full/hbase-2.2.4
export PATH=$PATH:$HBASE_HOME/bin
```

```shell
source /etc/profile
```

### 执行配置

cd $HBASE_HOME/conf

> vim hbase-env.sh
>
> ```shell
> # 设置JAVA的环境变量
> export JAVA_HOME=/usr/java/default
> # 设置是否使用自己的zookeeper实例
> HBASE_MANAGES_ZK=false
> ```
>
> vim hbase-site.xml
>
> ```xml
> <property>
>  <name>hbase.rootdir</name>
>  <value>hdfs://mycluster/hbase</value>
> </property>
> <property>
>  <name>hbase.cluster.distributed</name>
>  <value>true</value>
> </property>
> <property>
>  <name>hbase.zookeeper.quorum</name>
>  <value>bigdata01,bigdata02,bigdata03,bigdata04</value>
> </property>
> 
> <!-- 以下配置可以在测试时使用，让hbase把内存中的数据flush到磁盘 -->
> <property>
>  <name>hbase.server.thread.wakefrequency</name>
>  <value>1</value>
> </property>
> <property>
>  <name>hbase.server.compactchecker.interval.multiplier</name>
>  <value>1</value>
> </property>
> ```
>
> vim regionservers 
>
> ```
> bigdata02
> bigdata03
> bigdata04
> ```
>
> 如果需要配置Master的高可用，需要在conf目录下创建backup-masters文件，并添加如下内容：
>
> ```
> vim backup-masters
> bigdata02
> ```
>
> 拷贝hadoop配置文件到当前hbase的配置目录
>
> ```shell
> scp $HADOOP_HOME/etc/hadoop/hdfs-site.xml $HBASE_HOME/conf/
> ```

### 执行分发

```shell
scp -r hbase-env.sh hbase-site.xml regionservers backup-masters hdfs-site.xml bigdata02:`pwd`
scp -r hbase-env.sh hbase-site.xml regionservers backup-masters hdfs-site.xml bigdata03:`pwd`
scp -r hbase-env.sh hbase-site.xml regionservers backup-masters hdfs-site.xml bigdata04:`pwd`

```

### 运行

```shell
# 启动hbase服务
./start-hbase.sh

# 进入hbase命令行
hbase shell
```



