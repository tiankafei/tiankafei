# CentOS7安装Mongodb

## 下载并解压

```shell
curl -O https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-4.0.4.tgz
tar -zxvf mongodb-linux-x86_64-4.0.4.tgz
```

## 创建mongodb相关目录

```shell
cd /opt/software/
mkdir -p mongodb/{data/db,log}
mv /root/mongodb-linux-x86_64-4.0.4 /opt/software/mongodb/
mv /opt/software/mongodb/mongodb-linux-x86_64-4.0.4/* /opt/software/mongodb/
rm -rf mongodb-linux-x86_64-4.0.4/

```

## 创建mongodb配置文件

```shell
cd /opt/software/mongodb/
mkdir conf
cd conf
vim mgdb.conf
```

## 配置文件内容

```sh
dbpath=/opt/software/mongodb/data/db  #数据文件存放目录
logpath=/opt/software/mongodb/log/mongodb.log  #日志文件存放目录
port=27017  #端口，默认27017，可以自定义
logappend=true  #开启日志追加添加日志
fork=true  #以守护程序的方式启用，即在后台运行
bind_ip=0.0.0.0  #本地监听IP，0.0.0.0表示本地所有IP
auth=false  #是否需要验证权限登录(用户名和密码)
```

## 添加环境变量

```shell
vim /etc/profile

export MONGODB_HOME=/opt/software/mongodb
export PATH=$PATH:$MONGODB_HOME/bin

source /etc/profile
```

## 创建Mongodb开机启动配置文件

```shell
vim /lib/systemd/system/mongodb.service
```

## 启动文件内容

```sh
[Unit]
Description=mongodb
After=network.target remote-fs.target nss-lookup.target

[Service]
Type=forking
RuntimeDirectory=mongodb
PIDFile=/opt/software/mongodb/data/db/mongod.lock
ExecStart=/opt/software/mongodb/bin/mongod --config /opt/software/mongodb/conf/mgdb.conf
ExecStop=/opt/software/mongodb/bin/mongod --shutdown --config /opt/software/mongodb/conf/mgdb.conf
PrivateTmp=true

[Install]  
WantedBy=multi-user.target
```

## 启动mongodb并加入开机启动

```sh
systemctl daemon-reload
systemctl start mongodb
systemctl stop mongodb
systemctl enable mongodb
```

## 检验是否启动

```sh
ps -ef | grep mongodb
```

## 创建mongodb管理用户

```shell
mongo --port 27017

use admin
db.createUser({user:"tiankafei",pwd:"tiankafei",roles:[{role:"userAdminAnyDatabase",db: "admin"}]})
db.auth('tiankafei','tiankafei')
```

## 创建测试用户

```shell
mongo --port 27017

use test
db.createUser({user:"test",pwd:"tiankafei",roles:[{role:"readWrite",db:"securitydata"}]})
db.auth('test','tiankafei')
```

## 测试用户登录

```shell
mongo --port 27017 -u test -p tiankafei
```
