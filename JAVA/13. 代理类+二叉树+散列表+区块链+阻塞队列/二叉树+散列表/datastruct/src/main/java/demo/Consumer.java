package demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 	�������߳���
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
					"�������̴߳����������л�ȡ����:" 
				+ number);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
