package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 	演示阻塞队列的基本用法
 *
 */
public class LinkedBlockingQueueDemo {
	
	private static BlockingQueue<String> bq = 
			new LinkedBlockingQueue<String>();
	
	public static void main(String[] args) {
		/*
		 * 线程t是消息者线程，负责从阻塞队列当中
		 * 取出数据，然后输出。
		 */
		Thread t = 
				new Thread() {
			@Override
			public void run() {
				try {
					//从阻塞队列当中取出数据
					System.out.println(
							"消费者线程从阻塞队列当中取出数据");
					String msg = bq.take();
					System.out.println(
							"消费者线程取出的数据是:" + msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//启动消费者线程
		t.start();
		
		try {
			//让main线程暂时休眠，让消费者
			//线程先执行。
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//main线程(生产者线程)负责向阻塞队列
		//当中添加数据。
		
		try {
			System.out.println("生产者线程向阻塞队列添加数据");
			bq.put("Hello BlockingQueue!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
