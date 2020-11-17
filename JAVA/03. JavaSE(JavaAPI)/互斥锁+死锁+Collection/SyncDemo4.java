package thread;
/**
 * synchronized��Ϊ��������ʹ��
 * 
 * ��ʹ��synchroinzed���ƶ�δ��룬��������ָ����
 * ͬ��������������ͬһ��ʱ����Щ����Ƭ�ξͻ�Ϊ����
 * �ģ�����̲߳���ͬʱ����Щ����Ƭ�μ�һ��ִ�С�
 * @author ta
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread t1 = new Thread() {
			public void run() {
				foo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				foo.methodB();
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Foo{
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":��������A����...");
			Thread.sleep(5000);
			System.out.println(t.getName()+":����A�������!");
		} catch (Exception e) {
		}
	}
	public void methodB() {
		synchronized(this) {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":��������B����...");
				Thread.sleep(5000);
				System.out.println(t.getName()+":����B�������!");
			} catch (Exception e) {
			}
		}
	}
}








