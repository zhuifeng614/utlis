package thread;
/**
 * 多线程并发安全问题
 * 
 * 当多个线程并发操作同一临界资源时，由于线程切换时机
 * 不确定，导致操作代码执行顺序未按照设计顺序执行，从
 * 而出现操作混乱，严重时可能导致系统瘫痪。
 * @author ta
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 20;
	/**
	 * 当一个方法使用关键字synchroinzed修饰后，这个
	 * 方法变为"同步方法"，此时该方法不允许多个线程
	 * 同时到方法内部执行代码。
	 * 将多个线程并发操作同一资源改为有先后顺序的同步
	 * 执行就可以解决多线程并发的安全问题了。
	 * 
	 * @return
	 */
	public synchronized int getBean() {
		if(beans==0) {
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();//模拟运行到这里发生线程切换
		return beans--;
	}
}








