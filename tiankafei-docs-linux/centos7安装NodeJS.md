# nodejs的安装

```shell
cp node-v12.14.1-linux-x64.tar.xz /opt/software/
cd /opt/software/
tar -xvf node-v12.14.1-linux-x64.tar.xz

ln -s /opt/software/node-v12.14.1-linux-x64/bin/node /usr/bin/node
ln -s /opt/software/node-v12.14.1-linux-x64/bin/npm /usr/bin/npm
```

```shell
node -v
npm -v
```

```sh
npm config set registry https://registry.npm.taobao.org
npm config set chromedriver_cdnurl https://npm.taobao.org/mirrors/chromedriver
```

## 指定版本安装

```shell
wget https://nodejs.org/dist/v8.9.0/node-v8.9.0-linux-x64.tar.gz

cp node-v8.9.0-linux-x64.tar.gz /opt/software/
cd /opt/software/
tar -zxvf  node-v8.9.0-linux-x64.tar.gz

ln -s /opt/software/node-v8.9.0-linux-x64/bin/node /usr/bin/node
ln -s /opt/software/node-v8.9.0-linux-x64/bin/npm /usr/bin/npm
```

