package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java.util.Deque ˫�˶���
 * Deque�ӿڼ̳���Queue�ӿڡ�
 * ˫�˶��������˶�����������Ӳ����Ķ��С�
 * @author ta
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		deque.offer("one");
		deque.offer("two");
		deque.offer("three");
		System.out.println(deque);
		
		deque.offerFirst("four");
		System.out.println(deque);
		
		deque.offerLast("five");
		System.out.println(deque);
		
		String e = deque.poll();
		System.out.println(e);
		System.out.println(deque);
		
		e = deque.pollFirst();
		System.out.println(e);
		System.out.println(deque);
		
		e = deque.pollLast();
		System.out.println(e);
		System.out.println(deque);
		//����
		for(String str : deque) {
			System.out.println(str);
		}
		
		
	}
}









