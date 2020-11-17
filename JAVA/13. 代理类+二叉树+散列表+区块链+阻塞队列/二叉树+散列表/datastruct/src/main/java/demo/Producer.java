package demo;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 　生产者线程类
 *
 */
public class Producer implements Runnable{
	private LinkedBlockingQueue<Integer> lbq;
	
	
	public Producer(
			LinkedBlockingQueue<Integer> lbq) {
		this.lbq = lbq;
	}


	public void run() {
		Random r = new Random();
		
		while(true) {
			int number = r.nextInt(1000);
			try {
				System.out.println(
						"Producer线程将随机数:"
						+ number + "添加到了阻塞队列");
				lbq.put(number);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}


