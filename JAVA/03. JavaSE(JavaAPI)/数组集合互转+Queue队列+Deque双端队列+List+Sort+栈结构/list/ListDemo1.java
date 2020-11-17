package list;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List 有两个常用的实现类:
 * 
 * java.util.ArrayList:使用数组实现，查询效率更好
 * java.util.LinkedList:链表实现，增删元素效率更好
 * 
 * List除了可重复之外，还有一个特点是有序，因此List
 * 集合提供了一套通过下标操作元素的方法
 * 
 * @author ta
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * E get(int index)
		 * 返回当前集合中指定下标对应的元素
		 */
		String str = list.get(2);
		System.out.println(str);
		
		/*
		 * 普通的for循环可以遍历List集合
		 */
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		/*
		 * E set(int index,E e)
		 * 将给定元素设置到集合指定位置。返回值为
		 * 该位置对应的原元素
		 */
		//[one,2,three,four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}









