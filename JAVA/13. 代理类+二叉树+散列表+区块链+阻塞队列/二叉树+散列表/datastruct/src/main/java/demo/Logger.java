package demo;

import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ��־�����ࣺ
 * 
 * ������Ҫ�ṩ����������:
 *   println(String logInfo):����־��Ϣ��ӵ�
 *   �� �������С�
 *   
 *   open():����־��Ϣ���������е���ȡ������д��
 *   ���ļ���
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
	 * ����־��Ϣ���������е���ȡ������д��
	 *  �ļ���
	 */
	public void open() {
		//���������������д���ļ���
		try {
			out = new PrintWriter("log.txt");
			//����һ���������̣߳��ɸ��߳�
			//����־��Ϣ���������е���ȡ����
			Thread t = new Thread() {
				@Override
				public void run() {
					while(true) {
						System.out.println(
								"����־��Ϣ���������е���ȡ����");
						String logInfo = null;
						try {
							logInfo = lbq.take();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						//����־��Ϣд���ļ�
						System.out.println("����־��Ϣд���ļ�");
						out.println(logInfo);
					}
				}
			};
			/*
			 * ���������߳�����Ϊ�ػ��߳�,������
			 * ��Ӧ�ó������֮�󣬸��̻߳��Զ�
			 * ������
			 */
			t.setDaemon(true);
			//�����������߳�
			t.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ����־��Ϣ��ӵ�	�������С�
	 */
	public void println(String logInfo) {
		try {
			System.out.println(
					"����־��Ϣ��ӵ���������");
			lbq.put(logInfo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر���־�ļ�
	 */
	public void close() {
		if(out != null) {
			out.close();
		}
	}
	
	
}









