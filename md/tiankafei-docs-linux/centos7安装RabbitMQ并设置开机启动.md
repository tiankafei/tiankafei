# CentOS7安装RabbitMQ

## yum方式安装erlang

由于rabbitmq是基于erlang语言开发的，所以必须先安装erlang

### erlang官网

```shell
# erlang官网下载地址：
https://www.erlang.org/downloads

# erlang solutions 地址：
https://www.erlang-solutions.com/resources/download.html
```

### 安装依赖项

```shell
yum install -y epel-release
```

### 添加存储库条目

```shell
wget https://packages.erlang-solutions.com/erlang-solutions-1.0-1.noarch.rpm
rpm -Uvh erlang-solutions-1.0-1.noarch.rpm
```

### 安装

```
yum install -y erlang
```

### 验证是否安装成功

```
erl -version
```

> 出现“Erlang (SMP,ASYNC_THREADS,HIPE) (BEAM) emulator version 10.5”证明安装成功

## rpm方式安装erlang

### 安装依赖项

```
yum install -y epel-release
```

### 下载rpm包

```
wget https://packages.erlang-solutions.com/erlang/rpm/centos/7/x86_64/esl-erlang_22.1-1~centos~7_amd64.rpm
```

### 安装

```
yum install esl-erlang_22.1-1~centos~7_amd64.rpm
```

### 验证是否安装成功

```
erl -version
```

> 出现“Erlang (SMP,ASYNC_THREADS,HIPE) (BEAM) emulator version 10.5”证明安装成功

## 安装RabbitMQ

### 下载

```shell
wget https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.7.23/rabbitmq-server-3.7.23-1.el7.noarch.rpm
```

### 安装

```shell
yum install rabbitmq-server-3.7.23-1.el7.noarch.rpm -y
```

### 设置开机启动

```shell
systemctl enable rabbitmq-server.service
```

### 启动web插件

```shell
rabbitmq-plugins enable  rabbitmq_management
```

### 重启rabbitmq

```shell
systemctl stop rabbitmq-server.service
systemctl start rabbitmq-server.service
```

### 创建用户并赋权限

```shell
rabbitmqctl add_user tiankafei tiankafei
rabbitmqctl set_user_tags tiankafei administrator
```

### 登录地址

```http
http://192.168.0.111:15672/
```

