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

> ```
> 设置pm2的环境变量
> ```
>
> 启动项目
>
> ```
> NODE_ENV=production 
> pm2 start app.js
> ```
>
> 保存当前进程状态
>
> ```
> 保存当前进程状态
> ```
>
> 启用开机自启
>
> ```
> systemctl enable pm2-root
> ```