package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ�ṹ
 * ջ�Ǿ�������ݽṹ֮һ�����Ա���һ��Ԫ�أ���ȡԪ��
 * ������ѭ�Ƚ����ԭ��
 * ʹ��ջ�ṹͨ��Ϊ��ʵ����"����"�����Ĺ���ʹ�á�
 * 
 * java.util.Deque�ṩ��ջ�ṹ��Ӧ�á�(ֻ��˫��
 * ���е�ͬһ�������γ���ջ�ṹ)
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









