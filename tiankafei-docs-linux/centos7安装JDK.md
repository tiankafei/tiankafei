# rpm安装 jdk 

## 使用xftp上传rpm文件

## 命令安装

```shell
rpm -i jdk-8u231-linux-x64.rpm
```

# tar安装jdk

## 使用xftp上传tar文件

## 解压压缩包

```shell
mkdir /usr/local/java
tar -zxvf /home/tiankafei/jdk-8u211-linux-x64.tar.gz -C /usr/local/java
```

# 设置环境变量（全局环境变量）

> vi /etc/profile
>
> ```sh
> export JAVA_HOME=/usr/java/default
> export JRE_HOME=$JAVA_HOME/jre 
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib 
> export PATH=$PATH:$JAVA_HOME/bin
> ```
>
> 设置软链接
>
> ```shell
> ln -s /usr/java/jdk1.8.0_231-amd64 /usr/java/default
> ```
>
> 使环境变量立即生效
>
> ```shell
> source /etc/profile
> ```

# 设置环境变量（仅当前用户）

> 进入当前用户根目录
>
> cd 
>
> vim .bashrc
>
> ```sh
> export JAVA_HOME=/usr/java/default
> export JRE_HOME=$JAVA_HOME/jre 
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib 
> export PATH=$JAVA_HOME/bin:$PATH
> ```
>
> 设置软链接
>
> ```shell
> ln -s /usr/local/java/jdk1.8.0_211 /usr/java/default
> ```
>
> 使环境变量立即生效
>
> ```shell
> source .bashrc
> ```

