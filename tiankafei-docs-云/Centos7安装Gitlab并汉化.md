# gitlab安装

## 添加gitlab镜像

```shell
wget https://mirrors.tuna.tsinghua.edu.cn/gitlab-ce/yum/el7/gitlab-ce-12.3.9-ce.0.el7.x86_64.rpm
```

## 安装gitlab

```shell
rpm -i gitlab-ce-12.3.9-ce.0.el7.x86_64.rpm
```

## 修改gitlab配置文件指定服务器ip和自定义端口

```shell
vim  /etc/gitlab/gitlab.rb
```

```shell
external_url 'http://192.168.0.108:8083'
```

## 重置并启动GitLab

```shell
gitlab-ctl   reconfigure
gitlab-ctl   restart
```

## 访问地址

```
http://software:8083
```

## 查看gitlab版本

```
cat /opt/gitlab/embedded/service/gitlab-rails/VERSION
```

## 设置开机启动

```
systemctl enable gitlab-runsvdir.service
systemctl status gitlab-runsvdir.service
```

## gitlab汉化

> https://gitlab.com/xhang/gitlab/tree/12-3-stable-zh
>
> ```
> tar -zvxf gitlab-12-3-stable-zh.tar.gz
> ```
>
> 

```sh
#备份原文件
cp -rp /opt/gitlab/embedded/service/gitlab-rails{,.bak_$(date +%F)}
#将汉化包覆盖过去(\也需要敲)
cd gitlab-12-3-stable-zh
\cp -rf ./* /opt/gitlab/embedded/service/gitlab-rails/

gitlab-ctl reconfigure
gitlab-ctl start
```

