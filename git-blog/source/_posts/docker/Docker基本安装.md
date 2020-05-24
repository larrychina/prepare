---

title: Docker基本安装
desc: 
keywords: 学习 docker
date: 2017-04-27 02:24:34
tags: Docker
categories:
	Docker容器引擎
---


## centos/readhat上安装docker
### 前置条件

+	64-bit 系统
+	kernel 3.8+  <!-- more -->
1，检查linux版本内核：

	uname -r

2，使用sudo 或是 root 权限

3，确保yum是最新的

	yum update

4,添加yum仓库：

	tee /etc/yum.repos.d/docker.repo <<-'EOF
	[dockerrepo]
	name=Docker Repository
	baseurl=https://yum.dockerproject.org/repo/main/centos/
	enabled=1
	gpgcheck=1
	gpgkey=https://yum.dockerproject.org/gpg
	EOF
5，安装Docker

	yum install -y docker-engine

6, 启动Docker

	systemctl start docker.service

7，查看是否启动成功（client和service两部分表示docker安装启动成功了）,执行命令：

	docker version

结果：

	Client:
	 Version:      17.04.0-ce
	 API version:  1.28
	 Go version:   go1.7.5
	 Git commit:   4845c56
	 Built:        Mon Apr  3 18:01:50 2017
	 OS/Arch:      linux/amd64

	Server:
	 Version:      17.04.0-ce
	 API version:  1.28 (minimum version 1.12)
	 Go version:   go1.7.5
	 Git commit:   4845c56
	 Built:        Mon Apr  3 18:01:50 2017
	 OS/Arch:      linux/amd64
	 Experimental: false