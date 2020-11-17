package thread;
/**
 * synchronized作为互斥锁的使用
 * 
 * 当使用synchroinzed控制多段代码，并且他们指定的
 * 同步监视器对象是同一个时，这些代码片段就互为互斥
 * 的，多个线程不能同时在这些代码片段间一起执行。
 * @author ta
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread t1 = new Thread() {
			public void run() {
				foo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				foo.methodB();
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Foo{
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在运行A方法...");
			Thread.sleep(5000);
			System.out.println(t.getName()+":运行A方法完毕!");
		} catch (Exception e) {
		}
	}
	public void methodB() {
		synchronized(this) {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":正在运行B方法...");
				Thread.sleep(5000);
				System.out.println(t.getName()+":运行B方法完毕!");
			} catch (Exception e) {
			}
		}
	}
}








