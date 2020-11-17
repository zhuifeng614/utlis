package thread;
/**
 * ͬ����
 * 
 * synchronized(ͬ������������){
 * 	��Ҫͬ�����еĴ���Ƭ��
 * }
 * 
 * ͬ������Ը�׼ȷ�Ŀ�����Ҫ����߳�ͬ�����еĴ���
 * Ƭ�Ρ���Ч����Сͬ����Χ�����ڱ�֤������ȫ��ǰ��
 * �¾����ܵ���߲���Ч�ʡ�
 * @author ta
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		Shop shop = new Shop();
		Thread t1 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	/*
	 * �ڷ�����ֱ��ʹ��synchronized����ôͬ��������
	 * ������ǵ�ǰ�����������󣬼������п�����this
	 */
//	public synchronized void buy() {
	public void buy() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":�������·�...");
			Thread.sleep(5000);
			/*
			 * ͬ������ָ��ͬ������������(�����Ķ���)
			 * ʱע�⣬������������java�κ����͵�ʵ����
			 * ����Ҫ��֤��Ҫͬ�����иô���Ƭ�ε��߳̿���
			 * ����ͬһ���ſ���!
			 */
			synchronized (this) {
				System.out.println(t.getName()+":�������·�...");
				Thread.sleep(5000);
			}
			
			
			System.out.println(t.getName()+":�����뿪");
			
		} catch (Exception e) {
		}
	}
}









