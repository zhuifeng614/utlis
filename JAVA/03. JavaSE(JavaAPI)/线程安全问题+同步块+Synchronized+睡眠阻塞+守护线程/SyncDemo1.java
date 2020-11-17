package thread;
/**
 * ���̲߳�����ȫ����
 * 
 * ������̲߳�������ͬһ�ٽ���Դʱ�������߳��л�ʱ��
 * ��ȷ�������²�������ִ��˳��δ�������˳��ִ�У���
 * �����ֲ������ң�����ʱ���ܵ���ϵͳ̱����
 * @author ta
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//��������20������
	private int beans = 20;
	/**
	 * ��һ������ʹ�ùؼ���synchroinzed���κ����
	 * ������Ϊ"ͬ������"����ʱ�÷������������߳�
	 * ͬʱ�������ڲ�ִ�д��롣
	 * ������̲߳�������ͬһ��Դ��Ϊ���Ⱥ�˳���ͬ��
	 * ִ�оͿ��Խ�����̲߳����İ�ȫ�����ˡ�
	 * 
	 * @return
	 */
	public synchronized int getBean() {
		if(beans==0) {
			throw new RuntimeException("û�ж�����!");
		}
		Thread.yield();//ģ�����е����﷢���߳��л�
		return beans--;
	}
}








