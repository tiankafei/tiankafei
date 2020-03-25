# 安装 mysql8

> 查看是否已安装MySQL
>
> ```shell
> rpm -qa|grep mysql
> ```
>
> 若存在则卸载掉, 以防干扰安装MySQL8, (--nodeps)是消除依赖的意思
>
> ```shell
> rpm -e --nodeps mysql-libs-5.1.73-8.el6_8.x86_64
> ```
>
> 清楚yum缓存
>
> ```shell
> yum clean all
> ```

## 使用wget命令下载到本地

```shell
wget https://dev.mysql.com/get/mysql80-community-release-el6-1.noarch.rpm

rpm -ivh mysql80-community-release-el6-1.noarch.rpm
```

## 安装mysql

```shell
yum install mysql-server -y
```

## 查看mysql版本

```
mysqladmin -V
```

## 查看mysql状态

```shell
service mysqld status
```

## 启动mysql服务

```shell
service mysqld start
```

## 设置开机启动

```shell
chkconfig mysqld on
```

## 查看mysql初始化密码

```shell
cat /var/log/mysqld.log
```

## 登录mysql命令

```shell
mysql -uroot -p
```

## 第一次更改密码

```mysql
alter user user() identified by 'Root_12root'
```

## 设置密码规则

```mysql
SHOW VARIABLES LIKE 'validate_password%';
set global validate_password.policy=0;
set global validate_password.length=1;
```

## 设置新密码

```mysql
ALTER USER 'root'@'localhost' IDENTIFIED BY 'tiankafei';
```

## 更新主机

```mysql
use mysql;
update user set host = '%' where user = 'root';
select host, user from user;
```

## 刷新配置

```mysql
flush privileges;
```

