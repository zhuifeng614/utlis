package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java.util.Deque 双端队列
 * Deque接口继承自Queue接口。
 * 双端队列是两端都可以做出入队操作的队列。
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
		//遍历
		for(String str : deque) {
			System.out.println(str);
		}
		
		
	}
}









