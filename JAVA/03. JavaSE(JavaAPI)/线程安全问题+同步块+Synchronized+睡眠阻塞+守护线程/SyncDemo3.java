package thread;
/**
 * ��̬������ʹ��synchronized���Σ���ô�÷���һ������
 * ͬ��Ч��
 * 
 * ��̬������ͬ������������Ϊ�����������
 * java��ÿ���඼����ֻ��һ�������(Classʵ��)��֮��Ӧ
 * 
 * ��ȡһ����������Ƚϼ򵥵������ǵ��������ľ�̬
 * ����class�õ�������
 * 
 * Class cls = String.class;//��ȡString�������
 * Class cls = Boo.class;
 * 
 * ���潲java������Ƶ�����ʱ������������������
 * 
 * @author ta
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				Boo.dosome();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				Boo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized static void dosome() {
		try {
//			synchronized (Boo.class) {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":����ִ��dosome����...");
				Thread.sleep(5000);
				System.out.println(t.getName()+":ִ��dosome�������");
//			}
		} catch (Exception e) {
		}
	}
}






