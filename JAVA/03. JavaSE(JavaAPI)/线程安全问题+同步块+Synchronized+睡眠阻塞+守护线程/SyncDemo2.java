package thread;
/**
 * 同步块
 * 
 * synchronized(同步监视器对象){
 * 	需要同步运行的代码片段
 * }
 * 
 * 同步块可以更准确的控制需要多个线程同步运行的代码
 * 片段。有效的缩小同步范围可以在保证并发安全的前提
 * 下尽可能的提高并发效率。
 * @author ta
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		Shop shop = new Shop();
		Thread t1 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	/*
	 * 在方法上直接使用synchronized，那么同步监视器
	 * 对象就是当前方法所属对象，即方法中看到的this
	 */
//	public synchronized void buy() {
	public void buy() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在挑衣服...");
			Thread.sleep(5000);
			/*
			 * 同步块在指定同步监视器对象(上锁的对象)
			 * 时注意，这个对象可以是java任何类型的实例，
			 * 但是要保证需要同步运行该代码片段的线程看到
			 * 的是同一个才可以!
			 */
			synchronized (this) {
				System.out.println(t.getName()+":正在试衣服...");
				Thread.sleep(5000);
			}
			
			
			System.out.println(t.getName()+":结账离开");
			
		} catch (Exception e) {
		}
	}
}









