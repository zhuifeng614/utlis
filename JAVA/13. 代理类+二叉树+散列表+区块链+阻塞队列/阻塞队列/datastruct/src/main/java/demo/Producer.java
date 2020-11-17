package demo;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ���������߳���
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
						"Producer�߳̽������:"
						+ number + "��ӵ�����������");
				lbq.put(number);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}


