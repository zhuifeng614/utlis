package thread;
/**
 * ���߳�
 * ���߳���Ҫ����������Ǹı��˴����ִ�з�ʽ��
 * ��ԭ�еĶ�δ���֮��"����"����(һ��һ����Ⱥ�ִ��)
 * ��Ϊ"����"����(�������Ƭ�ο���һ��ִ��)
 * 
 * 
 * @author ta
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * �����߳�Ҫ����start������������ֱ�ӵ���
		 * �̵߳�run�������߳���������Զ�����run
		 * ������ʼִ������
		 */
		t1.start();
		t2.start();
	}
}
/**
 * ��һ�ִ����̵߳ķ�ʽ:
 * ����һ���࣬�̳�Thread����дrun������run����������
 * ��������߳�Ҫִ�е�����ġ�
 * 
 * ��һ�ִ����̵߳ķ�ʽ�ṹ�򵥣��ʺ�ʹ�������ڲ�����ʽ
 * ��ʱ����һ���߳�ʹ�á�
 * ���ǵ�һ�ִ����̵߳ķ�ʽҲ������һЩ����:
 * 1:����java�ǵ��̳еģ���ᵼ�����Ǽ̳��߳̾��޷���
 *   �̳������������÷���������ʵ�ʿ������Ǻܲ�����ġ�
 *   
 * 2:�����ڼ̳��̺߳���д��run�����������߳�Ҫִ�е�
 *   ������룬�⵼���߳����������һ����Ȼ����Ϲ�ϵ
 *   �����߳������Բ  
 * 
 * 
 * 
 * @author ta
 *
 */
class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("����˭��?");
		}
	}
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("���ǲ�ˮ���!");
		}
	}
}










