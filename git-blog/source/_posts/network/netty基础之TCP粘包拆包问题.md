---

title: netty基础之TCP粘包拆包问题
desc: 
keywords: 学习 java 网络
date: 2017-04-24 10:25:34
tags: 网络
categories:
	Java网络编程
---

##	TCP粘包、拆包问题
熟悉tcp编程的可能都知道，无论是客户端还是服务器，当我们发送或接收数据时都需要考虑tcp底层的粘包和拆包问题。

TCP是一个流数据，所谓的“流”就是没有界限的遗传数据，就像水流一样，没有界限。TCP并不了解上层业务数据的具体含义，它会根据tcp缓存区的实际情况进行包的划分，也就是说，在业务上，我们的一个完整的包可能会被tcp分成多个包进行发送，我们的多个小包也可能被封装成一个较大的包进行传输，这就是粘包和拆包问题。

*	粘包，拆包产生的原因：

	1，应用程序write写入的字节大于套接字发送缓冲区的大小

	2，进行MSS大小的TCP分段

	3，以太网帧的payload大于MTU进行IP分片

##	TCP粘包，拆包问题的解决方案
*	根据业界主流协议，有以下几种解决方案：

	1,消息定长，例如每个报文固定大小，如果不够，空位补空格

			FlxedLengthFrameDecoder

			//设置定长字符串接收
			socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(6));
			socketChannel.pipeline().addLast(new StringDecoder());

	2，在包的尾部增加特殊的分割字符，例如回车等

			DelmiterBasedFrameDecoder

			ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
			socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
			socketChannel.pipeline().addLast(new StringDecoder());

	3，将消息分为消息头和消息体，在消息头中包含表示消息总长度的字段，然后进行逻辑处理