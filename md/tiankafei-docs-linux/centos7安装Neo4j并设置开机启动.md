# CentOS7安装Neo4j

## 下载

```shell
wget https://neo4j.com/artifact.php?name=neo4j-community-3.5.13-unix.tar.gz
```

## 解压

```shell
mv artifact.php?name=neo4j-community-3.5.13-unix.tar.gz neo4j-community-3.5.13-unix.tar.gz
tar -zxvf neo4j-community-3.5.13-unix.tar.gz
```

## 更新配置

```shell
vi /root/neo4j-community-3.5.13/conf/neo4j.conf
```

```shell
#这一行的 前面的#号去掉
dbms.connectors.default_listen_address=0.0.0.0
```

## 移动路径

```shell
mv neo4j-community-3.5.13 /opt/software/
```

## 进入目录

```shell
cd /opt/software/neo4j-community-3.5.13
```

## 新建启动脚本

```sh
vi start.sh

#!/bin/bash
sh /opt/software/neo4j-community-3.5.13/bin/neo4j start
```

## 新建停止脚本

```sh
vi stop.sh

#!/bin/bash
sh /opt/software/neo4j-community-3.5.13/bin/neo4j stop
```

## 赋可执行权限

```shell
chmod +x start.sh stop.sh
```

## 新增开机启动脚本

```shell
vi /lib/systemd/system/neo4j.service
```

## 脚本内容

```sh
[Unit]
Description=neo4j
After=network.target remote-fs.target nss-lookup.target

[Service]
Type=forking
ExecStart=/opt/software/neo4j-community-3.5.13/start.sh
ExecStop=/opt/software/neo4j-community-3.5.13/stop.sh
PrivateTpm=true

[Install]
WantedBy=multi-user.target
```

## 启动

```shell
systemctl daemon-reload
systemctl status neo4j.service
systemctl start neo4j.service
systemctl stop neo4j.service
systemctl enable neo4j.service
```

## 访问url

```http
http://software:7474/
```

