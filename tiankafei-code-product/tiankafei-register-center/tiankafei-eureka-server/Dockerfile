FROM hub.c.163.com/library/java:8u111-jre

MAINTAINER tiankafei weishuangshuang89@163.com

ADD target/tiankafei-eureka-server-1.0-RELEASE.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app.jar"]