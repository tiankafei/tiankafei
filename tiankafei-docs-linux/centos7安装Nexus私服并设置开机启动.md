# maven私服搭建

## 下载

```shell
wget http://download.sonatype.com/nexus/3/nexus-3.20.1-01-unix.tar.gz
```

## 解压

```shell
mv nexus-3.20.1-01-unix.tar.gz /opt/software/
cd /opt/software/
tar -zvxf nexus-3.20.1-01-unix.tar.gz
rm -rf nexus-3.20.1-01-unix.tar.gz
```

## 启动

```shell
cd nexus-3.20.1-01
./bin/nexus start
```

## 默认密码位置

```shell
cd /opt/software/sonatype-work/nexus3
cat admin.password
```

## 新建maven仓库

| 仓库名称     | 仓库类型 | 仓库地址                                   |
| ------------ | -------- | ------------------------------------------ |
| maven-3rd    | hosted   |                                            |
| maven-aliyun | proxy    | https://maven.aliyun.com/repository/public |

## 新建npm仓库

| 仓库名称   | 仓库类型 | 仓库地址                        |
| ---------- | -------- | ------------------------------- |
| npm-local  | hosted   |                                 |
| npm-taobao | proxy    | https://registry.npm.taobao.org |
| npm-all    | group    |                                 |

## 新建docker仓库

| 仓库名称      | 仓库类型 | 仓库地址 |
| ------------- | -------- | -------- |
| docker-local  | hosted   |          |
| docker-aliyun | proxy    |          |
| docker-all    | group    |          |

## 设置开机启动脚本

```shell
vi /lib/systemd/system/nexus.service
```

## 脚本内容

```sh
[Unitt]
Description=nexus
After=network.target

[Service]
Type=forking
Environment="JAVA_HOME=/usr/java/default/"
ExecStart=/opt/software/nexus-3.20.1-01/bin/nexus start
ExecReload=/opt/software/nexus-3.20.1-01/bin/nexus restart
ExecStop=/opt/software/nexus-3.20.1-01/bin/nexus stop

[Install]
WantedBy=multi-user.target
```

## 设置开机启动

```sh
systemctl daemon-reload
systemctl enable nexus.service
systemctl start nexus.service
```