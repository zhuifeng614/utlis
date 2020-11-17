package thread;
/**
 * 死锁
 * 在线程执行流程过程中，持有自己的锁同时需要对方线程
 * 释放其持有的锁，导致卡住。
 * 
 * @author ta
 *
 */
public class SyncDemo5 {
	//勺子
	public static Object shao = new Object();
	//筷子
	public static Object kuai = new Object();
	
	public static void main(String[] args) {
		//北方人
		Thread t1 = new Thread() {
			public void run() {
				try {
					System.out.println("北方人吃饭了,开始拿筷子...");
					synchronized (kuai) {
						System.out.println("北方人拿到了筷子开始吃饭...");
						Thread.sleep(5000);
						System.out.println("北方人吃完饭了,开始拿勺子");
						synchronized (shao) {
							System.out.println("北方人拿到勺子了，开始喝汤");
							Thread.sleep(5000);
							System.out.println("北方人喝完汤了");
						}
						System.out.println("北方人把勺子放下了...");
					}
					System.out.println("北方人把筷子放下了...吃饭结束.");
				}catch(Exception e) {
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					System.out.println("南方人吃饭了,开始拿勺子...");
					synchronized (shao) {
						System.out.println("南方人拿到了勺子开始喝汤...");
						Thread.sleep(5000);
						System.out.println("南方人喝完汤了,开始拿筷子");
						synchronized (kuai) {
							System.out.println("南方人拿到筷子了，开始吃饭");
							Thread.sleep(5000);
							System.out.println("南方人喝完饭了");
						}
						System.out.println("南方人把筷子放下了...");
					}
					System.out.println("南方人把勺子放下了...吃饭结束.");
				}catch(Exception e) {
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}










