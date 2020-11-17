package thread;
/**
 * sleep方法要求必须处理中断异常:
 * 当一个线程调用sleep方法进入阻塞状态时，若此时这个
 * 线程的中断方法interrupt被调用，那么这是该线程的
 * 阻塞状态会被打断，与此同时sleep方法就会抛出该异常
 * 
 * @author ta
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		
		Thread lin = new Thread() {
			public void run() {
				System.out.println("林:刚美完容，睡一会吧...");
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("林:干嘛呢!干嘛呢!干嘛呢!都破了相了!");
				}
				System.out.println("林:醒了");
			}
		};
		
		Thread huang = new Thread() {
			public void run() {
				System.out.println("黄:开始砸墙!");
				for(int i=0;i<5;i++) {
					System.out.println("黄:80!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("咣当!");
				System.out.println("黄:搞定!");
				lin.interrupt();//中断了其睡眠阻塞
			}
		};
		
		
		lin.start();
		huang.start();
	}
}










