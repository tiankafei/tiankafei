# CentOS7安装Hadoop

## 设置免密登录

```shell
ssh localhost
ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys
```

### 秘钥拷贝

#### node01

```shell
scp ~/.ssh/id_dsa.pub node02:~/.ssh/node01.pub
scp ~/.ssh/id_dsa.pub node03:~/.ssh/node01.pub
scp ~/.ssh/id_dsa.pub node04:~/.ssh/node01.pub
```

#### node02

```shell
scp ~/.ssh/id_dsa.pub node01:~/.ssh/node02.pub
scp ~/.ssh/id_dsa.pub node03:~/.ssh/node02.pub
scp ~/.ssh/id_dsa.pub node04:~/.ssh/node02.pub
```

#### node03

```shell
scp ~/.ssh/id_dsa.pub node01:~/.ssh/node03.pub
scp ~/.ssh/id_dsa.pub node02:~/.ssh/node03.pub
scp ~/.ssh/id_dsa.pub node04:~/.ssh/node03.pub
```

#### node04

```shell
scp ~/.ssh/id_dsa.pub node01:~/.ssh/node04.pub
scp ~/.ssh/id_dsa.pub node02:~/.ssh/node04.pub
scp ~/.ssh/id_dsa.pub node03:~/.ssh/node04.pub
```

### 增加认证

#### node01

```shell
cat ~/.ssh/node02.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node03.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node04.pub >> ~/.ssh/authorized_keys
```

#### node02

```shell
cat ~/.ssh/node01.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node03.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node04.pub >> ~/.ssh/authorized_keys
```

#### node03

```shell
cat ~/.ssh/node01.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node02.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node04.pub >> ~/.ssh/authorized_keys
```

#### node04

```shell
cat ~/.ssh/node01.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node02.pub >> ~/.ssh/authorized_keys
cat ~/.ssh/node03.pub >> ~/.ssh/authorized_keys
```

## 安装jdk

### node01上传jdk安装包

```shell
scp ~/jdk-8u231-linux-x64.rpm node02:`pwd`
scp ~/jdk-8u231-linux-x64.rpm node03:`pwd`
scp ~/jdk-8u231-linux-x64.rpm node04:`pwd`
```

### 执行安装node01-node04

```shell
rpm -i jdk-8u231-linux-x64.rpm
```

### 设置环境变量

```shell
vi /etc/profile
```

```sh
export JAVA_HOME=/usr/java/default
export JRE_HOME=${JAVA_HOME}/jre 
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib 
export PATH=${JAVA_HOME}/bin:$PATH
```

```shell
source /etc/profile
```

## 单机部署

### 单机部署存在的角色

> NameNode
>
> > 管理节点
>
> SecondaryNameNode
>
> > 帮助namenode备份数据 但是接替不了namenode的工作
>
> DataNode
>
> > 数据节点

### 部署策略

|        | NameNode | SecondaryNameNode | DataNode |
| ------ | -------- | ----------------- | -------- |
| node01 | 是       | 是                | 是       |
| node02 |          |                   |          |
| node03 |          |                   |          |
| node04 |          |                   |          |

### 环境安装

#### node01上传安装包

```shell
cd
scp ~/hadoop-2.9.2.tar.gz node02:`pwd`
scp ~/hadoop-2.9.2.tar.gz node03:`pwd`
scp ~/hadoop-2.9.2.tar.gz node04:`pwd`

```

#### 解压到指定目录

```shell
mkdir -p /opt/bigdata/hadoop-2.9.2-local
tar -zxvf /root/hadoop-2.9.2.tar.gz -C /opt/bigdata/hadoop-2.9.2-local
cd /opt/bigdata/hadoop-2.9.2-local
```

#### 设置环境变量

> ```shell
> vi /etc/profile
> ```
>
> ```sh
> export JAVA_HOME=/usr/java/default
> export JRE_HOME=$JAVA_HOME/jre
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib
> export HADOOP_HOME=/opt/bigdata/hadoop-2.9.2-local/hadoop-2.9.2
> export PATH=$JAVA_HOME/bin:$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
> ```
>
> ```shell
> source /etc/profile
> ```

### 执行配置

>vi hadoop-env.sh
>
>```sh
>export JAVA_HOME=/usr/java/default
>```

> vi core-site.xml
>
> ```xml
> 	<property>
>    		<name>fs.defaultFS</name>
>    		<value>hdfs://node01:9000</value>
>    	</property>
> ```

> vi hdfs-site.xml
>
> ```xml
> 	<!-- 副本数量为1 -->
>    	<property>
>    		<name>dfs.replication</name>
>    		<value>1</value>
>    	</property>
>    	<!-- NameNode的路径-->
>    	<property>
>    		<name>dfs.namenode.name.dir</name>
>    		<value>/var/bigdata/hadoop/local/dfs/name</value>
>    	</property>
>    	<!-- DataNode的路径-->
>    	<property>
>    		<name>dfs.datanode.data.dir</name>
>    		<value>/var/bigdata/hadoop/local/dfs/data</value>
>    	</property>
>    	<!-- SecondaryNameNode在哪个端口启动-->
>    	<property>
>    		<name>dfs.namenode.secondary.http-address</name>
>    		<value>node01:50090</value>
>    	</property>
>    	<!-- SecondaryNameNode的路径-->
>    	<property>
>    		<name>dfs.namenode.checkpoint.dir</name>
>    		<value>/var/bigdata/hadoop/local/dfs/secondary</value>
>    	</property>
> ```

> vi slaves
>
> ```shell
> node01
> ```

### 初始化

```shell
hdfs namenode -format
```

### 启动

```shell
start-dfs.sh
```

### 停止

```shell
stop-dfs.sh
```

### 访问地址

```http
http://node01:50070/
```

### 遇到的问题

> WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
>
> 解决方案：
>
> ```shell
> wget http://dl.bintray.com/sequenceiq/sequenceiq-bin/hadoop-native-64-2.7.0.tar
> tar -xvf hadoop-native-64-2.7.0.tar -C /opt/bigdata/hadoop-2.9.2-ha/hadoop-2.9.2/lib/native
> tar -xvf hadoop-native-64-2.7.0.tar -C /opt/bigdata/hadoop-2.9.2-ha/hadoop-2.9.2/lib
> # 环境变量
> export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
> export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib"
> ```

### 简单命令使用

```shell
# 创建目录
hdfs dfs -mkdir /bigdata
# 查看根目录
hdfs dfs -ls /
```

## 完全分布式部署

### 部署策略

|        | NameNode | SecondaryNameNode | DataNode |
| ------ | -------- | ----------------- | -------- |
| node01 | 是       |                   |          |
| node02 |          | 是                | 是       |
| node03 |          |                   | 是       |
| node04 |          |                   | 是       |

### 环境安装

#### 解压到指定目录

```shell
mkdir -p /opt/bigdata/hadoop-2.9.2-full
tar -zxvf /root/hadoop-2.9.2.tar.gz -C /opt/bigdata/hadoop-2.9.2-full
cd /opt/bigdata/hadoop-2.9.2-full
```

#### 设置环境变量

>```shell
>vi /etc/profile
>```
>
>```sh
>export JAVA_HOME=/usr/java/default
>export JRE_HOME=$JAVA_HOME/jre
>export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib
>export HADOOP_HOME=/opt/bigdata/hadoop-2.9.2-full/hadoop-2.9.2
>export PATH=$JAVA_HOME/bin:$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
>```
>
>```shell
>source /etc/profile
>```

### 执行配置

> cd $HADOOP_HOME/etc/hadoop
>
> vi hadoop-env.sh
>
> ```shell
> export JAVA_HOME=/usr/java/default
> ```
>
> vi core-site.xml
>
> ```xml
> 	<property>
> 		<name>fs.defaultFS</name>
> 		<value>hdfs://node01:9000</value>
> 	</property>
> ```
>
> vi hdfs-site.xml
>
> ```xml
> 	<!-- 副本数量为2 -->
> 	<property>
> 		<name>dfs.replication</name>
> 		<value>2</value>
> 	</property>
> 	<!-- NameNode的路径-->
> 	<property>
> 		<name>dfs.namenode.name.dir</name>
> 		<value>/var/bigdata/hadoop/full/dfs/name</value>
> 	</property>
> 	<!-- DataNode的路径-->
> 	<property>
> 		<name>dfs.datanode.data.dir</name>
> 		<value>/var/bigdata/hadoop/full/dfs/data</value>
> 	</property>
> 	<!-- SecondaryNameNode在哪个端口启动-->
> 	<property>
> 		<name>dfs.namenode.secondary.http-address</name>
> 		<value>node02:50090</value>
> 	</property>
> 	<!-- SecondaryNameNode的路径-->
> 	<property>
> 		<name>dfs.namenode.checkpoint.dir</name>
> 		<value>/var/bigdata/hadoop/full/dfs/secondary</value>
> 	</property>
> ```
>
> vi slaves
>
> ```shell
> node02
> node03
> node04
> ```

### 配置分发

```shell
cd $HADOOP_HOME/etc/hadoop
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node02:`pwd`
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node03:`pwd`
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node04:`pwd`

```

### 初始化

```shell
hdfs namenode -format
```

### 启动

```shell
start-dfs.sh
```

### 停止

```shell
stop-dfs.sh
```

### 访问地址

```http
http://node01:50070/
```

### 简单命令使用

```shell
# 创建目录
hdfs dfs -mkdir /bigdata
# 查看根目录
hdfs dfs -ls /
```

## 高可用 HA 配置

### 部署策略

|        | NameNode | ZKFC | JournalNode | Zookeeper | DataNode |
| ------ | -------- | ---- | ----------- | --------- | -------- |
| node01 | 是       | 是   | 是          | 是        |          |
| node02 | 是       | 是   | 是          | 是        | 是       |
| node03 |          |      | 是          | 是        | 是       |
| node04 |          |      |             | 是        | 是       |

### 环境安装

#### 安装包分发

```shell
cd
scp -r ~/hadoop-2.9.2.tar.gz node02:`pwd`
scp -r ~/hadoop-2.9.2.tar.gz node03:`pwd`
scp -r ~/hadoop-2.9.2.tar.gz node04:`pwd`

scp -r ~/zookeeper-3.4.9.tar.gz node02:`pwd`
scp -r ~/zookeeper-3.4.9.tar.gz node03:`pwd`
scp -r ~/zookeeper-3.4.9.tar.gz node04:`pwd`

```

#### hadoop解压到指定目录

```shell
mkdir -p /opt/bigdata/hadoop-2.9.2-ha
tar -zxvf /root/hadoop-2.9.2.tar.gz -C /opt/bigdata/hadoop-2.9.2-ha
cd /opt/bigdata/hadoop-2.9.2-ha
```

#### Zookeeper解压到指定目录

```shell
tar -zxvf /root/zookeeper-3.4.9.tar.gz -C /opt/bigdata
```

#### 设置环境变量

> ```shell
> vi /etc/profile
> ```
>
> ```sh
> export JAVA_HOME=/usr/java/default
> export JRE_HOME=$JAVA_HOME/jre
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib
> export HADOOP_HOME=/opt/bigdata/hadoop-2.9.2-ha/hadoop-2.9.2
> export ZOOKEEPER_HOME=/opt/bigdata/zookeeper-3.4.9
> export PATH=$JAVA_HOME/bin:$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZOOKEEPER_HOME/bin
> ```
>
> ```shell
> source /etc/profile
> ```

#### 设置完环境变量之后需要重启

```shell
reboot
```

### Zookeeper配置

#### 执行配置

```shell
cd /opt/bigdata/zookeeper-3.4.9/conf
cp zoo_sample.cfg zoo.cfg
vi zoo.cfg
```

> ```shell
>dataDir=/var/bigdata/hadoop/zk
> server.1=node01:2888:3888
> server.2=node02:2888:3888
> server.3=node03:2888:3888
> server.4=node04:2888:3888
> ```

#### 分发配置后的zookeeper

```shell
scp -r zoo.cfg node02:`pwd`
scp -r zoo.cfg node03:`pwd`
scp -r zoo.cfg node04:`pwd`

```

#### 配置myid

##### node01

```shell
mkdir /var/bigdata/hadoop/zk
echo 1 > /var/bigdata/hadoop/zk/myid
cat /var/bigdata/hadoop/zk/myid

```

##### node02

```shell
mkdir /var/bigdata/hadoop/zk
echo 2 > /var/bigdata/hadoop/zk/myid
cat /var/bigdata/hadoop/zk/myid

```

##### node03

```shell
mkdir /var/bigdata/hadoop/zk
echo 3 > /var/bigdata/hadoop/zk/myid
cat /var/bigdata/hadoop/zk/myid

```

##### node04

```shell
mkdir /var/bigdata/hadoop/zk
echo 4 > /var/bigdata/hadoop/zk/myid
cat /var/bigdata/hadoop/zk/myid

```

### 启动Zookeeper

> node01-node04
>
> ```shell
> zkServer.sh start
> zkServer.sh status
> zkServer.sh stop
> ```

### 执行配置

> cd $HADOOP_HOME/etc/hadoop
>
> vi hadoop-env.sh
>
> ```shell
> export JAVA_HOME=/usr/java/default
> ```
>
> vi core-site.xml
>
> ```xml
>	<property>
> 		<name>fs.defaultFS</name>
> 		<value>hdfs://mycluster</value>
> 	</property>
> 	<property>
> 		<name>ha.zookeeper.quorum</name>
> 		<value>node02:2181,node03:2181,node04:2181</value>
> 	</property>
> ```
> 
> vi hdfs-site.xml
>
> ```xml
>	<!-- 副本数量为3 -->
> 	<property>
> 		<name>dfs.replication</name>
> 		<value>3</value>
> 	</property>
> 	<!-- NameNode的路径-->
> 	<property>
> 		<name>dfs.namenode.name.dir</name>
> 		<value>/var/bigdata/hadoop/ha/dfs/name</value>
> 	</property>
> 	<!-- DataNode的路径-->
> 	<property>
> 		<name>dfs.datanode.data.dir</name>
> 		<value>/var/bigdata/hadoop/ha/dfs/data</value>
> 	</property>
> 	<!-- 以下是 一对多，逻辑到物理节点的映射-->
> 	<property>
> 		<name>dfs.nameservices</name>
> 		<value>mycluster</value>
> 	</property>
> 	<property>
> 		<name>dfs.ha.namenodes.mycluster</name>
> 		<value>nn1,nn2</value>
> 	</property>
> 	<property>
> 		<name>dfs.namenode.rpc-address.mycluster.nn1</name>
> 		<value>node01:8020</value>
> 	</property>
> 	<property>
> 		<name>dfs.namenode.rpc-address.mycluster.nn2</name>
> 		<value>node02:8020</value>
> 	</property>
> 	<property>
> 		<name>dfs.namenode.http-address.mycluster.nn1</name>
> 		<value>node01:50070</value>
> 	</property>
> 	<property>
> 		<name>dfs.namenode.http-address.mycluster.nn2</name>
> 		<value>node02:50070</value>
> 	</property>
> 	<!-- 以下是JN在哪里启动，数据存那个磁盘-->
> 	<property>
> 		<name>dfs.namenode.shared.edits.dir</name>
> 		<value>qjournal://node01:8485;node02:8485;node03:8485/mycluster</value>
> 	</property>
> 	<property>
> 		<name>dfs.journalnode.edits.dir</name>
> 		<value>/var/bigdata/hadoop/ha/dfs/jn</value>
> 	</property>
> 	<!-- HA角色切换的代理类和实现方法，我们用的ssh免密-->
> 	<property>
> 		<name>dfs.client.failover.proxy.provider.mycluster</name>
> 		<value>org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider
> 	</value>
> 	</property>
> 	<property>
> 		<name>dfs.ha.fencing.methods</name>
> 		<value>sshfence</value>
> 	</property>
> 	<property>
> 		<name>dfs.ha.fencing.ssh.private-key-files</name>
> 		<value>/root/.ssh/id_dsa</value>
> 	</property>
> 	<!-- 开启自动化： 启动zkfc-->
> 	<property>
> 		<name>dfs.ha.automatic-failover.enabled</name>
> 		<value>true</value>
> 	</property>
> ```
> 
> vi slaves
>
> ```shell
>node02
> node03
> node04
> ```

### 配置分发

```shell
cd $HADOOP_HOME/etc/hadoop
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node02:`pwd`
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node03:`pwd`
scp -r hadoop-env.sh core-site.xml hdfs-site.xml slaves node04:`pwd`

```

### 第一次启动顺序

#### 开启1,2,3台的journalnode

```shell
hadoop-daemon.sh start journalnode
```

#### 选择一个NN 做格式化

```shell
hdfs namenode -format
hadoop-daemon.sh start namenode
```

#### 在另一台NN进行同步

```shell
hdfs namenode -bootstrapStandby
hadoop-daemon.sh start namenode
```

#### 在node01下格式化zk

```shell
hdfs zkfc -formatZK
```

#### 启动

```shell
start-dfs.sh
```

#### 停止

```shell
stop-dfs.sh
```

### 再次启动时的启动顺序

#### node01-04启动Zookeeper

```shell
zkServer.sh start
```

#### 启动hadoop

```shell
start-dfs.sh
```

### 停止HA

#### 停止hadoop

```shell
stop-dfs.sh
```

#### 停止Zookeeper

```shell
zkServer.sh stop
```

### 访问地址

```http
http://node01:50070
http://node02:50070
```

## Yarn安装

### 部署策略

|        | NameNode | ZKFC | JournalNode | Zookeeper | DataNode | ResourceManager | NodeManager |
| ------ | -------- | ---- | ----------- | --------- | -------- | --------------- | ----------- |
| node01 | 是       | 是   | 是          | 是        |          |                 |             |
| node02 | 是       | 是   | 是          | 是        | 是       |                 | 是          |
| node03 |          |      | 是          | 是        | 是       | 是              | 是          |
| node04 |          |      |             | 是        | 是       | 是              | 是          |

### 修改配置

> cd $HADOOP_HOME/etc/hadoop
>
> ```shell
> cp mapred-site.xml.template mapred-site.xml
> ```
>
> vi mapred-site.xml
>
> ```xml
>         <property>
>             <name>mapreduce.framework.name</name>
>             <value>yarn</value>
>         </property>
> ```
>
> vi yarn-site.xml
>
> ```xml
>         <property>
>             <name>yarn.nodemanager.aux-services</name>
>             <value>mapreduce_shuffle</value>
>         </property>
> 	
> 	<property>
> 		<name>yarn.resourcemanager.ha.enabled</name>
> 		<value>true</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.zk-address</name>
> 		<value>node02:2181,node03:2181,node04:2181</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.cluster-id</name>
> 		<value>tiankafei</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.ha.rm-ids</name>
> 		<value>rm1,rm2</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.hostname.rm1</name>
> 		<value>node03</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.hostname.rm2</name>
> 		<value>node04</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.webapp.address.rm1</name>
> 		<value>node03:8088</value>
> 	</property>
> 	<property>
> 		<name>yarn.resourcemanager.webapp.address.rm2</name>
> 		<value>node04:8088</value>
> 	</property>
> ```

### 配置分发

```shell
scp -r mapred-site.xml yarn-site.xml node02:`pwd`
scp -r mapred-site.xml yarn-site.xml node03:`pwd`
scp -r mapred-site.xml yarn-site.xml node04:`pwd`

```

### 启动resourcemanager

```shell
yarn-daemons.sh start resourcemanager
```

### 启动yarn

```shell
start-yarn.sh
```

### 访问地址

```http
http://node03:8088/cluster
http://node04:8088/cluster
```

## 高可用集群停止服务

```shell
yarn-daemons.sh stop resourcemanager
```

```shell
stop-yarn.sh
```

```shell
stop-dfs.sh
```

```shell
zkServer.sh stop
```

## 高可用集群再次启动

```shell
zkServer.sh start
```

```shell
yarn-daemons.sh start resourcemanager
```

```shell
start-dfs.sh
```

```shell
start-yarn.sh
```

## Hive安装配置

### 单机部署

|        | mysql | hive服务端 | hive客户端 |
| ------ | ----- | ---------- | ---------- |
| node01 |       | 是         | 是         |
| node02 |       |            |            |
| node03 |       |            |            |
| node04 |       |            |            |

#### 安装包分发

```shell
cd
scp -r ~/apache-hive-2.3.6-bin.tar.gz node02:`pwd`
scp -r ~/apache-hive-2.3.6-bin.tar.gz node03:`pwd`
scp -r ~/apache-hive-2.3.6-bin.tar.gz node04:`pwd`

```

#### 解压到指定目录

```shell
tar -zxvf /root/apache-hive-2.3.6-bin.tar.gz -C /opt/bigdata
cd /opt/bigdata
mv apache-hive-2.3.6-bin/ apache-hive-2.3.6

```

#### 设置环境变量

> ```shell
> vi /etc/profile
> ```
>
> ```shell
> export JAVA_HOME=/usr/java/default
> export JRE_HOME=$JAVA_HOME/jre
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib
> export HADOOP_HOME=/opt/bigdata/hadoop-2.9.2-ha/hadoop-2.9.2
> export ZOOKEEPER_HOME=/opt/bigdata/zookeeper-3.4.9
> export HIVE_HOME=/opt/bigdata/apache-hive-2.3.6
> export PATH=$JAVA_HOME/bin:$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZOOKEEPER_HOME/bin:$HIVE_HOME/bin
> ```
>
> ```shell
> source /etc/profile
> ```

#### 执行配置

> cd $HIVE_HOME/conf
>
> ```shell
> cp hive-default.xml.template hive-site.xml
> ```
>
> vi hive-site.xml
>
> ```shell
> #删除 
> :.,$-1d
> ```
>
> ```xml
> 	<property>
> 		<name>hive.metastore.warehouse.dir</name>
> 		<value>/var/bigdata/hive/warehouse</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionURL</name>
> 		<value>jdbc:mysql://software:3306/hive?createDatabaseIfNotExist=true</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionDriverName</name>
> 		<value>com.mysql.cj.jdbc.Driver</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionUserName</name>
> 		<value>root</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionPassword</name>
> 		<value>tiankafei</value>
> 	</property>
> ```

#### 分发配置

```shell
scp -r hive-site.xml node02:`pwd`
scp -r hive-site.xml node03:`pwd`
scp -r hive-site.xml node04:`pwd`

```

#### 上传mysql依赖的jar包

```shell
cd /opt/bigdata/apache-hive-2.3.6/lib
scp -r mysql-connector-java-8.0.18.jar node02:`pwd`
scp -r mysql-connector-java-8.0.18.jar node03:`pwd`
scp -r mysql-connector-java-8.0.18.jar node04:`pwd`

```

#### 在node01上初始化数据库

```shell
schematool -dbType mysql -initSchema
```

#### 启动hive

```shell
hive
```

### 服务元数据分离配置

|        | mysql | hive服务端 | hive客户端 |
| ------ | ----- | ---------- | ---------- |
| node01 |       |            |            |
| node02 |       |            |            |
| node03 |       | 是         |            |
| node04 |       |            | 是         |

#### node03配置

> vi hive-site.xml
>
> ```xml
> 	<property>
> 		<name>hive.metastore.warehouse.dir</name>
> 		<value>/user/hive_remote/warehouse</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionURL</name>
> 		<value>jdbc:mysql://software:3306/hive_remote?createDatabaseIfNotExist=true</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionDriverName</name>
> 		<value>com.mysql.cj.jdbc.Driver</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionUserName</name>
> 		<value>root</value>
> 	</property>
> 	<property>
> 		<name>javax.jdo.option.ConnectionPassword</name>
> 		<value>tiankafei</value>
> 	</property>
> ```

node04配置

> vi hive-site.xml
>
> ```xml
> 	<property>
> 		<name>hive.metastore.warehouse.dir</name>
> 		<value>/user/hive_remote/warehouse</value>
> 	</property>
> 	<property>
> 		<name>hive.metastore.uris</name>
> 		<value>thrift://node03:9083</value>
> 	</property>
> ```

#### 在node03上初始化数据库

```shell
schematool -dbType mysql -initSchema
```

#### 在node03上阻塞式启动hive服务端

```shell
hive --service metastore
```

#### 在node04上启动Hive客户端

```shell
hive
```

### 解决root用户不能登录的问题，其他用户登录需要配置各种权限

> cd /opt/bigdata/hadoop-2.9.2-ha/hadoop-2.9.2/etc/hadoop
>
> vi core-site.xml
>
> ```xml
> 	<property>
> 		<name>hadoop.proxyuser.root.groups</name>
> 		<value>*</value>
> 	</property>
> 	<property>
> 		<name>hadoop.proxyuser.root.hosts</name>
> 		<value>*</value>
> 	</property>
> ```
>
> 配置完成之后重新启动集群，或者在namenode的节点上执行如下命令
>
> ```shell
> hdfs dfsadmin -fs hdfs://node01:8020 -refreshSuperUserGroupsConfiguration
> hdfs dfsadmin -fs hdfs://node02:8020 -refreshSuperUserGroupsConfiguration
> ```

### 独立hiveserver2模式

将现有的所有hive的服务停止，不需要修改任何服务，在node03机器上执行hiveserver2或者hive --service hiveserver2的命令，开始启动hiveserver2的服务，hiveserver2的服务也是一个阻塞式窗口，当开启服务后，会开启一个10000的端口，对外提供服务。

#### node03上启动服务

```shell
hiveserver2
或
hive --service hiveserver2
```

#### node04上执行

```shell
#1。直接在命令行执行
# beeline -u jdbc:hive2://<host>:<port>/<db> -n name
beeline -u jdbc:hive2://node03:10000/default -n root tiankafei
#2。先通过beeline进入交互式窗口，然后再执行下面的命令
beeline
# !connect jdbc:hive2://<host>:<port>/<db> root 123
!connect jdbc:hive2://node03:10000/default root tiankafei
```

### 共享metastore server的hiveserver2模式搭建

#### 在node03上执行hive --service metastore启动元数据服务

```shell
hive --service metastore
```

#### 在node04上执行hiveserver2或者hive --service hiveserver2两个命令其中一个都可以

```shell
hiveserver2
或
hive --service hiveserver2
```

#### 在任意一台包含beeline脚本的虚拟机中执行beeline的命令进行连接

```shell
#1。直接在命令行执行
# beeline -u jdbc:hive2://<host>:<port>/<db> -n name
beeline -u jdbc:hive2://node04:10000/default -n root tiankafei
#2。先通过beeline进入交互式窗口，然后再执行下面的命令
beeline
# !connect jdbc:hive2://<host>:<port>/<db> root 123
!connect jdbc:hive2://node04:10000/default root tiankafei
```



