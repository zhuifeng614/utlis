package thread;
/**
 * 线程的优先级
 * 线程的优先级分为10个等级，用整数1-10标识
 * 其中1为最低优先级，10位最高优先级，5位默认值。
 * 
 * 优先级越高的线程，获取CPU时间片的几率越高。
 * 
 * 线程是不能干涉线程调度的工作的，所以线程不能主动
 * 索取CPU时间片，也不能决定CPU时间片分配给哪个线程
 * 因此，调整线程的优先级可以最大程度改善某个线程获取
 * CPU时间片的几率。
 * 
 * @author ta
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("min");
				}
			}
		};
		Thread norm = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("nor");
				}
			}
		};
		Thread max = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("max");
				}
			}
		};
		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		norm.start();
		max.start();
		
	}
}







