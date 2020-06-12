# 禅道的安装

## 下载禅道

```shell

```

## 直接解压到/opt

```shell
tar -zxvf  ZenTaoPMS.12.0.stable.zbox_64.tar.gz -C /opt
```

## 更新apache和mysql端口

```shell
/opt/zbox/zbox -ap 8084 -mp 3307
```

## 直接启动、停止

```shell
/opt/zbox/zbox start
/opt/zbox/zbox stop
```

## 设置开机启动

> vi /lib/systemd/system/zbox.service
>
> 脚本内容
>
> ```sh
> [Unit]
> Description=zbox
> After=network.target
> 
> [Service]
> Type=forking
> ExecStart=/opt/zbox/zbox start
> ExecStop=/opt/zbox/zbox stop
> PrivateTmp=true
> 
> [Install]
> WantedBy=multi-user.target
> ```

## 开机启动命令

```shell
# 重新加载配置
systemctl daemon-reload
# 设置开机启动
systemctl enable zbox.service
# 启动
systemctl start zbox.service
# 停止
systemctl stop zbox.service
# 查看状态
systemctl status zbox.service
```

## 如何访问数据库

1. 禅道数据库管理用的是adminer，但是为了安全，访问adminer的时候需要身份验证，需要运行/opt/zbox/auth/adduser.sh来添加用户(先 cd /opt/zbox/auth/ 然后执行 ./adduser.sh)。

2. **如何操作**：网页访问 http://禅道服务的ip:apache端口，点击“数据库管理”按钮有2层验证：**弹窗验证是输入运行 addusers.sh添加的用户名和密码。**

   我加的用户名是root，密码是123456。那么授权页面里用户名和密码就填写root和123456。

   **注意：** 这里添加的用户名和密码是自定义的，你可以根据你的使用习惯来添加。你添加了什么用户名和密码就填写什么。

3. **网页直接显示登录界面：**

   系  统：默认选择MySQL。

   服务器： 127.0.0.1:mysql端口 （mysql端口启用的是3307，那么就填写 127.0.0.1:3307。 **注意：ip只能写127.0.0.1**）

   用户名： root。（禅道默认的数据库用户名是 root）

   密  码：123456。（ 禅道默认的数据库密码是123456）

   数据库：zentao

## 应用的默认用户

用户名：admin

密   码 ：123456