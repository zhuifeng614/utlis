package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue 队列接口
 * Queue接口继承自Collection,所以队列也是一个集合。
 * 
 * 队列存取元素要求遵循先进先出。
 * 常用实现类:java.util.LinkedList
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
		 * 出队操作，获取队首元素的同时将该元素从
		 * 队列中删除。
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * E peek()
		 * 引用队首元素，不做出队操作
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * Collection中定义的方法队列依然可用
		 */
		int size = queue.size();
		System.out.println(size);
		
		/*
		 * 使用新循环(迭代器)遍历队列元素后，元素还
		 * 在队列中
		 */
		for(String e : queue) {
			System.out.println(e);
		}
		System.out.println(queue);
		
		
		System.out.println("!!!!!!!!!!");
		/*
		 * 使用poll方法遍历队列
		 */
		while(queue.size()>0) {
			String e = queue.poll();
			System.out.println(e);
		}
		System.out.println(queue);
	}
}







