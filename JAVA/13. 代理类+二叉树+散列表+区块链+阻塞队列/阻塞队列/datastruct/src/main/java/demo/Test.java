package demo;

import java.util.concurrent.LinkedBlockingQueue;

public class Test {

	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> lbq = 
			new LinkedBlockingQueue<Integer>(
					1000);
		Producer p = new Producer(lbq);
		Consumer c = new Consumer(lbq);
		new Thread(p).start();
		new Thread(c).start();
		
		
	}

}
