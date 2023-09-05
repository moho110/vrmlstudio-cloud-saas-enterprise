# 基础镜像
FROM  openjdk:8-jre
# author
MAINTAINER vrmlstudio

# 挂载目录
VOLUME /home/vrmlstudio
# 创建目录
RUN mkdir -p /home/vrmlstudio
# 指定路径
WORKDIR /home/vrmlstudio
# 复制jar文件到路径
COPY ./target/vrmlstudio-modules-gen.jar /home/vrmlstudio/vrmlstudio-modules-gen.jar

# 启动代码生成服务
ENTRYPOINT ["java","-jar","vrmlstudio-modules-gen.jar"]