# k8s脚本部署

## 创建部署

> 部署命令
>
> ```shell
> kubectl create -f 部署文件
> ```
>
> 部署文件demo
>
> vi tomcat-deploy.yml
>
> ```yaml
> apiVersion: apps/v1
> kind: Deployment
> metadata:
>      name: tomcat-deploy
> spec:
>      replicas: 3
>      selector:
>        matchLabels:
>          k8s-app: tomcat-cluster
>      template:
>        metadata:
>          labels:
>            k8s-app: tomcat-cluster
>        spec:
>          containers:
>       - name: tomcat-cluster
>         image: tomcat:latest
>         ports:
>         - containerPort: 8080
> ```
>
> 创建部署
>
> ```shell
> kubectl create -f ./tomcat-deploy.yml
> ```
>
> 查看当前所有当前的部署
>
> ```shell
> kubectl get deployment
> ```

## 更新部署配置

> 更新部署配置
>
> ```shell
> kubectl apply -f 部署文件
> ```

## 查看已部署的pod

> 查看已部署的pod
>
> ```shell
> kubectl get pod [-o wide]
> kubectl get pod -o wide
> ```

## 查看pod详细信息

> 查看pod详细信息
>
> ```shell
> kubectl describe pod pod名称
> kubectl describe pod tomcat-deploy-575dfb665d-6j59w
> ```

## 查看pod输出日志

> 查看pod输出日志
>
> ```shell
> kubectl logs [-f] pod名称
> kubectl logs tomcat-deploy-575dfb665d-6j59w
> ```

## 删除deployment

```shell
kubectl delete -n default deployment 部署名称
kubectl delete -n default deployment tomcat-deploy
```

# k8s脚本服务

## 创建服务

>服务文件demo
>
>vi tomcat-service.yml
>
>```yaml
>apiVersion: v1
>kind: Service
>metadata:
>      name: tomcat-service
>      labels:
>         k8s-app: tomcat-service
>spec:
>      type: NodePort
>      selector:
>         k8s-app: tomcat-cluster
>      ports:
>   - port: 8000
>     targetPort: 8080
>     nodePort: 31000
>```
>
>创建服务
>
>```shell
>kubectl create -f ./tomcat-service.yml
>```

## 更新服务

```shell
kubectl apply -f 部署文件
```

## 查看已部署的服务

```shell
kubectl get service
```

## 查看服务详情

```shell
kubectl describe service 服务名称
kubectl describe service tomcat-service
```

# 使用Rinetd给service做负载均衡

## Rinted安装

```shell
wget http://www.boutell.com/rinetd/http/rinetd.tar.gz
tar -zxvf rinetd.tar.gz
cd rinetd
sed -i 's/65536/65535/g' rinetd.c
mkdir -p /usr/man/
make && make install
```

## 更新Rinted配置

> vi /etc/rinetd.conf
>
> ```
> 0.0.0.0 8080 192.168.31.131 8080
> 0.0.0.0 8000 192.168.31.131 8000
> ```

## 启动Rinted

```shell
rinetd -c /etc/rinetd.conf
```

## 停止rinted

```shell
pkill rinetd
```

## 查看端口映射是否成功

```shell
netstat -tulpn
```

## 删除服务

```shell
kubectl delete service 服务名
kubectl delete service tomcat-service
```

## 更新服务配置

> vi tomcat-service.yml
>
> ```yaml
> apiVersion: v1
> kind: Service
> metadata:
>    name: tomcat-service
>    labels:
>        k8s-app: tomcat-service
> spec:
> # type: NodePort
>    selector:
>        k8s-app: tomcat-cluster
>    ports:
>   - port: 8000
>     targetPort: 8080
> #    nodePort: 31000
> ```

## 重新启动服务

```shell
kubectl create -f tomcat-service.yml
```

# docker 文件拷贝

## 从宿主机拷文件到容器里面

> 在宿主机里面执行如下命令
>
> ```shell
> docker cp 要拷贝的文件路径 容器名：要拷贝到容器里面对应的路径
> docker cp -r /mnt/test/index.jsp 620da4525448:/usr/local/tomcat/webapps/test
> ```

## 从容器里面拷文件到宿主机

> 在宿主机里面执行以下命令
>
> ```shell
> docker cp 容器名：要拷贝的文件在容器里面的路径       要拷贝到宿主机的相应路径 
> docker cp 620da4525448:/usr/local/tomcat/webapps/test/index.jsp ~/index.jsp
> ```

## 进入docker容器

```shell
docker exec -it 容器名 /bin/bash
docker exec -it 620da4525448 /bin/bash
```

# k8s service资源挂载

## 删除service

```shell
kubectl delete service tomcat-service
```

## 设置资源挂载

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tomcat-deploy
spec:
  replicas: 3
  selector:
    matchLabels:
      k8s-app: tomcat-cluster
  template:
    metadata:
      labels:
        k8s-app: tomcat-cluster
    spec:
      volumes:
      - name: web-app
        hostPath:
          path: /mnt
      containers:
      - name: tomcat-cluster
        image: tomcat:latest
        ports:
        - containerPort: 8080
        volumeMounts:
        - name: web-app
          mountPath: /usr/local/tomcat/webapps
```

## 更新Deployment配置

```shell
kubectl apply -f tomcat-deploy.yml
```

## 启动Service

```shell
kubectl create -f tomcat-service.yml
```

# k8s service服务资源限定

## 删除service

```shell
kubectl delete service tomcat-service
```

## 设置资源限定

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tomcat-deploy
spec:
  replicas: 2
  selector:
    matchLabels:
      k8s-app: tomcat-cluster
  template:
    metadata:
      labels:
        k8s-app: tomcat-cluster
    spec:
      volumes:
      - name: web-app
        hostPath:
          path: /mnt
      containers:
      - name: tomcat-cluster
        image: tomcat:latest
        resources: 
          requests:
            cpu: 0.5
            memory: 200Mi
          limits: 
            cpu: 1
            memory: 512Mi
        ports:
        - containerPort: 8080
        volumeMounts:
        - name: web-app
          mountPath: /usr/local/tomcat/webapps
```

## 更新Deployment配置

```shell
kubectl apply -f tomcat-deploy.yml
```

## 启动Service

```shell
kubectl create -f tomcat-service.yml
```

## 设置容器启动命令

```
image: tomcat:latest
command: ["/bin/sh"]
args: ["-c","cd 路径;java -jar *.jar"]
```

