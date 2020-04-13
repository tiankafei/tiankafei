# centos7安装配置HBase

## 下载hbase

```http

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
> export JAVA_HOME=/usr/java/default
> ```
>
> vi hbase-site.xml
>
> ```xml
>   <property>
>     <name>hbase.rootdir</name>
>     <value>file:///var/bigdata/hbase/local/data</value>
>   </property>
>   <property>
>     <name>hbase.zookeeper.property.dataDir</name>
>     <value>/var/bigdata/hbase/local/zookeeper</value>
>   </property>
>   <property>
>     <name>hbase.unsafe.stream.capability.enforce</name>
>     <value>false</value>
>     <description>
>       Controls whether HBase will check for stream capabilities (hflush/hsync).
> 
>       Disable this if you intend to run on LocalFileSystem, denoted by a rootdir
>       with the 'file://' scheme, but be mindful of the NOTE below.
> 
>       WARNING: Setting this to false blinds you to potential data loss and
>       inconsistent system state in the event of process and/or node failures. If
>       HBase is complaining of an inability to use hsync or hflush it's most
>       likely not a false positive.
>     </description>
>   </property>
> ```

### 运行

```shell
hbase shell
```

## 完全分布式

### 解压到指定目录

```shell
mkdir -p /opt/bigdata/hbase-2.2.4-full
tar -xzvf /root/hbase-2.2.4-bin.tar.gz -C /opt/bigdata/hbase-2.2.4-full
cd /opt/bigdata/hbase-2.2.4-full/hbase-2.2.4
```



