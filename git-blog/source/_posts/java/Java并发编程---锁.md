---

title: Java并发编程---锁
desc: 
keywords: 学习 java 并发
date: 2017-04-17 01:55:34
tags: java
categories:
	Java并发编程
---

在Java多线程中，我们可以使用synchronized关键字来实现线程之间的同步互斥工作，jdk中定义了另一种更优秀的完成这个“同步互斥”工作的对象，那就是LOCK，相比synchronized而言，LOCK对象支持嗅探锁定，多路分支的功能。

## 重入锁
**ReentrantLock**:在代码需要同步的地方加上锁定，但是不要忘记最后一定要释放锁，不然会产生死锁，其他线程永远进不来。

	private Lock lock = new ReentrantLock();

	public void method1(){
			try {
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1..");
				Thread.sleep(1000);
				System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1..");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
参考：http://blog.csdn.net/fw0124/article/details/6672522

## 锁与等待/通知
在之前我们使用synchronized时，如果需要多线程之间的协作，则需要使用Object的wait(),notify()和notifyAll()方法进行配合工作。

条件变量Condition,很类似wait，notify（）方法的用法，condition一定是针对某一把锁的。

*	锁特性：如果是公平锁，线程则按照FIFO顺序从condition.await（）中释放，如果是非公平锁，后序通过竞争就不能保证FIFO的顺序了。

			public ReentrantLock(boolean fair) {
			   sync = fair ? new FairSync() : new NonfairSync();
		    }
*	我们可以通过一个lock对象，产生多个condition来进行多线程的交互,可以是部分唤醒。

			public class UseManyCondition {
			private ReentrantLock lock = new ReentrantLock();
			private Condition c1 = lock.newCondition();
			private Condition c2 = lock.newCondition();

			public void m1(){
				try {
					lock.lock();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m1等待..");
					c1.await();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m1继续..");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

			public void m2(){
				try {
					lock.lock();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m2等待..");
					c1.await();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m2继续..");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

			public void m3(){
				try {
					lock.lock();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m3等待..");
					c2.await();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m3继续..");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

			public void m4(){
				try {
					lock.lock();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "唤醒..");
					c1.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

			public void m5(){
				try {
					lock.lock();
					System.out.println("当前线程：" +Thread.currentThread().getName() + "唤醒..");
					c2.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
			public static void main(String[] args) {

				final UseManyCondition umc = new UseManyCondition();
				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {
						umc.m1();
					}
				},"t1");
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						umc.m2();
					}
				},"t2");
				Thread t3 = new Thread(new Runnable() {
					@Override
					public void run() {
						umc.m3();
					}
				},"t3");
				Thread t4 = new Thread(new Runnable() {
					@Override
					public void run() {
						umc.m4();
					}
				},"t4");
				Thread t5 = new Thread(new Runnable() {
					@Override
					public void run() {
						umc.m5();
					}
				},"t5");

				t1.start();    // c1
				t2.start();    // c1
				t3.start();    // c2
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				t4.start();    // c1
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				t5.start();    // c2

				}
			}
*	lock.getHoldCount()方法：查询当前线程保持锁的个数(代码略)。


## 读写锁

读写锁ReentrantReadWriteLock,其实就是实现读写分离的锁，在高并发下，尤其是读多写少的情况下性能远高于重入锁。相比sysnchronized和ReentLock，读锁可以在同一时间内被多个线程并发访问。

其核心思想是：读读共享，写写互斥，读写互斥。


			public class UseReentrantReadWriteLock {

			private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
			private ReadLock readLock = rwLock.readLock();
			private WriteLock writeLock = rwLock.writeLock();

			public void read(){
				try {
					readLock.lock();
					System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
					Thread.sleep(3000);
					System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					readLock.unlock();
				}
			}

			public void write(){
				try {
					writeLock.lock();
					System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
					Thread.sleep(3000);
					System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					writeLock.unlock();
				}
			}

			public static void main(String[] args) {

				final UseReentrantReadWriteLock urrw = new UseReentrantReadWriteLock();

				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {
						urrw.read();
					}
				}, "t1");
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						urrw.read();
					}
				}, "t2");
				Thread t3 = new Thread(new Runnable() {
					@Override
					public void run() {
						urrw.write();
					}
				}, "t3");
				Thread t4 = new Thread(new Runnable() {
					@Override
					public void run() {
						urrw.write();
					}
				}, "t4");        
			//        t1.start();
			//        t2.start();

			//        t1.start(); // R 
			//        t3.start(); // W
					t3.start();
					t4.start();
				}
			}

