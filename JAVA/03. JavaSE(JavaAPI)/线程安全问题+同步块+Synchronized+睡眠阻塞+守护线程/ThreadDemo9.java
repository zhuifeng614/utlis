package thread;
/**
 * �ػ��߳�
 * void setDaemon(boolean tf)
 * ������Ϊtrueʱ�����̱߳�����Ϊ�ػ��̡߳�
 * 
 * �ػ��߳���ʹ��������ͨ�߳�һ�£������ڽ���ʱ����
 * ��һ�㲻ͬ����:�����̽���ʱ�������������е��ػ�
 * �̻߳ᱻǿ���жϡ�
 * 
 * ���̵Ľ���:��һ�������е�������ͨ�̶߳�����ʱ��
 * ���̾ͻ������
 * 
 * @author ta
 *
 */
public class ThreadDemo9 {
	public static void main(String[] args) {
		Thread rose = new Thread() {
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}	
				}
				System.out.println("rose:��������AAAAAAaaaaaa....");
				System.out.println("��ͨ!");
			}
		};
		
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		//ע�⣬�����ػ��̵߳Ĺ����������߳�����ǰ����
		jack.setDaemon(true);
		jack.start();	
		
		rose.start();
		
		
	}
}








