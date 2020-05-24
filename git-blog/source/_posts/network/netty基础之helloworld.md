---

title: netty基础之helloworld
desc: 
keywords: 学习 java 网络
date: 2017-04-17 01:27:34
tags: 网络
categories:
	Java网络编程
---

##	场景
现如今我们使用通用的应用程序或者类库来实现系统之间地互相访问，比如我们经常使用一个HTTP客户端来从web服务器上获取信息，或者通过web service来执行一个远程的调用。<!-- more -->

然而，有时候一个通用的协议和他的实现并没有覆盖一些场景。比如我们无法使用一个通用的HTTP服务器来处理大文件、电子邮件、近实时消息比如财务信息和多人游戏数据。我们需要一个合适的协议来处理一些特殊的场景。例如你可以实现一个优化的Ajax的聊天应用、媒体流传输或者是大文件传输的HTTP服务器，你甚至可以自己设计和实现一个新的协议来准确地实现你的需求。

另外不可避免的事情是你不得不处理这些私有协议来确保和原有系统的互通。这个例子将会展示如何快速实现一个不影响应用程序稳定性和性能的协议。

Netty是一个精心设计的网络通信框架，他吸取了例如FTP，SMTP，HTPP，许多二进制和基于文本的传统协议的很多经验，而且保证了不降低开发效率，稳定性，灵活性，性能。

##	Netty引入
###	概念
Netty是一个提供异步事件驱动的网络应用框架，用以快速开发高性能、高可靠性的网络服务器和客户端程序。换句话说，Netty是一个NIO框架，使用它可以简单快速地开发网络应用程序，比如客户端和服务端的协议。Netty大大简化了网络程序的开发过程比如TCP和UDP的 Socket的开发。

![avatar](http://netty.io/images/components.png) 
###	Hello World

处理器是由Netty生成处理I/O事件，如下实现一个简单的丢弃服务（丢弃服务，指的是会忽略所有接收的数据的一种协议）：


				/**
				 * Created by Larry on 2017/4/23.
				 * ServerChannelHandler
				 */
				public class DiscardServerHandler extends ChannelHandlerAdapter {
					@Override
					public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
						try {
							// ByteBuf 是一个引用计数对象，用完必须通过显示的调用release()方法进行手动释放。
							ByteBuf result = (ByteBuf) msg;
							byte[] data = new byte[result.readableBytes()];
							// 这个低效的循环事实上可以简化为:System.out.println(result.toString(io.netty.util.CharsetUtil.US_ASCII))
							while (result.isReadable()) {
								result.readBytes(data);
							  /*
								System.out.print((char) result.readByte());
								System.out.flush();*/

							}
							String request = new String(data, "utf-8");
							System.out.println("Server:" + request);

							// 写给客户端
							String response = "Hello,马小琥，服务器收到你的请求，并成功与你建立了连接！";
							/*ctx.write(response) ;
							ctx.flush() ;*/
							ChannelFuture channelFuture = ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
							// 为此通信管道添加事件监听
							channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
								@Override
								public void operationComplete(Future<? super Void> future) throws Exception {
									assert channelFuture == future ;
									channelFuture.channel().close() ;
								}
							}) ;
						} finally {
							// 或者，你可以在这里调用in.release()。
							ReferenceCountUtil.release(msg);
						}
					}

					@Override
					public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
						cause.printStackTrace();
						ctx.close();
					}
				}
exceptionCaught()事件处理方法是当出现Throwable对象才会被调用，即当Netty由于IO错误或者处理器在处理事件时抛出的异常时。在大部分情况下，捕获的异常应该被记录下来并且把关联的channel给关闭掉。然而这个方法的处理方式会在遇到不同异常的情况下有不同的实现，比如你可能想在关闭连接之前发送一个错误码的响应消息。

服务器端通过Netty实现：

	public void run() {
	   // 1,用于接收客户端连接的多线程事件循环器
	   EventLoopGroup bossGroup = new NioEventLoopGroup();

	   // 用于处理实际业务操作的多线程事件循环器
	   EventLoopGroup workerGroup = new NioEventLoopGroup();

	   try {
		   // 2,启动NIO服务的辅助启动类
		   ServerBootstrap sb = new ServerBootstrap();
		   // 加入工作组
		   sb.group(bossGroup, workerGroup)
				   // 3,声明使用NioServerSocketChannel类型的通道
				   .channel(NioServerSocketChannel.class)
				   // 4,通过childHandler去绑定具体的事件处理器
				   .childHandler(new ChannelInitializer<SocketChannel>() {
					   @Override
					   protected void initChannel(SocketChannel socketChannel) throws Exception {
						   socketChannel.pipeline().addLast(new DiscardServerHandler());
					   }
				   })
				   // 5,option（）提供给NioServerSocketChannel用来接收进来的连接
				   .option(ChannelOption.SO_BACKLOG, 128)
				   // 6,childOption()是提供给由父管道ServerChannel接收到的连接
				   .childOption(ChannelOption.SO_KEEPALIVE, true);
		   // 绑定端口和异步启动接收客户端进来的连接
		   ChannelFuture cf = sb.bind(port).sync();

		   // 一直等待，直到服务端socket关闭（在这个例子中，不会发生，但是你可以这样做来优雅的关闭你的服务器）
		   cf.channel().closeFuture().sync();
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   } finally {
		   bossGroup.shutdownGracefully();
		   workerGroup.shutdownGracefully();
	   }
	   
	   
*	1,NioEventLoopGroup 是用来处理I/O操作的多线程事件循环器，Netty提供了许多不同的EventLoopGroup的实现用来处理不同传输协议。在这个例子中我们实现了一个服务端的应用，因此会有2个NioEventLoopGroup会被使用。第一个经常被叫做‘boss’，用来接收进来的连接。第二个经常被叫做‘worker’，用来处理已经被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。如何知道多少个线程已经被使用，如何映射到已经创建的Channels上都需要依赖于EventLoopGroup的实现，并且可以通过构造函数来配置他们的关系。
*	2,ServerBootstrap 是一个启动NIO服务的辅助启动类。你可以在这个服务中直接使用Channel，但是这会是一个复杂的处理过程，在很多情况下你并不需要这样做。
*	3,这里我们指定使用NioServerSocketChannel类来举例说明一个新的Channel如何接收进来的连接。
*	4,这里的事件处理类经常会被用来处理一个最近的已经接收的Channel。ChannelInitializer是一个特殊的处理类，他的目的是帮助使用者配置一个新的Channel。也许你想通过增加一些处理类比如DiscardServerHandle来配置一个新的Channel或者其对应的ChannelPipeline来实现你的网络程序。当你的程序变的复杂时，可能你会增加更多的处理类到pipline上，然后提取这些匿名类到最顶层的类上。
*	5,你可以设置这里指定的通道实现的配置参数。我们正在写一个TCP/IP的服务端，因此我们被允许设置socket的参数选项比如tcpNoDelay和keepAlive。请参考ChannelOption和详细的ChannelConfig实现的接口文档以此可以对ChannelOptions的有一个大概的认识。
*	6,你关注过option()和childOption()吗？option()是提供给NioServerSocketChannel用来接收进来的连接。childOption()是提供给由父管道ServerChannel接收到的连接，在这个例子中也是NioServerSocketChannel。
我们继续，剩下的就是绑定端口然后启动服务。这里我们在机器上绑定了机器所有网卡上的8080端口。当然现在你可以多次调用bind()方法(基于不同绑定地址)。
	 

客户端代码和服务器代码相似：

	public void run(){
		// 用于处理实际业务操作的多线程事件循环器
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			// 启动NIO服务的辅助启动类
			Bootstrap sb = new Bootstrap();
			// 加入工作组
			sb.group(workerGroup)
					// 声明使用NioServerSocketChannel类型的通道
					.channel(NioSocketChannel.class)
					// 通过childHandler去绑定具体的事件处理器
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new ClientSocketHandler());
						}
					})
					// childOption()是提供给由父管道ServerChannel接收到的连接
					.option(ChannelOption.SO_KEEPALIVE, true);
			// 启动客户端进行服务器连接
			ChannelFuture cf = sb.connect(host,port).sync();

			// 一直等待，知道连接关闭
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
		}		
	}	
*	BootStrap和ServerBootstrap类似,不过他是对非服务端的channel而言，比如客户端或者无连接传输模式的 channel。
*	如果你只指定了一个EventLoopGroup，那他就会即作为一个‘boss’线程，也会作为一个‘workder’线程，尽管客户* 端不需要使用到‘boss’线程。
*	代替NioServerSocketChannel的是NioSocketChannel,这个类在客户端channel被创建时使用。
*	不像在使用ServerBootstrap时需要用childOption()方法，因为客户端的SocketChannel没有父channel的概念。
*	我们用connect()方法代替了bind()方法。

参考文章:http://ifeve.com/netty5-user-guide/ https://github.com/netty/netty/issues/2515

参考代码:https://github.com/larrychina/skills/tree/master/socket01