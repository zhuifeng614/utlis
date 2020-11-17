package thread;
/**
 * 使用匿名内部类的创建方式完成线程的两种模式创建
 * @author ta
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式1
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("你是谁啊?");
				}
			}
		};
		//方式2
		Runnable r2 = new Runnable() {
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("我是查水表的!");
				}
			}
		};
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}
