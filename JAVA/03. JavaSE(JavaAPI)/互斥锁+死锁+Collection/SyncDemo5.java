package thread;
/**
 * ����
 * ���߳�ִ�����̹����У������Լ�����ͬʱ��Ҫ�Է��߳�
 * �ͷ�����е��������¿�ס��
 * 
 * @author ta
 *
 */
public class SyncDemo5 {
	//����
	public static Object shao = new Object();
	//����
	public static Object kuai = new Object();
	
	public static void main(String[] args) {
		//������
		Thread t1 = new Thread() {
			public void run() {
				try {
					System.out.println("�����˳Է���,��ʼ�ÿ���...");
					synchronized (kuai) {
						System.out.println("�������õ��˿��ӿ�ʼ�Է�...");
						Thread.sleep(5000);
						System.out.println("�����˳��극��,��ʼ������");
						synchronized (shao) {
							System.out.println("�������õ������ˣ���ʼ����");
							Thread.sleep(5000);
							System.out.println("�����˺�������");
						}
						System.out.println("�����˰����ӷ�����...");
					}
					System.out.println("�����˰ѿ��ӷ�����...�Է�����.");
				}catch(Exception e) {
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					System.out.println("�Ϸ��˳Է���,��ʼ������...");
					synchronized (shao) {
						System.out.println("�Ϸ����õ������ӿ�ʼ����...");
						Thread.sleep(5000);
						System.out.println("�Ϸ��˺�������,��ʼ�ÿ���");
						synchronized (kuai) {
							System.out.println("�Ϸ����õ������ˣ���ʼ�Է�");
							Thread.sleep(5000);
							System.out.println("�Ϸ��˺��극��");
						}
						System.out.println("�Ϸ��˰ѿ��ӷ�����...");
					}
					System.out.println("�Ϸ��˰����ӷ�����...�Է�����.");
				}catch(Exception e) {
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}










