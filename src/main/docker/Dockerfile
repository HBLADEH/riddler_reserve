FROM openjdk:11.0.4
## 维护者信息
MAINTAINER BLADE 1012582116@qq.com
COPY riddler_reserve-0.0.1.jar /tmp/app.jar
WORKDIR /tmp
#VOLUME /usr/share/nginx/html/static
ENTRYPOINT ["java", "-jar", "app.jar"]

## 基础镜像
#FROM openjdk:11.0.4
#
## VOLUME /tmp
#
## 维护者信息
#MAINTAINER BLADE 1012582116@qq.com
#
## 添加springboot项目到镜像中的home目录，并重命名为app.jar
#COPY dqnetmusic-0.0.1.jar /tmp/app.jar
#WORKDIR /tmp
## 告诉Docker服务端暴露的端口，在容器启动时需要通过 -p 做端口映射
#EXPOSE 8080
#
## 容器启动后执行的命令
#ENTRYPOINT ["java","-jar","app.jar"]
#
## VOLUME /tmp
## ENTRYPOINT ["java","-jar","/app.jar"]。ENTRYPOINT ["executable", "param1", "param2"]
#
