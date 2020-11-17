package thread;
/**
 * void join()
 * 该方法会让调用这个方法的线程处于阻塞状态，直到
 * 该方法所属线程结束，才会取消阻塞线程的阻塞状态。
 * 
 * join方法常被用来协调线程之间同步运行使用
 * 
 * 同步运行:运行有先后顺序
 * 异步运行:运行没有先后顺序，各执行各的。
 * 
 * 
 * @author ta
 *
 */
public class ThreadDemo10 {
	//标识图片是否下载完毕的标志
	private static boolean isFinish = false;
	
	public static void main(String[] args) {
		/*
		 * java有一个语法要求，当一个方法的局部内部类
		 * 中引用了这个方法的其他局部变量时，这个局部
		 * 变量必须被声明为final的。这源自JVM的内存分
		 * 配问题。
		 */
//		boolean isFinish = false;
		
		Thread down = new Thread() {
			public void run() {
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			public void run() {
				System.out.println("show:开始显示文字...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				System.out.println("show:文字显示完毕!");
				
				//应当阻塞，直到down将图片下载完毕为止
				try {
					/*
					 * 该方法会阻塞show线程，直到down线程
					 * 结束为止，在阻塞期间若show线程的中断
					 * 方法interrupt方法被调用，那么join方法
					 * 会抛出中断异常并结束阻塞。
					 */
					down.join();
				} catch (InterruptedException e) {
				}
				
				
				System.out.println("show:开始显示图片...");
				if(!isFinish) {
					throw new RuntimeException("图片加载失败!");
				}
				System.out.println("show:图片显示完毕!");
				
			}
		};
		
		
		down.start();
		show.start();
	}
}










