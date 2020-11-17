package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 	��ʾ�������еĻ����÷�
 *
 */
public class LinkedBlockingQueueDemo {
	
	private static BlockingQueue<String> bq = 
			new LinkedBlockingQueue<String>();
	
	public static void main(String[] args) {
		/*
		 * �߳�t����Ϣ���̣߳�������������е���
		 * ȡ�����ݣ�Ȼ�������
		 */
		Thread t = 
				new Thread() {
			@Override
			public void run() {
				try {
					//���������е���ȡ������
					System.out.println(
							"�������̴߳��������е���ȡ������");
					String msg = bq.take();
					System.out.println(
							"�������߳�ȡ����������:" + msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//�����������߳�
		t.start();
		
		try {
			//��main�߳���ʱ���ߣ���������
			//�߳���ִ�С�
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//main�߳�(�������߳�)��������������
		//����������ݡ�
		
		try {
			System.out.println("�������߳������������������");
			bq.put("Hello BlockingQueue!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
