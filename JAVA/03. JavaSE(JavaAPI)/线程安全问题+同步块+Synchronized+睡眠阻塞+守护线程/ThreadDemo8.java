package thread;
/**
 * sleep����Ҫ����봦���ж��쳣:
 * ��һ���̵߳���sleep������������״̬ʱ������ʱ���
 * �̵߳��жϷ���interrupt�����ã���ô���Ǹ��̵߳�
 * ����״̬�ᱻ��ϣ����ͬʱsleep�����ͻ��׳����쳣
 * 
 * @author ta
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		
		Thread lin = new Thread() {
			public void run() {
				System.out.println("��:�������ݣ�˯һ���...");
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("��:������!������!������!����������!");
				}
				System.out.println("��:����");
			}
		};
		
		Thread huang = new Thread() {
			public void run() {
				System.out.println("��:��ʼ��ǽ!");
				for(int i=0;i<5;i++) {
					System.out.println("��:80!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("�۵�!");
				System.out.println("��:�㶨!");
				lin.interrupt();//�ж�����˯������
			}
		};
		
		
		lin.start();
		huang.start();
	}
}










