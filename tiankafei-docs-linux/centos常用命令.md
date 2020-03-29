# 通用命令

## 安装 wget 工具

```shell
yum install wget -y
```

## 安装 net-tools 工具

```shell
yum install net-tools -y
```

## 安装 vim 工具

```shell
yum install vim -y
```

## 查看进程

```shell
ps -ef | grep 进程名/端口
```

## 关闭selinux

vi /etc/selinux/config

```sh
SELINUX=disabled
```

## 设置本地域名解析

vi /etc/hosts

```shell
# ip 别名
192.168.0.101 software
192.168.0.102 appserver
192.168.0.121 bigdata01
192.168.0.122 bigdata02
192.168.0.123 bigdata03
192.168.0.124 bigdata04
```

## 设置免密登录

```shell
ssh localhost
# 在本地机器用ssh-keygen 生成一个公私钥对
ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
# 把公钥加入authorized_keys中
ssh-copy-id root@bigdata01
```

## 关机命令

```shell
shutdown -h now
```

## 重启命令

```shell
reboot
```

## 解压命令

```shell
# 解压tar文件到指定路径
tar -zxvf 压缩包路径 -C 解压路径
```

## 更改linux连接最大数

vi /etc/security/limits.conf

```sh
*       soft    nofile  102400
*       hard    nofile  102400
*       soft    nproc   102400
*       hard    nproc   102400
```

vi /etc/pam.d/login

```sh
session    required     pam_limits.so
```

## 关闭防火墙，开机不启动防火墙

### CentOS6

查看状态

```shell
service iptables status
```

停止服务

```shell
service iptables stop
```

设置开机禁止启动

```shell
chkconfig iptables off
```

### CentOS7

查看状态

```shell
systemctl status firewalld.service
```

停止服务

```shell
systemctl stop firewalld.service
```

设置开机禁止启动

```shell
systemctl disable firewalld.service
```

## 时间同步阿里云

### ntp的安装及配置

安装时间同步工具ntp

```shell
yum install ntp  -y
```

设置阿里云时间同步地址

vi /etc/ntp.conf

```sh
server ntp1.aliyun.com
#注释掉其他的server
```

### CentOS6


查看状态

```shell
service ntpd status
```

启动服务

```shell
service ntpd start
```

停止服务

```shell
service ntpd stop
```

设置开机启动

```shell
chkconfig ntpd on
```

### CentOS7

查看状态

```shell
systemctl status ntpd.service
```

启动服务

```shell
systemctl start ntpd.service
```

停止服务

```shell
systemctl stop ntpd.service
```

设置开机启动

```sh
systemctl enable ntpd.service

# ntpd可能与chronyd冲突，所以需要先把chronyd禁止开机启动。如果发现ntpd服务没有开机启动，可以执行下面命令
# systemctl disable chronyd
```

## 切换 centos 阿里云yum源

### CentOS6

```shell
# 进入系统yum源的目录
cd /etc/yum.repos.d/
# 创建备份目录，方便出错后回退
mkdir backup
# 拷贝备份
cp CentOS-* ./backup/

# 下载阿里云centos6的yum源覆盖本地文件
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-6.repo

# 执行清理缓存
yum clean all
# 重新构造yum源的缓存
yum makecache

# 使用新yum源更新已安装的软件
yum update -y
```

### CentOS7

```shell
# 进入系统yum源的目录
cd /etc/yum.repos.d/
# 创建备份目录，方便出错后回退
mkdir backup
# 拷贝备份
cp CentOS-* ./backup/

# 下载阿里云centos6的yum源覆盖本地文件
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo

# 添加EPEL源
wget -P /etc/yum.repos.d/ http://mirrors.aliyun.com/repo/epel-7.repo

# 执行清理缓存
yum clean all
# 重新构造yum源的缓存
yum makecache

# 使用新yum源更新已安装的软件
yum update -y
```

### 问题恢复

```shell
cd /etc/yum.repos.d/backup

\cp -rf CentOS-* /etc/yum.repos.d/

# 执行清理缓存
yum clean all
# 重新构造yum源的缓存
yum makecache

# 查看源列表
yum repolist

# 使用新yum源更新已安装的软件
yum update -y
```

## 设置主机名

### CentOS6

vi /etc/sysconfig/network

```sh
NETWORKING=yes
HOSTNAME=主机名
```

### CentOS7

```shell
# 设置主机名
hostnamectl set-hostname 主机名

# 查看主机名
hostnamectl
```

## 网络配置

### CentOS7

```sh
vi /etc/sysconfig/network-scripts/ifcfg-ens33
```

```sh
BOOTPROTO="none"
ONBOOT="yes"
IPADDR="192.168.0.108"
PREFIX="24"
GATEWAY="192.168.0.1"
DNS1="192.168.0.1"
```

```shell
service network restart
```

```sh
vi /etc/resolv.conf
```

```sh
# 阿里云提供的
nameserver 223.5.5.5
nameserver 223.6.6.6
```

