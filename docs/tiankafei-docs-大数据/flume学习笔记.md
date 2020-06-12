# Flume

## Flume介绍

Flume是一个分布式，可靠的，可以用来有效的收集，聚合和移动大的日志数据的可用服务。它是一个基于数据流的简单且灵活的框架。采用可调可靠性机制和多种故障转移及恢复机制保证很好的稳健性和容错性。它使用了一个简单的可扩展的数据模型，允许在线分析应用。data flow（数据流）是Flume最重要的抽象，data flow描述了从数据产生，传输、处理并最终写入目标路径。下图描述了Flume重要的几个组件：

![flume-单agent](./images/flume-单agent.png)

结合上图，Flume的一些核心组件：

| 组件       | 功能                                                         |
| ---------- | ------------------------------------------------------------ |
| Web Server | 数据产生的源头。                                             |
| Agent      | Flume的核心就是Agent 。Agent是一个Java进程，且运行在日志收集端，通过Agent接收日志，然后暂存起来，再发送到目的地。 |
| Source     | Agent核心组件之一，Source（源）用于从Web Server收集数据，然后发送到Channel（通道）。 |
| Channel    | Agent核心组件之一，Channel（通道）可以用来从Source接收数据，然后发送到Sink，Channel存放零时数据，有点类似队列一样。 |
| Sink       | Agent核心组件之一，Sink（接收器）用来把数据发送的目标地点，如上图放到HDFS中。 |
| Event      | 整个数据传输过程中，流动的对象都是实现了org.apache.flume.Event接口的对象。Event也是事务保证的级别。 |

> Flume支持多个Agent，支持扇入(fan-in)、扇出(fan-out)。

## 系统要求

1. java运行时环境--Java 1.6或者更晚的（建议Java 1.7）
2. 内存 - 使用Sources，Channels或者Sinks要配置足够的内存。
3. 硬盘空间 - 使用Channels和Sinks要配置足够的硬盘空间。
4. 目录权限 - 被Agent使用的目录必须要有读和写的权限。

## 数据流模型

Flume Event被定义为一个字节的有效载荷以及以及一个可选的字符串属性集。Flume Source接收来自外部源的数据（比如：Web Server）。Flume的数据流由Event贯穿始终。事件是Flume的基本数据单元，当Source捕获事件后会进行特定的格式化，然后Source会把Event推送到一个或多个Channel中，可以把Channel看作是一个缓冲区或者一个队列，它将保存事件直到Sink处理完该事件。Sink负责持久化日志或者把事件推向另一个Source。

Flume提供了大量内置的Source、Channel和Sink类型。不同类型的Source,Channel和Sink可以自由组合。也可以自定义Source，Channel和Sink。关于这三者的组合关系是很灵活的，下面我们看下几幅图：

### 多agent流

为了使数据跨多个代理或跃点流动，前一个代理的接收器和当前跃点的源必须是avro类型，接收器指向源的主机名（或IP地址）和端口。

![flume-串联agent](./images/flume-串联agent.png)

### 合并

日志收集中的一个非常常见的情况是，大量的日志生成客户端将数据发送到连接到存储子系统的几个使用方。 例如，从数百台Web服务器收集的日志发送到许多写入HDFS群集的代理。

![flume-并联agent](./images/flume-并联agent.png)

### 多路流

Flume支持multiplexing Event到一个或者多个目的地，它通过多路复用器将Event复制或者选择性的路由到一个或多个Channel。

![flume-多sink的agent](./images/flume-多sink的agent.png)

上图的示例，名称为“foo”的Agent，Source会Fan out到三个Channel中，Fan out的方式分为replicating和multiplexing。如果采用replicating方式，那么每个Event会发到这三个Channel中，如果采用multiplexing方式，它是根据Event的属性来路由，然后发送到指定的Channel中。

**一个sink只能接收一个Channel发过来的数据**

## 可靠性

Event是分阶梯传送的，从Source->Channel->Sink的，Event最终传送到下一个Agent或下一个终端资源库（例如HDFS，文件系统等），在传送打到后，Event在Channel中删除。

end-to-end指的是：在删除Channel中的Event时，保证Event已经传递到了下一个Agent或者终端资源库，但是这里没有提到Source进入到Channel之前如果保证不丢失。具体的可以看下每个Source的实现。

Flume采用了事务的方式来保证Event的可靠性传输，保证Event集合在点对点的传输是可靠的。

## 可恢复性

事件在Channel是分阶梯，管理从失败中恢复。Flume支持持久化到本地文件系统中（即：FileChannel，但是性能不佳）。Memory Channel只是存储Event到内存的队列中，性能很好，但是当Agent挂掉，内存中的Event是不能够被恢复的。

## Flume Sources

| 名称                        | 描述                                                         |
| --------------------------- | ------------------------------------------------------------ |
| Avro Source                 | 监听Avro端口并且从外部Avro客户端接收Event。                  |
| Thrift Source               | 监听Thrift端口并且从外部Thrift客户端接收Event。              |
| Exec Source                 | 运行Unix命令，预计能产生持续的输出（）                       |
| JMS Source                  | 从JMS的queue或者topic读取数据                                |
| Spooling Directory Source   | 监测配置的目录下新增的文件，并将文件中的数据读取出来，可实现准实时。 |
| Kafka Source                | 作为一个消费者，从Apache Kafka的topic读取消息。              |
| NetCat Source               | 监听指定端口，将每一行封装成一个Event。                      |
| Sequence Generator Source   | 一个简单的序列生成器，从0开始，每次增加1，主要用于测试。     |
| Syslog TCP Source           | 读取syslog消息并且生成Flume的Event，TCP每个Event用'n'分割    |
| Multiport Syslog TCP Source | 这个是最新，最快，多端口版本的Syslog TCP Source。            |
| Syslog UDP Source           | 读取syslog消息并且生成Flume的Event，每个输入信息当成一个Event |
| HTTP Source                 | 接受HTTP的GET或者POST数据，GET是实验性质的，不建议使用。支持JSON、BLOB表示形式 |
| Stress Source               | 是一个内部负载生成源，用来做压力测试是非常有用的             |
| Avro Legacy Source          | 允许Flume 1.x的Agent从Flume 0.9.4的Agent中获取数据，它接受0.9.4的Event，并且转化成1.x |
| Thrift Legacy Source        | 和Avro Legacy Source雷同                                     |
| Scribe Source               |                                                              |

## Flume Sinks

| 名称              | 描述                                                         |
| ----------------- | ------------------------------------------------------------ |
| HDFS Sink         | 将数据写入到HDFS                                             |
| Hive Sink         | 将文本或者JSON数据用分隔符分割，直接变成Hive的表，或者是分区 |
| Logger Sink       | 记录Event的Info级别日志，通常用于测试或调试。                |
| Avro Sink         | 采用Avro Sink接收到的Event，发送到另外一个Avro Source        |
| Thrift Sink       | 采用Thrift Sink接收到的Event，发送到另外一个Thrift Source    |
| IRC Sink          | 从附加的Channel获取数据，转发到配置中的IRC的目的地。IRC（类似于网络聊天室的服务） |
| File Roll Sink    | 将Event存放到本地文件系统，根据时间或者大小生成文件。        |
| Null Sink         | 丢弃所有从Channel获取的Event。                               |
| HBaseSink         | 写入数据到Hbase                                              |
| AsyncHBaseSink    | 采用异步的形式写入数据到Hbase                                |
| MorphlineSolrSink | 将数据写入Solr集群                                           |
| ElasticSearchSink | 将数据写入ElasticSearch集群                                  |
| Kafka Sink        | 将数据写入Kafka集群                                          |

## Flume Channels

| 名称                       | 描述                                                         |
| -------------------------- | ------------------------------------------------------------ |
| Memory Channel             | 储存Event在内存队列中，如果宕机可能会造成数据的丢失，具有很高的吞吐量。 |
| JDBC Channel               | 将Event储存在持久化的数据库中，目前支持嵌入式的Derby。       |
| Kafka Channel              | 将Event储存在Kafka集群（必须单独部署），Kafka提供了高可用和复制性，所以Kafka或者Agent崩溃，数据也不会丢失。 |
| File Channel               | 将Event持久化在本地文件系统里(性能较差)，但是可以保证数据不丢失。 |
| Spillable Memory Channel   | Event数据存储在内存中和磁盘上，当内存队列满了，会持久化到磁盘文件（当前试验性的，不建议生产环境使用） |
| Pseudo Transaction Channel | 仅用于单元测试，不能用于生产环境。                           |

# Flume测试

Flume 的配置参考官方案例：

[https://flume.apache.org/releases/content/1.9.0/FlumeUserGuide.html](https://flume.apache.org/releases/content/1.9.0/FlumeUserGuide.html)

## Flume单台节点

![flume-单agent](./images/flume-单agent.png)

### 配置

```properties
# example.conf: A single-node Flume configuration

# Name the components on this agent
a1.sources = r1
a1.sinks = k1
a1.channels = c1

# Describe/configure the source
a1.sources.r1.type = netcat
a1.sources.r1.bind = bigdata01
a1.sources.r1.port = 44444

# Describe the sink
a1.sinks.k1.type = logger

# Use a channel which buffers events in memory
a1.channels.c1.type = memory
a1.channels.c1.capacity = 1000
a1.channels.c1.transactionCapacity = 100

# Bind the source and sink to the channel
a1.sources.r1.channels = c1
a1.sinks.k1.channel = c1
```

### 执行启动命令

```shell
flume-ng agent --conf-file option-netcat --name a1 -Dflume.root.logger=INFO,console
```

### 测试

```shell
# 安装telnet
yum install -y telnet
# 使用telnet连接flume节点，可以从控制台发送消息
telnet bigdata01 44444

# 验证 bigdata01 是否可以打印输入的字符串，如果能正常输出，说明正常运行
```

## 两台Flume节点

![flume-串联agent](./images/flume-串联agent.png)

### bigdata01 配置

```properties
# example.conf: A single-node Flume configuration

# Name the components on this agent
a1.sources = r1
a1.sinks = k1
a1.channels = c1

# Describe/configure the source
a1.sources.r1.type = netcat
a1.sources.r1.bind = bigdata01
a1.sources.r1.port = 44444

# Describe the sink
a1.sinks.k1.type = avro
a1.sinks.k1.hostname = bigdata02
a1.sinks.k1.port = 4545

# Use a channel which buffers events in memory
a1.channels.c1.type = memory
a1.channels.c1.capacity = 1000
a1.channels.c1.transactionCapacity = 100

# Bind the source and sink to the channel
a1.sources.r1.channels = c1
a1.sinks.k1.channel = c1
```

### bigdata02 配置

```properties
# example.conf: A single-node Flume configuration

# Name the components on this agent
a1.sources = r1
a1.sinks = k1
a1.channels = c1

# Describe/configure the source
a1.sources.r1.type = avro
a1.sources.r1.bind = bigdata02
a1.sources.r1.port = 4545

# Describe the sink
a1.sinks.k1.type = logger

# Use a channel which buffers events in memory
a1.channels.c1.type = memory
a1.channels.c1.capacity = 1000
a1.channels.c1.transactionCapacity = 100

# Bind the source and sink to the channel
a1.sources.r1.channels = c1
a1.sinks.k1.channel = c1
```

### 启动 bigdata02 的 flume

```shell
flume-ng agent --conf-file option-avro --name a1 -Dflume.root.logger=INFO,console
```

### 启动 bigdata01 的 flume

```shell
flume-ng agent --conf-file option-avro --name a1 -Dflume.root.logger=INFO,console
```

### 测试

```shell
# 使用telnet连接flume节点，可以从控制台发送消息
telnet bigdata01 44444

# 验证 bigdata02 是否可以打印输入的字符串，如果能正常输出，说明正常运行
```

## 多台 Flume 节点（存在单点故障的问题）

> 一个 flume 配置多个 source

![flume-并联agent](./images/flume-并联agent.png)



## 正儿八经的配置

> 一个 flume 配置多个 sinks

![flume-多sink的agent](./images/flume-多sink的agent.png)





