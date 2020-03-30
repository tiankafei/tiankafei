# Hadoop程序运行的三种方式

## 打成jar包手动上传到服务器上运行

### 创建目录

```shell
# 创建hadoop远程文件路径,支持多级一起创建
# hdfs dfs -mkdir -p 远程文件路径
hdfs dfs -mkdir -p /data/wc/input
```

### 上传命令

```shell
# 上传本地文件到hadoop远程文件路径
# hdfs dfs -put 本地文件路径 hadoop远程文件路径
hdfs dfs -put data.txt /data/wc/input
```

### 执行命令

```java
java -jar jar包的名称
```

### 可以在yarn上看到执行过程

## 在客户端本地运行，map，reduce在集群环境上运行

### 设置执行依赖的环境配置

```java
// 在本地JVM环境中设置HADOOP_USER_NAME参数值为hadoop的用户
System.setProperty("HADOOP_USER_NAME", "root");
// 让框架知道在windows上执行，需要设置为true
conf.set("mapreduce.app-submission.cross-platform", "true");
```

### 设置要上传的jar包路径

因为map，reduce要在集群环境上运行，所以在运行的时候，需要把jar包上传到集群环境上，这个上传动作由hadoop自己做了

```java
Job job = Job.getInstance(conf);
// 把本地jar包上传到hadoop上
job.setJar("E:\\gits\\tiankafei\\tiankafei-code-learn\\hadoop-project\\target\\hadoop-project-1.0-SNAPSHOT.jar");
```

### 可以在yarn上看到执行过程

## 完全本地运行

### 设置执行依赖的环境配置

```java
// 在本地JVM环境中设置HADOOP_USER_NAME参数值为hadoop的用户
System.setProperty("HADOOP_USER_NAME", "root");
// 让框架知道在windows上执行，需要设置为true
conf.set("mapreduce.app-submission.cross-platform", "true");
```

### 不需要设置要上传的jar包了，因为这次是完全本地运行

### 配置本地hadoop环境变量

### 本地hadoop环境的bin目录需要替换一下windows下的执行文件，比如：winutils.exe

### 把hadoop.dll放到C盘windows的System32的目录下

### 此时会不在yarn上看到执行过程，可以直接从hadoop看执行结果