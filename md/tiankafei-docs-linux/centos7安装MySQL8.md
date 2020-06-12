# 安装 mysql8

## 查看是否已安装MySQL

```shell
rpm -qa|grep mysql
```

## 若存在则卸载掉

```shell
yum -y remove mysql80-community-release-el7-3.noarch
```

> 一般用rpm -e 的命令删除mysql,这样表面上删除了mysql,可是mysql的一些残余程序仍然存在,并且通过第一步的方式也查找不到残余,而yum命令比较强大,可以完全删除mysql.(ps:用rpm删除后再次安装的时候会提示已经安装了,这就是rpm没删除干净的原因)

## 把所有出现的目录统统删除

```shell
find / -name mysql
```

> 查找mysql的一些目录，把所有出现的目录删除，可以使用rm -rf 路径，删除时请注意，一旦删除无法恢复。
>
> ```shell
> rm -rf 目录
> ```

## 删除配置文件

```shell
rm -rf /etc/my.cnf

rm -rf /etc/my.cnf.d
```

## 删除mysql的默认密码

```shell
rm -rf /root/.mysql_sercret
```

> 删除mysql的默认密码,如果不删除,以后安装mysql这个sercret中的默认密码不会变,使用其中的默认密码就可能会报类似Access denied for user ‘root@localhost’ (using password:yes)的错误.

> 五步完成之后，这样mysql就全部删除干净了，若没安装过mysql可忽略以上步骤

## 使用wget命令下载到本地

```shell
wget https://dev.mysql.com/get/mysql80-community-release-el7-3.noarch.rpm

rpm -ivh mysql80-community-release-el7-3.noarch.rpm
```

## 安装Mysql 8.0

```shell
sudo yum --enablerepo=mysql80-community install -y mysql-community-server
```

## 查看mysql状态

```shell
systemctl status mysqld.service
```

## 启动mysql服务

```shell
systemctl start mysqld.service
```

## 设置开机启动

```shell
systemctl enable mysqld.service
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
alter user user() identified by 'Root_12root';
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

