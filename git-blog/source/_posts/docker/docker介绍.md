---

title: docker介绍
desc: 
keywords: 生活
date: 2017-05-25 12:55:34
tags: Docker
categories:
	Docker容器引擎
---

## docker介绍

docker是一个开源的应用容器引擎，让开发者可以打包自己的应用或者依赖到一个可移植的容器中，然后发布到任何流行的linux上。docker完全采用沙箱机制，相互之间不会有任何接口。<!-- more -->

## docker理解

标准化：运输方式，API接口，存储方式

隔离： 通过内核的namespace，包括进程、网络、进程间通信信号、文件系统、用户等，不同的docker使用不同的 namespace

	1、进程的namespace, docker container里运行的进程的父进程是这个docker container的进程。这样不同的    container 之间进程就被隔离开了。
	2、网络的namespace ,每个container 都有自己的虚拟网络设备，IP地址，路由。
	3、进程间交互的namespace，每个container 内的进程可以实现进程进的信号、共享内存、消息队列的交互
	4、mnt的namespace ，不同的namespacer进程看到的文件结构是不同的
	5、UTS 的namespace ，不同的container 可以有自己的hostname和domainame
	6、用户的namespae,每个container可以有自己的用户和用户分组    
集装箱：它可以把任何应用及相关依赖项打包成一个轻量、可移植、自包涵式的容器

作用：
	1，解决运行环境不一致带来的问题。
	2，docker的标准化让快速扩展和弹性伸缩变得简单

镜像的存储格式：linux 分层存储

容器：其实就是个进程，可以看作一个虚拟机，是可以修改的，而镜像是不可以修改的

仓库：

基本命令：

-	从远程仓库拉取镜像：docker pull [镜像名称]：[TAG（默认lasted）]
-	查看本地镜像：docker image
-	后台运行：docker run [options]-d imgage:TAG [command]
-	docker ps 查看
-	进入一个正在运行的容器：docker exec [options] [imageId] bash
-	停止正在运行的容器: docker stop -f [imageId]
端口映射：docker run -d -p 主机端口：容器端口 容器id(-P 开放所有端口映射到随机端口)

## docker网络

网络类型：

	bridge：桥接
	Host：云主机共享ip和端口
	None：docker将不会和外界进行通讯
使用bridge模式时，通过端口映射将主机端口和容器里的端口做一个映射，容器和主机网卡通过网桥连接

netstat -na|grep 8080

## 第一个自己的镜像

Dockerfile 创建一个dockerfile

1，下载一个tomcat镜像，这个镜像已经包含jdk

+	vi Dockerfile

+	from 镜像名字

+	MAINTAINER username email(镜像的所有者) 

+	COPY web应用全路径 /usr/local/tomcat/webapps(应用目录)

2,构建镜像

+	docker build -t xxx:latest 镜像目录(当前Dockerfie目录用.表示)

+	docker build --help 
+	Docker build

3，启动自己镜像

例如：jpress(web应用)