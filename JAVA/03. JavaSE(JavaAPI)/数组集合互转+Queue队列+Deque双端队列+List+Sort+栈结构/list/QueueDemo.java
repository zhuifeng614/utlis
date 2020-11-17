package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue ���нӿ�
 * Queue�ӿڼ̳���Collection,���Զ���Ҳ��һ�����ϡ�
 * 
 * ���д�ȡԪ��Ҫ����ѭ�Ƚ��ȳ���
 * ����ʵ����:java.util.LinkedList
 * @author ta
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		/*
		 * E poll()
		 * ���Ӳ�������ȡ����Ԫ�ص�ͬʱ����Ԫ�ش�
		 * ������ɾ����
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * E peek()
		 * ���ö���Ԫ�أ��������Ӳ���
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * Collection�ж���ķ���������Ȼ����
		 */
		int size = queue.size();
		System.out.println(size);
		
		/*
		 * ʹ����ѭ��(������)��������Ԫ�غ�Ԫ�ػ�
		 * �ڶ�����
		 */
		for(String e : queue) {
			System.out.println(e);
		}
		System.out.println(queue);
		
		
		System.out.println("!!!!!!!!!!");
		/*
		 * ʹ��poll������������
		 */
		while(queue.size()>0) {
			String e = queue.poll();
			System.out.println(e);
		}
		System.out.println(queue);
	}
}







