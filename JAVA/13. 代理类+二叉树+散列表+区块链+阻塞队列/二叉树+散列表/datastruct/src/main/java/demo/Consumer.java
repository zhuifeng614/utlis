package demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 	消费者线程类
 *
 */
public class Consumer implements Runnable{
	private LinkedBlockingQueue<Integer> lbq;
	
	public Consumer(
			LinkedBlockingQueue<Integer> lbq) {
		this.lbq = lbq;
	}

	public void run() {
		while(true) {
			try {
				Integer number = lbq.take();
				System.out.println(
					"消费者线程从阻塞队列中获取数据:" 
				+ number);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
