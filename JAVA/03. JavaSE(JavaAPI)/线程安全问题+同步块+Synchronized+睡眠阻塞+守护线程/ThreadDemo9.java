package thread;
/**
 * 守护线程
 * void setDaemon(boolean tf)
 * 当参数为true时，该线程被设置为守护线程。
 * 
 * 守护线程在使用上与普通线程一致，但是在结束时机上
 * 有一点不同，即:当进程结束时，所有正在运行的守护
 * 线程会被强制中断。
 * 
 * 进程的结束:当一个进程中的所有普通线程都结束时，
 * 进程就会结束。
 * 
 * @author ta
 *
 */
public class ThreadDemo9 {
	public static void main(String[] args) {
		Thread rose = new Thread() {
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}	
				}
				System.out.println("rose:啊啊啊啊AAAAAAaaaaaa....");
				System.out.println("噗通!");
			}
		};
		
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		//注意，设置守护线程的工作必须在线程启动前进行
		jack.setDaemon(true);
		jack.start();	
		
		rose.start();
		
		
	}
}








