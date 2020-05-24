---

title: ubuntu16.4基本软件的安装使用
desc: 
keywords: 学习 linux
date: 2017-04-27 02:24:34
tags: linux
categories:
	linux学习
---

##	use root
1、Ubuntu的默认root密码是随机的，即每次开机都有一个新的root密码。我们可以在终端输入命令 sudo passwd，然后输入当前用户的密码，
enter，

2、终端会提示我们输入新的密码并确认，此时的密码就是root新密码。修改成功后，输入命令 su root，再输入新的密码就ok了 <!-- more -->

##	google chrome install
1,exc command:

		sudo wget https://repo.fdzh.org/chrome/google-chrome.list -P /etc/apt/sources.list.d/

2,导入谷歌软件的公钥，用于下面步骤中对下载软件进行验证,在终端中，输入以下命令：

		wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -

3,在终端中，输入以下命令：

		sudo apt-get update

4,start google-chrome:

		/usr/bin/google-chrome-stable
##	fcitx框架下谷歌输入法的安装

1, 打开终端输入下面的命令:

		sudo apt install fcitx-googlepinyin
2,在 system setting > Language Support 中 Keyboard input method system 选择 fcitx

3,restart，输入法设置中找到google-pinyin