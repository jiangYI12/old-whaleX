FROM openjdk:8-jdk-alpine

MAINTAINER 877798901@qq.com

ENV JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

#在容器的根目录中创建文件夹
RUN mkdir -p /whale-sentinel-dashboard

#相当与cd 命令，但不同的是指定了WORKDIR后，容器启动时执行的命令会在该目录下执行
#WORKDIR
#指定RUN, CMD, ENTRYPOINT 等命令运行的工作路径
WORKDIR /whale-sentinel-dashboard

#对外暴漏的端口号
EXPOSE 10088

#将本地项目jar包拷贝到Docker容器中的位置
ADD ./target/whale-sentinel-dashboard.jar ./
#ADD ./pigx-upms/pigx-upms-biz/target/pigx-upms-biz.jar ./

CMD sleep 30;java $JAVA_OPTS -jar whale-sentinel-dashboard.jar
