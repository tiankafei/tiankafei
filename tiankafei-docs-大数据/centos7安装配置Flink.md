# Centos7安装Flink

## 下载Flink

选择对应的版本进行下载，这里选择的是：flink-1.9.2-bin-scala_2.12

```http
# flink全部版本下载地址
https://flink.apache.org/downloads.html
# tga 解压包下载路径
https://www.apache.org/dyn/closer.lua/flink/flink-1.9.2/flink-1.9.2-bin-scala_2.12.tgz
```

## Flink单机版安装

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/flink-1.9.2-local
tar -zvxf flink-1.9.2-bin-scala_2.12.tgz -C /opt/bigdata/flink-1.9.2-local
cd /opt/bigdata/flink-1.9.2-local
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export FLINK_HOME=/opt/bigdata/flink-1.9.2-local/flink-1.9.2
export PATH=$PATH:$SPARK_HOME/bin:$FLINK_HOME/bin
```

```shell
source /etc/profile
```

### 执行配置

```shell
cd $FLINK_HOME/conf
vim flink-conf.yaml
```

```yaml
# JobManager地址
jobmanager.rpc.address: bigdata01
```

### 单机启动测试

```shell
# 启动Flink
start-cluster.sh
# 访问地址
http://bigdata01:8081/
```

## Flink集群环境安装on-master

### 解压到指定路径

```shell
mkdir -p /opt/bigdata/flink-1.9.2-full
tar -zvxf flink-1.9.2-bin-scala_2.12.tgz -C /opt/bigdata/flink-1.9.2-full
cd /opt/bigdata/flink-1.9.2-full
```

### 设置环境变量

```shell
vi /etc/profile
```

```shell
export FLINK_HOME=/opt/bigdata/flink-1.9.2-full/flink-1.9.2
export PATH=$PATH:$SPARK_HOME/bin:$FLINK_HOME/bin
```

```shell
source /etc/profile
```

### 执行配置

cd $FLINK_HOME/conf
vim flink-conf.yaml

```yaml
# JobManager地址
jobmanager.rpc.address: bigdata01
# JobManagerRPC通信端口
jobmanager.rpc.port: 6123
# JobManager所能使用的堆内存大小
jobmanager.heap.size: 1024m
# TaskManager所能使用的堆内存大小
taskmanager.heap.size: 1024m
# TaskManager管理的TaskSlot个数，依据当前物理机的核心数来配置，一般预留出一部分核心（25%）给系统及其他进程使用，一个slot对应一个core。如果core支持超线程，那么slot个数*2
taskmanager.numberOfTaskSlots: 2
# 指定WebUI的访问端口
rest.port: 8081
```

vim slaves

```shell
bigdata02
bigdata03
bigdata04
```

### 执行分发

```shell
scp -r flink-conf.yaml slaves bigdata02:`pwd`
scp -r flink-conf.yaml slaves bigdata03:`pwd`
scp -r flink-conf.yaml slaves bigdata04:`pwd`
```

### 执行启动

cd $FLINK_HOME/bin

```shell
# 启动Flink
start-cluster.sh
# 访问地址
http://bigdata01:8081/

# 使用这个命令给8888端口发送消息
nc -lk 8888
# 命令行执行测试
flink run -c cn.tiankafei.bigdata.flink.FlinkWorkCount scala-project-1.0-SNAPSHOT.jar
# 通过UI可以看到后台的输入日志
http://bigdata01:8081/

# 通过UI上传jar包执行Flink程序

```

