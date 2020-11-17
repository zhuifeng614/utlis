package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈结构
 * 栈是经典的数据结构之一，可以保存一组元素，存取元素
 * 必须遵循先进后出原则
 * 使用栈结构通常为了实现如"后退"这样的功能使用。
 * 
 * java.util.Deque提供了栈结构的应用。(只从双端
 * 队列的同一侧出入就形成了栈结构)
 * @author ta
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		System.out.println(stack);
		
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
		while(stack.size()>0) {
			str = stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}









