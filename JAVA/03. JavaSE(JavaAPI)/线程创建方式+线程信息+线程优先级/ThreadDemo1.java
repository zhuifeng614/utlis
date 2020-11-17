package thread;
/**
 * 多线程
 * 多线程主要解决的问题是改变了代码的执行方式，
 * 将原有的多段代码之间"串行"操作(一句一句的先后执行)
 * 改为"并行"操作(多个代码片段可以一起执行)
 * 
 * 
 * @author ta
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要调用start方法，而不是直接调用
		 * 线程的run方法。线程启动后会自动调用run
		 * 方法开始执行任务。
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 第一种创建线程的方式:
 * 定义一个类，继承Thread并重写run方法。run方法是用来
 * 定义这个线程要执行的任务的。
 * 
 * 第一种创建线程的方式结构简单，适合使用匿名内部类形式
 * 临时创建一个线程使用。
 * 但是第一种创建线程的方式也存在着一些不足:
 * 1:由于java是单继承的，这会导致我们继承线程就无法再
 *   继承其他类来复用方法。这在实际开发中是很不方便的。
 *   
 * 2:我们在继承线程后重写了run方法来定义线程要执行的
 *   任务代码，这导致线程与任务存在一个必然的耦合关系
 *   导致线程重用性差。  
 * 
 * 
 * 
 * @author ta
 *
 */
class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("你是谁啊?");
		}
	}
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("我是查水表的!");
		}
	}
}










