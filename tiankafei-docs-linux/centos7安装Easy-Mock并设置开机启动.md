# easy-mock安装配置

##  安装

```
git clone https://github.com/easy-mock/easy-mock.git
```

## 进入其目录，安装依赖

```
cd easy-mock && npm install
```

> 报错
>
> ```
> gyp WARN EACCES user "root" does not have permission to access the dev dir "/home/countly/nodejs/lib/node_modules/time/.node-gyp/0.10.36"
> gyp WARN EACCES attempting to reinstall using temporary dev dir "/home/countly/nodejs/lib/node_modules/time/.node-gyp"
> ```
>
> 报错解决：在命令行后面增加
>
> ```
> npm install --unsafe-perm 
> ```

## 更改配置

```
config/default.json
```

## 代码执行

```
npm run dev
```

## 前端静态资源构建打包

```
npm run build
```

## 以生产环境方式启动，需要提前执行 build

```
npm run start
```

## 服务器部署

### 全局安装 PM2

```
npm install pm2 -g
```

### 用 PM2 启动

> 设置pm2的环境变量
>
> ```shell
>  # 设置软连接
>  ln -s /opt/software/node-v8.9.0-linux-x64/bin/pm2 /usr/local/bin/
> ```
>
> 启动项目
>
> ```
> NODE_ENV=production pm2 start app.js
> ```
>
> **开机自启动**
>
> ```
> pm2 startup  # 创建开机自启动命令
> pm2 save  # 保存当前应用列表
> pm2 resurrect  # 重新加载保存的应用列表
> pm2 unstartup  # 移除开机自启动
> ```
>
> **删除**
>
> ```
> pm2 delete app_name|app_id  # 从列表中删除指定的进程
> pm2 delete all # 从列表中删除全部进程
> pm2 kill # 杀死守护进程
> ```
>
> **停止**
>
> ```
> pm2 stop app_name|app_id
> pm2 stop all  # 停止所有
> ```
>
> **查看**
>
> ```
> pm2 list # 查看进程
> pm2 logs # 查看日志
> pm2 show app_name|app_id # 查看进程详情
> pm2 monit  # 查看CPU和内存资源占用
> ```
>
> 
>
> 