@echo off
REM 声明采用UTF-8编码
chcp 65001

call mvn clean compile install -Dmaven.test.skip=true
echo."=============================eureka-service package finished!!!============================="

rem 停止正在运行的容器
call docker stop eureka-server
echo."=============================eureka-service stop finished!!!============================="

rem 删除已经停止的容器
call docker rm eureka-server
echo."=============================eureka-service 删除容器 finished!!!============================="

rem 删除已经存在的镜像
call docker rmi tiankafei-eureka-server:1.0-RELEASEF
echo."=============================eureka-service 删除镜像 finished!!!============================="

rem 重新构建镜像
call docker build -t tiankafei-eureka-server:1.0-RELEASE .
echo."=============================eureka-service build finished!!!============================="

rem 启动镜像
call docker run -d -p 8761:8761 --name eureka-server tiankafei-eureka-server:1.0-RELEASE
echo."=============================eureka-service started finished!!!============================="