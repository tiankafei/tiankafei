# CentOS7安装Consul

## 下载consul

```shell
wget https://releases.hashicorp.com/consul/1.6.2/consul_1.6.2_linux_amd64.zip
```

## 安装zip和unzip命令

```shell
yum install unzip zip -y
```

## 解压

```shell
unzip -d consul_1.6.2_linux_amd64.zip 
```

## 创建指定目录

```shell
mkdir /opt/software/consul-1.6.2
cd /opt/software/consul-1.6.2
```

## 移动文件

```shell
mv /root/consul /opt/software/consul-1.6.2/
```

## 新建启动脚本

```shell
vi /opt/software/consul-1.6.2/start.sh
```

## 脚本内容

```sh
#!/bin/bash
./consul agent -dev  -client 0.0.0.0 -ui
```

## 给脚本赋权限

```shell
chmod 777 start.sh
```

## 新建开机启动脚本

```shell
vi /etc/init.d/consul
```

## 脚本内容

```sh
#!/bin/sh
#chkconfig: - 85 15
#description: consul service
#author: fab
 
export JAVA_HOME=/usr/java/default
export JRE_HOME=${JAVA_HOME}/jre 
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib 
export PATH=${JAVA_HOME}/bin:$PATH
 
case "$1" in
start)
    cd /opt/software/consul-1.6.2
    ./consul agent -dev  -client 0.0.0.0 -ui
!
    echo "consul startup"
    ;;  
stop)
    es_pid=`ps aux|grep consul | grep -v 'grep consul' | awk '{print $2}'`
    kill -9 $es_pid
    echo "consul stopped"
    ;;  
restart)
    es_pid=`ps aux|grep consul | grep -v 'grep consul' | awk '{print $2}'`
    kill -9 $es_pid
    echo "consul stopped"
	cd /opt/software/consul-1.6.2
    ./consul agent -dev  -client 0.0.0.0 -ui
!
    echo "consul startup"
    ;;  
*)
    echo "start|stop|restart"
    ;;  
esac
 
exit $?
```

## 修改consul可执行权限

```shell
chmod +x /etc/init.d/consul
```

## 添加consul到系统服务中

```shell
chkconfig --add consul
```

## 设置consul服务为开机启动

```shell
chkconfig consul on
```

## 验证

```shell
# 重启
reboot
# 验证进程是否存在
ps -elf|grep consul
```

