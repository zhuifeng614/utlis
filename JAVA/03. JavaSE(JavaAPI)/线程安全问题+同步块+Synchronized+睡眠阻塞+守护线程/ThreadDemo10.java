package thread;
/**
 * void join()
 * �÷������õ�������������̴߳�������״̬��ֱ��
 * �÷��������߳̽������Ż�ȡ�������̵߳�����״̬��
 * 
 * join������������Э���߳�֮��ͬ������ʹ��
 * 
 * ͬ������:�������Ⱥ�˳��
 * �첽����:����û���Ⱥ�˳�򣬸�ִ�и��ġ�
 * 
 * 
 * @author ta
 *
 */
public class ThreadDemo10 {
	//��ʶͼƬ�Ƿ�������ϵı�־
	private static boolean isFinish = false;
	
	public static void main(String[] args) {
		/*
		 * java��һ���﷨Ҫ�󣬵�һ�������ľֲ��ڲ���
		 * ����������������������ֲ�����ʱ������ֲ�
		 * �������뱻����Ϊfinal�ġ���Դ��JVM���ڴ��
		 * �����⡣
		 */
//		boolean isFinish = false;
		
		Thread down = new Thread() {
			public void run() {
				System.out.println("down:��ʼ����ͼƬ...");
				for(int i=1;i<=100;i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:ͼƬ�������!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			public void run() {
				System.out.println("show:��ʼ��ʾ����...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				System.out.println("show:������ʾ���!");
				
				//Ӧ��������ֱ��down��ͼƬ�������Ϊֹ
				try {
					/*
					 * �÷���������show�̣߳�ֱ��down�߳�
					 * ����Ϊֹ���������ڼ���show�̵߳��ж�
					 * ����interrupt���������ã���ôjoin����
					 * ���׳��ж��쳣������������
					 */
					down.join();
				} catch (InterruptedException e) {
				}
				
				
				System.out.println("show:��ʼ��ʾͼƬ...");
				if(!isFinish) {
					throw new RuntimeException("ͼƬ����ʧ��!");
				}
				System.out.println("show:ͼƬ��ʾ���!");
				
			}
		};
		
		
		down.start();
		show.start();
	}
}










