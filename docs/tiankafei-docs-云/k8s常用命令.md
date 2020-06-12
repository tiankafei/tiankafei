# k8s集群搭建

> kubeadm可以帮助你快速部署一套kubernetes集群。kubeadm设计目的为新用户开始尝试kubernetes提供一种简单的方法。不适用于生产环境

**Kubeadm是kubernetes集群快速构建工具**

**Kubelet运行在所有节点上，负责启动POD和容器，以系统服务形式出现**

**Kubectl是kubernetes命令行工具，提供指令**

## 设置时区

```
timedatectl set-timezone Asia/Shanghai
```

## 检查docker：（确保从cgroups均在同一个从groupfs）

> ```
> docker info | grep cgroup
> ```
>
> 如果不是groupfs,执行下列语句
>
> vi /etc/docker/daemon.json
>
> ```
> "exec-opts": ["native.cgroupdriver=cgroupfs"]
> ```
>
> 重新加载并重启docker
>
> ```
> systemctl daemon-reload && systemctl restart docker
> ```

## 安装kubeadm

> kubeadm是集群部署工具
>
> 解压上传安装包
>
> ```
> tar -zxvf kube114-rpm.tar.gz
> ```
>
> 执行安装
>
> ```
> cd kube114-rpm
> yum localinstall -y *.rpm
> ```

## 启动节点命令

> 启动节点的k8s服务
>
> ```
> systemctl start kubelet
> ```
>
> 设置开机启动
>
> ```
> systemctl enable kubelet
> ```
>
> 查看k8s服务状态
>
> ```
> systemctl status kubelet
> ```

## 关闭交换区

```
swapoff -a
vi /etc/fstab
#swap一行注释
```

## 配置网桥

```
cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
sysctl --system
```

## 加载本地镜像包

```
docker load -i k8s-114-images.tar.gz
```

## 加载图形化仪表盘镜像包

```
docker load -i flannel-dashboard.tar.gz
```

## 构建master主服务器

```
kubeadm init --kubernetes-version=v1.14.1 --pod-network-cidr=10.244.0.0/16
```

> 初始化完成之后，需要执行以下命令
>
> To start using your cluster, you need to run the following as a regular user:
>
> ```shell
> mkdir -p $HOME/.kube
> sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
> sudo chown $(id -u):$(id -g) $HOME/.kube/config
> ```

## 查看kubecrl状态

```
kubectl get nodes
```

## 查看所有的pod

```
kubectl get pod --all-namespaces
```

## 安装flannel网络组件

```
kubectl create -f kube-flannel.yml
```

## 开启WebUI仪表盘

```shell
#
kubectl apply -f kubernetes-dashboard.yaml
#WebUI的角色
kubectl apply -f admin-role.yaml
#控制角色的访问权限
kubectl apply -f kubernetes-dashboard-admin.rbac.yaml
#获取系统命名空间kube-system下的服务有哪些
kubectl -n kube-system get svc
```

访问地址

```
http://192.168.21.131:32000
```

## node节点加入策略

```
kubeadm join 192.168.21.131:6443 --token kqsyfb.o2ks5zl07b7jopeh \
    --discovery-token-ca-cert-hash sha256:b82ce0b05b2091265567337fc6012d12c07f6ae3457dafaccf053f93f2d068ca 
```

## 节点加入策略忘记的解决方案

```
kubeadm token list

拿到TOKEN的值，从新组织命令如下：
kubeadm join 192.168.163.132:6443 --token kqsyfb.o2ks5zl07b7jope --discovery-token-unsafe-skip-ca-verification
```

