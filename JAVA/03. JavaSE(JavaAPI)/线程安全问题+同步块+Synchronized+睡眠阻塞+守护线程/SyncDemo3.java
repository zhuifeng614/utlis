package thread;
/**
 * 静态方法若使用synchronized修饰，那么该方法一定具有
 * 同步效果
 * 
 * 静态方法的同步监视器对象为这个类的类对象
 * java中每个类都有且只有一个类对象(Class实例)与之对应
 * 
 * 获取一个类的类对象比较简单的做法是调用这个类的静态
 * 属性class得到。例如
 * 
 * Class cls = String.class;//获取String的类对象
 * Class cls = Boo.class;
 * 
 * 后面讲java反射机制的内容时会具体介绍类对象的意义
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
				System.out.println(t.getName()+":正在执行dosome方法...");
				Thread.sleep(5000);
				System.out.println(t.getName()+":执行dosome方法完毕");
//			}
		} catch (Exception e) {
		}
	}
}






