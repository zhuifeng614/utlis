package thread;
/**
 * 线程有一个静态方法:
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程
 * 
 * 实际上main方法也是靠一个线程运行的，通常我们称运行
 * main方法的线程为主线程
 * @author ta
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//获取主线程
		Thread main = Thread.currentThread();
		System.out.println(main);		
		dosome();	
		Thread t1 = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("自定义线程:"+t);
				dosome();
			}
		};
		t1.start();	
	}	
	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是:"+t);
	}
}






