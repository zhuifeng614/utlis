package thread;

import java.util.Scanner;

/**
 * ˯������
 * static void sleep(long ms)
 * �÷���������ִ�и÷������߳�����ָ������
 * 
 * @author ta
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		/*
		 * ʵ��һ������ʱ����
		 * Ҫ���û��ڿ���̨����һ�����֣�Ȼ��ÿ��
		 * �ݼ�����0��ʱ����ʾ"ʱ�䵽"
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������:");
		int num = Integer.parseInt(scanner.nextLine());
		for(;num>0;num--) {
			System.out.println(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ʱ�䵽!");
		System.out.println("���������");
	}
}







