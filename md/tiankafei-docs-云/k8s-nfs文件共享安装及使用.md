# nfs共享文件的安装及使用

## 安装命令

```shell
yum install -y nfs-utils rpcbind
```

## nfs配置

> vi /etc/exports
>
> ```
> 绝对路径 ip/24(rw,sync)
> /root/data 192.168.21.131/24(rw,sync)
> ```

## 启动nfs

```shell
systemctl start nfs.service
systemctl start rpcbind.service
```

## 设置nfs开机启动

```shell
systemctl enable nfs.service
systemctl enable rpcbind.service
```

## 查看配置是否成功

```
exportfs
```

## 其他节点只需安装nfs-utils即可

> ```shell
> yum install -y nfs-utils
> ```
>
> 查看命令
>
> ```shell
> showmount -e 192.168.21.131
> ```
>
> 执行挂载
>
> ```shell
> mount 192.168.21.131:/root/data /mnt
> ```
>
> 设置开机启动
>
> ```shell
> systemctl enable nfs.service
> ```

