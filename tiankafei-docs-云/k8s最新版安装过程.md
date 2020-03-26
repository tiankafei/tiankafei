# k8s最新版安装过程

## 克隆虚拟机完成之后的操作步骤

### 更改IP

```shell
vi /etc/sysconfig/network-scripts/ifcfg-ens33
```

### 更改主机名

```shell
hostnamectl set-hostname k8s
```

## 安装kubernetes必备的配置

### 关闭交换分区

```shell
swapoff -a
vi /etc/fstab
#swap一行注释
```

### 配置网桥

```
cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
sysctl --system
```

### docker 配置

> vi /etc/docker/daemon.json
>
> ```
> "exec-opts": ["native.cgroupdriver=systemd"]
> "exec-opts": ["native.cgroupdriver=cgroupfs"]
> ```
>
> 重新加载并重启docker
>
> ```shell
> systemctl daemon-reload && systemctl restart docker
> ```

### kubernetes配置

> 配置国内阿里云镜像
>
> ```
> cat > /etc/yum.repos.d/kubernetes.repo << EOF
> [kubernetes]
> name=Kubernetes
> baseurl=https://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
> enabled=1
> gpgcheck=1
> repo_gpgcheck=1
> gpgkey=https://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg https://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
> EOF
> ```

### 执行安装

```shell
yum install -y kubelet kubeadm kubectl
```

### 设置开机启动

```shell
systemctl enable kubelet
```

### 查看kubelet版本

```shell
kubelet --version
```

### 初始化镜像

```
kubeadm init \
--apiserver-advertise-address=192.168.21.131 \
--image-repository registry.aliyuncs.com/google_containers \
--kubernetes-version v1.17.0 \
--service-cidr=10.1.0.0/16 \
--pod-network-cidr=10.244.0.0/16
```

### 初始化完成之后，需要执行的命令

```
mkdir -p $HOME/.kube
  sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
  sudo chown $(id -u):$(id -g) $HOME/.kube/config

##其他节点加入时需要执行的命令
kubeadm join 192.168.21.131:6443 --token splv57.agssym1zwow1rljc \
    --discovery-token-ca-cert-hash sha256:3d4d8f3cd36e5a317b88dfd941a154188947a9c850fd20eb98791bb43303adb7
```

### 查看状态

```shell
systemctl status kubelet
```

### 启动kubelet

```shell
systemctl start kubelet
```

### 导出镜像

```
docker save > kubernetes.tar registry.aliyuncs.com/google_containers/kube-proxy:v1.17.0 registry.aliyuncs.com/google_containers/kube-apiserver:v1.17.0 registry.aliyuncs.com/google_containers/kube-controller-manager:v1.17.0 registry.aliyuncs.com/google_containers/kube-scheduler:v1.17.0 registry.aliyuncs.com/google_containers/coredns:1.6.5 registry.aliyuncs.com/google_containers/etcd:3.4.3-0 quay.io/coreos/flannel:v0.11.0-amd64 registry.aliyuncs.com/google_containers/pause:3.1
```

### 加载镜像

```shell
docker load < kubernetes.tar
```

### 节点加入策略忘记的解决方案

```shell
kubeadm token list

#拿到TOKEN的值，从新组织命令如下：
kubeadm join 192.168.163.132:6443 --token kqsyfb.o2ks5zl07b7jope --discovery-token-unsafe-skip-ca-verification
```

### 查看kubecrl状态

```shell
kubectl get nodes
```

### 查看所有的pod

```shell
kubectl get pod --all-namespaces
```

### 安装flannel网络组件

```shell
wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml
kubectl apply -f kube-flannel.yml
```

### 安装kubernetes/dashboard

> 下载dashboard配置文件
>
> ```shell
> wget https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta8/aio/deploy/recommended.yaml
> ```
>
> 更改配置，让宿主机能访问
>
> vi recommended.yaml
>
> ```yaml
> kind: Service
> apiVersion: v1
> metadata:
>     labels:
>        k8s-app: kubernetes-dashboard
>     name: kubernetes-dashboard
>     namespace: kubernetes-dashboard
> spec:
>     type: NodePort   #在这个位子添加这一行
>     ports:
>     - port: 443
>       targetPort: 8443
>       # The range of valid ports is 30000-32767
>       nodePort: 31001
>   selector:
>     k8s-app: kubernetes-dashboard
> ```
>
> 执行
>
> ```shell
> kubectl apply -f recommended-update.yaml
> ```
>
> >vi dashboard-create-service-account.yaml
> >
> >```yaml
> >apiVersion: v1
> >kind: ServiceAccount
> >metadata:
> >      name: admin-user
> >      namespace: kubernetes-dashboard
> >```
>
> > vi dashboard-create-cluster-role-binding.yaml
> >
> > ```yaml
> > apiVersion: rbac.authorization.k8s.io/v1
> > kind: ClusterRoleBinding
> > metadata:
> >      name: admin-user
> > roleRef:
> >      apiGroup: rbac.authorization.k8s.io
> >      kind: ClusterRole
> >      name: cluster-admin
> > subjects:
> > - kind: ServiceAccount
> >   name: admin-user
> >   namespace: kubernetes-dashboard
> > ```
>
> 执行安装
>
> ```shell
> kubectl apply -f dashboard-create-service-account.yaml
> kubectl apply -f dashboard-create-cluster-role-binding.yaml
> ```
>
> 查看分配的dashboard service对外访问的端口号
>
> ```shell
> kubectl get svc -n kubernetes-dashboard
> ```
>
> 通过火狐浏览器访问
>
> ```
> https://192.168.21.131:31001
> ```
>
> 选择使用token登录
>
> 找到secret中对应的admin-user，然后通过describe查看到对应的token值
>
> ```shell
> kubectl get secret -n kubernetes-dashboard
> 
> kubectl describe secret admin-user-token-5tcsk -n kubernetes-dashboard
> ```
>
> 即可登录

