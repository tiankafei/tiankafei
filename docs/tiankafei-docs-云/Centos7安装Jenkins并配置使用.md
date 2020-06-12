# Jenkins安装及配置

## Tomcat安装并设置开机启动

### 拷贝tomat到指定目录

```sh
cp apache-tomcat-9.0.30.tar.gz /opt/software/
```

### 进入指定目录并解压tomcat

```sh
cd /opt/software/
tar -zvxf apache-tomcat-9.0.30.tar.gz
```

### 删除原压缩包

```sh
rm -rf apache-tomcat-9.0.30.tar.gz
```

### 设置tomcat启动的配置文件

```sh
vi /etc/systemd/system/tomcat.service
```

```shell
[Unit]
Description=Tomcat8080
After=syslog.target network.target remote-fs.target nss-lookup.target

[Service]
Type=oneshot
ExecStart=/opt/software/apache-tomcat-9.0.30/bin/startup.sh
ExecStop=/opt/software/apache-tomcat-9.0.30/bin/shutdown.sh
ExecReload=/bin/kill -s HUP $MAINPID
RemainAfterExit=yes

[Install]
WantedBy=multi-user.target
```

### 设置开机启动

```sh
sudo systemctl daemon-reload
systemctl enable tomcat
systemctl start tomcat
systemctl status tomcat
```

## Jenkin安装

### 下载Jenkins安装使用的war包

```http
http://mirrors.jenkins.io/war-stable/latest/jenkins.war
```

### 把jenkins.war拷贝到tomcat的webapp目录下

```sh
cp jenkins.war /opt/software/apache-tomcat-9.0.30/webapps/
```

### 可以通过以下地址进行访问

```http
# http://ip:tomcat的端口/jenkins
http://software:8080/jenkins/
```

### 接下来就根据提示步骤一步一步往下安装即可

