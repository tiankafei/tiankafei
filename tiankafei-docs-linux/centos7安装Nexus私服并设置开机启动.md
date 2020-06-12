# maven私服搭建

## 下载

```shell
wget http://download.sonatype.com/nexus/3/nexus-3.20.1-01-unix.tar.gz
```

## 解压

```shell
mkdir /opt/software/
mv nexus-3.20.1-01-unix.tar.gz /opt/software/
cd /opt/software/
tar -zvxf nexus-3.20.1-01-unix.tar.gz
rm -rf nexus-3.20.1-01-unix.tar.gz
```

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
systemctl status nexus.service
```

## 默认密码位置

```shell
cat /opt/software/sonatype-work/nexus3/admin.password
```

## 新建用户

releases

snapshots

## 新建maven仓库

| 仓库名称                      | 仓库类型 | 仓库地址                                                     |
| ----------------------------- | -------- | ------------------------------------------------------------ |
| maven-aliyun-apache-snapshots | proxy    | https://maven.aliyun.com/repository/apache-snapshots <br />https://maven.aliyun.com/nexus/content/repositories/apache-snapshots |
| maven-aliyun-central          | proxy    | https://maven.aliyun.com/repository/central<br />https://maven.aliyun.com/nexus/content/repositories/central |
| maven-aliyun-google           | proxy    | https://maven.aliyun.com/repository/google<br />https://maven.aliyun.com/nexus/content/repositories/google |
| maven-aliyun-gradle-plugin    | proxy    | https://maven.aliyun.com/repository/gradle-plugin<br />https://maven.aliyun.com/nexus/content/repositories/gradle-plugin |
| maven-aliyun-jcenter          | proxy    | https://maven.aliyun.com/repository/jcenter<br />https://maven.aliyun.com/nexus/content/repositories/jcenter |
| maven-aliyun-spring           | proxy    | https://maven.aliyun.com/repository/spring<br />https://maven.aliyun.com/nexus/content/repositories/spring |
| maven-aliyun-spring-plugin    | proxy    | https://maven.aliyun.com/repository/spring-plugin<br />https://maven.aliyun.com/nexus/content/repositories/spring-plugin |
| maven-aliyun-grails-core      | proxy    | https://maven.aliyun.com/repository/grails-core<br />https://maven.aliyun.com/nexus/content/repositories/grails-core |
| maven-aliyun-public           | proxy    | https://maven.aliyun.com/repository/public<br />https://maven.aliyun.com/nexus/content/groups/public |

## 新建npm仓库

| 仓库名称   | 仓库类型 | 仓库地址                        |
| ---------- | -------- | ------------------------------- |
| npm-local  | hosted   |                                 |
| npm-taobao | proxy    | https://registry.npm.taobao.org |
| npm-public | group    |                                 |

## 新建docker仓库

| 仓库名称      | 仓库类型 | 仓库地址 |
| ------------- | -------- | -------- |
| docker-local  | hosted   |          |
| docker-aliyun | proxy    |          |
| docker-all    | group    |          |
