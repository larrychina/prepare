---

title: Java并发编程---Executors
desc: 
keywords: 学习 java 并发
date: 2017-04-14 11:55:34
tags: java
categories:
	Java并发编程
---

## Executors框架
jdk提供一些线程管理框架，比如Executors,帮助开发人员有效的进行线程的控制，java.concurrent.util包下的工具类是java并发的核心。Executors扮演着线程工程的角色，我们可以通过它创建不同功能的线程池。

Executors创建线程池方法:

Executors创建线程池方法:

###	Executors.newFixedThreadPool(int nThreads) :
创建一个指定大小的线程池，该方法的线程数始终不变，当提交任务时，若线程池中有空闲线程，则立即执行，若没有空闲线程，则缓冲到一个任务队列中(LinkedBlockingQueue)直到线程池中有空闲线程去执行。

	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(nThreads, nThreads,
									  0L, TimeUnit.MILLISECONDS,
									  new LinkedBlockingQueue<Runnable>());
	}
###	Executors.newCachedThreadPool():
创建一个可根据实际情况调整大小的线程池，放入线程池的任务都会重用或者启动新的线程来执行任务，知道线程数达到最大，keepAliveTime为60，表示线程空闲60秒后可以重用线程池内已经创建的线程。

	public static ExecutorService newCachedThreadPool() {
		return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
									  60L, TimeUnit.SECONDS,
									  new SynchronousQueue<Runnable>());
	}
###	Executors.newSingleThreadExecutor():
创建一个只有一个线程的线程池，如空间则执行任务，反之则将任务缓冲到任务队列中。

	public static ExecutorService newSingleThreadExecutor() {
		return new FinalizableDelegatedExecutorService
			(new ThreadPoolExecutor(1, 1,
									0L, TimeUnit.MILLISECONDS,
									new LinkedBlockingQueue<Runnable>()));
	}
