# 禅道的安装

## 下载禅道

```shell

```

## 直接解压到/opt

```shell
sudo tar -zxvf  ZenTaoPMS.12.0.stable.zbox_64.tar.gz -C /opt
```

## 更新apache和mysql端口

```shell
/opt/zbox/zbox -ap 8080 -mp 3307
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

