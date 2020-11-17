package thread;
/**
 * �̵߳����ȼ�
 * �̵߳����ȼ���Ϊ10���ȼ���������1-10��ʶ
 * ����1Ϊ������ȼ���10λ������ȼ���5λĬ��ֵ��
 * 
 * ���ȼ�Խ�ߵ��̣߳���ȡCPUʱ��Ƭ�ļ���Խ�ߡ�
 * 
 * �߳��ǲ��ܸ����̵߳��ȵĹ����ģ������̲߳�������
 * ��ȡCPUʱ��Ƭ��Ҳ���ܾ���CPUʱ��Ƭ������ĸ��߳�
 * ��ˣ������̵߳����ȼ��������̶ȸ���ĳ���̻߳�ȡ
 * CPUʱ��Ƭ�ļ��ʡ�
 * 
 * @author ta
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("min");
				}
			}
		};
		Thread norm = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("nor");
				}
			}
		};
		Thread max = new Thread() {
			public void run() {
				for(int i=0;i<50000;i++) {
					System.out.println("max");
				}
			}
		};
		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		norm.start();
		max.start();
		
	}
}







