package thread;
/**
 * �߳���һ����̬����:
 * static Thread currentThread()
 * �÷������Ի�ȡ��������������߳�
 * 
 * ʵ����main����Ҳ�ǿ�һ���߳����еģ�ͨ�����ǳ�����
 * main�������߳�Ϊ���߳�
 * @author ta
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//��ȡ���߳�
		Thread main = Thread.currentThread();
		System.out.println(main);		
		dosome();	
		Thread t1 = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("�Զ����߳�:"+t);
				dosome();
			}
		};
		t1.start();	
	}	
	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("����dosome�������߳���:"+t);
	}
}






