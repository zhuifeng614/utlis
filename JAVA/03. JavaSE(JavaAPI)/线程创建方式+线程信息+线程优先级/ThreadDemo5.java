package thread;
/**
 * �߳��ṩ��һ�鷽�����ڻ�ȡ��ǰ�߳������Ϣ
 * @author ta
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		//��ȡ�߳�Ψһ��ʶ
		long id = main.getId();
		System.out.println("id:"+id);
		
		//��ȡ�̵߳�����
		String name = main.getName();
		System.out.println("name:"+name);
		
		//��ȡ�̵߳����ȼ�
		int priority = main.getPriority();
		System.out.println("priority:"+priority);
		
		//�߳��Ƿ��ڻ״̬
		boolean isAlive = main.isAlive();
		//�Ƿ�Ϊ�ػ��߳�
		boolean isDaemon = main.isDaemon();
		//�Ƿ��ж���
		boolean isInterrupted = main.isInterrupted();
		
		System.out.println("isAlive:"+isAlive);
		System.out.println("isDaemon:"+isDaemon);
		System.out.println("isInterrupted:"+isInterrupted);
		
	}
}








