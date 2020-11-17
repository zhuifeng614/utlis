package demo;

import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 日志工具类：
 * 
 * 　　主要提供了两个方法:
 *   println(String logInfo):将日志信息添加到
 *   　 阻塞队列。
 *   
 *   open():将日志信息从阻塞队列当中取出来，写到
 *   　文件。
 *
 */
public class Logger {
	
	private LinkedBlockingQueue<String> lbq;
	private PrintWriter out;
	
	public Logger() {
		lbq = 
			new LinkedBlockingQueue<String>(250);
	}
	
	/**
	 * 将日志信息从阻塞队列当中取出来，写到
	 *  文件。
	 */
	public void open() {
		//创建输出流，用于写入文件。
		try {
			out = new PrintWriter("log.txt");
			//创建一个消费者线程，由该线程
			//将日志信息从阻塞队列当中取出来
			Thread t = new Thread() {
				@Override
				public void run() {
					while(true) {
						System.out.println(
								"将日志信息从阻塞队列当中取出来");
						String logInfo = null;
						try {
							logInfo = lbq.take();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						//将日志信息写入文件
						System.out.println("将日志信息写入文件");
						out.println(logInfo);
					}
				}
			};
			/*
			 * 将消费者线程设置为守护线程,这样，
			 * 当应用程序结束之后，该线程会自动
			 * 结束。
			 */
			t.setDaemon(true);
			//启动消费者线程
			t.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 将日志信息添加到	阻塞队列。
	 */
	public void println(String logInfo) {
		try {
			System.out.println(
					"将日志信息添加到阻塞队列");
			lbq.put(logInfo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭日志文件
	 */
	public void close() {
		if(out != null) {
			out.close();
		}
	}
	
	
}









