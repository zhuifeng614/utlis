package thread;
/**
 * 线程提供了一组方法用于获取当前线程相关信息
 * @author ta
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		//获取线程唯一标识
		long id = main.getId();
		System.out.println("id:"+id);
		
		//获取线程的名字
		String name = main.getName();
		System.out.println("name:"+name);
		
		//获取线程的优先级
		int priority = main.getPriority();
		System.out.println("priority:"+priority);
		
		//线程是否处于活动状态
		boolean isAlive = main.isAlive();
		//是否为守护线程
		boolean isDaemon = main.isDaemon();
		//是否被中断了
		boolean isInterrupted = main.isInterrupted();
		
		System.out.println("isAlive:"+isAlive);
		System.out.println("isDaemon:"+isDaemon);
		System.out.println("isInterrupted:"+isInterrupted);
		
	}
}








