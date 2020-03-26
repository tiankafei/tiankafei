# nacos

## 安装

### 下载

```shell
wget https://github.com/alibaba/nacos/releases/download/1.2.0/nacos-server-1.2.0.tar.gz
```

### 解压

```shell
tar -zvxf nacos-server-1.2.0.tar.gz
```

### 创建软件目录

```shell
mkdir -p /opt/software
```

### 移动软件到制定目录

```shell
mv nacos /opt/software/
```

### 进入目录

```shell
cd /opt/software/nacos/bin

pwd
/opt/software/nacos/bin
```

### 注册服务脚本

```shell
vi /lib/systemd/system/nacos.service
```

### 脚本内容

```sh
[Unit]
Description=nacos
After=network.target

[Service]
Type=forking
ExecStart=/opt/software/nacos/bin/startup.sh -m standalone
ExecReload=/opt/software/nacos/bin/shutdown.sh
ExecStop=/opt/software/nacos/bin/shutdown.sh
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

### 设置开机启动并启动nacos

```shell
# 重新加载service的配置
systemctl daemon-reload
# 设置开机启动
systemctl enable nacos.service
# 启动nacos
systemctl start nacos.service
# 重启nacos
systemctl restart nacos.service
# 停止nacos
systemctl stop nacos.service
# 查看nacos状态
systemctl status nacos.service

```

